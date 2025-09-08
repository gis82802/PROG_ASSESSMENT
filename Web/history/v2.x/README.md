## v2.0.1
- 資料庫格式大改
- 測資批改系統正式上線作用

## v2.0.2
- 更新編輯測資(edittester.php)之網頁資訊
- 修改測資批改系統資料夾名稱，以及相關程式之路徑(php/uploadhomework.php)
  - /java -> /javaTester
- php/uploadhomework.php
  - 重新註解部分未使用之段落(eg. AI批改系統)
  - 新增部分區段的註解說明
  - 將"批改程式系統" 統一更名為 "測資批改系統" "JavaTesterSystem"，縮寫為JTS，又名javaTester。

## v2.0.3
- 更新"uploadhomework.php"網頁顯示資訊
  - 區分成功(report)、錯誤(error)訊息，以及測資系統狀態之顯示。
- 測資批改系統由main_v5.java 更新為 main_v6.java
- 測資程式系統由main_v6.java 正式命名為JTS_main.java

## v2.0.4
- 資料新增: 0820 暑修課程內容
- py/ 更新為 LingoBridge/
  - 尚保留原始的Gemini.py Mistral.py
  - 目前LB系統 最高版本為 LingoBridge_v1.1.py
  - 未來會將LLM Token(API) 程式碼中移除，相關資料請於 data/items.json 寫入
- php/uploadhomework.php
  - "uploadhomework - 複製.php" 此為v2.0.3版本(備份用途)
  - "uploadhomework.php" 正在追加 LB系統，為半成品程式碼，雖尚未上線相關功能，但不影響其他網頁功能

## v2.1.1
- 新增selecthomework6添加了教師端的批改功能

## v2.1.2
- 修正無法註冊問題

 ## v2.1.3
- 修正註冊帳號KEY重複偵測問題(topic/php/signup.php)
