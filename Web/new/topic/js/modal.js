document.addEventListener("DOMContentLoaded", function () {
    // 取得所有的按鈕
    const openModalBtns = document.querySelectorAll(".openModalBtn");
  
    openModalBtns.forEach(function (btn) {
      btn.addEventListener("click", function () {
        // 根據按鈕的data-modal屬性顯示對應的彈跳視窗
        const modalId = btn.getAttribute("data-modal");
        const modal = document.getElementById(modalId);
        modal.style.display = "block";
      });
    });
  
    // 取得所有的關閉按鈕
    const closeModalBtns = document.querySelectorAll(".close");
  
    closeModalBtns.forEach(function (btn) {
      btn.addEventListener("click", function () {
        // 關閉彈跳視窗
        const modal = btn.closest(".modal");
        modal.style.display = "none";
      });
    });
  
    // 當用戶點擊彈跳視窗外的地方，關閉彈跳視窗
    window.addEventListener("click", function(event) {
      const modals = document.querySelectorAll(".modal");
      modals.forEach(function(modal) {
        if (event.target == modal) {
          modal.style.display = "none";
        }
      });
    });
  });