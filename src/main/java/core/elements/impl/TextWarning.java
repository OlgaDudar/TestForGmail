package core.elements.impl;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TextWarning extends CustomElement{
    protected TextWarning(WebElement wrappedElement) {
        super(wrappedElement);
    }
    @Override
    public boolean isDisplayed() {
        try {
            return super.isDisplayed();
        } catch (NoSuchElementException ex){
            return false;
        }
    }
}
