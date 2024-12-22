package Users;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {


		//		Admin admin = new Admin("Tech", "Guy", "user@5", "5", Language.KZ);
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
		//			student1.rateTeacher(teacher);
		//		student2.rateTeacher(teacher);

		//		Bachelor bachelor = new Bachelor("Bob", "john", "user@333", "333", Language.KZ, 2, 20, Department.SITE);
		//		System.out.println("Now lets create Masters");
		//		Master master = new Master();

		//		Data.getInstance().researchProjects.add(new ResearchProject("Fuzzy", "project@111"));
		//		Data.getInstance().researchJournals.add(new ResearchJournal("Fancy journal"));


		//		Student student = new Student("Bob", "Jogn", "user@333", "333", Language.KZ, 3, 20, Department.SITE);
		//		Data.getInstance().students.add(student);
		//		Course course = new Course("CSCI201", 2, "OOP", "some description", CourseType.MAJOR, 75);
		//		Data.getInstance().courses.add(course);
		//		student.getJournal().put(course, new Mark(0, 0, 0));
		DataOperation dataOperation = new DataOperation();
		dataOperation.login();


	}

}