#------------------------------------------------------------------------------+
#   PROJECT : LingoBridge
#   AUTHOR  : PIN CHEN, TSAI
#   VERSION : v1.1
#   UPDATE  : 2025-08-19
#------------------------------------------------------------------------------+

#--- INPORT--------------------------------------------------------------------+

import os
import sys
import time
from datetime import datetime
import json
import google.generativeai as genai

#--- VARIABLE------------------------------------------------------------------+

# 目前所在資料夾路徑
CURRENT_DIR = os.path.dirname(os.path.abspath(__file__))

# items 資料路徑
ITEMS_PATH  = os.path.normpath(os.path.join(CURRENT_DIR, 'data/items.json'))

# 預設路徑
TASK_PATH  = os.path.normpath(os.path.join(CURRENT_DIR, 'data/sample/Q1.txt')) # 預設題目位址
CODE_PATH  = os.path.normpath(os.path.join(CURRENT_DIR, 'data/sample/test.java')) # 預設程式位址
OUTPUT_DIR = os.path.normpath(os.path.join(CURRENT_DIR, 'logs/feedback/')) # 預設輸出路徑

# 存取標準輸入
TASK_PATH  = sys.argv[1] if len(sys.argv) > 1 else TASK_PATH  # 題目位址
CODE_PATH  = sys.argv[2] if len(sys.argv) > 2 else CODE_PATH  # 程式位址
OUTPUT_DIR = sys.argv[3] if len(sys.argv) > 3 else OUTPUT_DIR # 輸出路徑

# log 檔名及路徑
TIMELOG_NAME = "timelog_Gemini.txt"
TIMELOG_DIR  = os.path.join(OUTPUT_DIR, "logs")

# Gemini回饋 檔案名稱
GEMINI_FEEDBACK_NAME = "feedback_Gemini.txt"

#指令
INSTRUCTION = """
我是一名資訊工程系(computer Science)的教授，主要教授「Java程式設計」，
我會提供給你作業題目以及學生所提交的作業，請根據我的標準執行以下5點要求，並使用中文回答。

我的標準(標示出每一項的個別分數):
- 備註(滿分20)：該程式是否包含對其功能的明確說明
- 格式(滿分25)：是否保持適當的縮排和編碼風格
- 準確性(滿分25)：程式是否產生正確的結果
- 邏輯(滿分30)：程式是否有正確的邏輯

要求:
1. 請根據我的標準為這份作業打分（0-100）
2. 根據我的標準分析它的優缺點
3. 為我的學生提供改進的程式碼
  - 基於學生的程式碼進行修改
  - 使用原有的函式、變數名稱(除非變數命名不夠直觀時可改變數名稱)、使用語法(如:for, while迴圈等)
  - 保留優點，修改缺點
4. 說明改進的程式碼有修改的部分及原因
5. 為學生提供改進建議和反饋
"""

#--- INITIAL-------------------------------------------------------------------+

# 讀取資料
with open(ITEMS_PATH, "r", encoding = "utf8") as file:
    data = json.load(file)

#--- FUNCTIONS-----------------------------------------------------------------+
def main():
    # 檢查目標檔案是否存在，並讀取檔案內容。
    # errors = 'ignore'  無法解碼的字元直接跳過，不報錯。
    # errors = 'replace' 把無法解碼的字元換成 �(U+FFFD)。
    if os.path.exists(TASK_PATH):
        with open(TASK_PATH, "r", encoding = "utf-8", errors = 'replace') as file:
            task_description = file.read()
    else:
        print(f"題目 {TASK_PATH} 不存在，請檢查路徑或檔案名稱。")
        return -1

    # 檢查目標檔案是否存在，並讀取檔案內容。
    if os.path.exists(CODE_PATH):
        with open(CODE_PATH, "r", encoding = "utf-8", errors = 'replace') as file:
            code_description = file.read()
    else:
        print(f"程式 {CODE_PATH} 不存在，請檢查路徑或檔案名稱。")
        return -2

    # 建立輸出目錄(資料夾)
    # exist_ok 預設為 False，如果目錄已存在會報錯；True 則不會報錯。
    os.makedirs(OUTPUT_DIR, exist_ok = True)

    # 取得程式碼檔名
    code_name = os.path.basename(CODE_PATH)
    
    # 輸入文本
    input_msg = INSTRUCTION + "\n\n以下為作業題目:\n" + task_description + "\n\n以下為學生程式碼:\n" + code_description

    # 加載Gemini
    g1 = Gemini()
    g1.chat(input_msg)
    g1.log(TIMELOG_NAME, TIMELOG_DIR, code_name)
    g1.savefile(GEMINI_FEEDBACK_NAME)

    return 0

class Gemini:
    def __init__(self):
        self.res  = ""  # response
        self.time = -1
    
    def chat(self, msg):
        print("【Gemini】 通話中")
        
        # 配置生成模型
        genai.configure(api_key = data["token_gemini"]) # Gemini API Token
        
        # 受制生成模型參數
        generation_config = {
          "temperature": 1,   #生成創造力，生成文本的隨機和多樣性。值越大，文本更具創意和多樣性；值越小，則較保守、接近模型所訓練的文本
          "top_p": 0.95,    #當候選 token 的累計機率達到或超過此值時，就會停止選擇更多的候選 token。值越大，生成的文本越多樣化；值越小，生成的文本越保守。
          "top_k": 40,    #限制模型只從具有最高概率的 K 個 token 中進行選擇
          "max_output_tokens": 8192,    #控制生成文本的最最大字數
          "response_mime_type": "text/plain",   #指定返回的文本格式為純文本
        }

        # 初始化模型
        model = genai.GenerativeModel(
          model_name="gemini-2.0-flash-exp",
          generation_config=generation_config,
        )

        # 開啟對話
        chat_session = model.start_chat(history=[])

        # 向模型發送消息
        Stime     = time.time() # 開始時間(sec)
        response  = chat_session.send_message(msg) # Gemini 回覆
        Etime     = time.time() # 結束時間(sec)
        self.time = Etime - Stime  # 執行時間
        print("【Gemini】 結束對話")
        self.res = response.text

    def log(self, name, dir, code_name):
        # 儲存時間 log
        os.makedirs(dir, exist_ok = True) # 建立目錄
        timelog_path = os.path.join(dir, name)
        time_now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")

        with open(timelog_path, "w", encoding = "utf-8") as file:
            file.write(f"[{time_now}] {code_name} 耗費時間(sec):{self.time}\n")
        print("【Gemini】 已儲存時間log")

    def savefile(self, name):
        # 儲存回饋
        path = os.path.join(OUTPUT_DIR, name)
        with open(path, "w", encoding = "utf-8") as file:
            file.write(self.res)
        print("【Gemini】 已儲存回饋至 " + path)


#--- MAIN----------------------------------------------------------------------+
print("【SYSTEM】 已執行LB系統")
ERROR = main()
#print(ERROR)

#--- END-----------------------------------------------------------------------+
