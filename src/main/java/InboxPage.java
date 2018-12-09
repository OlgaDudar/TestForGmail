import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends BasePage{
    protected WebDriver driver;
    boolean msgSend;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement btnNewMail;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private WebElement btnSend;
    @FindBy(xpath = "//div[@class='bBe']")
    private WebElement msgBoxSend;

    public InboxPage(WebDriver driver){
        this.driver = driver;
    }



    public InboxPage(){
        this.driver = super.driver;
        PageFactory.initElements(driver, this);
    }


    public void createNewMail(){
        btnNewMail.click();
    }

    public void setAdress(String to){
        WebElement formElement = ((ChromeDriver) driver).findElementByXPath("//form[@class='bAs']");
        WebElement toWhomtxt = formElement.findElement(By.xpath(("//textarea[@class='vO']")));
        toWhomtxt.click();
        toWhomtxt.sendKeys(to);
    }

    public void setMassage(String txt){
        WebElement Msg = ((ChromeDriver) driver).findElementByXPath("//div[@class='Am Al editable LW-avf']");
        Msg.sendKeys(txt + Keys.TAB);

    }
    public void sendMassage(){
        btnSend.click();
        msgSend = msgBoxSend.isDisplayed();

    }
}
