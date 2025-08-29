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
