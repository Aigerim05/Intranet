package Users;
import java.io.IOException;

import Enums.CourseType;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// тут добавить логику чтобы проверять если такой админ есть в системе, то не создавать нового
		//		Admin admin = new Admin("Tech", "Guy", "somUserId", "111", Language.KZ);
		//		Data.getInstance().users.add(admin);
		//user@111 pass:111
		//		
		Course course = new Course("CsCI332", 3, "OOP", "", CourseType.MAJOR, 30);
		Data.getInstance().courses.add(course);
		//		course.getParticipants().add(new Student("Name", "Last", "user@student", "222", Language.KZ, 2, 21, Department.SITE));
		//
		//		Teacher teacher = Data.getInstance().teachers.get(0);
		//		teacher.getCourses().add(course);
		//		Student student1 = new Student("Dayana", "Smith", "student1@kbtu.kz", "pass1", Language.KZ, 2, 20, Department.SITE);
		//		Student student2 = new Student("Malika", "Jones", "student2@kbtu.kz", "pass2", Language.KZ, 2, 19, Department.SITE);
		//		//		student1.rateTeacher(teacher);
		//		student2.rateTeacher(teacher);

		DataOperation dataOperation = new DataOperation();
		dataOperation.login();


	}

}