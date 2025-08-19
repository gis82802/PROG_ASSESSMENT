#------------------------------------------------------------------------------+
#   PROJECT : LingoBridge
#   AUTHOR  : PIN CHEN, TSAI
#   VERSION : v1.0
#   UPDATE  : 2025-08-19
#------------------------------------------------------------------------------+

#--- INPORT--------------------------------------------------------------------+

import os
import sys
import time
from datetime  import datetime
import json
import google.generativeai as genai

#--- PATH SETTING--------------------------------------------------------------+
current_dir = os.path.dirname(os.path.abspath(__file__))  # 目前所在資料夾路徑
items_path  = os.path.normpath(os.path.join(current_dir, 'data/items.json')) # items 資料路徑
logs_dir    = os.path.normpath(os.path.join(current_dir, 'logs/'))   # 紀錄檔儲存路徑
base_path   = os.path.normpath(os.path.join(current_dir, '../data/')) # 資料基本路徑 (eg. ../xampp/htdocs/topic/data/)
output_dir  = os.path.normpath(os.path.join(current_dir, 'logs/feedback/')) # 預設輸出路徑


#--- INITIAL-------------------------------------------------------------------+

# 開啟資料 讀取模式
with open(items_path, "r", encoding = "utf8") as file:
    data = json.load(file)

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
chat_session = model.start_chat(
  history=[
  ]
)

#--- VARIABLE------------------------------------------------------------------+

#指令
instruction = """
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

# 存取標準輸入
task_path  = sys.argv[1] if len(sys.argv) > 1 else task_path  # 題目位址
code_path  = sys.argv[2] if len(sys.argv) > 2 else code_path  # 程式位址
output_dir = sys.argv[3] if len(sys.argv) > 3 else output_dir # 輸出路徑

# 檢查目標檔案是否存在，並讀取檔案內容。
# errors = 'ignore'  無法解碼的字元直接跳過，不報錯。
if os.path.exists(task_path):
    with open(task_path, "r", encoding = "utf-8", errors = 'replace') as file:
        task_description = file.read()
else:
    print(f"題目 {task_path} 不存在，請檢查路徑或檔案名稱。")

# 檢查目標檔案是否存在，並讀取檔案內容。
# errors = 'replace' 把無法解碼的字元換成 �(U+FFFD)。
if os.path.exists(code_path):
    with open(code_path, "r", encoding = "utf-8", errors = 'replace') as file:
        code_description = file.read()
else:
    print(f"程式 {code_path} 不存在，請檢查路徑或檔案名稱。")

# 建立輸出目錄(資料夾)
# exist_ok 預設為 False，如果目錄已存在會報錯；True 則不會報錯。
os.makedirs(output_dir, exist_ok = True)

# 取得程式碼檔名
code_name = os.path.basename(code_path)

#--- FUNCTIONS-----------------------------------------------------------------+

# 嘗試聯絡LLM模型
def Gemini():
    try:
        print("進入Gemini")
        
        # 輸入文本
        input_msg = instruction + "\n\n以下為作業題目:\n" + task_description + "\n\n以下為學生的程式碼:\n" + code_description
        
        # 向模型發送消息
        start_time = time.time()
        response   = chat_session.send_message(input_msg)
        end_time   = time.time()
        execution_time = end_time - start_time # 執行時間
        print("Gemini結束對話")
        
        # 儲存時間 log
        timelog_name = "timelog_Gemini.txt"
        timelog_dir  = os.path.join(output_dir, "logs")
        os.makedirs(timelog_dir, exist_ok = True) # 建立目錄
        timelog_path = os.path.join(timelog_dir, timelog_name)
        time_now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        with open(timelog_path, "w", encoding = "utf-8") as file:
            file.write(f"[{time_now}] {code_name} 耗費時間(sec):{execution_time}\n")
        #print("已儲存時間log")
        
        # 儲存回饋
        output_name = "feedback_Gemini.txt"
        output_path = os.path.join(output_dir, output_name)
        with open(output_path, "w", encoding = "utf-8") as file:
            file.write(response.text)
        print("已儲存 Gemini 回饋至 " + output_path)
        
    except KeyError:
        print("API 密鑰未設定，請檢查Token是否正確。")
    except Exception as e:
        print(f"AI執行到 {code_name} 時出現錯誤: {e}")

def Mistral():
    try:
        print("進入Mistral")
        
        
    except KeyError:
        print("API 密鑰未設定，請檢查Token是否正確。")
    except Exception as e:
        print(f"AI執行到 {code_name} 時出現錯誤: {e}")

#--- MAIN----------------------------------------------------------------------+

#Gemini()
#Mistral()

#--- END-----------------------------------------------------------------------+
