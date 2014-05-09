
import java.awt.*;
import javax.swing.*;
import java.util.*;

public  class DemoThread 
{
    public static void main(String [] args)
	{
	  PrintA a= new PrintA();
	  a.start();
	  
	  Thread t= new Thread(new PrintF());
	  t.start();
	  
	 //System.exit(0);
	}
	
	}
	class  PrintA extends Thread
	{
	  public void run()
	  {
	    try
		{  
		   while(true)
		   {
		     System.out.print("A ");
			 Thread.sleep(100);
	       }
	  
	  
	  }
	    catch (Exception e)
		{
		}
	
	
	}
	
	}
 class PrintF implements Runnable
	{
	
	  public void run()
	  {
	    try
		{  
		   while(true)
		   {
		     System.out.print("F ");
			 Thread.sleep(1000);
	       }
	  
	  
	  }
	    catch (Exception e)
		{
		}
	
	
	
	
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	