package core.elements.impl;
import org.openqa.selenium.WebElement;

public class Button extends CustomElement {
    protected Button(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click(){

        wrappedElement.click();
    }


}
