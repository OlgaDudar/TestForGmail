package pages;

import core.driver.WebDriverThreadLocal;
import core.elements.impl.Button;
import core.elements.impl.PopUp;
import core.model.Message;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OutBoxPage extends BasePage{
    @FindBy(xpath = "//div[@class='TN bzz aHS-bnu']")
    private Button outBox;
    @FindBy(xpath = "//table//span[@class='bog']")
    private WebElement subject;
    @FindBy(xpath = "//div[@id=':78']")
    private WebElement ckbSelectMail;
    @FindBy(xpath = "//div[@gh='mtb']//div[@act ='10']")
    private Button deleteMessage;
    @FindBy(xpath = "//div[@class='vh']//span[@class='bAq']")
    private WebElement popupDeleteMail;
    private static String title = "Надіслані - test18.acount18@gmail.com - Gmail";

    public OutBoxPage(WebDriver dr) {
        super(dr);
    }

    @Step("Click on Outbox button")
    public void goToOutBox(){
        outBox.click();
        waitOutbox();
    }

    private void waitOutbox(){
        Wait<WebDriver> wait = new WebDriverWait(WebDriverThreadLocal.getDriver(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.titleContains(title));
    }

    @Step("Select mail in Outbox")
    public void selectMail(Message msg){
        ckbSelectMail.click();
    }

    @Step("Delete Message")
    public void deleteMail(Message msg){
        deleteMessage.click();
    }

    @Step("Check message is present in Outbox")
    public boolean checkMessageIsPresent(Message msg){
        String sub;
        sub = msg.getSubject();
        List<WebElement> list =subject.findElements(By.xpath("//*[contains(text(),'" + sub + "')]"));
        return (list.size()>0);
    }

    @Step("Check mail was delete")
        public boolean isDeleteMailPopupIsPresent() {
        return popupDeleteMail.isEnabled();
    }

}
