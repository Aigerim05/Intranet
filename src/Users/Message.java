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

class SimpleMessage extends Message {

    public SimpleMessage() {
        super();
    }


    public SimpleMessage(Employee sender, Employee receiver, String content) {
        super(sender, receiver, content);
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                '}';
    }
}


class WorkMessage extends Message {
    private Urgency urgencyLevel;

    public WorkMessage() {
        super();
    }

    public WorkMessage(Employee sender, Employee receiver, String content, Urgency urgencyLevel) {
        super(sender, receiver, content);
        this.urgencyLevel = urgencyLevel;
    }


    public Urgency getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(Urgency urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorkMessage that = (WorkMessage) o;
        return urgencyLevel == that.urgencyLevel;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), urgencyLevel);
    }

    @Override
    public String toString() {
        return "WorkMessage{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                ", urgencyLevel=" + urgencyLevel +
                '}';
    }
}


enum Urgency {
    LOW, MEDIUM, HIGH;
}


class Employee {
    private String name;


    public Employee() {}


    public Employee(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

   
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

   
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
