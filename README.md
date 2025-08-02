# 🔍 Search Engine Chatbot using Java Spring Boot

A powerful web-based chatbot that behaves like a search engine. It takes user queries and returns summarized search results from **DuckDuckGo**, **Wikipedia**, and **NewsAPI** in a clean, responsive web UI built with **Spring Boot** and **Thymeleaf**.

---

## 🖼️ Screenshots

Home Page

<img width="1861" height="784" alt="Screenshot 2025-08-02 145815" src="https://github.com/user-attachments/assets/873d36d0-81ce-4b3f-9598-2378e7dc8e59" />

(DuckDuckGo)

<img width="1849" height="750" alt="Screenshot 2025-08-02 144222" src="https://github.com/user-attachments/assets/c03c38a5-b79d-43f8-a0f6-197f079eb427" />

<img width="1608" height="762" alt="Screenshot 2025-08-02 144237" src="https://github.com/user-attachments/assets/d856adba-4d29-4d1e-a70f-5ec473e29ae8" />


Wikipedia 

<img width="1819" height="886" alt="Screenshot 2025-08-02 144306" src="https://github.com/user-attachments/assets/224a0376-054d-48fd-ad94-5a23d2650505" />

<img width="1541" height="679" alt="Screenshot 2025-08-02 144326" src="https://github.com/user-attachments/assets/7c7eef95-c642-4aa7-8657-71f6e76bc90e" />


News

<img width="1844" height="834" alt="Screenshot 2025-08-02 144436" src="https://github.com/user-attachments/assets/433fce8c-856a-49ae-8f45-f9872fd60558" />

<img width="1509" height="829" alt="Screenshot 2025-08-02 144458" src="https://github.com/user-attachments/assets/15edfbc1-8a6b-4f2b-a28c-9fdd8593ddf2" />


---

## 🚀 Features

- 🔎 Search from multiple APIs: DuckDuckGo, Wikipedia, NewsAPI
- 🔐 CSRF protection with Spring Security
- ✅ Responsive design with vertical scrolling of results
- 📦 Clean MVC architecture (Controller-Service-View)
- ⚠️ Error handling for failed API requests (401/404)
- 📄 Query encoding & sanitization

---

## 🛠️ Technologies Used

- **Backend:** Java, Spring Boot (3.5+), Spring MVC
- **Frontend:** Thymeleaf, HTML5, CSS3
- **HTTP Client:** RestTemplate
- **APIs:** 
  - [DuckDuckGo API](https://duckduckgo.com/api)
  - [Wikipedia REST API](https://en.wikipedia.org/api/rest_v1/)
  - [NewsAPI](https://newsapi.org/)

---

## 🔧 Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/kolluri-rakesh/Spring-ChatBot.git
   cd search-engine-chatbot


2.   Add your NewsAPI Key:

    Open SearchService.java

    Replace "YOUR_NEWSAPI_KEY" with your actual API key from https://newsapi.org

3.   Run the project:

4.   Open in Browser:

    http://localhost:8080/

📁 Project Structure

├── controller
│   └── SearchController.java
├── service
│   └── SearchService.java
├── templates
│   ├── index.html
│   └── result.html
├── static
│   └── style.css
└── config
    └── SecurityConfig.java

