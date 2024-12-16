package Users;

import java.util.Scanner;

public class ResearchUtils {
	//	public void printResearchPapersOfAllResearchers() {
	//
	//	}

	public static ResearchDecorator createResearcher(User user) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter research field: ");
		String field = scanner.nextLine();

		System.out.print("Enter H-Index: ");
		int hIndex = scanner.nextInt();

		return new ResearchDecorator(user, hIndex, field);
	}

	public static ResearchDecorator askForResearcherRole(User user) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Do you want to become a researcher? (yes/no): ");
		String response = scanner.nextLine().trim().toLowerCase();

		if ("yes".equals(response)) {
			return createResearcher(user);
		} else {
			return null;
		}
	}

	//	public static ResearchPaper createResearchPaper() {
	//
	//	}
}



