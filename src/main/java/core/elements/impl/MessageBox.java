package core.elements.impl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MessageBox extends CustomElement {

    protected MessageBox(WebElement wrappedElement) {

        super(wrappedElement);
    }
    @Override
    public boolean isDisplayed(){

        return super.isDisplayed();
    }

    public boolean waitForSend(WebElement msgBoxText) {

        int COUNTER = 0;
        while (true){
            System.out.println("Count: " + COUNTER);
            if (COUNTER == 10) {
                return false;
            }
            WebElement res = msgBoxText;
            System.out.println(res.getText());
            String messageText = res.getText();
            if ((messageText.equals("Лист надіслано.")) || (messageText.equals("Message sent."))) {
                return true;
            }
            else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                COUNTER++;
            }
        }
    }

}
