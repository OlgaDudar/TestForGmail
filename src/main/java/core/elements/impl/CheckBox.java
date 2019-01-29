package core.elements.impl;

import org.openqa.selenium.WebElement;

public class CheckBox extends CustomElement{
    protected CheckBox(WebElement wrappedElement) {
        super(wrappedElement);
    }
    public void check () {
        wrappedElement.click();
    }
}
