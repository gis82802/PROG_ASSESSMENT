//--- INFORMATION----------------------------------------------------------------------------------------------------------------------------+
/*
author  : PIN CHEN, TSAI。
version : v2.0.1
updated : 2025-09-09, (UTC+8)23:55。
detail  :
 - 將批量作業版(v1.4.1) 與 網頁執行版(v1.6.2)整合至v2正式版
 - 正式專案名稱為 JavaTesterSystem_v2；檔案名稱為 JTS_main_v2.java
*/

//--- IMPORT---------------------------------------------------------------------------------------------------------------------------------+
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JTS_main_v2 {

//--- VARIABLE-------------------------------------------------------------------------------------------------------------------------------+
    static int MODE        = 0;           // 預設模式
    static String FILE_DIR = "Homeworks"; // 預設檔案路徑
    static String TEST_DIR = "Testcases"; // 預設測資路徑
    static String LOGS_DIR = "logs";      // 工作日誌路徑

    static Path HW_DIR = Paths.get(FILE_DIR); // 待批改作業目錄
    static Path TC_DIR = Paths.get(TEST_DIR); // 批改測資目錄
    static Path LG_DIR = Paths.get(LOGS_DIR); // 工作日誌目錄

    //時間戳記
    static String NOWTIME = DateTimeFormatter.ofPattern("yyMMdd_HHmm").format(LocalDateTime.now()); // eg. 250909_1858

//--- INITIAL--------------------------------------------------------------------------------------------------------------------------------+
    private static void init() throws Exception{
        //建立資料夾
        if(!Files.exists(HW_DIR))  {Files.createDirectories(HW_DIR);  System.out.println("【JTS】 已新增"+  HW_DIR.getFileName() +"資料夾。");}
        if(!Files.exists(TC_DIR))  {Files.createDirectories(TC_DIR);  System.out.println("【JTS】 已新增"+  TC_DIR.getFileName() +"資料夾。");}
        if(!Files.exists(LG_DIR))  {Files.createDirectories(LG_DIR);  System.out.println("【JTS】 已新增"+  LG_DIR.getFileName() +"資料夾。");}
    }

//--- FUNCTION-------------------------------------------------------------------------------------------------------------------------------+
    private static int runCompile(String fileName, File outFile) throws Exception{

        // 直接執行程式(限用java11以上之版本，否則得使用javac進行編譯)
        // 如果需要 javac編譯版本，請參考 v1.6.2寫法。
        ProcessBuilder pb = new ProcessBuilder("java", fileName);
        pb.directory(HW_DIR.toFile());  // 設定執行路徑

        // 檢查是否有可用的輸入測資(true or false)
        String testName = outFile.getName().replace(".out", ""); // eg. 01.out -> 01
        File inFile = TC_DIR.resolve(testName + ".in").toFile();
        if(inFile.exists()){
            // 如果輸入測資存在
            pb.redirectInput(inFile);
        }

        // 開始執行
        Process p2 = pb.start();

        // 讀取標準輸出(stdout)
        BufferedReader reader = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        List<String> actual = new ArrayList<>(); // 儲存標準輸出結果
        String line;
        while((line = reader.readLine()) != null){
            actual.add(line);
        }

        // 程式碼超時判定
        boolean finished = p2.waitFor(5, java.util.concurrent.TimeUnit.SECONDS); //等待 5sec
        if(!finished){
            p2.destroyForcibly(); // 強制結束程式
            return 999;
        }

        // 檢查程式狀態，0表示正常結束程式，反之為失敗。
        int exitCode = p2.exitValue();
        if(exitCode != 0) return 400;

        // 檢核輸出是否與測資相同
        List<String> expected = new ArrayList<>(); // 存取測資輸出結果
        try(BufferedReader br = new BufferedReader(new FileReader(outFile))){
            while((line = br.readLine()) != null){
                expected.add(line);
            }
        }

        // 最後結果判定
        boolean ans = actual.equals(expected);
        if(ans){
            // 如果比對結果相同，則為通過。
            return 0;
        }
        return -1;
    }

//--- MAIN-----------------------------------------------------------------------------------------------------------------------------------+

    // 如果 System.exit(0),表示成功通過JTS批改；反之回傳錯誤代碼。
    public static void main(String[] args) {

        // 1. 粗略檢查引數(參數)格式是否符合要求
        if(args.length < 1 || args.length > 3) {
            System.out.println("[Usage_batch] : java JTS_main_v2 0");
            System.out.println("[Usage_return]: java JTS_main_v2 1 <FileDir> <testcaseDir>");
            System.exit(400);
        }
        MODE     = (args.length > 0) ? Integer.parseInt(args[0]) : MODE; // eg. 1
        FILE_DIR = (args.length > 1) ? args[1] : FILE_DIR;               // eg. Homeworks/
        TEST_DIR = (args.length > 2) ? args[2] : TEST_DIR;               // eg. Testcases/

        // 2. 執行初始化
        try{
            init();
        }catch(Exception e) {
            e.printStackTrace();
            System.exit(500);
        }
        

        // 3. 核查目標路徑是否存在
        if(!Files.exists(HW_DIR)) System.exit(404);
        if(!Files.exists(TC_DIR)) System.exit(404);

        // 4. 讀取待批改作業
        File[] javaFiles = HW_DIR.toFile().listFiles((dir, name) -> name.endsWith(".java"));
        if(javaFiles == null || javaFiles.length == 0){
            System.out.println("【ERROR】 找不到任何待批改作業，已終止批改。");
            System.exit(405);
        }else{
            System.out.println("【JTS】 已加載: "+ javaFiles.length +"份作業。");
        }

        // 5. 讀取測資資料
        File[] inputFiles  = TC_DIR.toFile().listFiles((dir, name) -> name.endsWith(".in"));
        File[] outputFiles = TC_DIR.toFile().listFiles((dir, name) -> name.endsWith(".out"));
        if(outputFiles == null || outputFiles.length == 0){
            System.out.println("【ERROR】 找不到任何輸出測資，已終止批改。");
            System.exit(406);
        }else{
            System.out.println("【JTS】 已加載: "+ inputFiles.length +"份輸入測資，"+ outputFiles.length +"份輸出測資。");
        }

        // 6. 開始進行批改，並撰寫工作日誌。
        List<String> logs = new ArrayList<>(); //紀錄每份作業的結果
        int allPassed = 0;                     // 若通過所有測資將為0
        for(File ja : javaFiles) {
            String fileName = ja.getName();    //eg. 41243211_1.java
            
            int Passed = 0;             // 若通過測資將為0
            for(File outFile : outputFiles){
                if(Passed != 0) break;  // 無法通過測資，故跳出迴圈。
                try{
                    Passed = runCompile(fileName, outFile);
                }catch(Exception e){
                    e.printStackTrace();
                    System.exit(500);
                }
            }

            // 撰寫工作日誌
            if(Passed == 0) {
                logs.add(fileName + " -> 通過測資");
            }else {
                allPassed += 1;
                if     (Passed == 400) logs.add(fileName + " -> 出現異常錯誤");
                else if(Passed == 999) logs.add(fileName + " -> 出現超時錯誤");
                else                   logs.add(fileName + " -> 未通過測資");
            }
        }

        // 7. 儲存工作日誌
        Path logFilePath = LG_DIR.resolve(NOWTIME + ".log");  // 工作日誌路徑
        try(BufferedWriter writer = Files.newBufferedWriter(logFilePath)){
            for(String log : logs){
                writer.write(log + "\n");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.exit(500);
        }
        System.out.println("【JTS】 已儲存工作日誌於 " + logFilePath);

        // 8. 結束程式並回傳結果
        if(allPassed == 0){
            System.out.println("【JTS】 所有作業成功通過測資批改。");
            System.exit(0);
        }else{
            System.out.printf("【JTS】 共 %d 份作業未通過測資批改。", allPassed);
            System.exit(-1);
        }
    }
}

//--- END------------------------------------------------------------------------------------------------------------------------------------+