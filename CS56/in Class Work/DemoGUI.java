import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DemoGUI extends JFrame implements 
MouseListener, Driver
{
  private int xPos,yPos;
  private JTextField tX,tY;
  private Container c;
  private Color cc;
  public DemoGUI()
  {
     setTitle("My Jupiter Planet");
	 c=getContentPane();
	 c.setBackground(Color.GREEN);
	 c.setLayout(new FlowLayout());
	 tX=new JTextField(6);
	 tY=new JTextField(6);
	 c.add(new JLabel("X:"));
	 c.add(tX);
	 c.add(new JLabel("Y:"));
	 c.add(tY);
	 this.addMouseListener(this);
	 }
	 public void mouseEntered(MouseEvent e)
	 {
	     cc=c.getBackground();
		 c.setBackground(Color.BLACK);
	 }
	 public void mouseExited(MouseEvent e)
	 {
	   c.setBackground(cc);
	 }
	 public void mouseClicked(MouseEvent e)
	 {
	      int x= e.getX();
		  int y=e.getY();
		  tX.setText(""+x);
		  tY.setText(""+y);
	 
	 }
	 public void mousePressed(MouseEvent e)
	 {
	 }
	 public void mouseReleased(MouseEvent e)
	 {
	 }
	 public void howToDrive()
	 {
	 System.out.println(" I am Driving Safe");
	 }
	 
	 
	 
	 
	 
	 public static void main(String [] args)
	 {
	     DemoGUI win= new DemoGUI();
		 win.xDemo(win);
		 win.setSize(400,400);
	     win.setVisible(true);
	     win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	 
	 }
	 public static void xDemo(Driver x)
	 {
	    x.howToDrive();
	   //System.out.println("=====>>>");
	 
	 }
	 
	 
	 
	 
	 
	 
	 
	 }
	 
	interface Driver
    {
       public void howToDrive();
    }	   
	 
	 
	 


