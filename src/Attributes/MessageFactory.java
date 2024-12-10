package Attributes;

public class MessageFactory {

	public Message getMessage(String type) {
		switch (type) {
		case "Complaint":
			return new Complaint();
		case "WorkMessage":
			return new WorkMessage();
		case "Request":
			return new Request();
		case "SimpleMessage":
			return new SimpleMessage();
		default:
			throw new IllegalArgumentException("Неизвестный тип сообщения: " + type);
		}
	}
}