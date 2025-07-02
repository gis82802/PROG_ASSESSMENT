
document.addEventListener("DOMContentLoaded", function () {
	const openButtons = document.querySelectorAll(".openModalBtn");

	openButtons.forEach(button => {
		button.addEventListener("click", function () {
			const modalId = this.getAttribute("data-modal");
			const modal = document.getElementById(modalId);
			if (modal) {
				modal.style.display = "block";
			}
		});
	});

	// 關閉按鈕（X）
	const closeButtons = document.querySelectorAll(".modal .close");
	closeButtons.forEach(closeBtn => {
		closeBtn.addEventListener("click", function () {
			this.closest(".modal").style.display = "none";
		});
	});

	// 點擊背景關閉 modal
	window.addEventListener("click", function (event) {
		if (event.target.classList.contains("modal")) {
			event.target.style.display = "none";
		}
	});
});
