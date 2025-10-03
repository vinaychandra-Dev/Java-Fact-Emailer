# 🚀 Java Fact Emailer 📧

Welcome to **Java Fact Emailer**, a Spring Boot app that delivers daily Java programming facts at 9 AM IST! 🌞 Powered by the [OpenTDB API](https://opentdb.com), it transforms quiz questions into concise facts with an AI-like flair, making learning fun and automated. Perfect for Java enthusiasts and developers looking to impress! 🎉

![Java Fact Emailer](https://via.placeholder.com/600x200.png?text=Java+Fact+Emailer) <!-- Replace with screenshot/GIF -->

[![Java](https://img.shields.io/badge/Java-17+-orange)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

## ✨ Features
- 🧠 Fetches Java facts from OpenTDB API.
- ✍️ Converts quiz questions into statements (e.g., "In Java, a class that cannot be subclassed is Final.").
- 📬 Sends HTML-formatted emails daily at 9 AM IST.
- 🤖 Simulates AI with randomized intros and explanations.
- ☁️ Deployable on free platforms like Render.

## 🛠️ Tech Stack
- **Java 17+** ☕
- **Spring Boot** (Web, Mail, Scheduling) 🌱
- **OpenTDB API** for free trivia 📚
- **Jackson** for JSON parsing 🗂️
- **Maven** for builds 🔨
- **Render** for free hosting 🚀

## 📋 Prerequisites
- Java 17+ ☕
- Maven 3.6+ 🛠️
- Gmail account with App Password 📧
- IDE (IntelliJ, Eclipse, etc.) 💻

## ⚙️ Setup and Execution

### 1. Clone the Repository 📥
```bash
git clone https://github.com/your-username/java-fact-emailer.git
cd java-fact-emailer
```

### 2. Configure Environment 🔧
- Copy the template configuration:
  ```bash
  cp src/main/resources/application.properties.template src/main/resources/application.properties
  ```
- Edit `application.properties` with your Gmail and recipient details:
  ```properties
  spring.mail.host=smtp.gmail.com
  spring.mail.port=587
  spring.mail.username=your-email@gmail.com
  spring.mail.password=your-app-password
  spring.mail.properties.mail.smtp.auth=true
  spring.mail.properties.mail.smtp.starttls.enable=true
  server.port=8080
  recipient.email=your-recipient-email@example.com
  ```
- Generate a Gmail App Password at [Google Account Security](https://myaccount.google.com/security) > 2-Step Verification > App Passwords.

### 3. Build and Run Locally 🏃
```bash
mvn clean package
java -jar target/java-fact-emailer.jar
```
- The app sends emails daily at 9 AM IST (3:30 AM UTC).
- **Note**: Excludes `.idea/` and `target/` for a clean setup.

### 4. Test Manually with Postman 🧪
- Send a test email:
  ```bash
  curl "http://localhost:8080/send-fact?email=recipient@example.com"
  ```
- Check the recipient's inbox for a formatted fact.

## 📂 Project Structure
```
java-fact-emailer/
├── src/main/java/com/example/
│   ├── model/
│   │   ├── Response.java
│   │   ├── Result.java
│   ├── service/
│   │   ├── FactFetcherService.java
│   │   ├── EmailService.java
│   ├── scheduler/
│   │   ├── FactEmailScheduler.java
│   ├── controller/
│   │   ├── FactController.java
│   ├── Application.java
├── src/main/resources/
│   ├── application.properties.template
├── pom.xml
├── .gitignore
├── README.md
```

## 📧 Example Email
```
Subject: Your Daily Java Fact
Body:
<h3>Your Daily Java Fact</h3>
<p>Fun Java Fact: In Java, a class that cannot be subclassed is Final.<br>Explanation: Java excels in enterprise apps.</p>
```

## 🚀 Future Enhancements
- 🌐 Add a Thymeleaf web UI for user email input.
- 💾 Store sent facts in a database (e.g., H2).
- 🎨 Allow users to choose fact categories.

## 🤝 Contributing
Fork, submit issues, or create pull requests. Follow GitHub workflows! 🙌

## 📜 License
[MIT License](LICENSE)

## 🌟 Acknowledgments
- [OpenTDB](https://opentdb.com) for free trivia API.
- [Spring Boot](https://spring.io/projects/spring-boot) for awesome tools.
- [Render](https://render.com) for free hosting.

---

Built with 💻 and ☕ by vinay
