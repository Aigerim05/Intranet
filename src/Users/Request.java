package Users;

import Interfaces.Employee;

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
    @Override
    public void send(Employee manager, Dean dean) {
        // Декан подписывает запрос
        dean.signRequest(this);

        // Добавляем запрос в список запросов менеджера
        if (manager instanceof Manager) {
            ((Manager) manager).getRequests().add(this);
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
