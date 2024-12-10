package Users;

import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

import Attributes.News;

public class Admin extends User {



	public Admin() {
		super();
	}

	public Admin(String password, String email, String firstName, String lastName,
			String userId, Language language) {
		super(firstName,lastName,userId,password,language);
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}




	public void updateUser(User u) {
		Scanner in = new Scanner(System.in);
		System.out.println("What do you want to change? ");
		System.out.println("1 - User ID");
		System.out.println("2 - Password");
		System.out.println("3 - First Name");
		System.out.println("4 - Last Name");
		System.out.println("5 - Language");
		int choice = in.nextInt();
		in.nextLine();
		if(choice == 1) {
			System.out.println("Enter new User ID:");
			String newUserId = in.nextLine();
			u.setUserId(newUserId);
			System.out.println("Successfully changed the User ID!");

		}
		else if(choice == 2) {
			System.out.println("Enter new Password: ");
			String newPasswor = in.nextLine();
			u.setPassword(newPasswor);
			System.out.println("Successfully changed the Password!");
		}
		else if(choice == 3) {
			System.out.println("Enter new First Name: ");
			String newFistName = in.nextLine();
			u.setFirstName(newFistName);
			System.out.println("Successfully changed the First Name");
		}

		else if(choice == 4) {
			System.out.println("Enter new Last Name: ");
			String newLastName = in.nextLine();
			u.setLastName(newLastName);
			System.out.println("Successfully changed the Last Name");
		}
		else if(choice == 5) {
			System.out.println("Enter new Language(KZ,RU,EN): ");
			String newLanguage = in.nextLine().toUpperCase();
			if (newLanguage.equals("KZ")) {
				u.setLanguage(Language.KZ);
				System.out.println("Қазақ тіліне сәтті өзгертілді");
			}
			if(newLanguage.equals("RU")) {
				u.setLanguage(Language.RU);
				System.out.println("Успешно изменен на русский язык");
			}
			if(newLanguage.equals("EN")) {
				u.setLanguage(Language.EN);
				System.out.println("Successfully changed the Language to EN");
			}
		}

	}
	public void removeUser() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the User ID to remove: ");
		String removeUserId = in.nextLine();
		boolean userFound = false;

		for (User user : Data.INSTANCE.users) {
			if (user.getUserId().equals(removeUserId)) {
				userFound = true;
				Data.INSTANCE.users.remove(user);
				System.out.println("Successfully removed the user with ID: " + removeUserId);
				break; 
			}
		}

		if (!userFound) {
			System.out.println("No user found with the ID: " + removeUserId);
		}
	}

	@Override
	public String viewAllUsers() {
		if (Data.INSTANCE.users.isEmpty()) {
			return "Admin:\n  No users found";
		}

		StringBuilder sb = new StringBuilder("Admin:\n");
		for (User user : Data.INSTANCE.users) {
			sb.append("  ").append(user.toString()).append("\n");
		}
		return sb.toString();  
	}


	public void viewLogs(User u) {
		if (u.getLogins() == null || u.getLogins().isEmpty()) {
			System.out.println("No login records found for user: " + u.getUserId());
		} else {
			System.out.println("Login Dates for user " + u.getUserId() + ":");
			for (Date login : u.getLogins()) {
				System.out.println(login);
			}
		}
	}


	public void addNews(News news) {
		if (news != null) {
			Data.INSTANCE.news.add(news);
		}
	}

	public void removeNews(String newsId) {
		Data.INSTANCE.news.removeIf(news -> news.getNewsId().equals(newsId));
	}

	public void displayNews() {
		for (News news : Data.INSTANCE.news) {
			System.out.println(news);
		}
	}
}
