package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import Enums.Format;
import Users.Data;
import Users.ResearchJournal;
import Users.ResearchPaper;
import Users.ResearchProject;
import Users.Researcher;
import Users.UserOperation;

public class ResearcherController {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static String readFromConsole()   {
		String read = "";
		try {
			read = input.readLine();
		}
		catch(IOException e) {
			System.out.println("Unsupported format");
		}
		return read; 	
	}

	Scanner in = new Scanner(System.in);
	private void save() throws IOException {
		Data.write();
	}

	private Researcher researcher;

	public ResearcherController(Researcher researcher) {
		this.researcher = researcher;
	}


	private void exit() {
		System.out.println("Bye bye Researcher");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void calculateHIndex() {
		ArrayList<Integer> citations = new ArrayList<>();
		if(!researcher.getResearchPapers().isEmpty()) {
			for(ResearchPaper paper: researcher.getResearchPapers()) {
				citations.add(paper.getNumberOfCitations());
			}
			Collections.sort(citations, Collections.reverseOrder());

			int hIndex = 0;
			for (int i = 0; i < citations.size(); i++) {
				if (citations.get(i) >= i + 1) {
					hIndex = i + 1; 
				} else {
					break; 
				}
			}

			System.out.println("Your h-index is " + hIndex);
		}
		else {
			System.out.println("You have no research papers yet.");
		}

	}


	public void printResearchPapers() {
		if(!researcher.getResearchPapers().isEmpty()) {
			researcher.getResearchPapers().sort((p1, p2) -> Integer.compare(p2.getNumberOfCitations(), p1.getNumberOfCitations()));
			UserOperation.printList(researcher.getResearchPapers());
		}
		else {
			System.out.println("You have no research papers yet.");
		}
	}

	public ResearchPaper createResearchPaper() {

		System.out.print("Enter the name of the research paper: ");
		String name = readFromConsole();
		System.out.print("Available research journals: \n");

		UserOperation.printList(Data.getInstance().researchJournals);

		System.out.print("Enter the name of the research journal: \n");
		int journalNumber =  in.nextInt();
		ResearchJournal theJournal = Data.getInstance().researchJournals.get(journalNumber - 1);

		System.out.print("Time to enter the authors! How many researchers are authors? Enter single number \n");
		int authorCount =  in.nextInt();
		ArrayList authors = chooseAuthors(authorCount);

		System.out.print("Enter the number of pages in the research paper: \n");
		int pages = in.nextInt();

		System.out.print("Is the paper free access? \n 1) yes 2) no ");
		boolean freeAccess = false;
		int answer = in.nextInt();
		if(answer == 1) {
			freeAccess = true;
		}
		if(answer == 2) {
			freeAccess = false;
		}

		System.out.print("Enter the number of citations: ");
		int numberOfCitations = in.nextInt();
		ResearchPaper newPaper = new ResearchPaper(name, theJournal, pages, new Date(), freeAccess, numberOfCitations);
		assignAuthors(authors, newPaper);

		return newPaper;
	}  




	public void run() throws IOException {
		try {
			System.out.println("Welcome, Researcher " + researcher.getUser().getFirstName() + "!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1) Calculate h-index \n 2) View my research papers \n 3) Publish research paper \n 4) Join the research project \n 5) Drop from research project \n 6) View my research projects \n 7) Get citation in format \n 8) View"
						+ " research papers of all researchers \n 9) Exit");
				int choiceMenu  = in.nextInt();
				if(choiceMenu == 1){
					calculateHIndex: while(true){
						calculateHIndex();
						System.out.println("1) Return back \n");
						int choiceHIndex = in.nextInt();
						if(choiceHIndex  == 1) {
							continue menu;
						}

					}
				}
				else if (choiceMenu == 2) {
					printResearchPapers: while(true){
						printResearchPapers();
						System.out.println("1) Return back \n");
						int choicePapers = in.nextInt();
						if(choicePapers  == 1) {
							continue menu;
						}
					}
				}

				else if (choiceMenu == 3) {
					publishResearchPaper: while(true) {
						if(Data.getInstance().researchJournals.isEmpty()) {
							System.out.println("There is no Research Journals in the system.\n");
						}
						else {
							ResearchPaper paper = createResearchPaper();
							researcher.publishPaper(paper.getResearchJournal(), paper);

						}

						System.out.println("1) Return back \n 2) Publish another paper");
						int choicePublish = in.nextInt();
						if(choicePublish  == 1) {
							continue menu;
						}
						else if (choicePublish  == 2) {
							continue publishResearchPaper;
						}
					}
				}
				else if (choiceMenu == 4) {
					joinResearchProject: while(true) {
						joinResearchProject();
						System.out.println("1) Return back \n 2) Join another research project \n");
						int choicePublish = in.nextInt();
						if(choicePublish  == 1) {
							continue menu;
						}
						else if (choicePublish  == 2) {
							continue joinResearchProject;
						}
					}
				}
				else if (choiceMenu == 5) {
					dropResearchProject: while(true) {
						dropResearchProject();
						System.out.println("1) Return back \n");
						int choiceDrop = in.nextInt();
						if(choiceDrop  == 1) {
							continue menu;
						}

					}
				}

				else if (choiceMenu == 6) {
					printResearchProjects: while(true) {
						printResearchProjects();
						System.out.println("1) Return back \n");
						int choice = in.nextInt();
						if(choice  == 1) {
							continue menu;
						}

					}
				}

				else if (choiceMenu == 7) {
					getCitationFormat: while(true) {
						getCitationFormat();
						System.out.println("1) Return back \n");
						int choice = in.nextInt();
						if(choice  == 1) {
							continue menu;
						}

					}
				}

				else if (choiceMenu == 8) {
					printAllPapers: while(true) {
						printPapersOfAllResearchers();
						System.out.println("1) Return back \n");
						int choice = in.nextInt();
						if(choice  == 1) {
							continue menu;
						}

					}
				}
				else if (choiceMenu == 8) {exit(); break menu;}
				break;
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}


	public void joinResearchProject() {
		System.out.print("Available research projects: \n");
		UserOperation.printList(Data.getInstance().researchProjects);

		System.out.print("Enter number of the project you want to join in: ");
		int projectNum = in.nextInt();
		ResearchProject project = Data.getInstance().researchProjects.get(projectNum - 1);
		project.addParticipants(researcher);
		researcher.getReserachProjects().add(project);
		System.out.print("You succesfully joined " + "\"" + project.getTopic() + "\""+ " project!\n");
	}

	public void dropResearchProject() {
		System.out.print("Available research projects: \n");
		UserOperation.printList(Data.getInstance().researchProjects);
		System.out.print("Enter number of the project you want to join in: \n");
		int projectNum = in.nextInt();
		ResearchProject project = Data.getInstance().researchProjects.get(projectNum - 1);
		project.removeParticipants(researcher);
		researcher.getReserachProjects().remove(project);
		System.out.print("You succesfully dropped of " + "\"" + project.getTopic() + "\""+ " project.\n");
	}

	public void printResearchProjects() {
		if(!researcher.getReserachProjects().isEmpty()) {
			UserOperation.printList(researcher.getReserachProjects());
		}
		else {
			System.out.println("You have not joined to any research projects yet.");
		}
	}

	public void getCitationFormat() {
		if(!researcher.getResearchPapers().isEmpty()) {
			System.out.println("Your research papers: \n");
			UserOperation.printList(researcher.getResearchPapers());
			System.out.println("Choose research paper you want the citation of: \n");
			int paperChoice = in.nextInt();
			ResearchPaper paper = researcher.getResearchPapers().get(paperChoice - 1);
			System.out.println("Choose format: \n 1) BIBTEX \n 2) PLAINTEXT");
			int choice = in.nextInt();
			Format format = UserOperation.enterFormat(choice);
			String citation = paper.getCitation(format);
			System.out.println(citation);

		}
		else {
			System.out.println("You have no research papers yet.");
		}
	}

	public void printAllResearchers() {
		if(!Data.getInstance().researchers.isEmpty()) {
			UserOperation.printList(Data.getInstance().researchers);
		}
		else {
			System.out.println("No researchers found in the system.");
		}
	}

	public void printPapersOfAllResearchers() {
		ArrayList<ResearchPaper> papers = Data.getInstance().researchPapers;
		if(papers.isEmpty()) {
			System.out.println("There is no research papers in the system for now.");
		}
		else{
			papers.sort((p1, p2) -> Integer.compare(p2.getNumberOfCitations(), p1.getNumberOfCitations()));
			UserOperation.printList(papers);
		}
	}

	public ArrayList<Researcher> chooseAuthors(int count) {
		System.out.println("Researchers in our system: \n");
		printAllResearchers();
		System.out.println("Enter the number (delimeted by enter) of researchers who you include as authors: \n");
		
		ArrayList<Researcher> authors = new ArrayList<>();
		for(int i = 0; i < count; i++) {
			int num = in.nextInt();
			authors.add(Data.getInstance().researchers.get(num - 1));
		}
		return authors;
	}

	public void assignAuthors(ArrayList<Researcher> authors, ResearchPaper paper) {
		ArrayList<Researcher> paperAuthors = paper.getAuthors();
		for(int i = 0; i < authors.size(); i++) {
			paperAuthors.add(authors.get(i));
		}
	}
}
