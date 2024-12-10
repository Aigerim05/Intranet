package Attributes;

import Interfaces.Employee;

public class SimpleMessage extends Message {

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