package Users;

import java.util.Scanner;

import Enums.Department;
import Enums.Language;
import Enums.ManagerType;
import Enums.Position;

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
			System.out.println("Enter department: \n 1) SITE \n 2) ISE \n 3) SEOGI \n 4) SG \n 5) BS \n 6) KMA \n 7) SAM \n 8) SCE \n 9) SMSGT"); 
			int departmentChoice = Integer.parseInt(scanner.nextLine());
			Department department = UserOperation.enterDepartment(departmentChoice);
			return new Student(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department);

		} else if (userType.equalsIgnoreCase("Teacher")) {
			System.out.println("Enter position \n 1) PROFESSOR \n 2) SENIOR_LECTURER \n 3) ASSISTANT_PROFESSOR \n 4) TUTOR \n 5) ASSOCIATE_PROFESSOR"); 
			int positionChoice = Integer.parseInt(scanner.nextLine());
			Position position = UserOperation.enterPosition(positionChoice);
			System.out.println("Enter department: \n 1) SITE \n 2) ISE \n 3) SEOGI \n 4) SG \n 5) BS \n 6) KMA \n 7) SAM \n 8) SCE \n 9) SMSGT");
			int departmentChoice = Integer.parseInt(scanner.nextLine());
			Department department = UserOperation.enterDepartment(departmentChoice);
			System.out.println("Enter salary:");
			double salary = Double.parseDouble(scanner.nextLine());
			return new Teacher(firstName, lastName, userId, password, language, position, department, salary);
		} 

		else if (userType.equalsIgnoreCase("EResearcher")) {
			System.out.println("Enter salary:");
			double salary = Double.parseDouble(scanner.nextLine());
			return new EResearcher(firstName, lastName, userId, password, language, salary);
		} 
		else if (userType.equalsIgnoreCase("Manager")) {
			System.out.println("Enter position \n 1) OR \n 2) DEPARTMENT"); 
			int managerTypeChoice = Integer.parseInt(scanner.nextLine());
			ManagerType managerType = UserOperation.enterManagerType(managerTypeChoice);
			if(managerType == ManagerType.DEPARTMENT) {
				System.out.println("Enter department: 1) SITE \n 2) ISE \n 3) SEOGI \n 4) SG \n 5) BS \n 6) KMA \n 7) SAM \n 8) SCE \n 9) SMSGT");
				int departmentChoice = Integer.parseInt(scanner.nextLine());
				Department department = UserOperation.enterDepartment(departmentChoice);
			}
			return new Manager(password, firstName, lastName, userId, language, managerType);
		} 
		//		else if (userType.equalsIgnoreCase("Employee")) {
		//			System.out.println("Enter salary: \n"); 
		//			double salary = Double.parseDouble(scanner.nextLine());
		//			return new Employee(firstName, lastName, userId, password, language, salary);
		//		} 



		// else if (userType.equalsIgnoreCase("Manager")) {

		//			создание менеджера
		//			return new Manager(firstName, secondName, .......);
		else {
			System.out.println("Invalid user type");
			return null;
		}
	}
}
