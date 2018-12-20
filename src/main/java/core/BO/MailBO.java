package core.BO;

import core.model.Message;
import pages.InboxPage;

public class MailBO {
    InboxPage  inBox = new InboxPage();

    public MailBO(){
        ;
    }

    public void sendMessage(Message msg){
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setMessage(msg.getMsgBody());
        inBox.sendMail();
    }
    public boolean verifyMsgIsSent(){
       return inBox.sendMessagePopupDisplayed();
    }
}
