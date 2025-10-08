"""
PROJECT : LingoBridge_light
AUTHOR  : PIN CHEN, TSAI
VERSION : v1.0
UPDATE  : 2025-10-07
DETALES :
- 與各家LLM進行通訊的程序 (輕量版)
- 使用前請先將各家LLM的API金鑰填入該程序中
- 操作範例如下:
```
 $python LB_light.py --model gemini-2.5-flash --message "在python中，該如何使用os.getenv()，請說明並示範"
```
WORKLOG :

"""

import argparse
import os

# 各家 API
from openai import OpenAI
import google.generativeai as genai
from mistralai import Mistral
import anthropic


# 各家客戶端API
OPENAI_API_KEY    = ""
GOOGLE_API_KEY    = ""
MISTRAL_API_KEY   = ""
ANTHROPIC_API_KEY = ""

def chat_with_openai(model, message):
    """OpenAI GPT 系列 (gpt-4o, gpt-5, gpt-5-mini)"""
    openai_client = OpenAI(api_key=OPENAI_API_KEY)
    response = openai_client.chat.completions.create(
        model=model,
        messages=[{"role": "user", "content": message}],
    )
    return response.choices[0].message.content

def chat_with_google(model, message):
    """Google Gemini 系列 (2.5-pro, 2.5-flash)"""
    genai.configure(api_key=GOOGLE_API_KEY)
    model = genai.GenerativeModel(model)
    response = model.generate_content(message)
    return response.text

def chat_with_mistral(model, message):
    """Mistral 系列"""
    mistral_client = Mistral(api_key=MISTRAL_API_KEY)
    response = mistral_client.chat.complete(
        model=model,
        messages=[{"role": "user", "content": message}],
    )
    return response.choices[0].message["content"]

def chat_with_claude(model, message):
    """Anthropic Claude 系列 (Haiku 3.5, Sonnet 3.5...)"""
    anthropic_client = anthropic.Anthropic(api_key=ANTHROPIC_API_KEY)
    response = anthropic_client.messages.create(
        model=model,
        max_tokens=1024,
        messages=[{"role": "user", "content": message}],
    )
    return response.content[0].text

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--model", required=True, help="模型名稱")
    parser.add_argument("--message", required=True, help="要傳送的訊息")
    args = parser.parse_args()

    model = args.model.lower()
    message = args.message

    if model.startswith("gpt"):
        print(chat_with_openai(model, message))
    elif model.startswith("gemini"):
        print(chat_with_google(model, message))
    elif model.startswith("mistral"):
        print(chat_with_mistral(model, message))
    elif model.startswith("haiku") or model.startswith("claude"):
        print(chat_with_claude(model, message))
    else:
        print("❌ 不支援的模型名稱")

if __name__ == "__main__":
    main()
