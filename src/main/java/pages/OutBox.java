package pages;

import core.driver.WebDriverSingleton;
import core.elements.impl.Button;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static core.DataProperties.getDataProperties;

public class OutBox extends BasePage{
    @FindBy(xpath = "//div[@class='TN bzz aHS-bnu']")
    private Button outBox;
    @FindBy(xpath = "//table//tr[@class='zA yO']")
    private WebElement subject;

    public void goToOutBox(){
        outBox.click();
        //Wait<WebDriver> wait = new WebDriverWait(WebDriverSingleton.getInstance(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        //wait.until(ExpectedConditions.elementToBeClickable(subject));
    }
    public boolean checkMessageIsPresent(){
        String sub;
        sub = getDataProperties("subject");
        List<WebElement> list =subject.findElements(By.xpath("//*[contains(text(),'" + sub + "')]"));
        if (list.size()>0) return true;
        return false;
    }

}
