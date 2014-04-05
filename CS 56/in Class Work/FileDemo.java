import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.io.*;

public class FileDemo
{
  public static void main(String [] args) throws Exception
  {
    
File infile= new File("data.txt");
	 
     Scanner input= new Scanner(infile);
	 APerson ap[] = new APerson[2];
	 int i=0;
	 
	  while(input.hasNext())
	  {
	   String fn   = input.next();
	   String ln   = input.next();
	   int a= input.nextInt();
	   String s=input.next();
	   
	   ap[i++]=new APerson(fn+" "+ln,a,s);
	  
	  
	  
	  }





	File xfile= new File("data.ser");
  
    ObjectOutputStream in= new ObjectOutputStream(
	            new FileOutputStream(xfile));
	
    	for(  i= 0; i< ap.length ; i++)
	    {
		    in.writeObject(ap[i]);
        }
		
		
		
		
		
  
  input.close();in.close();
  
  File xxfile= new File("data.ser");
  
    ObjectInputStream xin= new ObjectInputStream(
	            new FileInputStream(xxfile));
   	APerson xp[]= new APerson[2];			
	for(i= 0 ; i < xp.length; i++)
       xp[i]= (APerson)   xin.readObject();	
	///////////////////////////////////////////////			
	for( APerson a : xp)
	  System.out.println(a.toString());			
  
  
  /*
     File infile= new File("data.txt");
	 
     Scanner input= new Scanner(infile);
	 APerson ap[] = new APerson[2];
	 int i=0;
	 
	  while(input.hasNext())
	  {
	   String fn   = input.next();
	   String ln   = input.next();
	   int a= input.nextInt();
	   String s=input.next();
	   
	   ap[i++]=new APerson(fn+" "+ln,a,s);
	  
	  
	  
	  }
	  for( APerson a : ap)
	  System.out.println(a.toString());
	  
	  
	  
	  
	  File outfile= new File("out.txt");
	  PrintWriter pr= new PrintWriter(outfile);
	  
	  for(  i= 0; i< ap.length ; i++)
	  {
	      pr.print(ap[i].getName()+" ");
		  pr.print(ap[i].getAge()+" ");
		  pr.println(ap[i].getSSN());
	}
	   pr.close(); input.close();
	  
	  
	 */ 
	  
	  
	}
}	
	  
	  
	  
	  
	  
	  
	  
	
	