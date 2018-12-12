import com.olga.ExtendedFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected WebElement waitForElement(WebDriver driver, final By by){
        Boolean staleElement = true;
        int RETRY_COUNT = 100;
        WebElement element = null;
        while(staleElement && (RETRY_COUNT > 0)){
            try{
                element = driver.findElement(by);
                element.sendKeys("");
                staleElement = false;
                RETRY_COUNT--;

            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return element;
    }

    private void init(){
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }
}