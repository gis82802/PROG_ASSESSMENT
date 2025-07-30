<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 

    <?php
    session_start();

    // --- 資料庫連線 ---
    $conn = new mysqli("localhost", "root", "", "topic");
    if ($conn->connect_error) {
        $_SESSION['error'] = "資料庫連線失敗，請稍後再試。";
        header("Location: ../index.php"); // 連線失敗，導向首頁
        exit();
    }

    // 檢查並顯示成功或錯誤訊息
    if (isset($_SESSION['success'])) {
        echo "<script>alert('" . htmlspecialchars($_SESSION['success'], ENT_QUOTES) . "');</script>";
        unset($_SESSION['success']);
    }
    if (isset($_SESSION['error'])) {
        echo "<script>alert('" . htmlspecialchars($_SESSION['error'], ENT_QUOTES) . "');</script>";
        unset($_SESSION['error']);
    }

    // --- 獲取 Homework ID (通常從 Session 傳入) ---
    $homeworkID = $_SESSION['selected_homework_id'] ?? null;
    if (!$homeworkID) {
        $_SESSION['error'] = "未選擇作業，請返回課程列表。";
        $conn->close();
        header("Location: teacherclass.php"); // 導向教師課程頁面
        exit();
    }

    // --- 獲取作業名稱、題目數量及班級 ID ---
    $homeworkName = "";
    $classID = null;
    $questionSum = 0; // 初始化題目數量
    $sql_homework = "SELECT HomeworkName, ClassID, QuestionSum FROM homeworkslist WHERE HomeworkID = ?";
    $stmt_homework = $conn->prepare($sql_homework);

    if ($stmt_homework) {
        $stmt_homework->bind_param("s", $homeworkID);
        $stmt_homework->execute();
        $result_homework = $stmt_homework->get_result();

        if ($result_homework->num_rows === 1) {
            $homeworkData = $result_homework->fetch_assoc();
            $homeworkName = $homeworkData['HomeworkName'];
            $classID = $homeworkData['ClassID'];
            $questionSum = $homeworkData['QuestionSum']; // 從資料庫獲取題目數量
        } else {
            $_SESSION['error'] = "找不到對應的作業資訊！";
            $conn->close();
            header("Location: teacherclass.php");
            exit();
        }
        $stmt_homework->close();
    } else {
        $_SESSION['error'] = "資料庫準備語句失敗：獲取作業資訊。" . $conn->error;
        $conn->close();
        header("Location: teacherclass.php");
        exit();
    }

    // --- 獲取登入使用者名稱 (假設是教師) ---
    $userid = $_SESSION['UserID'] ?? null;
    $fullname = "";
    if ($userid) {
        $sql_user = "SELECT FirstName, LastName FROM users WHERE UserID = ?";
        $stmt_user = $conn->prepare($sql_user);
        if ($stmt_user) {
            $stmt_user->bind_param("s", $userid);
            $stmt_user->execute();
            $result_user = $stmt_user->get_result();
            if ($result_user->num_rows === 1) {
                $userData = $result_user->fetch_assoc();
                $fullname = $userData['FirstName'] . $userData['LastName'];
            }
            $stmt_user->close();
        } else {
            error_log("資料庫準備語句失敗：獲取使用者名稱。" . $conn->error);
        }
    } else {
        $_SESSION['error'] = "未登入，請先登入。";
        $conn->close();
        header("Location: ../index.php");
        exit();
    }

    // --- 測資檔案目錄路徑 ---
    // 根據「題目共用」模式，測資存放於: data/{ClassID}/{HomeworkID}/tester/Q{QuestionID}/
    $testerBaseDirPath = __DIR__ . "/data/$classID/$homeworkID/tester/";

    // 確保測資主目錄存在，若不存在則嘗試創建
    if (!is_dir($testerBaseDirPath)) {
        if (!mkdir($testerBaseDirPath, 0777, true)) {
            $_SESSION['error'] = "無法建立測資主目錄：{$testerBaseDirPath}，請檢查權限。";
            // 頁面仍繼續顯示，但可能無法加載測資
        }
    }

    // --- 查詢所有現有測資檔案 (基於 .in 或 .out) ---
    $existingTestCases = []; // 儲存 { 'question_folder': 'Q1', 'name': '1', 'in_content': '...', 'out_content': '...' }

    if (is_dir($testerBaseDirPath)) {
        // 遍歷所有 Q{num} 子目錄
        $q_dirs = array_filter(glob($testerBaseDirPath . 'Q*'), 'is_dir'); 

        foreach ($q_dirs as $q_dir) {
            $questionFolderName = basename($q_dir); // 例如 'Q1'
            $currentTesterDir = $q_dir . DIRECTORY_SEPARATOR; // 完整的 Q{num} 路徑

            // 掃描當前題目資料夾下的所有檔案
            $files = scandir($currentTesterDir);
            $testCaseNames = []; // 用來收集測資名稱，避免重複

            foreach ($files as $file) {
                if ($file === '.' || $file === '..') continue; 

                $fileInfo = pathinfo($file);
                $baseName = $fileInfo['filename']; 
                
                if (isset($fileInfo['extension']) && ($fileInfo['extension'] === 'in' || $fileInfo['extension'] === 'out')) {
                    $testCaseNames[$baseName] = true; 
                }
            }

            // 對測資名稱進行自然排序 (例如 1, 2, 10 而不是 1, 10, 2)
            $sortedTestCaseNames = array_keys($testCaseNames);
            natsort($sortedTestCaseNames); 

            // 遍歷排序後的測資名稱，讀取其內容
            foreach ($sortedTestCaseNames as $testCaseName) {
                $inFilePath = $currentTesterDir . $testCaseName . '.in';
                $outFilePath = $currentTesterDir . $testCaseName . '.out';

                // 讀取檔案內容，如果檔案不存在則為空字串，並進行 HTML 實體轉義
                $inContent = file_exists($inFilePath) ? htmlspecialchars(file_get_contents($inFilePath), ENT_QUOTES) : '';
                $outContent = file_exists($outFilePath) ? htmlspecialchars(file_get_contents($outFilePath), ENT_QUOTES) : '';

                // 將測資資訊添加到主要陣列中
                $existingTestCases[] = [
                    'question_folder' => htmlspecialchars($questionFolderName), 
                    'name' => htmlspecialchars($testCaseName), 
                    'in_content' => $inContent, 
                    'out_content' => $outContent 
                ];
            }
        }
    }
    ?>

    <title>編輯測資 - <?php echo htmlspecialchars($homeworkName); ?></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/modernizr-2.6.2.min.js"></script>
</head>
<body>
    <div class="fh5co-loader"></div>
    
    <div id="page">
        <nav class="fh5co-nav" role="navigation">
            <div class="top">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 text-right">
                            <p class="num"><?php echo htmlspecialchars($fullname); ?></p>
                            <ul class="fh5co-social">
                                <li><a href="index.php">登出</i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="top-menu">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-1">
                            <a href="teacher.php"><img src="./images/NFU_Logo.png" alt="LOGO" style="height: 50px;"></a>
                        </div>
                        <div class="col-xs-11 text-right menu-1">
                            <ul>
                                <li class="btn-cta"><a href="teacherclass.php"><span>返回課程列表</span></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </nav>

        <header id="fh5co-header" class="fh5co-bgm" role="banner" style="background-image:url(images/img_bg_2.jpg);" data-stellar-background-ratio="0.5">
            
        </header>

        <div class="container center-container">
            <div class="upload-box text-center">
                <h2 class="mb-4">編輯測資：<?php echo htmlspecialchars($homeworkName); ?></h2>
                <p></p>

                <h3>新增測資</h3>
                <form action="./php/process_tester.php" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="homeworkID" value="<?php echo htmlspecialchars($homeworkID); ?>">
                    <input type="hidden" name="classID" value="<?php echo htmlspecialchars($classID); ?>">

                    <label for="new_question_folder">選擇題目號碼 (Q1, Q2, ...):</label>
                    <select id="new_question_folder" name="question_folder" required class="form-select mb-3">
                        <?php
                        // 根據 homeworkslist 中的 QuestionSum 來動態生成選項
                        if ($questionSum > 0) {
                            for ($q = 1; $q <= $questionSum; $q++) {
                                // 預設選中 Q1 (如果存在)
                                $selected = ($q === 1) ? 'selected' : '';
                                echo "<option value=\"Q$q\" $selected>Q$q</option>";
                            }
                        } else {
                            // 如果 QuestionSum 為 0 或未設定，提供一個預設選項
                            echo "<option value=\"Q1\" selected>Q1 (預設)</option>";
                        }
                        ?>
                    </select><br>

                    <label for="new_tester_in">輸入檔內容 (可選)：</label>
                    <textarea id="new_tester_in" name="tester_in_content" rows="5" style="width:100%;" class="form-control mb-3"></textarea><br>

                    <label for="new_tester_out">輸出檔內容 (必填)：</label>
                    <textarea id="new_tester_out" name="tester_out_content" rows="5" style="width:100%;" class="form-control mb-3" required></textarea><br>

                    <button type="submit" class="btn btn-primary">新增測資</button>
                </form>

                <hr style="margin: 30px 0;">

                <h3>現有測資</h3>
                <?php if (empty($existingTestCases)): ?>
                    <p>目前沒有任何測資。</p>
                <?php else: ?>
                    <div class="scrollable-table-container" style="max-height: 500px; overflow-y: auto;">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>題目</th>
                                    <th>測資名稱</th>
                                    <th>輸入內容 (.in)</th>
                                    <th>輸出內容 (.out)</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody id="testerTableBody"> <?php foreach ($existingTestCases as $testCase): ?>
                                    <tr>
                                        <td><?php echo $testCase['question_folder']; ?></td>
                                        <td><?php echo $testCase['name']; ?></td>
                                        <td><pre style="white-space: pre-wrap; word-wrap: break-word;"><?php echo $testCase['in_content']; ?></pre></td>
                                        <td><pre style="white-space: pre-wrap; word-wrap: break-word;"><?php echo $testCase['out_content']; ?></pre></td>
                                        <td>
                                            <form action="./php/process_tester.php" method="post" class="delete-tester-form" style="display:inline-block; margin-left: 5px;">
                                                <input type="hidden" name="action" value="delete">
                                                <input type="hidden" name="homeworkID" value="<?php echo htmlspecialchars($homeworkID); ?>">
                                                <input type="hidden" name="classID" value="<?php echo htmlspecialchars($classID); ?>">
                                                <input type="hidden" name="question_folder" value="<?php echo $testCase['question_folder']; ?>">
                                                <input type="hidden" name="tester_name" value="<?php echo $testCase['name']; ?>">
                                                <button type="submit" class="btn btn-danger btn-sm">刪除</button> </form>
                                        </td>
                                    </tr>
                                <?php endforeach; ?>
                            </tbody>
                        </table>
                    </div>
                <?php endif; ?>
            </div>
        </div>

        <div class="modal fade" id="editTesterModal" tabindex="-1" aria-labelledby="editTesterModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <form action="./php/process_tester.php" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editTesterModalLabel">編輯測資</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="action" value="edit">
                            <input type="hidden" name="homeworkID" value="<?php echo htmlspecialchars($homeworkID); ?>">
                            <input type="hidden" name="classID" value="<?php echo htmlspecialchars($classID); ?>">
                            
                            <label for="edit_question_folder">題目號碼：</label>
                            <input type="text" id="edit_question_folder" name="question_folder" readonly class="form-control-plaintext mb-3" style="background-color: #f0f0f0;"><br>

                            <label for="edit_tester_name">測資名稱：</label>
                            <input type="text" id="edit_tester_name" name="tester_name" readonly class="form-control-plaintext mb-3" style="background-color: #f0f0f0;"><br>

                            <label for="edit_tester_in">輸入檔內容：</label>
                            <textarea id="edit_tester_in" name="tester_in_content" rows="10" style="width:100%;" class="form-control mb-3"></textarea><br>

                            <label for="edit_tester_out">輸出檔內容：</label>
                            <textarea id="edit_tester_out" name="tester_out_content" rows="10" style="width:100%;" class="form-control mb-3" required></textarea><br>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <button type="submit" class="btn btn-primary">儲存修改</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-12 text-center">
            <p>
                <small class="block">by 翁慧霖 </small>
                <small class="block">張宇光</small>
                <br>
                <small class="block">國立虎尾科技大學 資工系</small>
            </p>
        </div>

        <div class="gototop js-top">
            <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
        </div>
        
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.countTo.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/magnific-popup-options.js"></script>
        <script src="js/main.js"></script>

        <script>
        // 自動解碼 HTML entities 的輔助函數
        function decodeHtml(html) {
            const textarea = document.createElement('textarea');
            textarea.innerHTML = html;
            return textarea.value;
        }

        // 頁面載入後執行所有初始化腳本
        document.addEventListener("DOMContentLoaded", function () {
            // Loader 效果的表單提交監聽
            document.querySelectorAll("form").forEach(function (form) {
                form.addEventListener("submit", function (event) { // 接收 event 參數
                    if (!form.checkValidity()) {
                        event.preventDefault(); // 阻止表單提交，讓內建錯誤訊息顯示
                        return; 
                    }
                    // 只有當表單通過驗證並準備提交時才顯示 loader
                    document.querySelector(".fh5co-loader").style.display = "block";
                    document.body.classList.add("loading");
                    const button = form.querySelector("button[type='submit']");
                    if (button) button.disabled = true;
                });
            });

            // 編輯測資 Modal 填充資料 (此邏輯現在將不再被任何按鈕觸發，因為編輯按鈕已移除)
            // 如果未來需要重新啟用編輯功能，可以將相關程式碼加回
            const editTesterModal = document.getElementById('editTesterModal');
            if (editTesterModal) { // 確保 modal 存在
                editTesterModal.addEventListener('show.bs.modal', function (event) {
                    const button = event.relatedTarget; // 觸發模態框的按鈕
                    // 檢查 button 是否存在，如果編輯按鈕不存在，這段代碼就不會被正常觸發
                    if (!button) return; 

                    const questionFolder = button.getAttribute('data-question-folder');
                    const testerName = button.getAttribute('data-tester-name');
                    const testerInContent = button.getAttribute('data-tester-in');
                    const testerOutContent = button.getAttribute('data-tester-out');

                    const modalTitle = document.getElementById('editTesterModalLabel');
                    const inputQuestionFolder = document.getElementById('edit_question_folder');
                    const inputTesterName = document.getElementById('edit_tester_name');
                    const textareaTesterIn = document.getElementById('edit_tester_in');
                    const textareaTesterOut = document.getElementById('edit_tester_out');

                    // 填充數據
                    modalTitle.textContent = '編輯測資：' + questionFolder + ' / ' + testerName;
                    inputQuestionFolder.value = questionFolder;
                    inputTesterName.value = testerName;
                    textareaTesterIn.value = decodeHtml(testerInContent);
                    textareaTesterOut.value = decodeHtml(testerOutContent);

                    // 這裡不需要 modal.show()，因為如果按鈕是 data-bs-toggle，它會自動處理顯示
                    // 但因為按鈕已移除，這段代碼的觸發點也消失了
                });
            }
            
            // --- 處理刪除按鈕取消後要重新整理頁面的問題 ---
            // 為所有 delete-tester-form 添加提交事件監聽器
            document.querySelectorAll('.delete-tester-form').forEach(form => {
                form.addEventListener('submit', function(event) {
                    const questionFolder = this.querySelector('input[name="question_folder"]').value;
                    const testerName = this.querySelector('input[name="tester_name"]').value;

                    // 彈出確認視窗
                    const confirmation = confirm(`確定要刪除題目 ${questionFolder} 下的測資 ${testerName} 嗎？`);

                    if (!confirmation) { // 如果用戶點擊「取消」
                        event.preventDefault(); // 阻止表單提交
                        // 強制重新整理頁面
                        window.location.reload(); 
                    } else {
                        // 如果用戶點擊「確定」，正常提交表單，loader 會被 form submit 事件自動觸發
                        // 這裡不需要額外操作，因為外層的 form submit 監聽器已經處理了 loader 和按鈕禁用
                    }
                });
            });
        });
        </script>
    </div> </body>
</html>
<?php
// --- 所有資料庫操作完成後，關閉連接 ---
$conn->close();
?>