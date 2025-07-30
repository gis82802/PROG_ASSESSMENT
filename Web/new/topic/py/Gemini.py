import os
import sys
import time
from datetime  import datetime
import google.generativeai as genai



'''with open('C:\\xampp\\htdocs\\topicbee\\py\\py_debug.txt', 'a', encoding='utf-8') as f:
    for i, arg in enumerate(sys.argv):
        f.write(f"argv[{i}]: {repr(arg)}\n")'''

# 配置生成模型
os.environ["GEMINI_API_KEY"] = "AIzaSyArn2HirJC47uM3GQWZPCwi8gYdyJMoLvc" # 環境變數中的 API 密鑰

# 配置生成模型
genai.configure(api_key=os.environ["GEMINI_API_KEY"])

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

#指令
instruction = """
我是一所大學計算機科學系的教授，主要教授「Java程式設計」，我將會提供學生所提交的作業，請你根據我的標準執行以下5點要求，並使用中文回答。
我的標準(標示出每一項的個別分數):
-備註(滿分20)：該程式是否包含對其功能的明確說明
-格式(滿分25)：是否保持適當的縮排和編碼風格
-準確性(滿分25)：程式是否產生正確的結果
-邏輯(滿分30)：程式是否有正確的邏輯

要求:
1. 請根據我的標準為這份作業打分（0-100）

2. 根據我的標準分析它的優缺點

3. 為我的學生提供改進的程式碼
-基於學生的程式碼進行修改
-使用原有的函式、變數名稱(除非變數命名不夠直觀時可改變數名稱)、使用語法(如:for, while迴圈等)
-保留優點，修改缺點

4.說明改進的程式碼有修改的部分及原因

5.為學生提供改進建議和反饋
"""

# 讀取特定路徑中的 .txt 檔案作為 task_description
# 設定路徑（用原始字串與 os.path.join）
base_path = r"C:\xampp\htdocs\topic\data"
task_file_path = os.path.join(base_path, sys.argv[1], sys.argv[2], f"homework_texts", f"Q{sys.argv[4]}.txt")
java_file_path = os.path.join(base_path, sys.argv[1], sys.argv[2], "homework", sys.argv[3], f"Q{sys.argv[4]}", sys.argv[5])
output_directory = os.path.join(base_path, sys.argv[1], sys.argv[2], "feedback", sys.argv[3])


# 檢查檔案是否存在，並讀取檔案內容
if os.path.exists(task_file_path):
    with open(task_file_path, "r", encoding="utf-8", errors='ignore') as file:
        task_description = file.read()
else:
    print(f"檔案 {task_file_path} 不存在，請檢查路徑或檔案名稱。")


os.makedirs(output_directory, exist_ok=True)

file_path = java_file_path

java_filename = os.path.basename(file_path)

try:
    # 讀取 Java 檔案的程式碼
    with open(file_path, "r", encoding="utf-8", errors='ignore') as file:
        code = file.read()

    # 將指令、題目、程式碼串接
    input_message = instruction + "\n" + task_description + "\n作業(程式碼)內容:\n" + code

    # 向模型發送消息
    start_time = time.time()
    response = chat_session.send_message(input_message)
    end_time = time.time()
    execution_time = end_time - start_time

    # 儲存時間 log
    timelog_path = os.path.join(output_directory, "Gemini_feedback_timelog.txt")
    formatted_time = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    with open(timelog_path, "w", encoding="utf-8") as file:
        file.write(f"{formatted_time} {java_filename}_feedback_timelog : {execution_time}\n")

    # 輸出 Gemini 評語
    output_filename = "Q"+sys.argv[4]+"_Gemini_feedback.txt"
    output_path = os.path.join(output_directory, output_filename)
    with open(output_path, "w", encoding="utf-8") as output_file:
        output_file.write(response.text)

    print(f"回應已儲存為 {output_path}")

except KeyError:
    print("API 密鑰未設定，請檢查環境變數 GEMINI_API_KEY")
except Exception as e:
    print(f"處理檔案 {java_filename} 時出現錯誤: {e}")
