package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

import Users.Course;
import Users.Data;
import Users.DataOperation;
import Users.Mark;
import Users.ResearchUtils;
import Users.Researcher;
import Users.Student;
import Users.Teacher;
import Users.UserOperation;

public class TeacherController {

	private Teacher teacher;

	public TeacherController(Teacher teacher) {
		this.teacher = teacher;
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
		if (teacher.getCourses().isEmpty()) {
			System.out.println("No courses yet...");
		}
		UserOperation.printList(Data.getInstance().courses);
	}

	public void viewStudents(Course c) {
		ArrayList<Student> participants = Data.getInstance().students.stream().filter(student -> student.getJournal().containsKey(c)).collect(Collectors.toCollection(ArrayList::new));

		UserOperation.printList(participants);
	}

	public void putMark(Student student, Course course) {
		System.out.println("Enter 1 for first attestation \nEnter 2 for second attestation \nEnter 3 for final scores");
		int attType = Integer.parseInt(DataOperation.readFromConsole());
		System.out.println("Enter Score:");
		double score = Double.parseDouble(DataOperation.readFromConsole());

		HashMap<Course, Mark> targetJournal = student.getJournal();
		Course c2 = new Course("CS101");

		Mark targetMark = targetJournal.get(course);

		if(attType == 1) {
			targetMark.setFirstAttestation(score);
		}
		if(attType == 2) {
			targetMark.setSecondAttestation(score);
		}
		if(attType == 3) {
			targetMark.setFinalExam(score);
		}
		System.out.println("Succesfully put mark");

	}

	public void run() throws IOException {
		try {
			System.out.println("Welcome, " + teacher.getFirstName() + "!");
			menu:
				while (true) {
					System.out.println("What do you want to do?\n 1) View courses \n 2) Put Mark \n 3) View my rating \n 4) Switch to researcher mode \n 5) Exit");
					int choiceMenu = in.nextInt();
					if (choiceMenu == 1) {
						viewCourse:
							while (true) {
								viewCourses();
								System.out.println("1) Return back \n");
								int choiceViewCourses = in.nextInt();
								if (choiceViewCourses == 1) {
									continue menu;
								}

							}
					} else if (choiceMenu == 2) {
						chooseCourse:
							while (true) {
								System.out.println("\n 1) Choose course \n 2) Return back");
								int choiceChooseCourse = in.nextInt();
								if (choiceChooseCourse == 1) {
									getCourse:
										while (true) {
											viewCourses();
											System.out.println("Select course number: ");
											int choiceCourse = in.nextInt();
											if (choiceCourse < 1 || choiceCourse > teacher.getCourses().size()) {
												System.out.println("Invalid course selection.");
												continue getCourse;
											}
											Course chosenCourse = teacher.getCourses().get(choiceCourse - 1);

											if (chosenCourse == null) {
												System.out.println("Course not found in Data. Returning...");
												continue;
											}

											getStudent:
												while (true) {
													System.out.println(" 1) Option choose Student \n 2) Return back ");

													int choiceGetStudent = in.nextInt();
													if (choiceGetStudent == 1) {

														chooseStudent:
															while (true) {
																viewStudents(chosenCourse);
																System.out.println(" Student number: ");
																int studentNumber = in.nextInt();
																ArrayList<Student> participants = Data.getInstance().students.stream().filter(student -> student.getJournal().containsKey(chosenCourse)).collect(Collectors.toCollection(ArrayList::new));
																Student chosenStudent = participants.get(studentNumber - 1);
																putMark(chosenStudent, chosenCourse);

																System.out.println(" 1) Choose another student \n 2) Return back ");
																int choiceAnotherStudent = in.nextInt();
																if (choiceAnotherStudent == 1) {
																	continue chooseStudent;
																} else if (choiceAnotherStudent == 2) {
																	continue chooseCourse;
																}

															}

													} else if (choiceGetStudent == 2) {
														continue chooseCourse;
													}

												}
										}
								} else if (choiceChooseCourse == 2) {
									continue menu;
								}
							}

					} else if (choiceMenu == 3) {
						displayRating:
							while (true) {
								displayTeacherRating();
								System.out.println("\n 1) Return back");
								int subChoice = in.nextInt();
								if (subChoice == 1) {
									continue menu;
								}
							}
					} else if (choiceMenu == 4) {
						launchResearcherMode:
							while (true) {
								Researcher researcher = teacher.getResearcher();
								ResearchUtils.launchResearcherMode(researcher);
								continue menu;
							}

					} else if (choiceMenu == 5) {
						exit();
						break menu;
					}
					break;
				}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}



	public void displayTeacherRating() {
		if (teacher.getRatings().isEmpty()) {
			System.out.println("No ratings yet for " + teacher.getFirstName() + " " + teacher.getLastName());
			return;
		} else {
			System.out.println("Ratings for " + teacher.getFirstName() + " " + teacher.getLastName() + ":");
		}
		double averageRating = teacher.getAverageRating();
		System.out.println("Average Rating: " + averageRating);
	}
}
