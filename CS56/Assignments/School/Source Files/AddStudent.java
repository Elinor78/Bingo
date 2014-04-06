/* Wallace, Joshua, Student ID #1428353
 * 3/13/14
 * Assignment: Project 1: Course/Student
 */

package school;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AddStudent extends javax.swing.JDialog {
    
    /*Creates a new listmodel for the student's selected courses.*/
    private final DefaultListModel listModelStudentsCourses = new DefaultListModel();
    
    /*Creates a new listmodel for the available courses which is separate from the main GUI's listmodel.*/
    private DefaultListModel listModelAvailableCourses = new DefaultListModel();
    
    /*An arraylist to temporarily hold the student's chosen courses.*/
    private ArrayList<Course> tempStudentCourses = new ArrayList<>();
    
    public AddStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        /*Copies elements from the main GUI's listmodel into the private one.*/
        for (int i = 0; i < SchoolGUI.listModelCourses.getSize(); i++) {
            listModelAvailableCourses.addElement(SchoolGUI.listModelCourses.getElementAt(i));
        }
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelStudentLastName = new javax.swing.JLabel();
        labelStudentFirstName = new javax.swing.JLabel();
        labelStudentID = new javax.swing.JLabel();
        labelStudentGPA = new javax.swing.JLabel();
        textStudentFirstName = new javax.swing.JTextField();
        textStudentLastName = new javax.swing.JTextField();
        textStudentID = new javax.swing.JTextField();
        textStudentGPA = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailableCourses = new javax.swing.JList();
        labelAvailableCourses = new javax.swing.JLabel();
        labelAvailableCourses1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listStudentsCourses = new javax.swing.JList();
        labelStudentInformation = new javax.swing.JLabel();
        buttonSelectCourse = new javax.swing.JButton();
        buttonRemoveCourse = new javax.swing.JButton();
        buttonCancelAddStudent = new javax.swing.JButton();
        buttonAddStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelStudentLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStudentLastName.setText("Last Name:");

        labelStudentFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStudentFirstName.setText("First Name:");

        labelStudentID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStudentID.setText("Student ID:");

        labelStudentGPA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStudentGPA.setText("GPA:");

        listAvailableCourses.setModel(listModelAvailableCourses);
        listAvailableCourses.setToolTipText("Double-click a course name to view course information.");
        jScrollPane1.setViewportView(listAvailableCourses);

        labelAvailableCourses.setText("Available Courses");

        labelAvailableCourses1.setText("Student's Courses");

        listStudentsCourses.setModel(listModelStudentsCourses);
        listStudentsCourses.setToolTipText("Double-click a course name to view course information.");
        jScrollPane2.setViewportView(listStudentsCourses);

        labelStudentInformation.setText("Student Information");

        buttonSelectCourse.setText("—>");
        buttonSelectCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSelectCourseMouseClicked(evt);
            }
        });

        buttonRemoveCourse.setText("<—");
        buttonRemoveCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRemoveCourseMouseClicked(evt);
            }
        });

        buttonCancelAddStudent.setMnemonic('C');
        buttonCancelAddStudent.setText("Cancel");
        buttonCancelAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelAddStudentMouseClicked(evt);
            }
        });

        buttonAddStudent.setMnemonic('A');
        buttonAddStudent.setText("Add Student");
        buttonAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddStudentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(labelStudentInformation)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelStudentLastName)
                                .addGap(18, 18, 18)
                                .addComponent(textStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelStudentFirstName)
                                .addGap(18, 18, 18)
                                .addComponent(textStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelStudentGPA)
                                    .addComponent(labelStudentID))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textStudentGPA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textStudentID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(labelAvailableCourses))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonSelectCourse)
                            .addComponent(buttonRemoveCourse))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelAvailableCourses1)
                                .addGap(117, 117, 117))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonCancelAddStudent)
                                .addGap(128, 128, 128))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(766, Short.MAX_VALUE)
                    .addComponent(buttonAddStudent)
                    .addGap(4, 4, 4)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAvailableCourses)
                    .addComponent(labelAvailableCourses1)
                    .addComponent(labelStudentInformation))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStudentFirstName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStudentLastName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStudentID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textStudentGPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStudentGPA)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(buttonSelectCourse)
                        .addGap(26, 26, 26)
                        .addComponent(buttonRemoveCourse)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCancelAddStudent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(170, Short.MAX_VALUE)
                    .addComponent(buttonAddStudent)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelAddStudentMouseClicked
        /*Closes the window.*/
        this.dispose();
    }//GEN-LAST:event_buttonCancelAddStudentMouseClicked

    private void buttonAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddStudentMouseClicked
        /*Try catch makes sure the student didn't enter incorrect data types.*/
        try {
            /*Gets the inforamtion from the GUI fields.*/
            String tempStudentFirstName = textStudentFirstName.getText();
            String tempStudentLastName = textStudentLastName.getText();
            int tempStudentID = Integer.parseInt(textStudentID.getText());
            double tempStudentGPA = Double.parseDouble(textStudentGPA.getText());
            
            /*Creates a new student object with overloaded constructor.*/
            Student newStudent = new Student(tempStudentFirstName, tempStudentLastName, tempStudentID, tempStudentGPA, tempStudentCourses);
            
            /*Adds newly created student to main students arraylist.*/
            School.allStudents.add(newStudent);
            
            /*Adds the new student to the JList on the main GUI.*/
            SchoolGUI.listModelStudents.addElement(School.allStudents.get(School.allStudents.size()-1).getStudentFullName());
            
            /*Closes the window.*/
            this.dispose();
        } catch (Exception e) {
            /*Lets the user know there was an invalid data type and clears text fields.*/
            JOptionPane.showMessageDialog(null, "Please only enter letters for Name, whole numbers for ID, and double for GPA", "Input Error", JOptionPane.OK_OPTION);
            textStudentFirstName.setText(null);
            textStudentLastName.setText(null);
            textStudentGPA.setText(null);
            textStudentID.setText(null);
        }
        
        
        
    }//GEN-LAST:event_buttonAddStudentMouseClicked

    private void buttonSelectCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSelectCourseMouseClicked
        
        int indexOfSelectedCourse = 0;
        /*I started to create the code for validating if a course overlaps but ran out of time/ran into issues. I plan on working on it though after I turn it in because I'm determined!*/
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        Date SelectedCourseBeginTime = new Date();
        Date SelectedCourseEndTime = new Date();
        
        /*Retrieve the value from the listmodel.*/
        String tempCourseSelection = (String)listAvailableCourses.getSelectedValue();
        
        /*Get only the value of the last part of the string which has the Course ID.*/
        int tempCourseID = Integer.parseInt(tempCourseSelection.substring(tempCourseSelection.lastIndexOf(" ") + 1).toString());
        
        /*Search through allCourses array for a matching course with that ID.*/
        for (int i = 0; i < School.allCourses.size(); i++) {
            if (School.allCourses.get(i).getCourseID() == tempCourseID) {
                /*Add matching course to student's temporary courses array.*/
                indexOfSelectedCourse = i;
            }
        }
        
        /*Add matching course to student's temporary courses array.*/
        tempStudentCourses.add(School.allCourses.get(indexOfSelectedCourse));
        
        /*Update students courses listmodel with the one from the available courses and remove it from available courses.*/
        listModelStudentsCourses.addElement(tempCourseSelection);
        listModelAvailableCourses.removeElement(tempCourseSelection); 
        
    }//GEN-LAST:event_buttonSelectCourseMouseClicked

    private void buttonRemoveCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRemoveCourseMouseClicked
        /*This retrieves the value, matches it to an actual course, removes it from the course, and updates this JLists.*/
        
        String tempCourseName = (String)listStudentsCourses.getSelectedValue();
        
        for (int i = 0; i < School.allCourses.size(); i++) {
            if (tempStudentCourses.get(i).getCourseName() == tempCourseName) {
                tempStudentCourses.remove(i);
            }
        }
        listModelStudentsCourses.removeElement(tempCourseName);
        listModelAvailableCourses.addElement(tempCourseName);

    }//GEN-LAST:event_buttonRemoveCourseMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddStudent dialog = new AddStudent(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddStudent;
    private javax.swing.JButton buttonCancelAddStudent;
    private javax.swing.JButton buttonRemoveCourse;
    private javax.swing.JButton buttonSelectCourse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAvailableCourses;
    private javax.swing.JLabel labelAvailableCourses1;
    private javax.swing.JLabel labelStudentFirstName;
    private javax.swing.JLabel labelStudentGPA;
    private javax.swing.JLabel labelStudentID;
    private javax.swing.JLabel labelStudentInformation;
    private javax.swing.JLabel labelStudentLastName;
    private javax.swing.JList listAvailableCourses;
    private javax.swing.JList listStudentsCourses;
    private javax.swing.JTextField textStudentFirstName;
    private javax.swing.JTextField textStudentGPA;
    private javax.swing.JTextField textStudentID;
    private javax.swing.JTextField textStudentLastName;
    // End of variables declaration//GEN-END:variables
}
