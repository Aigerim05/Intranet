package Users;

import java.util.Scanner;

public class BachelorStudent {
	public ResearchDecorator askForResearcherRole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to become a researcher? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(response)) {
            return ResearchUtils.createResearcher();
        } else {
            return null;
        }
    }
}
