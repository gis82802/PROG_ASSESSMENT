<!DOCTYPE html>
<html lang="zh-Hant">
<head>
  <meta charset="UTF-8">
  <title>Modal 測試</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">使用者資料</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <div class="modal-body" id="modalContent">
        Loading...
      </div>
    </div>
  </div>
</div>

<!-- 觸發按鈕 -->
<ul>
  <li>使用者A <button onclick="loadDataAndShowModal('00000000')">詳情</button></li>
  <li>使用者B <button onclick="loadDataAndShowModal('00000001')">詳情</button></li>
</ul>

<script>
  function loadDataAndShowModal(userId) {
    document.getElementById('modalContent').innerText = 'Loading...';

    fetch(`./php/gethomework.php?id=${userId}`)
      .then(response => response.json())
      .then(data => {
        if (data.error) {
          document.getElementById('modalContent').innerText = data.error;
        } else {
          // 更新 modal 內容
          document.getElementById('modalContent').innerHTML =
            `<p>作業數：${data.QuestionSum}</p>`;
          
          const myModal = new bootstrap.Modal(document.getElementById('myModal'));
          myModal.show();
        }
      })
      .catch(err => {
        document.getElementById('modalContent').innerText = '載入失敗';
        console.error(err);
      });
  }
</script>

</body>
</html>
