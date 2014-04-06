/* Wallace, Joshua, Student ID #1428353
 * 3/13/14
 * Assignment: Project 1: Course/Student
 */

package school;

import javax.swing.DefaultListModel;

public class SchoolGUI extends javax.swing.JFrame {

    public static DefaultListModel listModelCourses = new DefaultListModel();
    public static DefaultListModel listModelStudents = new DefaultListModel();
    public SchoolGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listAllCourses = new javax.swing.JList();
        labelAllCourses = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAllStudents = new javax.swing.JList();
        labelAllStudents = new javax.swing.JLabel();
        buttonAddStudent = new javax.swing.JButton();
        buttonAddCourse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        listAllCourses.setModel(listModelCourses);
        listAllCourses.setToolTipText("Double-click a course name to view course information.");
        listAllCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAllCoursesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listAllCourses);

        labelAllCourses.setText("All Courses");

        listAllStudents.setModel(listModelStudents);
        listAllStudents.setToolTipText("Double-click a student name to view student information.");
        listAllStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAllStudentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listAllStudents);

        labelAllStudents.setText("All Students");

        buttonAddStudent.setMnemonic('S');
        buttonAddStudent.setText("Add Student");
        buttonAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddStudentMouseClicked(evt);
            }
        });

        buttonAddCourse.setMnemonic('C');
        buttonAddCourse.setText("Add Course");
        buttonAddCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddCourseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(labelAllCourses)
                        .addGap(155, 155, 155)
                        .addComponent(labelAllStudents)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(buttonAddCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAddStudent)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAllCourses)
                    .addComponent(labelAllStudents))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddStudent)
                    .addComponent(buttonAddCourse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddCourseMouseClicked
        
        /*Show the add course window.*/
        AddCourse newCourse = new AddCourse(this, rootPaneCheckingEnabled);
        newCourse.setVisible(true);
    }//GEN-LAST:event_buttonAddCourseMouseClicked

    private void buttonAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddStudentMouseClicked
        
        /*Show the add student window.*/
        AddStudent newStudent = new AddStudent(this, rootPaneCheckingEnabled);
        newStudent.setVisible(true);
    }//GEN-LAST:event_buttonAddStudentMouseClicked

    private void listAllCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAllCoursesMouseClicked
        
        /*If there is a double click, get the list index underneath the double click, pass it to ViewCourse, and show it.*/
        if (evt.getClickCount() == 2) {
            int listIndex = listAllCourses.locationToIndex(evt.getPoint());
            ViewCourse viewCourse = new ViewCourse(this, rootPaneCheckingEnabled, listIndex);
            viewCourse.setVisible(true);
        }
    }//GEN-LAST:event_listAllCoursesMouseClicked

    private void listAllStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAllStudentsMouseClicked
        
        /*If there is a double click, get the list index underneath the double click, pass it to ViewStudent, and show it.*/
        if (evt.getClickCount() == 2) {
            int listIndex = listAllCourses.locationToIndex(evt.getPoint());
            ViewStudent viewStudent = new ViewStudent(this, rootPaneCheckingEnabled, listIndex);
            viewStudent.setVisible(true);
        }
    }//GEN-LAST:event_listAllStudentsMouseClicked

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
            java.util.logging.Logger.getLogger(SchoolGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchoolGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchoolGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchoolGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchoolGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddCourse;
    private javax.swing.JButton buttonAddStudent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAllCourses;
    private javax.swing.JLabel labelAllStudents;
    public static javax.swing.JList listAllCourses;
    public static javax.swing.JList listAllStudents;
    // End of variables declaration//GEN-END:variables
}
