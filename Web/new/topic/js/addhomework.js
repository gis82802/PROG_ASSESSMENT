
let subQuestionCount = 0;

function addSubQuestion() {
	subQuestionCount++;

	const container = document.getElementById("subQuestionsContainer");

	// 建立一個包住整行的小題區塊
	const div = document.createElement("div");
	div.className = "sub-question";
	div.id = `subQ${subQuestionCount}`;

	// 小題輸入欄
	const input = document.createElement("input");
	input.type = "text";
	input.name = `subTitle${subQuestionCount}`;
	input.placeholder = `題目 ${subQuestionCount} `;
	input.required = true;

	// 刪除按鈕
	const btn = document.createElement("button");
	btn.type = "button";
	btn.textContent = "❌ 刪除";
	btn.onclick = function () {
        subQuestionCount--;
		container.removeChild(div);
	};

	// 加到 div 裡
	div.appendChild(input);
	div.appendChild(btn);

	// 加到 container 裡
	container.appendChild(div);
	document.getElementById("subCount").value = subQuestionCount;

}
