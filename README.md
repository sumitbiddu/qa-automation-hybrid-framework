# QA Automation Hybrid Framework

This is a hybrid QA automation framework built for UI and API testing using Selenium WebDriver, TestNG, and Rest Assured. The project also includes CI/CD integration using GitHub Actions.

---

##  Tech Stack

- Java 20
- Selenium WebDriver
- TestNG
- Rest Assured (API Testing)
- Maven
- GitHub Actions (CI/CD)

---

## Framework Structure

- Page Object Model (POM) for UI automation
- TestNG for test execution and assertions
- Separate API test layer using Rest Assured
- Utility classes for reporting and screenshots
- CI/CD pipeline using GitHub Actions

---

##  Project Structure

src/main/java  
├── base  
├── ui/pages  
├── ui/tests  
├── api/tests  
├── utils  

---


## ▶ How to Run Tests

Run all tests using Maven:

```bash
mvn clean test

---

CI/CD Pipeline

This project uses GitHub Actions to automatically run tests on every push to the main branch.

Workflow file:
.github/workflows/test.yml

---

Features
UI Automation (Login, Cart, Product flow)
API Testing (GET/POST validations)
Page Object Model (POM) architecture
CI/CD integration with GitHub Actions
Extent Reports integration (optional)

---

 Author
Sumit Biddu
QA Automation Engineer
