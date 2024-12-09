package Users;

public class Request extends Message {
    private String signedStatus; // Изменено на String

    // Конструктор по умолчанию
    public Request() {
        super();
    }

    // Конструктор с параметрами
    public Request(Employee sender, Employee receiver, String content, String signedStatus) {
        super(sender, receiver, content);
        this.signedStatus = signedStatus;
    }

    public String getSignedStatus() {
        return signedStatus;
    }

    public void setSignedStatus(String signedStatus) {
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
