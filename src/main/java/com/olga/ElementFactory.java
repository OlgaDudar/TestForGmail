package com.olga;

import org.openqa.selenium.WebElement;
import com.olga.elements.Element;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);
}
