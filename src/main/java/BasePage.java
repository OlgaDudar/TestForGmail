import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class BasePage  {

    public WebDriver driver;


    public BasePage() {

       driver = WebDriverSingleton.getInstance();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void OpenSite(String _path){
        driver.get(_path);
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
}