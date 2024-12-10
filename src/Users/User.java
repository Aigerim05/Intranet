package Users;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;

import Enums.Language;
public abstract class User implements Serializable
{

	public String password;
	public String email;
	private String firstName;
	private String lastName;
	private String userId;
	private Language language;
	private Vector<Date> logins;
	private Vector<ResearchJournal> subscriptions;

	{
		logins = new Vector<Date>();
		subscriptions = new Vector<ResearchJournal>();
	}

	public User() {

	}

	public User(String firstName, String lastName, String userId, String email, Language language) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.email = email;
		this.language = language;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return userId.equals(user.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
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

