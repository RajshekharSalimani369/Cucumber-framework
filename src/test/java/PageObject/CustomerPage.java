package PageObject;

import StepDefinitions.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage extends BaseClass {
    WebDriver driver;
    public CustomerPage(WebDriver driver){
           this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//i[@class='nav-icon fas fa-desktop']")
    WebElement dashBoard;
    @FindBy(xpath="(//li[@class='nav-item has-treeview'])[4]")
    WebElement customersLeftNavigation;
    @FindBy(xpath="(//i[@class='nav-icon far fa-dot-circle'])[13]")
    WebElement customersMenuItem;
    @FindBy(xpath="//a[@class='btn btn-primary']")
    WebElement addNewButton;
    @FindBy(xpath="//input[@id='Email']")
    WebElement emailTextBox;
    @FindBy(xpath="//input[@id='Password']")
    WebElement passwordTextBox;
    @FindBy(xpath="//input[@id='FirstName']")
    WebElement firstNameTextBox;
    @FindBy(xpath="//input[@id='LastName']")
    WebElement lastNameTextBox;
    @FindBy(xpath="//input[@id='Gender_Male']")
    WebElement genderMale_radiobutton;
    @FindBy(xpath="//input[@id='Gender_Female']")
    WebElement genderFemale_radiobutton;
    @FindBy(xpath="//textarea[@id='AdminComment']")
    WebElement adminCommentTextBox;
    @FindBy(xpath="//button[@name='save']")
    WebElement save;


    public void clickcustomersLeftNavigation(){

        customersLeftNavigation.click();
    }
    public void clickcustomersMenuItem(){

        customersMenuItem.click();
    }
    public void clickaddNewButton(){

        addNewButton.click();
    }
    public void enteremailTextBox(){

        emailTextBox.sendKeys(generateRandomEmailId()+"@gmail.com");
    }
    public void enterpasswordTextBox(){

        passwordTextBox.sendKeys("12345678");
    }
    public void clickgenderMale_radiobutton(){

        genderMale_radiobutton.click();
    }
    public void enterCommentTextBox(){

        adminCommentTextBox.sendKeys("Hello");
    }
    public void clickSave(){

        save.click();
    }




}
