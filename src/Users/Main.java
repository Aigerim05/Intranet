package Users;

public class Main {
    public static void main(String[] args) {
        // Создаём фабрику сообщений
        MessageFactory factory = new MessageFactory();

        // Создаём объект Complaint через фабрику
        Complaint complaint = (Complaint) factory.getMessage("Complaint");
        complaint.setSender(new Employee("Иван Иванов", "HR"));
        complaint.setReceiver(new Employee("Декан Петров", "Научный отдел"));
        complaint.setContent("Жалоба на задержку лекций");
        complaint.setUrgencyLevel(Urgency.HIGH);

        // Печать объекта Complaint
        System.out.println(complaint);

        // Создаём объект Request через фабрику
        Request request = (Request) factory.getMessage("Request");
        request.setSender(new Employee("Анна Смирнова", "Администрация"));
        request.setReceiver(new Employee("Декан Сидоров", "Научный отдел"));
        request.setContent("Запрос на подпись документа");
        request.setSignedStatus("PENDING"); // Используем строку вместо перечисления

        // Печать объекта Request
        System.out.println(request);

        // Создаём объект WorkMessage через фабрику
        WorkMessage workMessage = (WorkMessage) factory.getMessage("WorkMessage");
        workMessage.setSender(new Employee("Екатерина Иванова", "IT"));
        workMessage.setReceiver(new Employee("Декан Иванов", "Научный отдел"));
        workMessage.setContent("Задача на согласование");

        // Печать объекта WorkMessage
        System.out.println(workMessage);
    }
}
