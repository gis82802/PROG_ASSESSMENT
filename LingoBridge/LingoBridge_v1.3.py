#------------------------------------------------------------------------------+
#   PROJECT : LingoBridge
#   AUTHOR  : PIN CHEN, TSAI
#   VERSION : v1.3
#   UPDATE  : 2025-08-23
#------------------------------------------------------------------------------+

#--- INPORT--------------------------------------------------------------------+

import os
import sys
import time
from datetime import datetime
import json
import google.generativeai as genai
from mistralai import Mistral as misai

#--- VARIABLE------------------------------------------------------------------+

# 如果為0，表示正常結束程序
ERROR = 0

# LLM模型選擇，預設為0
MODE = 0

# 目前所在目錄
CURRENT_DIR = os.path.dirname(os.path.abspath(__file__))

# items 資料路徑
DATA_DIR    = os.path.normpath(os.path.join(CURRENT_DIR, 'data/'))
ITEMS_PATH  = os.path.normpath(os.path.join(DATA_DIR, 'items.json'))

# log 目錄及檔名
LOG_TIME = datetime.now().strftime("%y%m%d_%H%M%S") # 時間擷取 eg. 250822_184759
LOGS_DIR = os.path.normpath(os.path.join(CURRENT_DIR, "logs/")) # logs 根目錄
LOG_DIR  = os.path.normpath(os.path.join(LOGS_DIR, LOG_TIME))   # 本次 log目錄
LOG_NAME          = LOG_TIME + ".log"         # log 檔名
LOG_FEEDBACK_NAME = "@_feedback.txt" # feedback 檔名
LOG_QUIZ_NAME     = "quiz.txt"       # quiz 檔名

# 提問文本 預設路徑
QUIZ_PATH = os.path.normpath(os.path.join(DATA_DIR, "quiz/default.txt"))

# 輸出文本 預設目錄
OUTPUT_DIR = LOG_DIR

#--- INITIAL-------------------------------------------------------------------+

# 初始化必要目錄
# exist_ok 預設為 False，如果目錄已存在會報錯；True 則不會報錯。
os.makedirs(DATA_DIR, exist_ok = True)     # 建立 data目錄
os.makedirs(LOGS_DIR, exist_ok = True)     # 建立 logs 根目錄
os.makedirs(LOG_DIR, exist_ok = True)      # 建立 log 目錄

# 讀取 items.json 資料
if os.path.exists(ITEMS_PATH):
    with open(ITEMS_PATH, "r", encoding = "utf-8") as file:
        data = json.load(file)
else:
    print("【ERROR】 items.json 不存在，請檢查是否存在於" + ITEMS_PATH)

# 讀取標準輸入
MODE       = int(sys.argv[1]) if len(sys.argv) > 1 else MODE   # 模型選擇
QUIZ_PATH  = os.path.normpath(sys.argv[2]) if len(sys.argv) > 2 else QUIZ_PATH   # 提問路徑
OUTPUT_DIR = os.path.normpath(sys.argv[3]) if len(sys.argv) > 3 else OUTPUT_DIR  # 輸出路徑


#--- FUNCTIONS-----------------------------------------------------------------+

def main(mode):
    # print(mode)

    # 讀取提問文本
    # errors = 'replace' 把無法解碼的字元換成 �(U+FFFD)。
    if os.path.exists(QUIZ_PATH):
        with open(QUIZ_PATH, "r", encoding = "utf-8", errors = "replace") as file:
            quiz_description = file.read()
    else:
        print(f"【ERROR】 提問文本 {QUIZ_PATH} 不存在，請檢查相關路徑或檔案名稱。")
        return -1
    # print(quiz_description)

    # 選擇模型進行提問
    mode =  Choose_LLM(mode)

    feedback  = "" # 模型回饋文本
    LLM_name  = "" # 使用模型名稱
    used_time = -1 # 模型回覆使用時間
    finished  = -1 # 如果為0，表示正常結束LLM
    if mode == 1:
        LLM_name  = "gemini-2.0-flash-exp"
        print(f"【SYSTEM】 已選擇 {LLM_name} 模型")
        g1 = Gemini(LLM_name)
        finished  = g1.run(quiz_description)
        feedback  = g1.res
        used_time = g1.time
    elif mode == 2:
        LLM_name  = "mistral-large-latest"
        print(f"【SYSTEM】 已選擇 {LLM_name} 模型")
        m1 = Mistral(LLM_name)
        finished  = m1.run(quiz_description)
        feedback  = m1.res
        used_time = m1.time

    # 若非預期結束LLM，則回報錯誤
    if finished != 0:
        print("【ERROR】 LLM非預期輸出，已終止執行")
        return -2

    # 儲存模型回饋
    fb_name = LOG_FEEDBACK_NAME.replace("@", LLM_name)
    savefile(LOG_DIR, fb_name, feedback)

    # 儲存提問文本
    savefile(LOG_DIR, LOG_QUIZ_NAME, quiz_description)

    # 撰寫工作紀錄 (log)，並儲存
    log_description = makeLog(LLM_name, used_time)
    savefile(LOG_DIR, LOG_NAME, log_description)

    # 如果輸出目錄非 log路徑時，再輸出一份至指定路徑
    if OUTPUT_DIR != LOG_DIR:
        os.makedirs(OUTPUT_DIR, exist_ok = True) # 建立輸出目錄
        savefile(OUTPUT_DIR, fb_name, feedback)

    return 0

def Choose_LLM(mode):
    if(mode >= 1 and mode <= 2):
        return mode
    else:
        # 預設使用模型
        return 1

def savefile(dir, name, msg):
    # 將文字內容保存為 .txt
    path = os.path.join(dir, name)

    with open(path, "w", encoding = "utf-8") as file:
        file.write(msg)
    print(f"【SYSTEM】 已保存 {name} 至{path}")

def makeLog(name, used_time):
    time_log = datetime.now().strftime("%Y-%m-%d %H:%M:%S") # 取得當前時間 eg. 2025-08-22 19:25:47
    result = f"[{time_log}] 【{name}】 耗費時間(sec): {used_time}\n"
    return result

class Gemini:
    def __init__(self, name):
        self.name = name
        self.res  = "" # response
        self.time = -1

    def run(self, msg):
        # 嘗試呼叫 Gemini 模型
        try:
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
              model_name = self.name,
              generation_config=generation_config,
            )

            # 開啟對話
            chat_session = model.start_chat(history=[])

            # 向模型發送消息
            Stime     = time.time()    # 開始時間(sec)
            response  = chat_session.send_message(msg) # Gemini 回覆
            Etime     = time.time()    # 結束時間(sec)
            self.time = Etime - Stime  # 執行時間
            print("【Gemini】 結束對話")

            # 回傳模型回覆
            self.res = response.text
            return 0

        except KeyError:
            print("【ERROR】 API 密鑰未設定，請檢查Token是否正確。")
            return 1
        except Exception as e:
            print(f"【ERROR】 發生錯誤: {e}")
            return 2

class Mistral:
    def __init__(self, name):
        self.name = name
        self.res  = "" # response
        self.time = -1

    def run(self, msg):
        # 嘗試呼叫 Mistral 模型
        try:
            print("【Mistral】 通話中")
            
            # 初始化模型
            client = misai(api_key = data["token_mistral"]) # Mistral API Token
            
            # 向模型發送消息
            Stime     = time.time()    # 開始時間(sec)
            response  = client.chat.complete(
                model = self.name,
                messages = [
                    {
                        "role": "user",
                        "content": msg,
                    }
                ]
            )
            self.res = response.choices[0].message.content
            Etime     = time.time()    # 結束時間(sec)
            self.time = Etime - Stime  # 執行時間
            print("【Mistral】 結束對話")
            return 0

        except KeyError:
            print("【ERROR】 API 密鑰未設定，請檢查Token是否正確。")
            return 1
        except Exception as e:
            print(f"【ERROR】 發生錯誤: {e}")
            return 2

#--- MAIN----------------------------------------------------------------------+
if ERROR == 0:
    print("【SYSTEM】 已執行LB系統")
    ERROR = main(MODE)
else:
    print("【ERROR】 發生錯誤，已停止程序")

#--- END-----------------------------------------------------------------------+
