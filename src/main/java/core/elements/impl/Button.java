package core.elements.impl;
import core.driver.WebDriverSingleton;
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
        Wait<WebDriver> wait = new WebDriverWait(WebDriverSingleton.getDriver(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
    }

}
