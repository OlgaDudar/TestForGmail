package pages;

import core.elements.impl.Button;
import core.model.Message;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class OutBox extends BasePage{
    @FindBy(xpath = "//div[@class='TN bzz aHS-bnu']")
    private Button outBox;
    @FindBy(xpath = "//table//tr[@class='zA yO']")
    private WebElement subject;

    public OutBox(WebDriver dr) {
        super(dr);
    }

    public void goToOutBox(){
        outBox.click();
    }

    public boolean checkMessageIsPresent(Message msg){
        String sub;
        sub = msg.getSubject();
        List<WebElement> list =subject.findElements(By.xpath("//*[contains(text(),'" + sub + "')]"));
        return (list.size()>0);
    }

}
