package StepDefinitions;

import PageObject.CustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class LoginStepdefs extends BaseClass{
Logger logger= LogManager.getLogger(LoginStepdefs.class);

@Before
    public void setup() throws FileNotFoundException, RuntimeException {
    readConfig=new Properties();

    try {
        FileInputStream file = new FileInputStream("src/test/Resources/config.properties");
        readConfig.load(file);

    } catch (Exception e) {
     e.printStackTrace();
    }
    logger.info("This is information message");
    System.out.println("This is before hooks method");
    String browser_name = readConfig.getProperty("browser");
    switch (browser_name) {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            break;
        case "edge":
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            break;
    }
    }

    @Given("User launch Chrome browser")
    public void userLaunchChromeBrowser() {
        logger.info("This is launch browser message");
        driver.manage().window().maximize();;
        loginpage=new LoginPage(driver);
        customerPage=new CustomerPage(driver);
        searchcustomerpage=new SearchCustomerPage(driver);
    }

    @When("User opens url {string}")
    public void userOpensUrl(String url) {
        driver.get(url);
        logger.error("This is error message");
    }
//Login email and password---ignore
    @And("User enters Email as {string} and password as {string}")
    public void userEntersEmailAsAndPasswordAs(String emailAdd, String password) {
        loginpage.enterEmail(emailAdd);
        loginpage.enterPassword(password);
    }


    @And("click on Login")
    public void clickOnLogin() {

        loginpage.clickLogin();
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            Assert.assertTrue(true);
         }
        else{
            Assert.assertTrue(false);
            }
    }
////Add new customer
    @When("User clicks on Customers menu")
    public void userClicksOnCustomersMenu() throws InterruptedException {

        customerPage.clickcustomersLeftNavigation();
        Thread.sleep(1000);
    }

    @And("User clicks on Customer")
    public void userClicksOnCustomer() {
        customerPage.clickcustomersMenuItem();
    }

    @And("User clicks on Add new button")
    public void userClicksOnAddNewButton() {

        customerPage.clickaddNewButton();
    }

    @When("User enters customer info")
    public void userEntersCustomerInfo() {
       // customerPage.enteremailTextBox(generateRandomEmailId());
        customerPage.enteremailTextBox();
        customerPage.enterpasswordTextBox();
        customerPage.clickgenderMale_radiobutton();
        customerPage.enterCommentTextBox();
    }

    @And("clicks on Save button")
    public void clicksOnSaveButton() {
        customerPage.clickSave();
    }
    @When("Users clicks on Logout")
    public void usersClicksOnLogout() {

        loginpage.clickLogout();
    }
    @Then("page title should be as {string}")
    public void pageTitleShouldBeAs(String expectedtitleafterlogout) {
        String actualtitleafterlogout=driver.getTitle();
        if(actualtitleafterlogout.equals(expectedtitleafterlogout)){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }



   ////////////////////////////Search Customer//////////////////////////////
    @When("User enters in customer email textbox")
    public void userEntersInCustomerEmailTextbox() {
        searchcustomerpage.emailTextBoxEnterData("raj12@gmail.com");
    }

    @When("User clicks on search bar")
    public void userClicksOnSearchBar() {
        searchcustomerpage.searchBarClick();
    }

    @Then("User should find results in table")
    public void userShouldFindResultsInTable() {
      String expectedEmail="raj12@gmail.com";
       Assert.assertTrue(searchcustomerpage.searchCustomerByEmail(expectedEmail));
    }

    @And("User enters FirstName")
    public void userEntersFirstName() {
        searchcustomerpage.searchCustomerByName("Victoria");
    }

    @And("User enters LastName")
    public void userEntersLastName() {
        searchcustomerpage.enterLastName("Terces");
    }

    @Then("User should be found in table")
    public void userShouldBeFoundInTable() {
        String expectedName="Victoria Terces";
        Assert.assertTrue(searchcustomerpage.searchCustomerByName(expectedName));
    }
@After
    public void teardown(){
    System.out.println("This is after hooks method");
    driver.quit();
    }
@AfterStep
    public void addScreenshot(Scenario scenario){
        try {
            // Capture the screenshot as a File
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Convert the File to byte array
            byte[] screenshot = Files.readAllBytes(screenshotFile.toPath());

            // Attach the screenshot to the scenario
            scenario.attach(screenshot, "image/png", scenario.getName());

            System.out.println("Screenshot attached successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
