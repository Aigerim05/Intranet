package Controllers;

import Users.Course;
import Users.Data;
import Users.Manager;
import Users.Student;
import Users.Teacher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private Student student;
    private Scanner in;

    public StudentController(Student student) {
        this.student = student;
        this.in = new Scanner(System.in);
    }

    private void save() {
        try {
            Data.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exit() {
        System.out.println("Logging out...");
        save();
    }

    public void run() {
        try {
            System.out.println("Welcome, " + student.getFirstName() + "!");
            menu: while (true) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1) View Courses");
                System.out.println("2) View Marks");
                System.out.println("3) View Instructors");
                System.out.println("4) Register for a Course");
                System.out.println("5) Rate a Teacher");
                System.out.println("6) View Transcript");
                System.out.println("7) Logout");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(in.nextLine());

                switch (choice) {
                    case 1:
                        student.viewCourses();
                        break;
                    case 2:
                        student.viewMarksForCourses();
                        break;
                    case 3:
                        student.viewInstructors();
                        break;
                    case 4:
                        registerForCourse();
                        break;
                    case 5:
                        rateTeacher();
                        break;
                    case 6:
                        student.viewTranscript();
                        break;
                    case 7:
                        exit();
                        break menu;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Saving data...");
            e.printStackTrace();
            save();
        }
    }

    private void registerForCourse() {
        System.out.println("Available Courses:");
        ArrayList<Course> availableCourses = Data.getInstance().courses;
        if (availableCourses.isEmpty()) {
            System.out.println("No courses available at the moment.");
            return;
        }

        int index = 1;
        for (Course course : availableCourses) {
            System.out.println(index + ") " + course.getCourseName() + " (" + course.getCode() + ")");
            index++;
        }

        System.out.print("Enter the number of the course you want to register for: ");
        int courseChoice = Integer.parseInt(in.nextLine());

        if (courseChoice < 1 || courseChoice > availableCourses.size()) {
            System.out.println("Invalid course selection.");
            return;
        }

        Course selectedCourse = availableCourses.get(courseChoice - 1);
        if (Data.getInstance().managers.isEmpty()) {
            System.out.println("No managers available to approve registration.");
            return;
        }

        Manager manager = Data.getInstance().managers.get(0);
        student.registerToCourse(selectedCourse, manager);
    }

    private void rateTeacher() {
        System.out.println("Your Instructors:");
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Course course : student.getJournal().keySet()) {
            for (Teacher teacher : course.getInstructors()) {
                if (!teachers.contains(teacher)) {
                    teachers.add(teacher);
                }
            }
        }

        if (teachers.isEmpty()) {
            System.out.println("No instructors found.");
            return;
        }

        int index = 1;
        for (Teacher teacher : teachers) {
            System.out.println(index + ") " + teacher.getFirstName() + " " + teacher.getLastName());
            index++;
        }

        System.out.print("Enter the number of the instructor you want to rate: ");
        int instructorChoice = Integer.parseInt(in.nextLine());

        if (instructorChoice < 1 || instructorChoice > teachers.size()) {
            System.out.println("Invalid instructor selection.");
            return;
        }

        Teacher selectedTeacher = teachers.get(instructorChoice - 1);
        student.rateTeacher(selectedTeacher);
    }
}