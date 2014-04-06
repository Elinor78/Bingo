//NoteBar class: Provides methods for adjusting the tone of the instrument based on file data

import java.lang.*;

public class NoteBar{
	private int frets[] = new int[ 1000 ];
	private int current = 0;
	
	//Empty constructor
	
	public NoteBar() {}

	//Adjusts tone value based on current fret "held"
	//To be sent to GuitarString.hitString() method
	
	public int processNote( int tone ){
		tone+=frets[current];	
		current++;
		return tone;
	}

	//Takes a character array and inserts values into NoteBar's array
	//If statements weed out non-note characters ('-' for visual spacing in file, newlines and carriage returns)		
	
	public void fillArray(char[] c){
		int i=0;
		int x=0;
		while(c[i]!='x'){
			if((c[i]!='-')&&(c[i]!='\n')&&(c[i]!=13)) {
				frets[x]=c[i]-48;
				x++;
			}
			i++;
		}
	}
	
	//Resets current to 0, which is used as an array index for frets[]
	
	public void resetCurrent() {
		current = 0;
	}
	
	//Getter method to get int value of fret last played
	//1 is subtracted from current because processNote() increments current immediately after being played
	
	public int getCurrentFret() {
		return frets[current-1];
	}
}