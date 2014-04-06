/* Wallace, Joshua, Student ID #1428353
 * 3/29/14
 * Assignment: Polygons
 */

package polygons;

import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class RegularPolygonPanel extends JPanel {
    
    /*Variable to hold the number of sides for the polgyon to be displayed.*/
    int numberOfSides;
    /*Default constructor creates a triangle.*/
    public RegularPolygonPanel() {
        this.numberOfSides = 3;
    }
    /*Overloaded constructor that lets you set the number of sides when creating a new object.*/
    public RegularPolygonPanel(int sides) {
        this.numberOfSides = sides;
    }
    /*Paints the polygon on the panel.*/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawPolygon(createPolygon());
    }
    /*Creates the polygon.*/
    public final Polygon createPolygon() {
        
        /*Makes a new polygon object.*/
        Polygon polygon = new Polygon();
        /*Sets the center of the polgyon to the center of the panel.*/
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() /2;
        /*Sets the radius of the polygon.*/
        int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
        
        /*First Point which is at the polygon's center + its radius to the right.*/
        polygon.addPoint(xCenter + radius, yCenter);
        /*Second Point. This math basically takes points around a circle with a certain number of sides.*/
        polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 1))* 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 1))* 2 * Math.PI / numberOfSides)));
        /*Third Point.*/
        polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 2)) * 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 2)) * 2 * Math.PI / numberOfSides)));
        /*Fourth Point. The following points are only added if the sides are above a certain number.*/
        if (numberOfSides >3) {
            polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 3)) * 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 3)) * 2 * Math.PI / numberOfSides)));
        }
        /*Fifth Point.*/
        if (numberOfSides > 4) {
            polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 4)) * 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 4)) * 2 * Math.PI / numberOfSides)));
        }
        /*Sixth Point.*/
        if (numberOfSides > 5) {
            polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 5)) * 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 5)) * 2 * Math.PI / numberOfSides)));
        }
        /*Seventh Point.*/
        if (numberOfSides > 6) {
            polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 6)) * 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 6)) * 2 * Math.PI / numberOfSides)));
        }
        /*Eighth Point.*/
        if (numberOfSides > 7) {
            polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 7)) * 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 7)) * 2 * Math.PI / numberOfSides)));
        }
        /*Ninth Point.*/
        if (numberOfSides > 8) {
            polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 8)) * 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 8)) * 2 * Math.PI / numberOfSides)));
        }
        /*Tenth Point.*/
        if (numberOfSides > 9) {
            polygon.addPoint((int)(xCenter + radius * Math.cos((numberOfSides - (numberOfSides - 9)) * 2 * Math.PI / numberOfSides)), 
                (int)(yCenter + radius * Math.sin((numberOfSides - (numberOfSides - 9)) * 2 * Math.PI / numberOfSides)));
        }
        
        return polygon;
        
    }

}
