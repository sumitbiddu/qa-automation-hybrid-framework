#  QA Automation Hybrid Framework (UI + API + CI/CD)

A production-style QA automation framework combining **UI and API testing**, with full **CI/CD integration using GitHub Actions**.  
Designed to simulate real-world automation workflows used in enterprise QA environments.

---

##  Live CI/CD Status

[![QA Automation Tests](https://github.com/sumitbiddu/qa-automation-hybrid-framework/actions/workflows/test.yml/badge.svg)](https://github.com/sumitbiddu/qa-automation-hybrid-framework/actions/workflows/test.yml)

- CI Pipeline runs automatically on every push  
- Executes UI + API tests in headless environment  

---

##  Key Highlights

End-to-end UI automation (Login, Cart, Checkout flow)  
API testing using Rest Assured  
Page Object Model (POM) architecture  
TestNG framework for execution & assertions  
CI/CD pipeline using GitHub Actions  
Headless browser execution for CI  
Failure screenshots + Extent reporting  
Parallel execution enabled for faster runs

---

##  Tech Stack

- Java 20  
- Selenium WebDriver  
- TestNG  
- Rest Assured  
- Maven  
- GitHub Actions  

---

##  Project Structure

src/main/java
├── base
├── ui/pages
├── ui/tests
├── api/tests
├── utils

---

##  How to Run Locally

```bash
mvn clean test
```

## CI/CD Pipeline
Runs automatically on every push to main
Executes UI + API tests in headless mode
Generates test reports and logs in GitHub Actions
Supports parallel test execution in GitHub Actions

 View pipeline:
https://github.com/sumitbiddu/qa-automation-hybrid-framework/actions

## Features Implemented
UI Automation using Selenium WebDriver
API Testing using Rest Assured
Scalable POM framework design
TestNG-based execution flow
GitHub Actions CI/CD integration
Screenshot capture on failure
Reporting support (Extent Reports)

##  Parallel Execution Support

This framework supports parallel execution using TestNG.

- Runs UI and API tests in parallel
- Uses ThreadLocal WebDriver for thread-safe execution
- Ensures no test data collision in concurrent runs
- Improves execution speed in CI/CD pipelines

  ##  Framework Enhancements

- Migrated WebDriver to ThreadLocal for parallel safety
- Improved TestNG Listener for thread-safe reporting
- Updated CI pipeline to support parallel execution
- Ensured stable execution in GitHub Actions environment

## Author

Sumit Biddu
QA Automation Engineer (Aspiring SDET)





