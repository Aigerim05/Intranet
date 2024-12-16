package Users;

import java.util.Scanner;

import Enums.Department;
import Enums.Language;

public class UserFactory {

	public static User createUser(String userType) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first name:");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name:");
		String lastName = scanner.nextLine();
		System.out.println("Enter user ID: ");
		String userId = scanner.nextLine();
		System.out.println("Enter password:");
		String password = scanner.nextLine();
		System.out.println("Enter language \n 1) KZ 2) RU \n 3) EN"); 
		int languageChoice = Integer.parseInt(scanner.nextLine());
		Language language = UserOperation.enterLanguage(languageChoice);

		if (userType.equalsIgnoreCase("Student")) {
			System.out.println("Enter year of study:");
			int yearOfStudy = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter max credits:");
			int maxCredit = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter department: 1) SITE \n 2) ISE \n 3) SEOGI \n 4) SG \n 5) BS \n 6) KMA \n 7) SAM \n 8) SCE \n 9) SMSGT"); 
			int departmentChoice = Integer.parseInt(scanner.nextLine());
			Department department = UserOperation.enterDepartment(departmentChoice);
			return new Student(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department);

			//		} else if (userType.equalsIgnoreCase("Teacher")) {
			//			System.out.println("Enter position \n 1) Professor"); 
			//			int positionChoice = Integer.parseInt(scanner.nextLine());
			//			Position position = UserOperation.enterPosition(positionChoice);
			//			System.out.println("Enter department \n 1) SITE");
			//			int departmentChoice = Integer.parseInt(scanner.nextLine());
			//
			//			// тут нужно дописать специфичные филды Employee 
			//			return new Teacher(firstName, lastName, userId, password, language, );
			//		} else if (userType.equalsIgnoreCase("Manager")) {
			//
			//			создание менеджера
			//			return new Manager(firstName, secondName, .......);
		} else {
			System.out.println("Invalid user type");
			return null;
		}
	}
}
