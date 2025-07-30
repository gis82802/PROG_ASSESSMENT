document.querySelector('.openModalBtn').addEventListener('click', function () {
    document.getElementById('modal').style.display = 'block';
  });

  // 關閉 Modal
  document.querySelector('.close').addEventListener('click', function () {
    document.getElementById('modal').style.display = 'none';
  });

  // 提交表單後處理
  document.getElementById('joinClassForm').addEventListener('submit', function (e) {
    e.preventDefault(); // 阻止表單的預設提交行為

    const classid = document.getElementById('classid').value;
    const resultMsg = document.getElementById('resultMsg');

    fetch('php/joinclass.php', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body: 'classid=' + encodeURIComponent(classid)
    })
    .then(response => response.text())
    .then(data => {
      resultMsg.innerHTML = data; // 顯示 PHP 回傳訊息
    })
    .catch(error => {
      resultMsg.innerHTML = "<h3 style='color:red;'>發生錯誤，請稍後再試。</h3>";
      console.error('錯誤:', error);
    });
  });