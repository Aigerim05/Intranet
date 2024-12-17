package Users;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;

import Enums.Language;
public abstract class User implements Serializable
{

	public String password;
	private String firstName;
	private String lastName;
	private String userId;
	private Language language;
	private Vector<Date> logins;
	//	private Vector<ResearchJournal> subscriptions;

	{
		logins = new Vector<>();
		//		subscriptions = new Vector<ResearchJournal>();
	}

	public User() {

	}

	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public User(String firstName, String lastName, String userId, String password, Language language) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.language = language;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	//	public Vector<ResearchJournal> getSubscriptions() {
	//		return subscriptions;
	//	}
	//
	//	public void setSubscriptions(Vector<ResearchJournal> subscriptions) {
	//		this.subscriptions = subscriptions;
	//	}

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
				'}';
	}





}

