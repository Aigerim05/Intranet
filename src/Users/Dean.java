package Users;

import Attributes.Message;
import Attributes.Complaint;
import Attributes.Request;

public class Dean implements Observer {

    private String name;

    public Dean(String name) {
        this.name = name;
    }

    @Override
    public void update(Message message) {
        System.out.println(name + " получил уведомление о новом сообщении: " + message.getContent());
        if (message instanceof Complaint) {
            handleComplaint((Complaint) message);
        } else if (message instanceof Request) {
            handleRequest((Request) message);
        }
    }

    private void handleComplaint(Complaint complaint) {
        System.out.println(name + " обрабатывает жалобу: " + complaint.getContent());
    }

    private void handleRequest(Request request) {
        System.out.println(name + " подписывает запрос: " + request.getContent());
    }
}
