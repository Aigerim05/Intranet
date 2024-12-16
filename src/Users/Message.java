package Users;

import java.util.Random;
import java.util.Date;

import Users.Employee;

public abstract class Message {
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
    public Employee getReceiver() {
        return receiver;
    }
    public String getContent() {
        return content;
    }
    public void editMessage(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Message message = (Message) obj;
        return content != null && content.equals(message.content); // Сравнение по content
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0; // Генерация hashCode на основе content
    }

    @Override
    public String toString() {
        return "Message [sender=" + sender + ", receiver=" + receiver + ", content=" + content + "]";
    }
}
