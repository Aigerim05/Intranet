package Users;

import Enums.Department;
import Enums.Language;
import Enums.Position;

public class UserOperation {
	public UserOperation() {};

	public static Department enterDepartment(int choice) {
		switch (choice) {
		case 1:
			return Department.SITE;
		case 2:
			return Department.ISE;
		case 3:
			return Department.SEOGI;
		case 4:
			return Department.SG;
		case 5:
			return Department.BS;
		case 6:
			return Department.KMA;
		case 7:
			return Department.SAM;
		case 8:
			return Department.SCE;
		case 9:
			return Department.SMSGT;
		default:
			return null;  
		}
	}


	public static Language enterLanguage(int choice) {
		switch (choice) {
		case 1:
			return Language.KZ;
		case 2:
			return Language.RU;
		case 3:
			return Language.EN;
		default:
			return null;  
		}
	}



	public static Position enterPosition(int choice) {
		switch (choice) {
		case 1:
			return Position.PROFESSOR;
		case 2:
			return Position.SENIOR_LECTURER;
		case 3:
			return Position.ASSISTANT_PROFESSOR;
		case 4:
			return Position.TUTOR;
		case 5:
			return Position.ASSOCIATE_PROFESSOR;
		default:
			return null;  
		}
	}


}
