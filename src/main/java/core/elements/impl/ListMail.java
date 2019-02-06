package core.elements.impl;

import core.driver.WebDriverThreadLocal;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListMail extends CustomElement{

    protected ListMail(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public WebElement findElement(By by){
        return wrappedElement.findElement(by);
    }


}
