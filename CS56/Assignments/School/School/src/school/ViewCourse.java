/* Wallace, Joshua, Student ID #1428353
 * 3/13/14
 * Assignment: Project 1: Course/Student
 */

package school;

import java.text.SimpleDateFormat;

public class ViewCourse extends javax.swing.JDialog {
    
    /*Get a holder for the selected course.*/
    private Course selectedCourse = new Course();
    /*SimpleDateFormat for printing the date variable to something more readable.*/
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
    
    public ViewCourse(java.awt.Frame parent, boolean modal, int listIndex) {
        super(parent, modal);
        /*Since the list index will always be the same as the order of the arraylist, simply use the passed value to load the correct course from the arraylist.*/
        selectedCourse = School.allCourses.get(listIndex);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCourseName = new javax.swing.JLabel();
        labelCourseID = new javax.swing.JLabel();
        labelCourseInstructor = new javax.swing.JLabel();
        labelCourseCredit = new javax.swing.JLabel();
        labelStartTime = new javax.swing.JLabel();
        labelEndTime = new javax.swing.JLabel();
        labelCourseNameVar = new javax.swing.JLabel();
        labelCourseIDVar = new javax.swing.JLabel();
        labelCourseInstructorVar = new javax.swing.JLabel();
        labelCourseCreditVar = new javax.swing.JLabel();
        labelCourseStartTimeVar = new javax.swing.JLabel();
        labelCourseEndTimeVar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Course Info");
        setResizable(false);

        labelCourseName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCourseName.setText("Name:");

        labelCourseID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCourseID.setText("Course ID:");

        labelCourseInstructor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCourseInstructor.setText("Instructor:");

        labelCourseCredit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCourseCredit.setText("Credit:");

        labelStartTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStartTime.setText("Start Time:");

        labelEndTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEndTime.setText("End Time:");

        labelCourseNameVar.setText(selectedCourse.getCourseName());

        labelCourseIDVar.setText(Integer.toString(selectedCourse.getCourseID()));

        labelCourseInstructorVar.setText(selectedCourse.getCourseInstructor());

        labelCourseCreditVar.setText(Integer.toString(selectedCourse.getCourseCred()));

        labelCourseStartTimeVar.setText(dateFormat.format(selectedCourse.getCourseBeginTime()));
        labelCourseStartTimeVar.setToolTipText("");

        labelCourseEndTimeVar.setText(dateFormat.format(selectedCourse.getCourseEndTime()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelStartTime)
                        .addGap(18, 18, 18)
                        .addComponent(labelCourseStartTimeVar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(labelCourseName)
                        .addGap(18, 18, 18)
                        .addComponent(labelCourseNameVar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCourseID)
                        .addGap(18, 18, 18)
                        .addComponent(labelCourseIDVar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCourseCredit)
                            .addComponent(labelCourseInstructor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCourseInstructorVar)
                            .addComponent(labelCourseCreditVar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelEndTime)
                        .addGap(18, 18, 18)
                        .addComponent(labelCourseEndTimeVar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCourseName)
                    .addComponent(labelCourseNameVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCourseID)
                    .addComponent(labelCourseIDVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCourseInstructor)
                    .addComponent(labelCourseInstructorVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCourseCredit)
                    .addComponent(labelCourseCreditVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStartTime)
                    .addComponent(labelCourseStartTimeVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEndTime)
                    .addComponent(labelCourseEndTimeVar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewCourse dialog = new ViewCourse(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JLabel labelCourseCredit;
    private javax.swing.JLabel labelCourseCreditVar;
    private javax.swing.JLabel labelCourseEndTimeVar;
    private javax.swing.JLabel labelCourseID;
    private javax.swing.JLabel labelCourseIDVar;
    private javax.swing.JLabel labelCourseInstructor;
    private javax.swing.JLabel labelCourseInstructorVar;
    private javax.swing.JLabel labelCourseName;
    private javax.swing.JLabel labelCourseNameVar;
    private javax.swing.JLabel labelCourseStartTimeVar;
    private javax.swing.JLabel labelEndTime;
    private javax.swing.JLabel labelStartTime;
    // End of variables declaration//GEN-END:variables
}
