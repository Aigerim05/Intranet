package Users;
import java.io.IOException;

import Enums.Language;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//		UserOperation.printList(Data.getInstance().courses);
		Admin admin = new Admin("Tech", "Guy", "user@5", "5", Language.KZ);
		Data.getInstance().users.add(admin);

		// Hiroharu: user@3
		// Pakita: user@2
		// Manager : user@1


		//
		//		Data.getInstance().researchProjects.add(new ResearchProject("Fuzzy", "project@111"));
		//		Data.getInstance().researchJournals.add(new ResearchJournal("Fancy journal"));


		DataOperation dataOperation = new DataOperation();
		dataOperation.login();


	}

}