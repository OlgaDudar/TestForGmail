import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BasePage {
    public WebDriver driver;

    public LoginPage(){
        driver = super.driver;
    }

    public void setMail(String _mail){
        WebElement inp_Mail = ((ChromeDriver)driver).findElementByXPath("//input[@class='whsOnd zHQkBf']");
        inp_Mail.sendKeys(_mail);
        WebElement btn_Next = ((ChromeDriver) driver).findElementByXPath("//span[@class='RveJvd snByac']");
        btn_Next.click();
    }

    public void setPassword(String pass){
        WebElement inpPass = waitForElement(driver, By.xpath("//input[@type='password']"));
        inpPass.sendKeys(pass);
        WebElement btnNext = ((ChromeDriver) driver).findElementByXPath("//span[@class='RveJvd snByac']");
        btnNext.click();
    }


}
