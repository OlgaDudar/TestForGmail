package pages;

import core.ExtendedFieldDecorator;
import core.driver.WebDriverThreadLocal;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BasePage  {
    protected WebDriver driver;


    public BasePage(WebDriver dr) {
        driver = dr;
        init();

    }

    public String getTitle(){
        return driver.getTitle();
    }

    @Step("Open Web Page")
    public void openSite(String path){
        driver.get(path);
    }

    private void init(){
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1600,1020));
    }

    protected void waitOutbox(String title){
        Wait<WebDriver> wait = new WebDriverWait(WebDriverThreadLocal.getDriver(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.titleContains(title));
    }

    public boolean waitTextIsVisibleInElement(WebElement el, String text) {
        Wait<WebDriver> wait = new WebDriverWait(WebDriverThreadLocal.getDriver(), 10)
                .ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.textToBePresentInElement(el, text));
        return el.isDisplayed();
    }
}