package Attributes;

import Enums.RequestStatus;
import Interfaces.Employee;

public class Request extends Message {
	private RequestStatus signedStatus; 


	public Request() {
		super();
	}


	public Request(Employee sender, Employee receiver, String content, RequestStatus signedStatus) {
		super(sender, receiver, content);
		this.signedStatus = signedStatus;
	}

	public RequestStatus getSignedStatus() {
		return signedStatus;
	}

	public void setSignedStatus(RequestStatus signedStatus) {
		this.signedStatus = signedStatus;
	}

	@Override
	public String toString() {
		return "Request{" +
				"sender=" + getSender() +
				", receiver=" + getReceiver() +
				", content='" + getContent() + '\'' +
				", signedStatus='" + signedStatus + '\'' +
				'}';
	}
}