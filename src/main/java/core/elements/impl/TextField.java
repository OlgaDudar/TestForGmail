package core.elements.impl;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class TextField extends CustomElement {

    protected TextField(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void type(final String text) {
        waitForElement();
        wrappedElement.sendKeys(text);
    }

    public void click(){
        wrappedElement.click();
    }

    public void waitForElement() {
        Boolean staleElement = true;
        int RETRY_COUNT = 100;
        while(staleElement && (RETRY_COUNT > 0)){
            try{
                wrappedElement.sendKeys("");
                staleElement = false;
                RETRY_COUNT--;
            }
            catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
