//Frame that contains all UI elements

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.midi.*;
import java.util.*;
import java.io.*;

public class GuitarFrame extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

   private int previousY=0;

   //MidiChannel and Synthesizer must be class level variables so MouseListener functions can access them
             
   private MidiChannel mc;
   private Synthesizer synth;

   private JButton resetButton;
  
   
   //Setting up the 6 guitar strings, and the 6 note bars

   private GuitarString string1, string2, string3, string4, string5, string6;
   private NoteBar note1,note2,note3,note4,note5,note6;
   
   public GuitarFrame() throws IOException{

	super("Guitar String Test Frame");

  	Container c=getContentPane();
  	c.setLayout(new FlowLayout());

	resetButton = new JButton("Reset");
	resetButton.addActionListener(this);
	c.add(resetButton);

  	try{
		File inputFile = new File(JOptionPane.showInputDialog("Enter file name: "));
		FileReader in = new FileReader(inputFile);

	  	//creating the 6 note bars

		note1 = new NoteBar();
		note2 = new NoteBar();
		note3 = new NoteBar();
		note4 = new NoteBar();
		note5 = new NoteBar();
		note6 = new NoteBar();

		//fills each noteBar array based on formatted text data
		
		note1.fillArray(readLine(in));
		note2.fillArray(readLine(in));
		note3.fillArray(readLine(in));
		note4.fillArray(readLine(in));
		note5.fillArray(readLine(in));
		note6.fillArray(readLine(in));

		in.close();
	}catch (IOException e){}

	//Creating 6 guitar strings, arguments passed are: x-pos,y-pos,length,starting tone
  	
	string1 = new GuitarString(50,100,700,40); 
 	string2 = new GuitarString(50,125,700,45); 
  	string3 = new GuitarString(50,150,700,50); 
  	string4 = new GuitarString(50,175,700,55); 
  	string5 = new GuitarString(50,200,700,59);
	string6 = new GuitarString(50,225,700,64);
     
  	addMouseListener(this);
  	addMouseMotionListener(this);  

  	setSize(800,300);
	setResizable(false);
  	setVisible(true); 

	//Sets up MIDI system to be ready to play guitar sounds
	//value '27' passed to setInstrument cooresponds to java MIDI guitar instrument number

	try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            mc = synth.getChannels()[0];
            setInstrument(27);
        } catch (MidiUnavailableException e) {} 
   }
 
   //Only one actionPerformed object in program: the reset button
   //calls resetCurrent on each noteBar, setting it's current array index to 0

   public void actionPerformed(ActionEvent e){
	note1.resetCurrent();
	note2.resetCurrent();
	note3.resetCurrent();
	note4.resetCurrent();
	note5.resetCurrent();
	note6.resetCurrent();
   }

   public void mouseClicked( MouseEvent e){}

   //button3_mask checks for right mouse button
   //notes do not play when right mouse button is held down for greater control

   //PreviousY gets it's first value when the mouse is first pressed

   public void mousePressed( MouseEvent e){
	if((e.getModifiers() & InputEvent.BUTTON3_MASK) != InputEvent.BUTTON3_MASK) previousY=e.getY();
   }

   //if mouse is released, and a string is playing, stop it
   //simulates a guitar player putting their hands on the strings to stop them early

   public void mouseReleased( MouseEvent e){
  	if((e.getModifiers() & InputEvent.BUTTON3_MASK) != InputEvent.BUTTON3_MASK){

  	   if(string1.isPlaying()) string1.stopString(mc,string1.getTone());
  	   if(string2.isPlaying()) string2.stopString(mc,string2.getTone());
   	   if(string3.isPlaying()) string3.stopString(mc,string3.getTone());
   	   if(string4.isPlaying()) string4.stopString(mc,string4.getTone());
   	   if(string5.isPlaying()) string5.stopString(mc,string5.getTone());
	   if(string6.isPlaying()) string6.stopString(mc,string6.getTone());
   	}
	repaint();
   }

   public void mouseEntered( MouseEvent e){}
 
   public void mouseExited( MouseEvent e){}

   //First checks if right mouse button is held, if so it wont play a sound
   //Next it checks if you are strumming up or down, then applies proper inequalities
   // 	to see if you hit a string
   //If you did, triggers hitString() on specified string and passes relevant data
   //repaint() is called to allow red dot to appear on fret that is being played
   //Finally, previousY is set to current mouse position so it can be compared against next mouse position

   public void mouseDragged( MouseEvent e){
            if((e.getModifiers() & InputEvent.BUTTON3_MASK) != InputEvent.BUTTON3_MASK){

            if(e.getY()>previousY){
    		if(string1.getYPos()>previousY && string1.getYPos()<=e.getY()) 						string1.hitString(mc,note1.processNote(40),200);

    		if(string2.getYPos()>previousY && string2.getYPos()<=e.getY()) 									string2.hitString(mc,note2.processNote(45),200);

    		if(string3.getYPos()>previousY && string3.getYPos()<=e.getY()) 									string3.hitString(mc,note3.processNote(50),200);

    		if(string4.getYPos()>previousY && string4.getYPos()<=e.getY()) 									string4.hitString(mc,note4.processNote(55),200);

    		if(string5.getYPos()>previousY && string5.getYPos()<=e.getY()) 									string5.hitString(mc,note5.processNote(59),200);

		if(string6.getYPos()>previousY && string6.getYPos()<=e.getY()) 									string6.hitString(mc,note6.processNote(64),200);
  	    }
   
   	    if(e.getY()<previousY){    
		if(string6.getYPos()<previousY && string6.getYPos()>=e.getY()) 									string6.hitString(mc,note6.processNote(64),200);

    		if(string5.getYPos()<previousY && string5.getYPos()>=e.getY()) 									string5.hitString(mc,note5.processNote(59),200);

    		if(string4.getYPos()<previousY && string4.getYPos()>=e.getY()) 									string4.hitString(mc,note4.processNote(55),200);

    		if(string3.getYPos()<previousY && string3.getYPos()>=e.getY()) 									string3.hitString(mc,note3.processNote(50),200);

    		if(string2.getYPos()<previousY && string2.getYPos()>=e.getY()) 									string2.hitString(mc,note2.processNote(45),200);

    		if(string1.getYPos()<previousY && string1.getYPos()>=e.getY()) 										string1.hitString(mc,note1.processNote(40),200);
   	    }

	repaint();
 	}
   
  	previousY=e.getY();

   }
 
   public void mouseMoved( MouseEvent e){}


  
   public void paint(Graphics g){
  	super.paint(g);
  
	g.setColor(Color.BLACK);

  	//graphically draw 6 guitar string lines based on position information given to constructor

 	g.drawLine(string1.getXPos(),string1.getYPos(),
		(string1.getXPos()+string1.getLength()),string1.getYPos());

  	g.drawLine(string2.getXPos(),string2.getYPos(),
		(string2.getXPos()+string2.getLength()),string2.getYPos());

  	g.drawLine(string3.getXPos(),string3.getYPos(),
		(string3.getXPos()+string3.getLength()),string3.getYPos());

  	g.drawLine(string4.getXPos(),string4.getYPos(),
		(string4.getXPos()+string4.getLength()),string4.getYPos());

  	g.drawLine(string5.getXPos(),string5.getYPos(),
		(string5.getXPos()+string5.getLength()),string5.getYPos());

	g.drawLine(string6.getXPos(),string6.getYPos(),
		(string6.getXPos()+string6.getLength()),string6.getYPos());
	
	//Lazy loop to draw the 14 frets
	
	for(int i=0;i<14;i++){
		g.drawLine(750-(i*40),100,750-(i*40),225);
	}

	g.setColor(Color.RED);

	//If a current string is playing when repaint is called, 
	//grab the current fret and draw a red circle in proper position

	if(string1.isPlaying()) g.fillOval(740-(note1.getCurrentFret()*40),90,20,20);
	if(string2.isPlaying()) g.fillOval(740-(note2.getCurrentFret()*40),115,20,20);
	if(string3.isPlaying()) g.fillOval(740-(note3.getCurrentFret()*40),140,20,20);
	if(string4.isPlaying()) g.fillOval(740-(note4.getCurrentFret()*40),165,20,20);
	if(string5.isPlaying()) g.fillOval(740-(note5.getCurrentFret()*40),190,20,20);
	if(string6.isPlaying()) g.fillOval(740-(note6.getCurrentFret()*40),215,20,20);
   }

   // loads the instrument sound that you want to play

   public void setInstrument(int instrument){

      	synth.getChannels()[0].programChange(instrument);

   }
  
   //Empty main

   public static void main (String args[]) throws IOException{
  	GuitarFrame app = new GuitarFrame();
  	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   //Gathers a line's worth of data from the text file
   // and prepares it to be sent to NoteBar.fillArray

   public char[] readLine(FileReader in) throws IOException{
	int i=0;
	int x=0;
	char[] temp=new char[1000];
	while((temp[i]=(char)(in.read()))!='x') {
		i++;
	}	
	return temp;
   }
}