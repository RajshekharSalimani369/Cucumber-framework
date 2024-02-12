package StepDefinitions;

import PageObject.CustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.Random;


//Parent class
public class BaseClass {
    public static WebDriver driver;
    public LoginPage loginpage;
    public CustomerPage customerPage;
    public SearchCustomerPage searchcustomerpage;
    Properties readConfig;

    public String generateRandomEmailId(){

        return (RandomStringUtils.randomAlphabetic(5));
    }
}
