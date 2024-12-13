package Users;

import Interfaces.Employee;
import Attributes.Message;

public class WorkMessage extends Message {

    public WorkMessage() {
        super(); // Вызываем конструктор родительского класса
    }

    public WorkMessage(Employee sender, Employee receiver, String content) {
        super(sender, receiver, content);
    }

    @Override
    public void send() {
        getReceiver().getMessages().add(this); // Добавляем WorkMessage в сообщения получателя
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
