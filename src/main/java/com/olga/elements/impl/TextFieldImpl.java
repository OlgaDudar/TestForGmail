package com.olga.elements.impl;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import com.olga.elements.TextField;

public class TextFieldImpl extends AbstractElement implements TextField {
    protected TextFieldImpl(final WebElement wrappedElement) {

        super(wrappedElement);
    }

    @Override
    public void type(final String text) {
        waitForElement();
        wrappedElement.sendKeys(text);
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public void clearAndType(final String text) {

        clear();
        type(text);
    }

    @Override
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
}
