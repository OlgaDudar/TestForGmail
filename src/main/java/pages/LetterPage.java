package pages;

import core.elements.impl.Button;
import core.elements.impl.ListMail;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends BasePage{

    @FindBy(xpath = "//table//div[@class='yW']")
    private WebElement subject;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aZj T-I-ax7 T-I-Js-IF L3']")
    private Button dwnAttach;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aZj T-I-ax7 T-I-Js-Gs L3 T-I-JE']")
    public Button dwnToDrive;
    @FindBy(xpath = "//div[@class='J-M J-M-ayU DSaQrd']//div[text()='Спрощена китайська']")
    private Button dwnChinese;
    @FindBy(xpath = "//div[@class='ae4 aDM']//span[@class='bA4']")
    private ListMail fromList;
    @FindBy(xpath = "//div[@act='19']")
    private Button backToInbox;
    private String xPathForMail = "//table//div[@class='yW']//span[contains(text(),'Olga Dudar')]";


    @Step("Search mail with attachment")
    private WebElement getMailWithAttachment(){
        fromList.waitLoadInBox();
        return fromList.findElement(By.xpath(xPathForMail));
    }

    @Step("Check attachment is present in mail")
    private boolean CheckAttachmentIsPresent(){
        return dwnAttach.isDisplayed();
    }

    @Step("Download attachment on Chinese archive")
    public void DownloadAttachment(){
        getMailWithAttachment().click();
        if (CheckAttachmentIsPresent()) {
            dwnAttach.click();
            dwnChinese.click();
            System.out.println(driver.getTitle());
            backToInbox.click();
            System.out.println(driver.getTitle());
        } else {
            System.out.println("Attachment not present in letter");
            backToInbox.click();
        }
    }


    public LetterPage(WebDriver dr) {
        super(dr);
    }

}
