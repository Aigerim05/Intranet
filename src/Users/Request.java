package Users;

import java.util.Objects;

public class Request extends Message {
    private RequestStatus signedStatus;

    public Request(Employee sender, Employee receiver, String content, RequestStatus signedStatus) {
        super(sender, receiver, content); // Call to the parent class constructor
        this.signedStatus = signedStatus;
    }


    public RequestStatus getSignedStatus() {
        return signedStatus;
    }

    public void setSignedStatus(RequestStatus signedStatus) {
        this.signedStatus = signedStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        if (!super.equals(o)) return false;
        Request request = (Request) o;
        return signedStatus == request.signedStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), signedStatus);
    }


    @Override
    public String toString() {
        return "Request{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                ", signedStatus=" + signedStatus +
                '}';
    }
}
