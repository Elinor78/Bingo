import java.awt.*;
import javax.swing.*;
import java.util.*;

public  class  Banner extends JFrame
{
   private Container c;
   private JLabel jLab;
   
   public Banner()
   {
     c=getContentPane();
	 c.setLayout(new FlowLayout());
	 jLab=new JLabel();
	 Font f= new Font("Times new Roman",Font.BOLD+Font.ITALIC,36);
	 jLab.setFont(f);jLab.setForeground(Color.BLUE);
	 c.setBackground(Color.YELLOW);
	 jLab.setText("As a Robot I Love you Guys Unconditionally");
	 Thread t= new Thread(new DoBanner());
	 t.start();
	 c.add(jLab);
	 }
	 private class DoBanner implements Runnable
	 {
	 
	   public void run()
	   {
	      try
		  {
		     while(true)
			 {
			 //System.out.print("$");
		   String st=jLab.getText();
			   char ch=st.charAt(0);
			String   stt=st.substring(1);
			   stt= stt + ch;
			   jLab.setText(stt);
			   Thread.sleep(200);
			   
			 
			 
			 }
		  
		  
		  
		  }
		  catch (InterruptedException ex)
		  {
		  }
	   
	   
	   
	   }
	 
	 
	 
	 
	 }
	   public static void main(String args[] )
	   {
	      Banner win= new Banner();
		  win.setSize(600,400);
		  win.setVisible(true);
		  win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 }
		 }
		  
		  
		  
		  
		  
		  
		  
	   
	  
	   
	 
	 
	 
	 
	 
	 