package core.elements.impl;

import core.elements.Element;
import org.openqa.selenium.WebElement;

abstract class CustomElement implements Element {
    protected final WebElement wrappedElement;

    protected CustomElement(final WebElement wrappedElement) {

        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return true;//wrappedElement.isDisplayed();
    }

}
