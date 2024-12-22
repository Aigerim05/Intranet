package Users;

import Enums.Department;
import Enums.Language;

public class Master extends GraduateStudent{

	public Master() {
		super();

	}

	public Master(String firstName,
			String lastName,
			String userId,
			String password,
			Language language,
			int yearOfStudy,
			int maxCredit,
			Department department,
			Researcher supervisor,
			ResearchProject researchProject) {

		// Chain to GraduateStudent’s constructor
		super(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department, supervisor, researchProject);

		// Use the inherited setResearcher(...) method from Student/GraduateStudent
		setResearcher(ResearchUtils.createResearcher(this));
	}


}
