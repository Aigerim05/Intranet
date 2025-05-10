package Attributes;

import Interfaces.Employee;

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

}