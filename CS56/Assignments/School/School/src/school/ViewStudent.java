/* Wallace, Joshua, Student ID #1428353
 * 3/13/14
 * Assignment: Project 1: Course/Student
 */

package school;

import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;

public class ViewStudent extends javax.swing.JDialog {

    /*Get holder for selected Student object.*/
    private Student selectedStudent = new Student();
    /*To print the time more readably.*/
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm a");
    /*New listmodel for the JList to display the classes.*/
    private final DefaultListModel listModelselectedStudent = new DefaultListModel();
    
    public ViewStudent(java.awt.Frame parent, boolean modal, int listIndex) {
        super(parent, modal);
        selectedStudent = School.allStudents.get(listIndex);
        
        /*Add to the listmodel the elements from the students courses arraylist.*/
        for (int i = 0; i < selectedStudent.getStudentSchedule().size(); i++) {
            listModelselectedStudent.addElement(selectedStudent.getStudentSchedule().get(i).getCourseName() + ": " +
                    dateFormat.format(selectedStudent.getStudentSchedule().get(i).getCourseBeginTime()) + " - " +
                    dateFormat.format(selectedStudent.getStudentSchedule().get(i).getCourseEndTime()));
        }
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelStudentFirstName = new javax.swing.JLabel();
        labelStudentLastName = new javax.swing.JLabel();
        labelStudentID = new javax.swing.JLabel();
        labelStudentGPA = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        labelStudentFirstNameVar = new javax.swing.JLabel();
        labelStudentLastNameVar = new javax.swing.JLabel();
        labelStudentIDVar = new javax.swing.JLabel();
        labelStudentGPAVar = new javax.swing.JLabel();
        labelCourseList = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Info");
        setResizable(false);

        labelStudentFirstName.setText("First Name:");

        labelStudentLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStudentLastName.setText("Last Name:");

        labelStudentID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStudentID.setText("Student ID:");

        labelStudentGPA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStudentGPA.setText("GPA:");

        jList1.setModel(listModelselectedStudent);
        jList1.setToolTipText("Double-click a course name to view course information.");
        jScrollPane1.setViewportView(jList1);

        labelStudentFirstNameVar.setText(selectedStudent.getStudentFirstName());

        labelStudentLastNameVar.setText(selectedStudent.getStudentLastName());

        labelStudentIDVar.setText(Integer.toString(selectedStudent.getStudentID())
        );

        labelStudentGPAVar.setText(Double.toString(selectedStudent.getStudentGPA())
        );

        labelCourseList.setText("Course List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labelStudentID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelStudentGPA))
                                    .addComponent(labelStudentFirstName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelStudentLastNameVar)
                                    .addComponent(labelStudentIDVar)
                                    .addComponent(labelStudentGPAVar)
                                    .addComponent(labelStudentFirstNameVar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(labelCourseList)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStudentFirstName)
                    .addComponent(labelStudentFirstNameVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStudentLastName)
                    .addComponent(labelStudentLastNameVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStudentID)
                    .addComponent(labelStudentIDVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStudentGPA)
                    .addComponent(labelStudentGPAVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(labelCourseList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewStudent dialog = new ViewStudent(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCourseList;
    private javax.swing.JLabel labelStudentFirstName;
    private javax.swing.JLabel labelStudentFirstNameVar;
    private javax.swing.JLabel labelStudentGPA;
    private javax.swing.JLabel labelStudentGPAVar;
    private javax.swing.JLabel labelStudentID;
    private javax.swing.JLabel labelStudentIDVar;
    private javax.swing.JLabel labelStudentLastName;
    private javax.swing.JLabel labelStudentLastNameVar;
    // End of variables declaration//GEN-END:variables
}
