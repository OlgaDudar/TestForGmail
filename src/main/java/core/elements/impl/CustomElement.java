package core.elements.impl;

import core.driver.WebDriverThreadLocal;
import core.elements.Element;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class CustomElement implements Element {
    protected final WebElement wrappedElement;

    protected CustomElement(final WebElement wrappedElement) {

        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
    @Override
    public boolean isEnabled() {
        return wrappedElement.isEnabled();
    }

    public boolean waitTextIsVisibleInElement(String text){
        Wait<WebDriver> wait = new WebDriverWait(WebDriverThreadLocal.getDriver(), 10)
                .ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        return wait.until(ExpectedConditions.textToBePresentInElement(wrappedElement, text));
    }

    protected void waitElementIsVisible(){
        Wait<WebDriver> wait = new WebDriverWait(WebDriverThreadLocal.getDriver(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
    }
    public void waitLoadInBox(){
        Wait<WebDriver> wait = new WebDriverWait(WebDriverThreadLocal.getDriver(), 10).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.titleContains("Вхідні"));
    }

}
