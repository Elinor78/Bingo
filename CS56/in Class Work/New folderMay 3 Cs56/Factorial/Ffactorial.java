// None comunicating Mutually-exclusive threads
// using Static Synchronized Method
// to update the value of result
// To solve Factorial problem concurrently
// the number is break down to series of subrange
// for each subrage an object is created. Those object
// are running concurrently. getsub Method will
// collect the subrage result and produces the final value of factorial
//
//


// Demo; compute factorial of a large number
import java.io.*;
import java.awt.*;
import javax.swing.*;


public class Ffactorial {
    static double result=1;static JTextArea jt=new JTextArea(16,25);
    public static void main (String s[])throws IOException {
        char c;
		JFrame win= new JFrame();
		win.add(jt);
		win.setSize(500,500);
		win.setVisible(true);
		
        long possFac = Long.parseLong (s[0]);
        int confact = (int) (possFac/10) + 1;

        for(int i=0; i< confact; i++){
            new FactRange(i*10, possFac).start();

        }
        try {
                    Thread.sleep (700);

                }catch (InterruptedException e) {
                    System.out.println("Intrrupted");
                                        }
SwingUtilities.invokeLater(new RunnableOutput(jt," the factorial of "+ possFac+"!= "+result));
        System.out.println (" the factorial of "+ possFac+"!= "+result);
        System.out.println("Enter q to quit");
                    do {
                        c = (char) System.in.read();
                        System.out.println(c);
                    } while(c != 'q');
    }

//***********************************************
static class FactRange extends Thread {

    static long possFac;double Fact=1;
    long from, to;

    static synchronized void getsub(double sub) {
        double sub1 = sub;
        Ffactorial.result= Ffactorial.result * sub1;
    }

    // constructor
    //  record the number we are to get factorial, and
    //  the sub range for factorils we are to try.

  public  FactRange(int argFrom, long argpossFac) {

        possFac = argpossFac;
        if(argFrom==0) from=1; else from=argFrom;
        if((argFrom+9)> possFac) to=possFac; else to = argFrom + 9;
    }

    public void run() {

        for(long i=from; i<= to && i<=possFac; i++) {
            Fact = Fact * i;}

          synchronized (jt)
		  {
		     SwingUtilities.invokeLater(new RunnableOutput(jt,"sub factorial of "+from+ " to "+to+" is "+Fact+" computed by thread "+getName()+"\n"));
		  }	 
            System.out.println (
                    "sub factorial of "+from+ " to "+to+" is "+Fact+" computed by thread "+getName());
                    getsub(Fact);
                    this.stop();

            yield();
        }
    }
	
static	class RunnableOutput implements Runnable
	{
	  private JTextArea jt;
	  private String message;
	  
	  public RunnableOutput(JTextArea j, String m)
	  {
	     jt=j;
		 message=m;
		 }
	  
	  
	  public void run()
	  {
	    jt.append(message);
		}
    }
	  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
