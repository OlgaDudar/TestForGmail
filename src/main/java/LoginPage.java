import com.olga.ExtendedFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.olga.elements.impl.*;



public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    private TextField inpMail;

    @FindBy(xpath = "//input[@type='password']")
    private TextField inpPass;

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private Button btnNext;

    public void setMail(String mail){
        inpMail.type(mail);
        btnNext.click();
    }

    public void setPassword(String pass){
        inpPass.type(pass);
        btnNext.click();
    }




}
