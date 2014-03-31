import java.util.*;

public class TestBingoCallNumber2{
	private int numberOfBingos = 75;
	public TestBingoCallNumber2(){
		ArrayList<Integer> numbers = populateNumberArray();
		callNumber2(numbers);
	}
	public static void main(String[] args){
		TestBingoCallNumber2 b = new TestBingoCallNumber2();
	}

	public void callNumber2(ArrayList<Integer> numberList){
		Random rand = new Random();

		for(int i = 0; i < 5; i++){
			if(numberList.size() > 0){
			int randomIndex = rand.nextInt(numberList.size());
			int numberToCall = numberList.remove(randomIndex); 
			//linear time
			//speakNumber(numberToCall);									//add in later
			//There need to be methods here to send this to the GUI, and any other processes that need it - faux methods not supplied
			//There also needs to be a checkForBingoCalls method which, if true, would then call isBingo() - the control here is a bit iffy
			if(checkForBingoCalls()){										//this is a faux method
				ArrayList<Integer> possibleBingo = getBingoArray();        	//this is a faux method
				boolean bingo = isBingo(numberList, possibleBingo);
				if(bingo){
					System.out.println(bingo);								//deal with this however - either with if/else or a new method
				}
				else
					System.out.println(bingo);
			}
			}
		}
	}
	//this is a faux method
	public ArrayList<Integer> getBingoArray(){							
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0; i < 5; i++){
			int randomInt = rand.nextInt(75) + 1;
			list.add(randomInt);
		}
		return list;
	}
	public ArrayList<Integer> populateNumberArray(){
		int size = 75;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < size; i++){
			list.add(i);													
		}	
		return list;
	}
	/*This doesn't have to be here in Bingo, but I put it here because of control issues and because this is where I'm working*/
	public boolean isBingo(ArrayList<Integer> numbersLeft, ArrayList<Integer> possibleBingo){
		for(int i = 0; i < possibleBingo.size(); i++){							//linear --> n=5, so basically constant
			for(int j = 0; j < numbersLeft.size(); j++){						//linear --> n <=71
				if(possibleBingo.get(i).equals(numbersLeft.get(j)))				//equals()?
					return false;
			}
		}
		numberOfBingos--;
		return true;
	}
	public boolean areBingosLeft(){
		if(numberOfBingos == 0){
			return false;
		}
		else if(numberOfBingos < 0){
			System.out.println("Error handling");
			return false;
		}
		return true;	
	}
	//this is a faux method
	public boolean checkForBingoCalls(){
		Random rand = new Random();
		boolean randomBool = rand.nextBoolean();
		return randomBool;
	}
}