package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverSingleton {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<WebDriver>(){
        @Override
        protected WebDriver initialValue()
        {
            return new ChromeDriver(); // can be replaced with other browser drivers
        }
    };

    public static void setDriver(WebDriver webDriver){

        webDriverThreadLocal.set(webDriver);
    }

    public static WebDriver getDriver(){

        return webDriverThreadLocal.get();
    }

    public static void closeDriver(){
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }

}
