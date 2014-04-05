//GuitarString class
//Holds data about each guitar string (location in JFrame, tone data(initial and adjusted), if its currently playing)
//Contains methods relating to each string (hitString and stopString control the sound)



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.midi.*;
import java.util.*;

public class GuitarString extends Object {
 
   private int xPos=0,yPos=0,length=0;
   private boolean playing;
   private int currentTone;
   private int stringTone;

   //Empty constructor not used

   public GuitarString(){}

   //This constructor used in main program

   public GuitarString(int cXPos,int cYPos,int cLength,int tone){
  	xPos=cXPos; //x position of the start of the guitar string
  	yPos=cYPos; //y position of the start of the guitar string
  	length=cLength; //length of the guitar string
  	stringTone=tone; //initial (without any frets held) tone of this string
   }

   //getter methods, used for drawing and mouse/string hit detection

   public int getXPos(){
  	return xPos;
   } 

   public int getYPos(){
 	 return yPos;
   }

   public int getLength(){
 	 return length;
   }

   //returns true if the string is currently playing

   public boolean isPlaying(){
 	 return playing;
   }

   //returns value of the currently played tone on this string

   public int getTone(){
	return currentTone;
   }

   //MidiChannel needs to be passed when turning on/off a sound
   //Tone must be passed when turning on/off a sound
   //Velocity must be passed when turning on a sound

   //Checks to see if current string is already playing, if so turns it off
   //Changes the currentTone to value passed
   //sets boolean playing to TRUE
   //sends message to passed channel to start playing passed tone

   public void hitString(MidiChannel channel,int tone,int volume){
  	if(playing) stopString(channel,currentTone);
  	currentTone=tone;
  	playing=true;
  	channel.noteOn(tone,volume);
   }

   //Sets boolean playing to FALSE
   //Sends message to passed channel to stop playing passed tone

   public void stopString(MidiChannel channel, int tone){
  	playing=false;
  	channel.noteOff(tone);
   }
}