package Users;

import Enums.Department;
import Enums.Language;

public class Bachelor extends Student{

	// fields related to organizations (not now)


	public Bachelor(String firstName,
			String lastName,
			String userId,
			String password,
			Language language,
			int yearOfStudy,
			int maxCredit,
			Department department) {

		super(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department);

		// Use the parent’s setResearcher(...) method
		setResearcher(ResearchUtils.askForResearcherRole(this));
	}

	public Bachelor() {
		super();

	}



}
