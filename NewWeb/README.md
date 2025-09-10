## v0.0.1
- index.php (首頁)
- config.php (資料庫連線設定)
- data.php (顯示資料庫內容)
- login.php (登入)
- register.php (註冊)
- 以上僅前端網頁，尚未具有功能
- 建立資料庫雛形

| Name | Type | Collation | Attributes | Null | Default | Comments | Extra | Action |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **List Primary** | int(8) | | | No | None | | AUTO_INCREMENT | |
| **UserID** | int(8) | | | No | None | | | |
| **Email** | varchar(255) | utf8mb4_general_ci | | No | None | | | |
| **Password** | varchar(255) | utf8mb4_general_ci | | No | None | | | |
| **FirstName** | varchar(100) | utf8mb4_general_ci | | No | None | | | |
| **LastName** | varchar(100) | utf8mb4_general_ci | | No | None | | | |
| **Job** | tinyint(1) | | | No | None | | | |

## v0.0.2
- 更改程式，資料庫名字，由topic-> AGFS
- {基於大語言模型之程式作業自動評分與建議回饋系統(Automatic Grading and Feedback System for planning assignments based on a Large Language Model)}
