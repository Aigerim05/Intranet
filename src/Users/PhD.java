package Users;

import Enums.Department;
import Enums.Language;

public class PhD extends GraduateStudent{

	public PhD() {
		super();
	}

	public PhD(String firstName, String lastName, String userId, String password, Language language,
			int yearOfStudy, int maxCredit, Department department, ResearchDecorator supervisor, 
			ResearchProject researchProject) {
		super(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department, supervisor,
				researchProject);
	}



}
