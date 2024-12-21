package Users;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//		Admin admin = new Admin("Tech", "Guy", "somUserId", "111", Language.KZ);
		//		Data.getInstance().users.add(admin);
		//user@111 pass:111
		//		
		//		Course course = new Course("CsCI332", 3, "OOP", "", CourseType.MAJOR, 30);
		//		Data.getInstance().courses.add(course);
		//		course.getParticipants().add(new Student("Name", "Last", "user@student", "222", Language.KZ, 2, 21, Department.SITE));
		//
		//		Teacher teacher = Data.getInstance().teachers.get(0);
		//		teacher.getCourses().add(course);
		//		Student student1 = new Student("Dayana", "Smith", "student1@kbtu.kz", "pass1", Language.KZ, 2, 20, Department.SITE);
		//		Student student2 = new Student("Malika", "Jones", "student2@kbtu.kz", "pass2", Language.KZ, 2, 19, Department.SITE);
		//		//		student1.rateTeacher(teacher);
		//		student2.rateTeacher(teacher);


		//		Data.getInstance().researchProjects.add(new ResearchProject("Fuzzy", "project@111"));
		//		Data.getInstance().researchJournals.add(new ResearchJournal("Fancy journal"));


		// teacher: user@111, 111
		// just a researcher: user@222, 222
		DataOperation dataOperation = new DataOperation();
		dataOperation.login();


	}

}