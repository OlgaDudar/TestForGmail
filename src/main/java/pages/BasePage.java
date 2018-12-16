package pages;

import core.ExtendedFieldDecorator;
import core.driver.WebDriverSingleton;
import core.elements.impl.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage  {

    public WebDriver driver;


    public BasePage() {

        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        init();
    }

    public void OpenSite(String path){
        driver.get(path);
    }

    private void init(){

        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }
}