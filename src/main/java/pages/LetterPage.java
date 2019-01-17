package pages;

import core.elements.impl.Button;
import core.model.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Iterator;
import java.util.List;


public class LetterPage extends BasePage{

    @FindBy(xpath = "//table//div[@class='yW']")
    private WebElement subject;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aZj T-I-ax7 T-I-Js-IF L3']")
    public Button dwnAttach;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aZj T-I-ax7 T-I-Js-Gs L3 T-I-JE']")
    public Button dwnToDrive;
    @FindBy(xpath = "//div[@class='J-M J-M-ayU DSaQrd']//div[text()='Спрощена китайська']")
    public Button dwnChinese;
    @FindBy(xpath = "//div[@class='ae4 aDM']//span[@class='bA4']")
    public WebElement fromList;
    @FindBy(xpath = "//div[@class=' G-atb D E']//div[@class='G-Ni G-aE J-J5-Ji']//div[@class='T-I J-J5-Ji lS T-I-ax7 mA T-I-Zf-aw2']")
    private Button backToInbox;
    @FindBy(xpath = "//span[@class='nU ']")
    public WebElement lk_Inbox;

    public void openLetter(Message msg) {
        String sub;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> getMails(){
        List<WebElement> list = fromList.findElements(By.xpath("//table//div[@class='yW']"));
        return list;
    }

    public boolean CheckAttachmentIsPresent(){
        return dwnAttach.isDisplayed();
    }

    public void DownloadAttachment(){
        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        Iterator<WebElement> iterator = getMails().iterator();
        while(iterator.hasNext()) {
            WebElement obj = iterator.next();
            obj.click();

            if (CheckAttachmentIsPresent()) {
                dwnAttach.click();
                dwnChinese.click();
                System.out.println(driver.getTitle());
                driver.navigate().back();
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Attachment not present in letter");
                driver.navigate().back();
            }
        }
    }



    public LetterPage(WebDriver dr) {
        super(dr);
    }

}
