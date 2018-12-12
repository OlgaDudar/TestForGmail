import com.olga.ExtendedFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.olga.elements.impl.*;



public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    private TextFieldImpl inpMail;

    @FindBy(xpath = "//input[@type='password']")
    private TextFieldImpl inpPass;

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private ButtonImpl btnNext;



    public LoginPage(){
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);

    }

    public void setMail(String mail){
        inpMail.type(mail);
        btnNext.click();
    }

    public void setPassword(String pass){
//        WebElement inpPass = waitForElement(driver, By.xpath("//input[@type='password']"));

        inpPass.type(pass);
        btnNext.click();
    }




}
