package pages;

import core.elements.impl.Button;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import static core.DataProperties.getDataProperties;

public class OutBox extends BasePage{
    @FindBy(xpath = "//div[@class='TN bzz aHS-bnu']")
    private Button outBox;
    @FindBy(xpath = "//table//tr[@class='zA yO']")
    private WebElement subject;

    public void goToOutBox(){
        outBox.click();
    }
    public boolean checkMessageIsPresent(){
        String sub;
        sub = getDataProperties("subject");
        List<WebElement> list =subject.findElements(By.xpath("//*[contains(text(),'" + sub + "')]"));
        if (list.size()>0) return true;
        return false;
    }

}
