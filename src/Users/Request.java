package Users;

import Interfaces.Employee;
import Users.Dean;
import Users.Manager;

public class Request extends Message {
    private boolean assignedStatus = false; // Изначально статус false (не подписан)

    // Конструктор по умолчанию
    public Request() {
        super();
    }

    // Конструктор с параметрами
    public Request(Employee sender, Employee receiver, String content) {
        super(sender, receiver, content);
    }

    public boolean isAssignedStatus() {
        return assignedStatus;
    }

    public void setAssignedStatus(boolean assignedStatus) {
        this.assignedStatus = assignedStatus;
    }
    
    // Метод Send
    public void send(Employee manager, Employee dean) {
        // Декан подписывает запрос
    	if(dean instanceof Dean)
    		((Dean) dean).signRequest(this);
    	else {
    		System.out.println("Dean must sign the request");
    		return;
    	}
        
        // Добавляем запрос в список запросов менеджера
        if (manager instanceof Manager) {
            ((Manager) manager).addRequest(this);
        }
        else {
        	System.out.println("Access Denied");
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                ", assignedStatus=" + assignedStatus +
                '}';
    }
}
