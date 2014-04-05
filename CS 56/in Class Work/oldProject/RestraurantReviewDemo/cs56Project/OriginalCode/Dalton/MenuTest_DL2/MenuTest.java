// Fig. 14.9: MenuTest.java
// Demonstrating menus
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuTest extends JFrame {

   // set up GUI
   public MenuTest()
   {
      super( "Using JMenus" );     

      // set up File menu and its menu items
      JMenu fileMenu = new JMenu( "File" );
      fileMenu.setMnemonic( 'F' );

      // set up About... menu item
      JMenuItem addReviewItem = new JMenuItem( "Add a review" );
      addReviewItem.setMnemonic( 'A' );
      fileMenu.add( addReviewItem );
      addReviewItem.addActionListener(

         new ActionListener() {  // anonymous inner class

            // display message dialog when user selects About...
            public void actionPerformed( ActionEvent event )
            {
               JOptionPane.showMessageDialog( MenuTest.this,
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener
 
//    set up search... menu item
      JMenuItem searchRestaurantItem = new JMenuItem( "Search for a restaurant" );
      searchRestaurantItem.setMnemonic( 'S' );
      searchRestaurantItem.setEnabled(false);
      fileMenu.add( searchRestaurantItem );
      searchRestaurantItem.addActionListener(

         new ActionListener() {  // anonymous inner class

            // display message dialog when user selects About...
            public void actionPerformed( ActionEvent event )
            {
               JOptionPane.showMessageDialog( MenuTest.this,
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener
 
      // set up Exit menu item
      JMenuItem exitItem = new JMenuItem( "Exit" );
      exitItem.setMnemonic( 'x' );
      fileMenu.add( exitItem );
      exitItem.addActionListener(

         new ActionListener() {  // anonymous inner class

            // terminate application when user clicks exitItem
            public void actionPerformed( ActionEvent event )
            {
               System.exit( 0 );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      // create menu bar and attach it to MenuTest window
      JMenuBar bar = new JMenuBar();  
      setJMenuBar( bar );  
      bar.add( fileMenu );    


      
      JMenu aboutMenu = new JMenu("About...");
      aboutMenu.setMnemonic('A');
      JMenuItem programItem = new JMenuItem("Restaurant Review");
      aboutMenu.add(programItem);
      programItem.addActionListener(
      		new ActionListener() {  // anonymous inner class

                // display message dialog when user selects About...
                public void actionPerformed( ActionEvent event )
                {
                   JOptionPane.showMessageDialog( MenuTest.this,
                      "This is a Restaurant Review Program",
                      "About", JOptionPane.PLAIN_MESSAGE );
                }
             } // end anonymous inner class
      	);


      // add Format menu to menu bar
 
      bar.add( aboutMenu);
     
      // set up label to display text

      NewSearch2 ns = new NewSearch2();    
      TasksTab tt = new TasksTab();
      NewReview nr = new NewReview();
      
//      nr.setVisible(false);
//      ns.setVisible(true);

      tt.setVisible(true);
      getContentPane().add( ns, BorderLayout.CENTER );
      getContentPane().add( tt, BorderLayout.WEST );
//      getContentPane().add( nr, BorderLayout.CENTER );

      
     setSize( 800, 500 );
      setVisible( true );

   } // end constructor

   public static void main( String args[] )
   {
      MenuTest application = new MenuTest();
      
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   // inner class to handle action events from menu items
   private class ItemHandler implements ActionListener {

      // process color and font selections
      public void actionPerformed( ActionEvent event )
      {
         // process color selection

         repaint();  

      } // end method actionPerformed

   } // end class ItemHandler

   // inner class to handle item events from check box menu items
   private class StyleHandler implements ItemListener {

      // process font style selections
      public void itemStateChanged( ItemEvent e )
      {


         repaint();
      }

   } // end class StyleHandler

} // end class MenuTest


/**************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and               *
 * Prentice Hall. All Rights Reserved.                                    *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

