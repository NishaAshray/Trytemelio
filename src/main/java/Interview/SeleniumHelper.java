package Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SeleniumHelper {

    private static WebDriver driver;
    private static final String URL = "https://app-dev.trytemelio.com/foundation/84afbd82-deb9-4112-87dc-7089c4ee29ab";
    private static final String USERNAME = "Nishaashraysuvarna@gmail.com";
    private static final String PASSWORD = "Temelio@123";
    private static final int DEFAULT_WAIT_TIME = 15;

    public static void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openUrl() {
        if (driver == null) {
            initializeDriver();
        }
        driver.get(URL);
    }

    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static void clickDropdownAndSelectOption(By dropdownButton, By optionsListLocator, String optionText) {
        WebElement dropdown = driver.findElement(dropdownButton);
        dropdown.click();
        List<WebElement> options = driver.findElements(optionsListLocator);
        for (WebElement option : options) {
            if (option.getText().equals(optionText)) { // Compare exact match
                option.click();
                return; // Exit the loop after clicking
            }
        }
        throw new RuntimeException("Option with text '" + optionText + "' not found in the dropdown.");
    }

    public static WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBePresent(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static WebElement waitForElementToBeVisible(By locator) {
        return waitForElementToBeVisible(locator, DEFAULT_WAIT_TIME);
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        return waitForElementToBeClickable(locator, DEFAULT_WAIT_TIME);
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    // Refactored generic explicit wait method
    public static WebElement waitForElement(By locator, String conditionType, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        switch (conditionType) {
            case "visibility":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            case "clickable":
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            case "presence":
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            default:
                throw new IllegalArgumentException("Invalid condition type: " + conditionType);
        }
    }
}
