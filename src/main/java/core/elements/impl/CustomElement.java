package core.elements.impl;

import core.elements.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

abstract class CustomElement implements Element {
    protected final WebElement wrappedElement;

    protected CustomElement(final WebElement wrappedElement) {

        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}
