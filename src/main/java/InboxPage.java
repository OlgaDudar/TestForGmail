import com.olga.elements.impl.Button;
import com.olga.elements.impl.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends BasePage{
    boolean msgSend;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button btnNewMail;
    @FindBy(xpath = "//form[@class='bAs']")
    private WebElement formElement;
    @FindBy(xpath = "//textarea[@class='vO']")
    private TextField toWhomtxt;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private Button btnSend;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private TextField Msg;
    @FindBy(xpath = "//div[@class='bBe']")
    private WebElement msgBoxSend;

    public void createNewMail(){
        btnNewMail.click();
    }

    public void setAddress(String to){
        toWhomtxt.click();
        toWhomtxt.type(to);
    }

    public void setMessage(String txt){
        Msg.type(txt + Keys.TAB);

    }

    public void sendMail(){
        btnSend.click();
    }

    public boolean sendMessagePopupDisplayed(){
        return msgBoxSend.isDisplayed();
    }
}
