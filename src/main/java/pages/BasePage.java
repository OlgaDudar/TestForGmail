package pages;

import core.ExtendedFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
}