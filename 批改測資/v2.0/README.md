## v2.0.1
- 將批量作業版(v1.4.1) 與 網頁執行版(v1.6.2)整合至v2正式版
- 正式專案名稱為 JavaTesterSystem_v2；檔案名稱為 JTS_main_v2.java
- 目前有二種批改模式，本地批改 與 目標批改，使用方式如下:
### 本地批改  
```
java JTS_main_v2.java 0
```
### 目標批改  
```
java JTS_main_v2.java {(int)MODE} {(str)作業目錄} {(str)測資目錄}
```
- 引數中的 MODE 目前無實裝任何功能，輸入任意 int即可

## v2.0.2
- 將時間格式從 "yyMMdd_HHmm" 改為 "yyMMdd_HHmmssSS"
