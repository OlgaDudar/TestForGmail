import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends BasePage{
    boolean msgSend;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement btnNewMail;
    @FindBy(xpath = "//form[@class='bAs']//textarea[@class='vO']")
    private WebElement toWhomtxt;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private WebElement btnSend;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement Msg;
    @FindBy(xpath = "//div[@class='bBe']")
    private WebElement msgBoxSend;

    public InboxPage(WebDriver driver){
        ;
    }


    public InboxPage(){
        PageFactory.initElements(driver, this);
    }


    public void createNewMail(){
        btnNewMail.click();
    }

    public void setAdress(String to){
        toWhomtxt.click();
        toWhomtxt.sendKeys(to);
    }

    public void setMassage(String txt){
        Msg.sendKeys(txt + Keys.TAB);

    }
    public void sendMassage(){
        btnSend.click();
        msgSend = msgBoxSend.isDisplayed();

    }
}
