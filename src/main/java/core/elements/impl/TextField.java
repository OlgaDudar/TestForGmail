package core.elements.impl;

import core.driver.WebDriverThreadLocal;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextField extends CustomElement {

    protected TextField(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void type(final String text) {
        waitElementIsVisible();
        wrappedElement.sendKeys(text);
    }

}
