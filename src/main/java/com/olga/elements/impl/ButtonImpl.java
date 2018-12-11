package com.olga.elements.impl;

import org.openqa.selenium.WebElement;
import com.olga.elements.Button;

public class ButtonImpl extends AbstractElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
