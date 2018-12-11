package com.olga;

import org.openqa.selenium.WebElement;
import com.olga.elements.Element;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
