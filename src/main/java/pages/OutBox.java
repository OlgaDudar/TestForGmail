package pages;

import core.driver.WebDriverSingleton;
import core.elements.impl.Button;
import core.model.Message;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OutBox extends BasePage{
    @FindBy(xpath = "//div[@class='TN bzz aHS-bnu']")
    private Button outBox;
    @FindBy(xpath = "//table//span[@class='bqe']")
    private WebElement subject;

    public OutBox(WebDriver dr) {
        super(dr);
    }

    public void goToOutBox(){
        outBox.click();
        waitOutbox();

    }

public void waitOutbox(){
    Wait<WebDriver> wait = new WebDriverWait(WebDriverSingleton.getDriver(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    wait.until(ExpectedConditions.titleContains("Надіслані"));
}


    public boolean checkMessageIsPresent(Message msg){
        String sub;
        sub = msg.getSubject();
        List<WebElement> list =subject.findElements(By.xpath("//*[contains(text(),'" + sub + "')]"));
        return (list.size()>0);
    }

}
