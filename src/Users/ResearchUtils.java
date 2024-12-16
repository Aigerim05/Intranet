package Users;

import java.util.Scanner;

public class ResearchUtils {

	public void printResearchPapersOfAllResearchers() {
		
	}
	    public static ResearchDecorator createResearcher() {
	    	 Scanner scanner = new Scanner(System.in);

	         System.out.print("Enter User Name: ");
	         String name = scanner.nextLine();

	         System.out.print("Enter Department: ");
	         String departmentName = scanner.nextLine();
	         
	         System.out.print("Enter H-Index: ");
	         int hIndex = scanner.nextInt();
	         Department department = Department.valueOf(departmentName.toUpperCase());
	         UserFactory user = new UserFactory();
	         ResearchDecorator researcher = new ResearchDecorator(user, hIndex, department);
	         return researcher;
	    }

	    public static ResearchDecorator askForResearcherRole() {
	    	Scanner scanner = new Scanner(System.in);

	        System.out.print("Do you want to become a researcher? (yes/no): ");
	        String response = scanner.nextLine().trim().toLowerCase();

	        if ("yes".equals(response)) {
	            return createResearcher();
	        } else {
	            return null;
	        }
	    }
	}

