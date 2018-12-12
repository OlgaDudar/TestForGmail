package com.olga.elements.impl;

import org.openqa.selenium.WebElement;
import com.olga.elements.Element;

abstract class CustomElement implements Element {
    protected final WebElement wrappedElement;

    protected CustomElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

}
