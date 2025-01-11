package Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AdminSettingPage {
    private final WebDriver driver;

    // Locators
    private final By adminSettingArrow = By.xpath("//button[contains(@aria-label,'Open entity switcher')]");
    private final By adminSetting = By.xpath("//div[contains(text(),'Admin Settings')]/ancestor::a[@role='menuitem']");
    private final By addTeamMemberButton = By.xpath("//button[contains(text(),'Add Team Member')]");
    private final By teamMemberNameInput = By.xpath(" (//section//input[contains(@class,\"chakra-input\")])[1]");
    private final By teamMemberEmailInput = By.xpath(" (//section//input[contains(@class,'chakra-input')])[2]");
    private final By selectUserAccess = By.xpath(" //section//select[contains(@id,'field')]");
    private final By selectUserAccessOption = By.xpath("//section//select[contains(@id,'field')]//option");
    private final By saveTeamMemberButton = By.xpath(" //section//footer//button[text()='Add']");

    private final By tagName = By.xpath("//input[contains(@placeholder,'Tag name')]");
    private final By addTag = By.xpath("//input[contains(@placeholder,'Tag name')]/following-sibling::button[contains(text(),'Add')]");
    private final By emailAddress = By.xpath("//td[contains(text(),'@')]");

    private final By customProgramArea = By.xpath("//input[@placeholder='Program Area']");
    private final By customProgramAreaAdd = By.xpath("//input[@placeholder='Program Area']/following-sibling::button[text()='Add']");

    public AdminSettingPage() {
        this.driver = SeleniumHelper.getDriver();
    }

    public void addTeamMember(String name, String email) {
        SeleniumHelper.waitForElementToBeClickable(addTeamMemberButton).click();
        SeleniumHelper.waitForElementToBeClickable(teamMemberNameInput).sendKeys(name);
        SeleniumHelper.waitForElementToBeClickable(teamMemberEmailInput).sendKeys(email);
        SeleniumHelper.waitForElementToBeClickable(selectUserAccess).click();
        SeleniumHelper.clickDropdownAndSelectOption(selectUserAccess, selectUserAccessOption, "Admin Access");
        SeleniumHelper.waitForElementToBeClickable(saveTeamMemberButton).click();
    }

    public void adminPageOpen() {
        SeleniumHelper.waitForElementToBeClickable(adminSettingArrow).click();
        SeleniumHelper.waitForElementToBeClickable(adminSetting).click();
    }

    public void addFoundationTag() {
        String tagValue = SeleniumHelper.generateRandomString(4);
        SeleniumHelper.waitForElementToBeClickable(tagName).sendKeys(tagValue);
        SeleniumHelper.waitForElementToBeClickable(addTag).click();

    }

    public List<String> getEmailAddress() {
        List<WebElement> emailElements = driver.findElements(emailAddress); // Find all matching elements
        List<String> emailTexts = new ArrayList<>();

        for (WebElement element : emailElements) {
            emailTexts.add(element.getText()); // Extract and store the text from each element
        }

        return emailTexts;
    }

    public void addCustomProgramArea() throws InterruptedException {
        SeleniumHelper.waitForElementToBeClickable(customProgramArea).sendKeys("NewCustomProgramArea11");
        Thread.sleep(3000);
        SeleniumHelper.waitForElementToBeClickable(customProgramAreaAdd).click();
        Thread.sleep(3000);

    }
}
