package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPage {
    WebDriver driver;
    public SearchCustomerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@id='SearchEmail']")
    WebElement emailTextBox;
    @FindBy(xpath="//button[@id='search-customers']")
    WebElement searchBar;
    @FindBy(xpath="//table[@id='customers-grid']//tr[1]//td")
    List<WebElement> noOfColumns;
    @FindBy(xpath="//table[@id='customers-grid']//tr//td[2]")
    List<WebElement> noOfRows;

    @FindBy(xpath="//input[@id='SearchFirstName']")
    WebElement First_Name;
    @FindBy(xpath="//input[@id='SearchLastName']")
    WebElement Last_Name;

    public void enterFirstName(String firstname){
        First_Name.sendKeys(firstname);
    }
    public void enterLastName(String lastname){
        Last_Name.sendKeys(lastname);
    }
    public void emailTextBoxEnterData(String emailTextBoxData){

        emailTextBox.sendKeys(emailTextBoxData);
    }

    public void searchBarClick(){
        searchBar.click();
    }

    public boolean searchCustomerByEmail(String email){
        boolean found=false;

        //total no. of rows in a grid
        int totalrows=noOfRows.size();

       for(int i=1;i<=totalrows;i++){
            WebElement actualEmail= driver.findElement(By.xpath("//table[@id='customers-grid']//tr["+i+"]//td[2]"));

           String actualemailtext= actualEmail.getText();
           System.out.println("the value got from actual email is:"+actualemailtext);
           if(actualemailtext.equals(email)){
               found=true;
               break;
           }

       }
        return found;
    }

///2nd boolean function
public boolean searchCustomerByName(String name){
    boolean found=false;

    //total no. of rows in a grid
    int totalrows=noOfRows.size();
    for(int i=1;i<=totalrows;i++){
        WebElement actualName= driver.findElement(By.xpath("//table[@id='customers-grid']//tr["+i+"]//td[3]"));

        String actualNametext= actualName.getText();
        System.out.println("the value got from actual email is:"+actualNametext);
        if(actualNametext.equals(name)){
            found=true;
            break;
        }

    }
    return found;
}





}
