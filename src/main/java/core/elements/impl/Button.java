package core.elements.impl;
import com.google.common.collect.ImmutableMap;
import core.driver.WebDriverThreadLocal;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Button extends CustomElement {
    protected Button(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click(){
        waitForButton();
        wrappedElement.click();
    }
    public void waitForButton(){
        Wait<WebDriver> wait = new WebDriverWait(WebDriverThreadLocal.getDriver(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
    }

}
