function loadDataAndShowModal(userId) {
    document.getElementById('modalContent').innerText = 'Loading...';

    fetch(`../php/gethomework.php?id=${userId}`)
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