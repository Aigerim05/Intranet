package Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

import Enums.Department;
import Enums.Language;

public class Student extends User {

    private int yearOfStudy;
    private HashMap<Course, Mark> journal;
    private int maxCredit;
    private int currCredit;
    private Department department;
    private HashMap<Course, Mark> takenCourses;

    {
        journal = new HashMap<Course, Mark>();
        takenCourses = new HashMap<Course, Mark>();
        currCredit = 0;
    }

    public Student() {

    }

    public Student(String firstName, String lastName, String userId, String password, Language language, int yearOfStudy, int maxCredit, Department department) {
        super(firstName, lastName, userId, password, language);
        this.yearOfStudy = yearOfStudy;
        this.maxCredit = maxCredit;
        this.department = department;

    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public HashMap<Course, Mark> getJournal() {
        return journal;
    }

    public HashMap<Course, Mark> getTakenCourses() {
        return takenCourses;
    }

    public void addToJournal(Course course, Mark mark) {
        this.journal.put(course, mark);
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(int maxCredit) {
        this.maxCredit = maxCredit;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getCurrCredit() {
        return currCredit;
    }

    public void setCurrCredit(int currCredit) {
        this.currCredit = currCredit;
    }

    @Override
    public String toString() {
        return super.toString() + "Student [yearOfStudy=" + yearOfStudy + ", maxCredit=" + maxCredit
                + ", department=" + department + "current credits= " + currCredit + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Student)) {
            return false;
        }
        Student otherStudent = (Student) other;
        return this.getUserId().equals(otherStudent.getUserId());
    }

    @Override
    public int hashCode() {
        return this.getUserId().hashCode();
    }

    public ArrayList<Course> getTakenCoursesArray() {
        return new ArrayList<Course>(takenCourses.keySet());
    }

    public void viewCourses() {
        if (journal == null || journal.isEmpty()) {
            System.out.println(getFirstName() + " " + getLastName() + " is not taking any courses.");
            return;
        }
        System.out.println(getFirstName() + " " + getLastName() + " is taking the following courses:");
        for (Course course : journal.keySet()) {
            System.out.println(course.getCourseName() + " (" + course.getCode() + ")");
        }
    }

    public void viewTranscript() {
        if (journal == null || journal.isEmpty()) {
            System.out.println(this.getFirstName() + " " + this.getLastName() + " does not have a transcript.");
            return;
        }

        System.out.println(this.getFirstName() + " " + this.getLastName() + " has marks for the following courses:");
        for (Entry<Course, Mark> entry : journal.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            char grade = (mark.getTotal() >= 90) ? 'A'
                    : (mark.getTotal() >= 80) ? 'B'
                    : (mark.getTotal() >= 70) ? 'C'
                    : (mark.getTotal() >= 60) ? 'D' : 'F';
            System.out.println(course.getCode() + " | " + course.getCourseName() + " : " + grade);
        }
    }

    public void rateTeacher(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Rate the Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " from 1 to 10: ");

            int rating = scanner.nextInt();

            teacher.addRating(rating);
            System.out.println("You rated the teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " with a " + rating + "/10");
        } catch (NullPointerException e) {
            System.out.println("Error: The teacher object or some of its properties are null.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public void registerToCourse(Course course, Manager manager) {
        if (course == null) {
            System.out.println("Invalid course selection.");
            return;
        }

        if (manager == null) {
            System.out.println("No manager available to approve the registration.");
            return;
        }

        manager.approveStudent(this, course);
        System.out.println("Course " + course.getCourseName() + " has been approved for registration.");
    }

    public void viewMarksForCourses() {
        if (journal == null || journal.isEmpty()) {
            System.out.println(this.getFirstName() + " " + this.getLastName() + " has no marks to display.");
            return;
        }

        System.out.println(this.getFirstName() + " " + this.getLastName() + " has marks for the following courses:");
        for (Entry<Course, Mark> entry : journal.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            char grade = (mark.getTotal() >= 90) ? 'A'
                    : (mark.getTotal() >= 80) ? 'B'
                    : (mark.getTotal() >= 70) ? 'C'
                    : (mark.getTotal() >= 60) ? 'D' : 'F';
            System.out.println(course.getCode() + " | " + course.getCourseName() + " : " + grade);
        }
    }

    public void viewInstructors() {
        if (journal == null || journal.isEmpty()) {
            System.out.println(this.getFirstName() + " " + this.getLastName() + " is not enrolled in any courses.");
            return;
        }

        System.out.println(this.getFirstName() + " " + this.getLastName() + " has the following instructors:");
        HashSet<Teacher> instructors = new HashSet<>();

        for (Course course : journal.keySet()) {
            instructors.addAll(course.getInstructors());
        }

        if (instructors.isEmpty()) {
            System.out.println("No instructors found.");
            return;
        }

        for (Teacher teacher : instructors) {
            System.out.println(teacher.getFirstName() + " " + teacher.getLastName());
        }
    }
}
