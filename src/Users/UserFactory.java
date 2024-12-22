package Users;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

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

			// Ask for specific student type
			System.out.println("Choose student type: \n 1) Bachelor \n 2) Master \n 3) PhD");
			int studentTypeChoice = Integer.parseInt(scanner.nextLine());

			switch (studentTypeChoice) {
			case 1: // Bachelor
				return new Bachelor(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department);

			case 2: { // Master
				Researcher supervisor = selectSupervisor(scanner);
				ResearchProject project = selectResearchProject(scanner);
				return new Master(firstName, lastName, userId, password, language,
						yearOfStudy, maxCredit, department, supervisor, project);
			}

			case 3: { // PhD
				Researcher supervisor = selectSupervisor(scanner);
				ResearchProject project = selectResearchProject(scanner);
				return new PhD(firstName, lastName, userId, password, language,
						yearOfStudy, maxCredit, department, supervisor, project);
			}

			default:
				System.out.println("Invalid student type selected, creating default Student");
				return new Student(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department);
			}
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
		} else if (userType.equalsIgnoreCase("EResearcher")) {
			System.out.println("Enter salary:");
			double salary = Double.parseDouble(scanner.nextLine());
			return new EResearcher(firstName, lastName, userId, password, language, salary);
		} else if (userType.equalsIgnoreCase("Manager")) {
			System.out.println("Enter position \n 1) OR \n 2) DEPARTMENT");
			int managerTypeChoice = Integer.parseInt(scanner.nextLine());
			ManagerType managerType = UserOperation.enterManagerType(managerTypeChoice);
			if (managerType == ManagerType.DEPARTMENT) {
				System.out.println("Enter department: 1) SITE \n 2) ISE \n 3) SEOGI \n 4) SG \n 5) BS \n 6) KMA \n 7) SAM \n 8) SCE \n 9) SMSGT");
				int departmentChoice = Integer.parseInt(scanner.nextLine());
				Department department = UserOperation.enterDepartment(departmentChoice);

			}
			System.out.println("Enter salary:");
			double salary = Double.parseDouble(scanner.nextLine());
			return new Manager(password, firstName, lastName, userId, language, managerType, salary);
		} 
		else {
			System.out.println("Invalid user type");
			return null;
		}
	}

	public static Researcher selectSupervisor(Scanner scanner) {
		ArrayList<Researcher> supervisors = Data.getInstance().researchers.stream()
				.filter(researcher -> researcher.calculateHIndex() > 3) 
				.collect(Collectors.toCollection(ArrayList::new)); 
		if (supervisors.isEmpty()) {
			System.out.println("No available supervisors found.");
			return null;
		}
		System.out.println("Available supervisors:");
		for (int i = 0; i < supervisors.size(); i++) {
			Researcher r = supervisors.get(i);
			System.out.println((i + 1) + ") " + r.getUser().getFirstName() + " " + r.getUser().getLastName() 
					+ " (ID: " + r.getUser().getUserId() + ")");
		}
		System.out.print("Enter the number of the supervisor or 0 to skip: ");
		String input = scanner.nextLine();
		if (input.isEmpty()) {
			return null;
		}
		int choice = Integer.parseInt(input);
		if (choice <= 0 || choice > supervisors.size()) {
			System.out.println("Skipping supervisor selection...");
			return null;
		}
		return supervisors.get(choice - 1);
	}

	public static ResearchProject selectResearchProject(Scanner scanner) {
		ArrayList<ResearchProject> projects = Data.getInstance().researchProjects;
		if (projects.isEmpty()) {
			System.out.println("No available research projects.");
			return null;
		}
		System.out.println("Available research projects:");
		for (int i = 0; i < projects.size(); i++) {
			ResearchProject p = projects.get(i);
			System.out.println((i + 1) + ") " + p.getTopic() + " (ID: " + p.getProjectId() + ")");
		}
		System.out.print("Enter the number of the project or 0 to skip: ");
		String input = scanner.nextLine();
		if (input.isEmpty()) {
			return null;
		}
		int choice = Integer.parseInt(input);
		if (choice <= 0 || choice > projects.size()) {
			System.out.println("Skipping project selection...");
			return null;
		}
		return projects.get(choice - 1);
	}
}
