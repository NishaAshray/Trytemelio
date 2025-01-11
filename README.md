
**src/main/java/Interview/:**
Contains Java classes related to the page object model (POM), step definitions, helpers, and hooks.
**AdminSettingPage.java:** Page object class that contains all methods related to the Admin Settings page.
**AdminSettingStepDefinition.java:** Cucumber step definition file that contains step definitions for the feature file.
**GetterSetter.java:** Class to hold and manage test data like team member name and email.
**LoginPage.java:** Class that handles login-related functionality.
**SeleniumHelper.java:** Utility class for common Selenium functions like waiting for elements, entering text, clicking, etc.
**Hooks.java:** Class with Cucumber hooks that runs before and after all tests (e.g., driver initialization and cleanup).

**src/test/resources/features/:**
Contains the Cucumber .feature files that define the test scenarios.
**AdminSetting.feature:** Cucumber feature file where the user stories/scenarios are written in Gherkin syntax.

**src/test/java/Interview/RunnerTest.java:**
Cucumber test runner class that connects the features and step definitions. It uses the Cucumber @CucumberOptions to point to the location of the feature files and glue code.
**pom.xml:**
Maven configuration file for dependencies, build configurations, and plugins.
You'll need dependencies for Selenium, Cucumber, TestNG (if used for assertions), WebDriverManager (for driver management), and any other necessary libraries.
**.gitignore:**
File to exclude files/folders from being committed to a Git repository (e.g., target/, *.log, *.class).
**README.md:**
Contains project details and setup instructions.

# Temelio Automation Project

This is an automation testing project for the Temelio platform using Selenium, Cucumber, and TestNG.

## Project Structure
- `src/main/java/Interview/`: Contains Java classes for page objects, step definitions, and utility methods.
- `src/test/resources/features/`: Contains the Cucumber feature files.
- `src/test/java/Interview/`: Contains the Cucumber runner class to execute tests.

## Prerequisites
- Java 11 or above
- Maven 3.x or above
- ChromeDriver (or any browser driver you're using)

## Setup Instructions

1. Clone the repository:
    ```bash
    git clone <repository_url>
    ```

2. Navigate to the project directory:
    ```bash
    cd TemelioAutomationProject
    ```

3. Install dependencies:
    ```bash
    mvn clean install
    ```

4. Run the tests:
    ```bash
    mvn test
    ```

## Features
- Add team members
- Add foundation tags
- Add custom program areas

## Technologies Used
- Selenium WebDriver
- Cucumber
- TestNG
- Maven

## License
This project is licensed under the MIT License - see the LICENSE file for details.

![image](https://github.com/user-attachments/assets/4127c63a-f7f6-4209-b47d-4ca9b8e9aaba)

