package Users;

import java.util.Objects;

public class Message {
    private Employee sender;
    private Employee receiver;
    private String content;


    public Message() {}


    public Message(Employee sender, Employee receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }


    public Employee getSender() {
        return sender;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public Employee getReceiver() {
        return receiver;
    }

    public void setReceiver(Employee receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
   
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(sender, message.sender) &&
               Objects.equals(receiver, message.receiver) &&
               Objects.equals(content, message.content);
    }


    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver, content);
    }

    
    
    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", content='" + content + '\'' +
                '}';
    }
}
