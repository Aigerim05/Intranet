package Users;

import Interfaces.Employee;

public class SimpleMessage extends Message {

    public SimpleMessage() {
        super();
    }

    public SimpleMessage(Employee sender, Employee receiver, String content) {
        super(sender, receiver, content);
    }

    @Override
    public void send() {
        getReceiver().getMessages().add(this); // Добавляем сообщение в список сообщений получателя
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
