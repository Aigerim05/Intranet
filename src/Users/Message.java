package Attributes;

import Interfaces.Employee;

public abstract class Message {
    private Employee sender;
    private Employee receiver;
    private String content;
    private String messageId; // Новое поле

    public Message() {}

    public Message(Employee sender, Employee receiver, String content, String messageId) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.messageId = messageId; // Интеграция messageId
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

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Message message = (Message) obj;
        return messageId != null && messageId.equals(message.messageId); // Сравнение по messageId
    }

    @Override
    public int hashCode() {
        return messageId != null ? messageId.hashCode() : 0; // Генерация hashCode на основе messageId
    }
}
