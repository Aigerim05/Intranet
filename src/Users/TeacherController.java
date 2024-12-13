package Users;

import java.io.IOException;
import java.util.Scanner;

public class TeacherController {
    private Teacher teacher;
    private Scanner scanner = new Scanner(System.in);

    public TeacherController(Teacher teacher) {
        this.teacher = teacher;
    }
    public boolean showStudents(){
		if(Data.INSTANCE.students.isEmpty()) {
			System.out.println("No students yet...Try adding one");
			return false;
		}
		printList(Data.INSTANCE.students);
		return true;
	}
	public boolean showCourses(){
		if(Data.INSTANCE.courses.isEmpty()) {
			System.out.println("No courses yet...");
			return false;
		}
		printList(Data.INSTANCE.courses);
		return true;
	}
    public void teacherMenu() throws IOException {
        try {
            System.out.println("Welcome, " + teacher.getFirstName() + "!");
            menu:
            while (true) {
                System.out.println("What do you want to do?");
                System.out.println("1) View courses");
                System.out.println("2) Put marks");
                System.out.println("3) Messages");
                System.out.println("4) Change password");
                System.out.println("5) Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        viewCourses();
                        break;
                    case 2:
                        putMarks();
                        break;
                    case 3:
                        sendMessage();
                        break;
                    case 4:
                        changePassword();
                        break;
                    case 5:
                        exit();
                        break menu;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Something bad happened... Saving resources...");
            e.printStackTrace();
            saveData();
        }
    }

   
    private void viewCourses() {
        System.out.println("Viewing courses:");
        teacher.viewCourses();
    }
    private void putMarks() {
        System.out.println("Choose student to which you want to put marks: (Enter number)");
        if (!showStudents()) {  
            return;
        }
        Student student = Data.INSTANCE.students.get(scanner.nextInt() - 1);
        System.out.println("Choose course: (Enter number)");
        if (!showCourses()) {  
            return;
        }
        int courseIndex = scanner.nextInt() - 1;
        Course course = teacher.getCourses().get(courseIndex);

        System.out.println("Choose attestation type (1 - First, 2 - Second, 3 - Final): ");
        int attType = scanner.nextInt();

        System.out.println("Enter the score: ");
        double score = scanner.nextDouble();

        teacher.putMark(student, course, attType, score);
    }


    	private void changePassword() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your current password: ");
            String currentPassword = scanner.nextLine();
            System.out.print("Enter your new password: ");
            String newPassword = scanner.nextLine();

            if (teacher.getPassword().equals(currentPassword)) {
                teacher.setPassword(newPassword);
                System.out.println("Password changed successfully!");
            } else {
                System.out.println("Current password is incorrect.");
            }
        }

    private void exit() throws IOException {
        System.out.println("Bye bye");
        saveData();
    }


   
    private void saveData() throws IOException {
        Data.write();
    }
}

