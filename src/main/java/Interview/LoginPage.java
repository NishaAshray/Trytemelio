package Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    // Locators
    private final By emailInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("signin-button");

    public LoginPage() {
        this.driver = SeleniumHelper.getDriver();
    }

    public void login() {
        WebElement emailField = driver.findElement(emailInput);
        WebElement passwordField = driver.findElement(passwordInput);
        WebElement loginBtn = driver.findElement(loginButton);

        SeleniumHelper.enterText(emailField, SeleniumHelper.getUsername());
        SeleniumHelper.enterText(passwordField, SeleniumHelper.getPassword());
        SeleniumHelper.clickElement(loginBtn);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
