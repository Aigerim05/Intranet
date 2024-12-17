package Users;

import Enums.Department;
import Enums.Language;
import Enums.Position;

public class TestResearcher {

	public static void main(String[] args) {
		Teacher teacher = new Teacher ("Pakita", "Shamoi", "user@3131", "111", Language.EN, Position.PROFESSOR, Department.SITE);

		System.out.println(teacher.getResearcher().getField());
		teacher.getResearcher().sethIndex(10);
		System.out.println(teacher.getResearcher().gethIndex());
		//
		//		Teacher no  nprof = new Teacher("Bob", "Bob", "user@00", "101", Language.EN, Position.ASSISTANT_PROFESSOR, Department.BS);
		//
		//		PhD phd = new PhD("PhD", "PhD", "user@13123", "222", Language.RU, 1, 30, Department.ISE, teacher.getResearcher(), new ResearchProject());
		//
		//		phd.setSupervisor(nonprof.getResearcher());
		//
		//		System.out.println(phd.getSupervisor().toString());




	}

}
