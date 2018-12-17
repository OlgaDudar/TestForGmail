package core.elements.impl;

import org.openqa.selenium.WebElement;

public class MessageBox extends CustomElement {

    protected MessageBox(WebElement wrappedElement) {
        super(wrappedElement);
    }
    @Override
    public boolean isDisplayed(){
        return super.isDisplayed();
    }


    public void waitForSend(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
