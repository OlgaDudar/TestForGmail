package core.model;

public class Message {
private String toWhom;
private String subject;
private String msgBody;
public Message(String toWhomMsg, String subMsg, String bodyMsg){
    toWhom = toWhomMsg;
    subject = subMsg;
    msgBody = bodyMsg;
}
    public String getToWhom(){
    return this.toWhom;
    }
    public String getSubject(){
        return this.subject;
    }
    public String getMsgBody(){
        return this.msgBody;
    }
}
