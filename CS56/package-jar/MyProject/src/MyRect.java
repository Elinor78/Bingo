package mylib.lib;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class MyRect {


private int hieght=200, width=200;
private int xpos=20,ypos=20;
private Color c=Color.BLACK;

public MyRect (int w,int h){

 hieght=h; width=w;
}   

public void setColor( Color cc){
    c= cc;
}

public Color getColor(){
  return c;
}
public String getInfo(){ return "Rect widyh is===>"+width;}

public void setLocation ( int x, int y){

    xpos= x; ypos=y;
}

public void fill(Graphics g){
  g.setColor(c);
  g.fillRect(xpos,ypos, width,hieght);
}

public void draw(Graphics g) {
  g.setColor(c);
  g.drawRect(xpos,ypos, width,hieght);
}
}




    
      