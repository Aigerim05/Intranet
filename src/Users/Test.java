package Users;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.List;
public class Test {

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<>();

        
        User user1 = new User("password1", "user1@example.com", "John", "Doe", "user1", Language.EN, new Vector<Date>(), new Vector<ResearchJournal>()) {};
        User user2 = new User("password2", "user2@example.com", "Jane", "Smith", "user2", Language.KZ, new Vector<Date>(), new Vector<ResearchJournal>()) {};
        users.add(user1);
        users.add(user2);

 
        Admin admin = new Admin(users);

        System.out.println("Users List:");
        for (User user : users) {
            System.out.println(user);
        }

        admin.updateUser(users.get(0));

        admin.removeUser(users.get(1));

	}

}
