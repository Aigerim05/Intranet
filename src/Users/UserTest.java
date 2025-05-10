package Users;

import java.util.Date;
import java.util.Vector;

public class UserTest {
    public static void main(String[] args) {
        
        User user = new User("password123", "test@example.com", "John", "Doe", "U001", Language.EN) {};
        user.viewProfile();

        user.viewProfile();

        System.out.println(user);
        User user2 = new User("password123", "test@example.com", "John", "Doe", "U001", Language.EN) {};
    
        System.out.println( user.equals(user2));
    }
}
