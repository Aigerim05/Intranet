package Users;

import java.io.IOException;
import java.util.Scanner;

import Controllers.ResearcherController;

public class ResearchUtils {

	/*Creeates Researcher.*/
	public static Researcher createResearcher(User user) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter research field: ");
		String field = scanner.nextLine();

		System.out.print("Enter H-Index: ");
		int hIndex = scanner.nextInt();
		Researcher newResearcher = new Researcher(user, field);
		Data.getInstance().researchers.add(newResearcher);
		return newResearcher;
	}
	/*Asks if user want to be a researcher.*/
	public static Researcher askForResearcherRole(User user) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Do you want to become a researcher? (yes/no): ");
		String response = scanner.nextLine().trim().toLowerCase();

		if ("yes".equals(response)) {
			return createResearcher(user);
		} else {
			return null;
		}
	}

	public static void launchResearcherMode(Researcher researcher) throws IOException {
		ResearcherController researcherController= new ResearcherController(researcher);
		researcherController.run();
	}


}



