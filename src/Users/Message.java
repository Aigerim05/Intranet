package Users;

import java.util.Random;
import java.util.Date;

import Users.Employee;

public abstract class Message {
    private Employee sender;
    private Employee receiver;
    private String content;
    private String messageId; // Новое поле

    public Message() {}

    public Message(Employee sender, Employee receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.messageId = generateId(); // Интеграция messageId
    }
    
    // метод для генерирования айди основываясь на времени и ранд числу
    private String generateId() {
    	Random random = new Random();
        Date d = new Date();
    	String currentTime = String.valueOf(d.getHours()) + String.valueOf(d.getMinutes());
            
        int randomNum = random.nextInt(10000);
        return currentTime + Integer.toString(randomNum, 36);
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
    public String getMessageId() {
        return messageId;
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

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", receiver=" + receiver + ", content=" + content + ", messageId="
				+ messageId + "]";
	}
}
