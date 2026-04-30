# QA Automation Hybrid Framework
A production-style hybrid QA automation framework with integrated CI/CD pipeline executing UI and API tests on every commit.

[![QA Automation Tests](https://github.com/sumitbiddu/qa-automation-hybrid-framework/actions/workflows/test.yml/badge.svg)](https://github.com/sumitbiddu/qa-automation-hybrid-framework/actions/workflows/test.yml)

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


##  How to Run Tests

Run all tests using Maven:

```bash
mvn clean test
```

---

## CI/CD Execution Proof

- Tests run automatically on every push
- UI tests executed in headless Chrome (CI environment)
- API tests validated using Rest Assured
- View logs and execution details in GitHub Actions

👉 https://github.com/sumitbiddu/qa-automation-hybrid-framework/actions

 CI/CD Pipeline

This project uses GitHub Actions to automatically run tests on every push to the main branch.

 Workflow file:
.github/workflows/test.yml

---

## Features

- End-to-End UI Automation (Login, Cart, Product flow)
- API Testing with Rest Assured (GET/POST validation)
- Page Object Model (Scalable framework design)
- CI/CD integration using GitHub Actions
- Headless execution for CI environments
- Reusable utilities (Screenshot, Reporting, Listeners)

---

## Author
Sumit Biddu
QA Automation Engineer
