package Users;

import Interfaces.Employee;

public class SimpleMessage extends Message implements Sendable{

    public SimpleMessage() {
        super();
    }

    public SimpleMessage(Employee sender, Employee receiver, String content) {
        super(sender, receiver, content);
    }
    
    
	@Override
	public String toString() {
		return "SimpleMessage["+super.toString()+"]";
	}

	public void send() {
		super.getReceiver().addMessage(this);
	}
    
}

