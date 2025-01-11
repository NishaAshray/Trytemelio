package Interview;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "Interview",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
