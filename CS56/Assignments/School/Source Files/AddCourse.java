/* Wallace, Joshua, Student ID #1428353
 * 3/13/14
 * Assignment: Project 1: Course/Student
 */

package school;

import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class AddCourse extends javax.swing.JDialog {

    
    public AddCourse(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCourseName = new javax.swing.JLabel();
        labelCourseID = new javax.swing.JLabel();
        labelCourseInstructor = new javax.swing.JLabel();
        labelCourseCredit = new javax.swing.JLabel();
        labelCourseStartTime = new javax.swing.JLabel();
        labelCourseEndTime1 = new javax.swing.JLabel();
        textCourseName = new javax.swing.JTextField();
        textCourseID = new javax.swing.JTextField();
        textCourseInstructor = new javax.swing.JTextField();
        textCourseCredit = new javax.swing.JTextField();
        spinnerStartTime = new javax.swing.JSpinner();
        spinnerEndTime = new javax.swing.JSpinner();
        buttonAddCourse = new javax.swing.JButton();
        buttonCancelAddCourse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Course");
        setResizable(false);

        labelCourseName.setText("Name:");

        labelCourseID.setText("Course ID:");
        labelCourseID.setToolTipText("");

        labelCourseInstructor.setText("Instructor:");
        labelCourseInstructor.setToolTipText("");

        labelCourseCredit.setText("Credit:");
        labelCourseCredit.setToolTipText("");

        labelCourseStartTime.setText("Start Time:");
        labelCourseStartTime.setToolTipText("");

        labelCourseEndTime1.setText("End Time:");
        labelCourseEndTime1.setToolTipText("");

        spinnerStartTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        spinnerStartTime.setEditor(new JSpinner.DateEditor(spinnerStartTime, "h:mm a"));
        spinnerStartTime.setToolTipText("");
        spinnerStartTime.setValue(new Date(2014, 1, 1, 7, 0)
        );

        spinnerEndTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        spinnerEndTime.setEditor(new JSpinner.DateEditor(spinnerEndTime, "h:mm a"));
        spinnerEndTime.setValue(new Date(2014, 1, 1, 8, 0));

        buttonAddCourse.setMnemonic('A');
        buttonAddCourse.setText("Add Course");
        buttonAddCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddCourseMouseClicked(evt);
            }
        });

        buttonCancelAddCourse.setMnemonic('C');
        buttonCancelAddCourse.setText("Cancel");
        buttonCancelAddCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelAddCourseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCancelAddCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddCourse))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCourseCredit)
                                .addGap(18, 18, 18)
                                .addComponent(textCourseCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCourseInstructor)
                                .addGap(18, 18, 18)
                                .addComponent(textCourseInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCourseName)
                                .addGap(18, 18, 18)
                                .addComponent(textCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCourseID)
                                .addGap(18, 18, 18)
                                .addComponent(textCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCourseStartTime, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelCourseEndTime1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spinnerEndTime, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(spinnerStartTime))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCourseName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCourseID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCourseInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCourseInstructor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCourseCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCourseCredit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCourseStartTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCourseEndTime1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddCourse)
                    .addComponent(buttonCancelAddCourse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelAddCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelAddCourseMouseClicked
        /*Closes the window.*/
        this.dispose();
    }//GEN-LAST:event_buttonCancelAddCourseMouseClicked

    private void buttonAddCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddCourseMouseClicked
        /*Try catch to avoid program crash if user inputs incorrect data types.*/
        try {
            String tempCourseName = textCourseName.getText();
            String tempCourseInstructor = textCourseInstructor.getText();
            int tempCourseCredit = Integer.parseInt(textCourseCredit.getText());
            Date tempCourseStartTime = (Date)spinnerStartTime.getValue();
            Date tempCourseEndTime = (Date)spinnerEndTime.getValue();
            int tempCourseID = Integer.parseInt(textCourseID.getText());
            
            /*If no error, a new course is made with the overloaded constructor and values from inputs.*/
            Course newCourse = new Course(tempCourseName, tempCourseInstructor, 
                tempCourseCredit, tempCourseStartTime, tempCourseEndTime, tempCourseID);
            
            /*Adds this new course to the allCourses arraylist for safekeeping.*/
            School.allCourses.add(newCourse);
            
            /*Sorts the arraylist based on Course's compareTo method.*/
            Collections.sort(School.allCourses);
            
            /*Erases the listmodel which displays the courses in the main window.*/
            SchoolGUI.listModelCourses.clear();
            
            /*Readds the courses to the listmodel for the main window in the newly sorted order.*/
            for (int i = 0; i < School.allCourses.size(); i++) {
                SchoolGUI.listModelCourses.addElement(School.allCourses.get(i).getCourseName() + ",  ID: " + Integer.toString(School.allCourses.get(i).getCourseID()));
            }
            
            /*Closes the window.*/
            this.dispose();
            
        } catch (Exception e) {
            /*Lets the user know they did something wrong and resets the fields.*/
            JOptionPane.showMessageDialog(null, "Please only enter letters for Name/Instructor and whole numbers for credit and ID.", "Input Error", JOptionPane.OK_OPTION);
            textCourseName.setText(null);
            textCourseInstructor.setText(null);
            textCourseCredit.setText(null);
            textCourseID.setText(null);
        }
    }//GEN-LAST:event_buttonAddCourseMouseClicked

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
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddCourse dialog = new AddCourse(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonAddCourse;
    private javax.swing.JButton buttonCancelAddCourse;
    private javax.swing.JLabel labelCourseCredit;
    private javax.swing.JLabel labelCourseEndTime1;
    private javax.swing.JLabel labelCourseID;
    private javax.swing.JLabel labelCourseInstructor;
    private javax.swing.JLabel labelCourseName;
    private javax.swing.JLabel labelCourseStartTime;
    private javax.swing.JSpinner spinnerEndTime;
    private javax.swing.JSpinner spinnerStartTime;
    private javax.swing.JTextField textCourseCredit;
    private javax.swing.JTextField textCourseID;
    private javax.swing.JTextField textCourseInstructor;
    private javax.swing.JTextField textCourseName;
    // End of variables declaration//GEN-END:variables
}
