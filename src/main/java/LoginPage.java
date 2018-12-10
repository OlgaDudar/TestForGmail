import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    private WebElement inpMail;
    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement btnNext;
    By passLocator = By.xpath("//input[@type='password']");


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void setMail(String mail){
        inpMail.sendKeys(mail);
        btnNext.click();
    }

    public void setPassword(String pass){
        WebElement inpPass = waitForElement(driver, passLocator);
        inpPass.sendKeys(pass);
        btnNext.click();
    }


}
