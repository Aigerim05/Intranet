package Attributes;

import Interfaces.Employee;

public class MessageFactory {

	public Message getMessage(String type, Employee caller) {
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