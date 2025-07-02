// 打開Modal
function openModal() {
    document.getElementById("modalclass").style.display = "block";
}

// 關閉Modal
function closeModal() {
    document.getElementById("modalclass").style.display = "none";
}

// 當選擇不同的小題時，更新小題內容
function loadSubQuestion() {
    const questionSelect = document.getElementById("questionSelect");
    const selectedValue = questionSelect.value;
    
    // 假設你有一個小題資料陣列，這裡的資料只是範例，實際情況應該來自伺服器或是其他資料源
    const subQuestions = {
        "1": "這是小題 1 的內容",
        "2": "這是小題 2 的內容",
        "3": "這是小題 3 的內容"
    };

    const subQuestionText = document.getElementById("subQuestionText");
    const subQuestionIndex = document.getElementById("subQuestionIndex");

    // 根據選擇的小題來更新文本框中的內容
    if (subQuestions[selectedValue]) {
        subQuestionText.value = subQuestions[selectedValue];
        subQuestionIndex.value = selectedValue; // 記錄選擇的小題編號
    } else {
        subQuestionText.value = ''; // 如果沒有選擇小題，清空內容
        subQuestionIndex.value = '';
    }
}

// 假設頁面載入時，自動填充小題選擇框
window.onload = function() {
    const questionSelect = document.getElementById("questionSelect");

    // 假設你有一個小題清單，這裡只是範例
    const questions = ["1", "2", "3"];
    
    questions.forEach(function(question) {
        let option = document.createElement("option");
        option.value = question;
        option.text = "小題 " + question;
        questionSelect.appendChild(option);
    });
};
