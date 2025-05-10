package Users;

import Enums.Department;
import Enums.Language;

public class Bachelor extends Student{
	private ResearchDecorator researcher;

	// fields related to organizations (not now)


	public Bachelor(String firstName, String lastName, String userId, String password, Language language,
			int yearOfStudy, int maxCredit, Department department) {

		super(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department);

		this.researcher = ResearchUtils.askForResearcherRole(this);
	}

	public Bachelor() {
		super();

	}

	public ResearchDecorator getResearcher() {
		return researcher;
	}

	public void setResearcher(ResearchDecorator researcher) {
		this.researcher = researcher;
	}



}
