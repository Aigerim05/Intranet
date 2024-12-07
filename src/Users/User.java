package Users;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;
public abstract class User implements Serializable
{

	public String password;
	public String email;
	private String firstName;
	private String lastName;
	private String userId;
	private Language language;
	public Vector<Date> logins;
	protected Vector<ResearchJournal> subscriptions;
	{
		logins = new Vector<Date>();
	    subscriptions = new Vector<ResearchJournal>();
		}
	public User() {
		
	}
	public User(String password, String email, String firstName, String lastName,
            String userId, Language language, Vector<Date> logins,
            Vector<ResearchJournal> subscriptions) {
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userId = userId;
    this.language = language;
    this.logins = logins;
    this.subscriptions = subscriptions;
}
	
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
    public Vector<Date> getLogins() {
        return logins;
    }

    public void setLogins(Vector<Date> logins) {
        this.logins = logins;
    }

    public Vector<ResearchJournal> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Vector<ResearchJournal> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        User user = (User) o;
        return password.equals(user.password) &&
               email.equals(user.email) &&
               firstName.equals(user.firstName) &&
               lastName.equals(user.lastName) &&
               userId.equals(user.userId) &&
               logins.equals(user.logins) &&
               subscriptions.equals(user.subscriptions);
    }

    public int hashCode() {
        return Objects.hash(password, email, firstName, lastName, userId, logins, subscriptions);
    }

    public String toString() {
        return "User{" +
               "password='" + password + '\'' +
               ", email='" + email + '\'' +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", userId='" + userId + '\'' +
               ", logins=" + logins +
               ", subscriptions=" + subscriptions +
               '}';
    }
	
	
	public void setLanguage() {
		// TODO implement me
		return;	
	}
	
	public void viewProfile() {
		 System.out.println("Profile Information:");
		    System.out.println("Name: " + firstName);
		    System.out.println("Surname: " + lastName);
		    System.out.println("Email: " + email);
		    System.out.println("User ID: " + userId);
		    System.out.println("Language: " + language);
		    System.out.println("Logins: " + logins);
		    System.out.println("Subscriptions: " + subscriptions);	
	}
	
	
}

