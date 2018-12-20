package core.BO;

import core.model.Message;
import pages.InboxPage;
import pages.OutBox;

public class MailBO {
    InboxPage  inBox = new InboxPage();

    public MailBO(){
        ;
    }

    public void sendMessage(Message msg){
        inBox.createNewMail();
        inBox.setAddress(msg.getToWhom());
        inBox.setSubject(msg.getSubject());
        inBox.setMessage(msg.getMsgBody());
        inBox.sendMail();
    }
    public boolean verifyMsgIsSent(){

        return inBox.sendMessagePopupDisplayed();
    }

    public boolean checkMessageInOutbox(){
        OutBox outBox = new OutBox();
        outBox.goToOutBox();
        return outBox.checkMessageIsPresent();
    }
}
