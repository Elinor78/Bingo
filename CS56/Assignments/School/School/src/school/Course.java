/* Wallace, Joshua, Student ID #1428353
 * 3/13/14
 * Assignment: Project 1: Course/Student
 */
package school;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course implements Comparable {
    
    /*Instance variable for Course objects.*/
    private String courseName;
    private String courseInstructor;
    private Date courseBeginTime;
    private Date courseEndTime;
    private int courseCred;
    private int courseID;
    
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    
    public Course() {
    }
    
    public Course(String courseName) {
        this.courseName = courseName;
    }
    
    public Course(String courseName, String courseInstructor, int courseCred, Date courseBeginTime, Date courseEndTime, int courseID) {
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
        this.courseCred = courseCred;
        this.courseBeginTime = courseBeginTime;
        this.courseEndTime = courseEndTime;
        this.courseID = courseID;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
    
    public String getCourseInstructor() {
        return courseInstructor;
    }
    
    public void setCourseCred(int courseCred) {
        this.courseCred = courseCred;
    }
    
    public int getCourseCred() {
        return courseCred;
    }
    
    public void setCourseBeginTime(Date courseBeginTime) {
        this.courseBeginTime = courseBeginTime;
    }
    
    public Date getCourseBeginTime() {
        return courseBeginTime;
    }
    
    public void setCourseEndTime(Date courseEndTime) {
        this.courseEndTime = courseEndTime;
    }
    
    public Date getCourseEndTime() {
        return courseEndTime;
    }
    
    public void setCourseID(int ID) {
        this.courseID = ID;
    }
    
    public int getCourseID() {
        return courseID;
    }
    
    public void printCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Instructor: " + courseInstructor);
        System.out.println("Course Credit: " + courseCred);
        System.out.println("Course Begin Time: " + dateFormat.format(courseBeginTime));
        System.out.println("Course End Time: " + dateFormat.format(courseEndTime));
        System.out.println("Course ID: " + courseID);  
    }
    
    public int compareTo(Object c) {
        if (this.courseID == ((Course) c).courseID) {
            return 0;
        }
        else if (this.courseID > ((Course) c).courseID) {
            return 1;
        }
        else
            return -1;
    }
}
