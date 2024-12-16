package Attributes;
import java.util.Objects;

import Interfaces.Employee;

public class WorkMessage extends Message {


	public WorkMessage() {
		super(); 
	}


	public WorkMessage(Employee sender, Employee receiver, String content) {
		super(sender, receiver, content);
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof WorkMessage)) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode());
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