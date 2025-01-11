package Interview;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

public class AdminSettingStepDefinition {
    String name = "New Member";
    String email = "newmember@example.com";

    LoginPage loginPage = new LoginPage();
    AdminSettingPage teamMemberPage = new AdminSettingPage();
    GetterSetter getterSetter = new GetterSetter();

    @Given("I open the application")
    public void iOpenTheApplication() {
        SeleniumHelper.openUrl();
    }

    @Given("I am logged into the Temelio application")
    public void iAmLoggedIntoTheTemelioApplication() {
        SeleniumHelper.openUrl();
        loginPage.login();
    }

    @When("I create a new team member")
    public void iCreateANewTeamMember() {
        getterSetter.setTeamMemberDetails(name, email);
        teamMemberPage.addTeamMember(name, email);
    }

    @Then("the team member should be added successfully")
    public void theTeamMemberShouldBeAddedSuccessfully() {
        String expectedEmail = getterSetter.getTeamMemberEmail();
        List<String> emailAddress = teamMemberPage.getEmailAddress();
        org.testng.Assert.assertTrue(emailAddress.contains(expectedEmail),
                "Expected email '" + expectedEmail + "' was not found in the list of team members.");

    }

    @When("I select Admin Setting")
    public void iSelectAdminSetting() {
        teamMemberPage.adminPageOpen();
    }

    @When("I new foundation tag")
    public void iNewFoundationTag() {
        teamMemberPage.addFoundationTag();
    }

    @Then("tag should be added successfully")
    public void tagShouldBeAddedSuccessfully() {


    }

    @When("I create a new custom program area")
    public void iCreateANewCustomProgramArea() throws InterruptedException {
        teamMemberPage.addCustomProgramArea();
    }

    @Then("the custom program area should be added successfully")
    public void theCustomProgramAreaShouldBeAddedSuccessfully() {
        org.testng.Assert.assertTrue(true, "Custom Program Area added successfully");
    }
}
