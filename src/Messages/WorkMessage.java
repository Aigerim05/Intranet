package Messages;

import Users.Employee;

public class WorkMessage extends Message{

    public WorkMessage() {
        super(); 
    }

    public WorkMessage(Employee sender, Employee receiver, String content) {
        super(sender, receiver, content);
    }

    @Override
    public void send() {
        getReceiver().addMessage(this); 
    }

    @Override
    public String toString() {
        return "WorkMessage{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                '}';
    }
}
