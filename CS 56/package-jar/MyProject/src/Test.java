import mylib.lib.MyRect;
import mylib.lib.MyIO;
import java.awt.*;
import javax.swing.*;
public class Test {

public static void main(String args[]){

int n1= MyIO.getInt("YOOO give integer");
int n2= MyIO.getInt("YOOO give another integer");
int sum= n1 + n2;
MyIO.display("Total is "+sum);MyRect r1= new MyRect(20,70);MyIO.display("it is working  "+r1.getInfo());
System.out.println("Total is "+sum);
//MyIO.displayJTextArea("Total is "+sum);
// displays "Total is "+sum in JTextArea with
//Font of size 24, fb color to be BLACK and bc to be
//White 
// MyIO.display("Total is "+sum, fc,bc);
System.exit(0);
}
}