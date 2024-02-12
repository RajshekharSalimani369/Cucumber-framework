package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id='Email']")
    WebElement email;
    @FindBy(xpath="//input[@name='Password']")WebElement password;
    @FindBy(xpath="//button[text()='Log in']")WebElement login;

    @FindBy(xpath="//a[text()='Logout']")WebElement logout;
    public void enterEmail(String emailInput){
        email.clear();
        email.sendKeys(emailInput);
    }
    public void enterPassword(String passwordInput){
        password.clear();
        password.sendKeys(passwordInput);
    }
    public void clickLogin(){

        login.click();
    }
    public void clickLogout(){
        logout.click();;
    }

}
