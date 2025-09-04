#------------------------------------------------------------------------------+
#   PROJECT : WebtoLB
#   AUTHOR  : PIN CHEN, TSAI
#   VERSION : v0.2
#   UPDATE  : 2025-09-04
#   DETAILS : 
#       - 追加sys.exit()功能
#------------------------------------------------------------------------------+

#--- INPORT--------------------------------------------------------------------+

import os
import sys

import LingoBridge_v1_5 as LB

#--- VARIABLE------------------------------------------------------------------+

# 如果為0，表示正常結束程序
ERROR = 0

# LLM模型選擇，Gemini為1，Mistral為2
MODE = 1

# 目前所在目錄
CURRENT_DIR = os.path.dirname(os.path.abspath(__file__))

# items 資料路徑
DATA_DIR    = os.path.normpath(os.path.join(CURRENT_DIR, 'data/'))
ITEMS_PATH  = os.path.normpath(os.path.join(DATA_DIR, 'items.json'))

# 預設提問路徑
QUIZ_PATH = os.path.normpath(os.path.join(DATA_DIR, "quiz/default.txt"))

# 預設題目路徑
TOPIC_PATH = os.path.normpath(os.path.join(DATA_DIR, "sample/Q1.txt"))

# 預設程式碼路徑
CODE_PATH = os.path.normpath(os.path.join(DATA_DIR, "sample/test.java"))

# 預設輸出路徑
OUTPUT_PATH = os.path.normpath(os.path.join(DATA_DIR, "quiz/WebQuiz.txt"))

#--- INITIAL-------------------------------------------------------------------+

# 讀取標準輸入
TOPIC_PATH = os.path.normpath(sys.argv[1]) if len(sys.argv) > 1 else TOPIC_PATH  # 題目路徑
CODE_PATH  = os.path.normpath(sys.argv[2]) if len(sys.argv) > 2 else CODE_PATH   # 程式路徑


#--- FUNCTIONS-----------------------------------------------------------------+

def main(mode):

    # 讀取提問文本
    # errors = 'replace' 把無法解碼的字元換成 �(U+FFFD)。
    if os.path.exists(QUIZ_PATH):
        with open(QUIZ_PATH, "r", encoding = "utf-8", errors = "replace") as file:
            quiz_description = file.read()
    else:
        print(f"【ERROR】 提問文本 {QUIZ_PATH} 不存在，請檢查相關路徑或檔案名稱。")
        return -1
    # print(quiz_description)

    # 讀取題目文本
    # errors = 'replace' 把無法解碼的字元換成 �(U+FFFD)。
    if os.path.exists(TOPIC_PATH):
        with open(TOPIC_PATH, "r", encoding = "utf-8", errors = "replace") as file:
            topic_description = file.read()
    else:
        print(f"【ERROR】 題目文本 {TOPIC_PATH} 不存在，請檢查相關路徑或檔案名稱。")
        return -2
    # print(topic_description)

    # 讀取程式作業
    # errors = 'replace' 把無法解碼的字元換成 �(U+FFFD)。
    if os.path.exists(CODE_PATH):
        with open(CODE_PATH, "r", encoding = "utf-8", errors = "replace") as file:
            code_description = file.read()
    else:
        print(f"【ERROR】 程式作業 {CODE_PATH} 不存在，請檢查相關路徑或檔案名稱。")
        return -3
    # print(code_description)

    # 將所有文本存為.txt
    input_msg = quiz_description + "\n\n以下為作業題目:\n" + topic_description + "\n\n以下為學生程式碼:\n" + code_description
    savefile(OUTPUT_PATH, input_msg)

    # 執行LB系統
    LB_msg = LB.main(mode, input_msg)
    print(LB_msg)

    # 結束程式
    return 0

def savefile(path, msg):
    # 將文字內容保存為 .txt

    with open(path, "w", encoding = "utf-8") as file:
        file.write(msg)
    # print(f"【SYSTEM】 已保存至 {path}")

#--- MAIN----------------------------------------------------------------------+

if ERROR == 0:
    # print("【SYSTEM】 已執行中")
    ERROR = main(MODE)

if ERROR != 0:
    # 若程式未順利完成，回傳 1，表示發生錯誤
    print(f"【ERROR】 發生錯誤 {ERROR}，已停止程序")
    sys.exit(1)

# 若程式順利執行完成，則回傳 0
# print("【SYSTEM】 WebtoLB.py 已結束")
sys.exit(0)

#--- END-----------------------------------------------------------------------+
