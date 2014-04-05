package mylib.lib;
import java.awt.*;
import javax.swing.*;

public class MyIO {

public static int getInt(String s){

 return Integer.parseInt(JOptionPane.showInputDialog
(s));
}

///////////////////////////////
public static double getDouble(String s){

  String s1=JOptionPane.showInputDialog(s);
  return Double.parseDouble(s1);
}

public static void display(String s){
 JOptionPane.showMessageDialog(null,s);
}
}