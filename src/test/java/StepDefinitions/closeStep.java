package StepDefinitions;

import io.cucumber.java.en.And;

public class closeStep extends BaseClass{

    @And("close the browser")
    public void closeTheBrowser() {
        driver.close();

    }
}
