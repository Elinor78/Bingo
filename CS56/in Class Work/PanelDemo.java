import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public  class PanelDemo extends JFrame
{
   private JButton b1,b2,b3,b4,b5;
   private Container c;
   private JPanel p1;
   
   public class Handler implements ActionListener
   {
     public void actionPerformed(ActionEvent e)
	 {
	    System.out.println("You pressed b2");
	    p1.remove(b2);validate();	
	 
	 }
   
   
   }
   
   
   public PanelDemo()
   {  
      c=getContentPane();
      c.setLayout(new GridLayout(2,1));
	  //c.setLayout(new BorderLayout());
	  b1=new JButton("B1");
	  b2=new JButton("B2");
	  Handler h= new Handler();
	  b2.addActionListener(h);
	  b3=new JButton("B3");
	  b4=new JButton("B4");
	  b5=new JButton("B5");
	 /* c.add(new JButton("b1"));c.add(b2);c.add(b3);
	  c.add(b4);c.add(b5);*/
	  
	  
	  p1= new JPanel();
	  p1.setBackground(Color.GREEN);
	  p1.setLayout(new GridLayout(3,2));
	  p1.add(new JLabel("===>>"));
	  p1.add(b1);
	  p1.add(new JLabel("===>>"));
	  p1.add(b2);
	  p1.add(new JLabel("===>>"));
	  p1.add(b3);
	 
	  
	  JPanel p2= new JPanel();
	  p2.setBackground(Color.YELLOW);
	  p2.setLayout(new FlowLayout());
	  p2.add(new JLabel("Bad Teacher"));
	  p2.add(new JLabel("To day Only"));
	  
	  c.add(p1); c.add(p2);
	  
	  
	  
	/* 
	  c.add(b1,BorderLayout.NORTH);c.add(b2,BorderLayout.SOUTH);
	  c.add(b3,BorderLayout.EAST);
	  c.add(b4,BorderLayout.WEST);c.add(b5,BorderLayout.CENTER);
	  */
	  }
	   public static void main(String [] args)
	   {
	   
	      PanelDemo win= new PanelDemo();
		  win.setSize(400,500);
		  win.setVisible(true);
	  }
	  }
	  
	  
	  
	  
	  
	  
	  
   