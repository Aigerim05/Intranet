package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import Users.Course;
import Users.Data;
import Users.DataOperation;
import Users.Manager;
import Users.Student;
import Users.Teacher;

public class StudentController {
	private Student student;

	public StudentController(Student student) {
		this.student = student;
	}

	private void save() {
		try {
			Data.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exit() {
		System.out.println("Bye bye");
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
				String input = DataOperation.readFromConsole();
				if (input.isEmpty()) {
					System.out.println("No input provided. Please enter a choice.");
					continue;
				}
				int choice;
				try {
					choice = Integer.parseInt(input);
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a number between 1 and 7.");
					continue;
				}

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
					registerCourseLoop:
						while (true) {
							registerForCourse();
							System.out.println("\n1) Register for another course");
							System.out.println("2) Return to main menu");
							String regInput = DataOperation.readFromConsole();
							if (regInput.equals("1")) {
								continue registerCourseLoop;
							} else if (regInput.equals("2")) {
								break registerCourseLoop;
							} else {
								System.out.println("Invalid choice. Returning to main menu.");
								break registerCourseLoop;
							}
						}
					break;
				case 5:
					rateTeacherLoop:
						while (true) {
							rateTeacher();
							System.out.println("\n1) Rate another teacher");
							System.out.println("2) Return to main menu");
							String rateInput = DataOperation.readFromConsole();
							if (rateInput.equals("1")) {
								continue rateTeacherLoop;
							} else if (rateInput.equals("2")) {
								break rateTeacherLoop;
							} else {
								System.out.println("Invalid choice. Returning to main menu.");
								break rateTeacherLoop;
							}
						}
					break;
				case 6:
					student.viewTranscript();
					break;
				case 7:
					exit();
					break menu;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 7.");
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
		String input = DataOperation.readFromConsole();
		if (input.isEmpty()) {
			System.out.println("No input provided. Returning.");
			return;
		}
		int courseChoice;
		try {
			courseChoice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid course number.");
			return;
		}

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
		if (student.getJournal() == null || student.getJournal().isEmpty()) {
			System.out.println("You are not enrolled in any courses to rate teachers.");
			return;
		}

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
		String input = DataOperation.readFromConsole();
		if (input.isEmpty()) {
			System.out.println("No input provided. Returning.");
			return;
		}
		int instructorChoice;
		try {
			instructorChoice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid instructor number.");
			return;
		}

		if (instructorChoice < 1 || instructorChoice > teachers.size()) {
			System.out.println("Invalid instructor selection.");
			return;
		}

		Teacher selectedTeacher = teachers.get(instructorChoice - 1);
		student.rateTeacher(selectedTeacher);
	}
}