package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Enums.CourseType;
import Users.Course;
import Users.Data;
import Users.Manager;
import Users.Mark;
import Users.Student;
import Users.Teacher;

public class ManagerController {
	Manager manager;

	public ManagerController(Manager manager) {
		this.manager = manager;
	}

	Scanner in = new Scanner(System.in);

	private void save() throws IOException {
		Data.write();
	}

	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewCourses() {
		if (Data.getInstance().courses.isEmpty()) {
			System.out.println("No courses available yet...");
		} else {
			for (int i = 0; i < Data.getInstance().courses.size(); i++) {
				System.out.println((i + 1) + ". " + Data.getInstance().courses.get(i).getCourseName());
			}
		}
	}

	public void viewStudents() {
		if (Data.getInstance().students.isEmpty()) {
			System.out.println("No students...");
		}else {
			System.out.println("List of Students: ");
			for(Student student: Data.getInstance().students) {
				System.out.println("Stduent Id: " + student.getUserId() + " ,Name: " + student.getFirstName() + " " + student.getLastName() );
			}
		}
	}


	public void viewTeachers() {
		if (Data.getInstance().teachers.isEmpty()) {
			System.out.println("No teachers available yet...");
		} else {
			for (int i = 0; i < Data.getInstance().teachers.size(); i++) {
				System.out.println((i + 1) + ". " + Data.getInstance().teachers.get(i).getUserId() + " " + Data.getInstance().teachers.get(i).getFirstName());
			}
		}
	}

	public void addCourse() {
		System.out.println("Enter course type \n 1) MAJOR \n 2) MINOR \n 3) FREE ");
		int courseTypeChoice = in.nextInt();

		CourseType courseType;
		if (courseTypeChoice == 1) {
			courseType = CourseType.MAJOR;
		} else if (courseTypeChoice == 2) {
			courseType = CourseType.MINOR;
		} else if (courseTypeChoice == 3) {
			courseType = CourseType.FREE;
		} else {
			System.out.println("Invalid choice. Please enter 1, 2, or 3.");
			return;
		}
		System.out.println("Please write the code: ");
		String code = in.next();

		System.out.println("Enter number of credits:");
		int numberOfCredits = in.nextInt();

		System.out.println("Enter course name:");
		in.nextLine();
		String courseName = in.nextLine();

		System.out.println("Enter course description:");
		String description = in.nextLine();

		System.out.println("Enter course max Students:");
		int maxCountOfStudents = Integer.parseInt(in.nextLine());

		System.out.println("Courses in our system: \n"); 
		viewCourses(); 
		System.out.println("Enter the number of prerequisites (0 if none): ");
		int prereqsCount = in.nextInt();
		ArrayList<Course> prerequisites = new ArrayList<>();
		if (prereqsCount > 0) {
			prerequisites = chooseAuthors(prereqsCount);
		}
		manager.addCourse(courseType, code, numberOfCredits, courseName, description, maxCountOfStudents, prerequisites);
		System.out.println("Course added successfully.");
	}

	public ArrayList<Course> chooseAuthors(int count) { 

		System.out.println("Enter the number of courses that you want to add as a prerequisite"); 

		ArrayList<Course> prereqs = new ArrayList<>(); 
		for(int i = 0; i < count; i++) { 
			int num = in.nextInt(); 
			prereqs.add(Data.getInstance().courses.get(num - 1)); 
		} 
		return prereqs; 
	}


	public void removeCourse() {
		System.out.println("Enter the course code: ");
		String code = in.next();
		manager.removeCourseByCode(code);
	}



	public void assignCourseToTeacher() {
		System.out.println("Select teacher: ");
		viewTeachers();
		System.out.println("Enter teacher number: ");
		int teacherChoice = in.nextInt();

		System.out.println("Select course: ");
		viewCourses();
		System.out.println("Enter course number: ");
		int courseChoice = in.nextInt();

		if (teacherChoice > 0 && teacherChoice <= Data.getInstance().teachers.size() &&
				courseChoice > 0 && courseChoice <= Data.getInstance().courses.size()) {

			Teacher selectedTeacher = Data.getInstance().teachers.get(teacherChoice - 1);
			Course selectedCourse = Data.getInstance().courses.get(courseChoice - 1);

			selectedTeacher.addCourse(selectedCourse);
			if (!selectedCourse.getInstructors().contains(selectedTeacher)) {
				selectedCourse.getInstructors().add(selectedTeacher);
			}
			System.out.println(selectedCourse.getCode() + " " + selectedCourse.getCourseName() + " has been assigned to " + selectedTeacher.getFirstName() + " " + selectedTeacher.getLastName());
		} else {
			System.out.println("Invalid selection. Please try again.");
		}
	}

	public void reportGeneration() {
		if (Data.getInstance().courses.isEmpty()) {
			System.out.println("No courses available for reporting.");
			return;
		}

		for (Course course : Data.getInstance().courses) {
			if (course == null || course.getParticipants().isEmpty()) {
				System.out.println("Course: " + (course != null ? course.getCourseName() : "Unknown") + 
						" has no participants.");
				continue;
			}

			double totalScore = 0;
			double highestScore = Double.MIN_VALUE;
			double lowestScore = Double.MAX_VALUE;
			int studentCount = course.getParticipants().size();

			for (Student student : course.getParticipants()) {
				Mark mark = student.getJournal().get(course);
				if (mark != null) {
					double totalMark = mark.getTotal();
					totalScore += totalMark;

					if (totalMark > highestScore) {
						highestScore = totalMark;
					}
					if (totalMark < lowestScore) {
						lowestScore = totalMark;
					}
				}
			}

			double averageScore = totalScore/studentCount;

			System.out.println("Course: " + course.getCourseName());
			System.out.printf("  Average Score: %.2f%n", averageScore);
			System.out.printf("  Highest Score: %.2f%n", highestScore);
			System.out.printf("  Lowest Score: %.2f%n", lowestScore);
			System.out.println("  Total number of Students: " + studentCount);
			System.out.println();
		}
	}




	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu: while (true) {
				System.out.println("What do you want to do?\n 1) Add course \n 2) Remove course \n 3)Update course \n 4)Assign course to Teacher \n 5) Assign Supervisor to Student  \n 6)View information about teachers \n 7) View information about students \n 8) Report Generation \n 9) View Courses \n 10) Exit");
				int choiceMenu = in.nextInt();
				in.nextLine();

				if (choiceMenu == 1) {
					chooseAddCourse: while (true) {
						addCourse();
						System.out.println("1) Return back \n 2) Continue adding ");
						int choiceAdd = in.nextInt();
						in.nextLine();

						if (choiceAdd == 1) {
							continue menu;
						} else if (choiceAdd == 2) {
							continue chooseAddCourse;
						} 
					}
				} else if (choiceMenu == 2) {
					chooseRemCourse: while (true) {
						removeCourse();
						System.out.println("1) Return back");
						int choiceRemove = in.nextInt();
						if (choiceRemove == 1) {
							break chooseRemCourse;
						}
					}
				} else if (choiceMenu == 3) {
					chooseUpdateCourse: while (true) {
						System.out.println("What course do you want to change?");
						viewCourses();
						System.out.println("Enter the number of the course to update: ");
						int courseIndex = in.nextInt() - 1;
						Course selectedCourse = Data.getInstance().courses.get(courseIndex);
						while (true) {
							System.out.println("What do you want to change?");
							System.out.println("1) Course code\n2) Course name\n3) Course description\n4) Course type\n5) Return back");
							int choice = in.nextInt();
							in.nextLine();

							if (choice == 1) {
								System.out.println("Enter new course code: ");
								String newCode = in.nextLine();
								selectedCourse.setCode(newCode);
							} else if (choice == 2) {
								System.out.println("Enter new course name: ");
								String newName = in.nextLine();
								selectedCourse.setCourseName(newName);
							} else if (choice == 3) {
								System.out.println("Enter new course description: ");
								String newDescription = in.nextLine();
								selectedCourse.setDescription(newDescription);
							} else if (choice == 4) {
								System.out.println("Enter course type:\n1) MAJOR\n2) MINOR\n3) FREE");
								int courseTypeChoice = in.nextInt();

								CourseType courseType;
								if (courseTypeChoice == 1) {
									courseType = CourseType.MAJOR;
								} else if (courseTypeChoice == 2) {
									courseType = CourseType.MINOR;
								} else if (courseTypeChoice == 3) {
									courseType = CourseType.FREE;
								} else {
									System.out.println("Invalid choice. Please enter 1, 2, or 3.");
									continue;
								}
								selectedCourse.setCourseType(courseType);
							} else if (choice == 5) {
								System.out.println("Exiting update menu.");
								continue menu;
							} else {
								System.out.println("Invalid choice. Please try again.");
							}

							manager.updateCourse(
									selectedCourse.getCode(),
									selectedCourse.getCourseName(),
									selectedCourse.getDescription(),
									selectedCourse.getCourseType()
									);
							System.out.println("Course updated successfully.");
						}
					}
				}else if (choiceMenu == 4) {
					chooseAssignCourse: while (true) {
						assignCourseToTeacher();
						System.out.println("1) Return back");
						int choiceUpdate = in.nextInt();
						if (choiceUpdate == 1) {
							break chooseAssignCourse;
						}
					}
				}
				else if (choiceMenu == 5) {

				}

				else if (choiceMenu == 6) {
					chooseViewInfoTeachers: while (true) {
						viewTeachers();
						System.out.println("1) Return back");
						int choiceViewTeachers = in.nextInt();
						if (choiceViewTeachers == 1) {
							break chooseViewInfoTeachers;
						}
					}
				}
				else if (choiceMenu == 7) {
					chooseViewInfoOfStudents: while (true) {
						viewStudents();
						System.out.println("1) Return back");
						int choiceViewStudents = in.nextInt();
						if (choiceViewStudents == 1) {
							break chooseViewInfoOfStudents;
						}
					}
				}
				else if (choiceMenu == 8) {
					chooseReport: while (true) {
						reportGeneration();
						System.out.println("1) Return back");
						int choiceViewStudents = in.nextInt();
						if (choiceViewStudents == 1) {
							break chooseReport;
						}
					}
				}
				else if (choiceMenu == 9) {
					viewCourse: while (true) {
						viewCourses();
						System.out.println("1) Return back");
						int choiceViewCourses = in.nextInt();
						if (choiceViewCourses == 1) {
							break viewCourse;
						}
					}
				} else if (choiceMenu == 10) {
					exit();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}
}
