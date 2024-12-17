package Users;
import Enums.Department;
import Enums.Language;
import Enums.Position;
public class TestUserandTaecher {
	public static void main(String[] args) {
	Student student1 = new Student("John", "Doe", "std001", "pass123", Language.EN, 2, 30, Department.SITE);
    Teacher teacher1 = new Teacher("Jane", "Smith", "tch001", "pass456", Language.EN, Position.TUTOR, Department.SITE);

    // Студент ставит оценки учителю
    student1.rateTeacher(teacher1);
    student1.rateTeacher(teacher1);

    // Учитель получает средний балл
    double avgRating = teacher1.getAverageRating();
    System.out.println("Teacher's average rating: " + avgRating);
}
}