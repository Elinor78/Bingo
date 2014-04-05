
import java.awt.*;
import javax.swing.*;

public class TasksTab extends JPanel  {

   // set up GUI
   public TasksTab()
   {
 //     super( "JTabbedPane Demo " );

      // create JTabbedPane 
      JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);

      // set up pane11 and add it to JTabbedPane 
      JLabel label1 = new JLabel( "Detail", SwingConstants.CENTER );
      JPanel panel1 = new JPanel();
      panel1.add( label1 ); 
      tabbedPane.addTab( "Details", null, panel1, "Details" ); 
      
      // set up panel2 and add it to JTabbedPane
      JLabel label2 = new JLabel( "Notes", SwingConstants.CENTER );
      JPanel panel2 = new JPanel();
      panel2.add( label2 );
      tabbedPane.addTab( "Notes", null, panel2, "Notes" ); 

      // set up panel3 and add it to JTabbedPane
      JLabel label3 = new JLabel( "Find" );
      JPanel panel3 = new JPanel();
      panel3.setLayout( new BorderLayout() ); 
      NewSearch2 ns = new NewSearch2();

      panel3.add( ns, BorderLayout.CENTER );
      tabbedPane.addTab( "Find", null, panel3, "Find" );

      // add JTabbedPane to container
//      getContentPane().add( tabbedPane );
      this.add(tabbedPane);

      setSize( 250, 500 );
      setVisible( true );

   } // end constructor

} // end class JTabbedPaneDemo


