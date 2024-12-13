package Users;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private List<Request> requests = new ArrayList<>();

    public List<Request> getRequests() {
        return requests;
    }

    public void addRequest(Request request) {
        requests.add(request);
    }
}
