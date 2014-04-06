/* Wallace, Joshua, Student ID #1428353
 * 3/13/14
 * Assignment: Project 1: Course/Student
 */
package school;

import java.util.ArrayList;

public class Student {
    
    /*Instance variables for all Student objects.*/
    private String studentFirstName;
    private String studentLastName;
    private int studentID;
    private double studentGPA;
    private ArrayList<Course> studentSchedule;
    
    public Student() {
    }
    
    /*Constructor with just first and last name.*/
    public Student(String studentFirstName, String studentLastName) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }
    
    /*Completely overloaded constructor.*/
    public Student(String studentFirstName, String studentLastName, int studentID, double studentGPA, ArrayList<Course> studentSchedule) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentID = studentID;
        this.studentGPA = studentGPA;
        this.studentSchedule = studentSchedule;
    }
    
    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }
    
    public String getStudentFirstName() {
        return studentFirstName;
    }
    
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
    
    public String getStudentLastName() {
        return studentLastName;
    }
    
    /*In order to make printing the full name easier.*/
    public void setStudentFullName(String studentFirstName, String studentLastName) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }
    
    public String getStudentFullName() {
        return studentFirstName + " " + studentLastName;
    }
    
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    
    public int getStudentID() {
        return studentID;
    }
    
    public void setStudentGPA(double studentGPA) {
        this.studentGPA = studentGPA;
    }
    
    public double getStudentGPA() {
        return studentGPA;
    }
    
    public void setStudentSchedule(ArrayList<Course> studentSchedule) {
        this.studentSchedule = studentSchedule;
    }
    
    public ArrayList<Course> getStudentSchedule() {
        return studentSchedule;
    }
    
    /*Command line print a student schedule.*/
    public void printStudentSchedule(ArrayList<Course> studentSchedule) {
        for (int i = 0; i < studentSchedule.size(); i++) {
            studentSchedule.get(i).printCourse();
        }
    }
    
    public void printStudent() {
        System.out.println("Student First Name: " + studentFirstName);
        System.out.println("Student Last Name: " + studentLastName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Student GPA: " + studentGPA);
        printStudentSchedule(studentSchedule);
 
    }
}
