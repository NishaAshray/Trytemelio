package Interview;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        SeleniumHelper.initializeDriver();
    }

    @AfterAll
    public static void afterAll(){
        SeleniumHelper.closeDriver();
    }
}
