package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        //features = {"src/test/java/Featurefiles/Customers.feature"},
        features = {"src/test/java/Featurefiles/Customers.feature","src/test/java/Featurefiles/Login.feature"},
        glue={"StepDefinitions"},
        dryRun = false,
        monochrome = false,
        tags="@Sanity",
       // plugin={"pretty","html:target/cucumber-reports/reports1.html","json:target/cucumber-reports/reports2.json","junit:target/cucumber-reports/reports3.xml"}
        plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)
public class Runner extends AbstractTestNGCucumberTests {
//this class will be empty
}
