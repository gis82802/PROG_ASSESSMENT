# 所需模組表
```
pip install google-genai
pip install mistralai
```

## 匯入方式
- 到data目錄中下載 requirements.txt
- 在同目錄執行該段程式
```
pip install -r requirements.txt
```

## LingoBridge_v1.0
- 重新撰寫Gemini.py 之功能，命名為 LingoBridge (語言橋梁)，可簡寫為LB
- 預留Mistral 的撰寫空間

## LingoBridge_v1.1
- 將Gemini功能重新包裝成 class
- 尚未實裝Mistral功能
- 希望將 INSTRUCTION (指令) 更改為讀取.txt檔案，未來較無需更動程式碼

## LingoBridge_v1.2
- 追加報錯功能(避免LLM無法呼叫)
- 更改 log 相關資料格式及路徑

## LingoBridge_v1.3
- 追加 Mistral LLM模型 (模式選則為 2)
- log 時間改為 yyMMdd_HHmmSS (原為 yyMMdd_HHmm)
- 如果 items.json不存在時，會終止執行系統
- 此為正式版本，可串聯應用於網頁或其他程序
  - 應用於專題網頁恐還需要一份串接程式碼
- 使用方式如下:
```
python LingoBridge_v1.3.py {(int)模型選擇} {(str)提問路徑} {(str)輸出路徑}
```
以上參數均為可選，若無提供則會執行預設路徑
- 模型預設: (1) gemini-2.0-flash-exp
- 提問路徑: data/quiz/default.txt
- 輸出路徑: logs/{log}/  
- **使用需知**
  - 使用前，請務必自行更改data/items.json內的LLM Token，方可使用

## LingoBridge_v1.4
- 由傳入文本路徑及輸出路徑，更改為直接輸入輸出字串
- 使用方式如下:
```
python LingoBridge_v1.4.py {(int)模型選擇} {(str)輸出文本}
```

## 2025.08.29
- 上傳data/ 範例資料

## LingoBridge_v1_4
- 由傳入文本路徑及輸出路徑，更改為直接輸入輸出字串
- 標準輸入改為備援功能，以間接程式呼叫為主
- 命名規則從v1.4改為 v1_4
- main不再回傳錯誤值，改為回傳AI回饋，預設為None
- 將log目錄建立從初始化，移至main()中處理

## LingoBridge_v1_5
- 針對間接程式呼叫進行問題除錯
- 將提示性的patint全數註解，以便後續做使用

## WebtoLB
### v0.1 開發初稿
- 使用方式如下:
  - 題目路徑 & 程式路經均為可選，存在預設選項
```
python WebtoLB.py {(str)題目.txt路徑} {(str)程式.java路徑}
```

### v0.2 更新
- 追加sys.exit()功能；若未順利執行，回傳 1；反之若順利執行則為 0
