/* Wallace, Joshua, Student ID #1428353
 * 3/29/14
 * Assignment: Polygons
 */
package polygons;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class DrawPolygons extends JFrame {
    
    public DrawPolygons() {
        /*Set the title of the window to "Polygons".*/
        setTitle("Polygons");
        /*Sets a grid layout where the number of collumns doesnt matter as long as there is only one row. 
        This also makes sure that the polygons will resize correctly.*/
        setLayout(new GridLayout(1,0));
        /*Add differntly sided polygons to the frame.*/
        add(new RegularPolygonPanel(5));
        add(new RegularPolygonPanel(6));
        add(new RegularPolygonPanel(7));
        add(new RegularPolygonPanel(8));
        add(new RegularPolygonPanel(9));
        add(new RegularPolygonPanel(10));
        
    }

    public static void main(String[] args) {
        /*Create a new frame and display it.*/
        DrawPolygons frame = new DrawPolygons();
        frame.setSize(500, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
    
}
