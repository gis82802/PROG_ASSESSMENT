import os
import sys
import time
from datetime  import datetime
from mistralai import Mistral

# 環境變數中的 API 密鑰
os.environ["MISTRAL_API_KEY"] = "ICwwj7r1k1dcDQumsABzpaRYL4A904nm"
api_key = os.environ["MISTRAL_API_KEY"] 

model = "mistral-large-latest" #mistral-large-latest

client = Mistral(api_key=api_key)

#指令
instruction = """
我是一所大學計算機科學系的教授，主要教授「Java程式設計」，我將會提供學生所提交的作業，請你根據我的標準執行以下6點要求，並使用中文回答。
我的標準:
(1)    程式執行結果正確 
(2)    若有資料輸入，在讀入使用者輸入資料之前，程式應顯示適當訊息，讓使用者知道應輸入資料，且了解輸入資料的型態與數量 
(3)    若有資料輸入，程式碼可以檢查錯誤的輸入，並顯示訊息重新讀取使用者輸入
(4)    程式碼解決問題的邏輯簡單易了解
(5)    程式可讀性佳，變數命名有意義、程式結構有適當內縮、程式碼提供適當註解、在程式開頭有標頭註解說明程式：功能、作者、版本、日期等訊息
(6)    程式執行有效率，可以在較短時間內完成

要求:
1. 請根據我的標準為這份作業打分（0-100），並且標示出每一項標準的個別分數

2. 根據我的標準分析它的優缺點

3. 為我的學生提供改進的程式碼
-基於學生的程式碼進行修改
-使用原有的函式、變數名稱(除非變數命名不夠直觀時可改變數名稱)、使用語法(如:for, while迴圈等)
-保留優點，修改缺點
-若沒有「程式開頭有標頭註解說明程式：功能、作者、版本、日期等訊息」，於改進程式碼顯示:「缺少程式開頭有標頭註解說明程式：功能、作者、版本、日期等訊息」

4.說明改進的程式碼有修改的部分及原因

5.為學生提供改進建議和反饋
"""

# 讀取特定路徑中的 .txt 檔案作為 task_description
base_path = r"C:\xampp\htdocs\topicbee\data"
task_file_path = os.path.join(base_path, sys.argv[1], sys.argv[2], f"homework_texts", f"Q{sys.argv[4]}.txt")
java_file_path = os.path.join(base_path, sys.argv[1], sys.argv[2], "homework", sys.argv[3], f"Q{sys.argv[4]}", sys.argv[5])
output_directory = os.path.join(base_path, sys.argv[1], sys.argv[2], "feedback", sys.argv[3])

# 檢查檔案是否存在，並讀取檔案內容
if os.path.exists(task_file_path):
    with open(task_file_path, "r", encoding="utf-8", errors='ignore') as file:
        task_description = file.read()
else:
    print(f"檔案 {task_file_path} 不存在，請檢查路徑或檔案名稱。")

# 如果輸出資料夾不存在，則建立資料夾
os.makedirs(output_directory, exist_ok=True)

file_path = java_file_path

java_filename = os.path.basename(file_path)


try:
  # 讀取 Java 檔案的程式碼
  with open(file_path, "r", encoding="utf-8", errors='ignore') as file:
    code = file.read()
            
  # 將指令、題目、程式碼串接
  input_message = instruction + "\n" + task_description + "\n作業(程式碼)內容:\n" + code
        
  # 模型發送消息
  start_time = time.time()    #開始時間
  chat_response = client.chat.complete(
    model=model,
    messages=[
      {
        "role": "user",
        "content": input_message,
      },
    ]
  )
  response = chat_response.choices[0].message.content
  end_time = time.time()  #結束時間
  execution_time = end_time - start_time

  timelog_path = os.path.join(output_directory, "Mistral_feedback_timelog.txt")
  formatted_time = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
  with open(timelog_path, "w", encoding="utf-8") as file:
      file.write(f"{formatted_time} {java_filename}_feedback_timelog : {execution_time}\n")

  output_filename = "Q"+sys.argv[4]+"_Mistral_feedback.txt"
    # 定義輸出檔案名稱變數，將檔名改為 "<原檔名>feedback.txt"
  output_path = os.path.join(output_directory, output_filename)

    # 輸出回應到txt檔案中
  with open(output_path, "w", encoding="utf-8") as output_file:
    output_file.write(response)

  print(f"回應已儲存為 {output_path}")

except KeyError:
    print("API 密鑰未設定，請檢查環境變數 Mistral_API_KEY")
except Exception as e:
    print(f"處理檔案 {java_filename} 時出現錯誤: {e}")

