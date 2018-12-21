package pages;

import core.ExtendedFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage  {

    public WebDriver driver;

    public BasePage(WebDriver dr) {
        driver = dr;
        init();
    }

    public void openSite(String path){
        driver.get(path);
    }

    private void init(){
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }
}