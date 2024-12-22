package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import Users.Course;
import Users.Data;
import Users.DataOperation;
import Users.Manager;
import Users.ResearchUtils;
import Users.Researcher;
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
			while (true) {
				System.out.println("What would you like to do?");
				System.out.println("1) View Courses");
				System.out.println("2) View Marks");
				System.out.println("3) View Instructors");
				System.out.println("4) Register for a Course");
				System.out.println("5) Rate a Teacher");
				System.out.println("6) View Transcript");
				System.out.println("7) Switch to Researcher Mode");
				System.out.println("8) Logout");
				System.out.print("Enter your choice: ");
				String choice = DataOperation.readFromConsole();

				switch (choice) {
				case "1":
					do {
						student.viewCourses();
					} while (repeatOperation());
					break;
				case "2":
					do {
						student.viewMarksForCourses();
					} while (repeatOperation());
					break;
				case "3":
					do {
						student.viewInstructors();
					} while (repeatOperation());
					break;
				case "4":
					do {
						registerForCourse();
					} while (repeatOperation());
					break;
				case "5":
					do {
						rateTeacher();
					} while (repeatOperation());
					break;
				case "6":
					do {
						student.viewTranscript();
					} while (repeatOperation());
					break;
				case "7":
					if (student.getResearcher() != null) {
						Researcher researcher = student.getResearcher();
						ResearchUtils.launchResearcherMode(researcher);
					} else {
						System.out.println("You are not a researcher.");
					}
					break;
				case "8":
					exit();
					return;
				default:
					System.out.println("Invalid choice. Try again.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean repeatOperation() {
		System.out.println("\n1) Repeat this operation");
		System.out.println("2) Return to main menu");
		String input = DataOperation.readFromConsole();
		return input.equals("1");
	}

	private void registerForCourse() {
		System.out.println("Available Courses:");
		ArrayList<Course> availableCourses = Data.getInstance().courses;
		if (availableCourses.isEmpty()) {
			System.out.println("No courses available.");
			return;
		}

		int index = 1;
		for (Course course : availableCourses) {
			System.out.println(index++ + ") " + course.getCourseName());
		}

		System.out.print("Enter the number of the course you want to register for: ");
		String input = DataOperation.readFromConsole();
		if (input.isEmpty()) {
			System.out.println("No input provided. Please enter a choice.");
			return;
		}

		int courseNumber = Integer.parseInt(input);
		if (courseNumber < 1 || courseNumber > availableCourses.size()) {
			System.out.println("Invalid course number.");
			return;
		}

		Course course = availableCourses.get(courseNumber - 1);
		Manager ORManager = Data.getInstance().getManager();
		ORManager.approveStudent(student, course);
		System.out.println("Successfully registered for the course: " + course.getCourseName());
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
