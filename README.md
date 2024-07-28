# User Management Automation

## Overview

This project is an automation suite for managing users in an application using Selenium WebDriver with Cucumber for behavior-driven development (BDD). The suite covers scenarios for logging in, adding a user, and deleting a user, ensuring that user counts are correctly updated and validated.

## Features

- Automated login process
- Navigation to the Admin page
- Addition of a new user with a random username
- Verification of user count before and after user addition
- Deletion of a user and validation of the user count

## Prerequisites

- **Java**: JDK 8 or above
- **Maven**: For dependency management
- **Selenium WebDriver**: For browser automation
- **ChromeDriver**: For running tests on Chrome browser

## Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Mmansour3011/FlairsTech_AutomationAssessment.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd FlairsTech_AutomationAssessment
    ```

3. **Install dependencies:**

    ```bash
    mvn install
    ```

## Usage

1. **Run Tests:**
   
   Execute the Cucumber tests using Maven:

    ```bash
    mvn test
    ```

2. **Configuration:**
   
   Ensure that the WebDriver and other configurations are correctly set up in your `BasePage` class.
## Test Result Screenshot

![screenshot](https://github.com/user-attachments/assets/f8ad8916-30c3-4baf-9351-1c1a15b777d1)

## Step Definitions

The `StepDefinitions` class outlines the steps for user management scenarios:

- **Setup and Teardown:**
  - `@Before` and `@After` hooks to initialize and clean up WebDriver and related resources.

- **Login and Navigation:**
  - `@Given` step for navigating to the login page.
  - `@When` steps for logging in and navigating to the Admin page.

- **Adding and Deleting a User:**
  - `@When` steps for adding, searching, and deleting a user.
  - `@Then` steps to verify the user count before and after operations.

## Contributing

To contribute to this project:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Create a new Pull Request.


## Used Tools

- **Selenium WebDriver**: For browser automation.
- **Cucumber**: For behavior-driven development.

