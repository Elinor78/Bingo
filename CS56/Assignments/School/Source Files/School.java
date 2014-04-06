/* Wallace, Joshua, Student ID #1428353
 * 3/13/14
 * Assignment: Project 1: Course/Student
 */
package school;

import java.util.*;

public class School {
    
    /*Create arraylists to hold all the students and courses available to every class.*/
    public static ArrayList<Course> allCourses = new ArrayList<>();
    public static ArrayList<Student> allStudents = new ArrayList<>();
    
    public static void main(String[] args) {
        /*Show the main window.*/
        SchoolGUI school = new SchoolGUI();
        school.setVisible(true);
    }
}
