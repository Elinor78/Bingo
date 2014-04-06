//package BoundedShapeDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel
{
    private MyShape shapes[];
    private MyShape currentShapes[];

    private int shapeCount;
    private int currentShapeCount;
    private int shapeType;
    private int counter;
    private MyShape currentShape;
    private Color currentColor;
    private boolean filledShape;
    private JLabel statusLabel = new JLabel();

    public DrawPanel(JLabel frameLabel)
    {
        statusLabel = frameLabel;
        shapes = new MyShape[300];
        currentShapes = new MyShape[10000];
        shapeCount = 0;
        currentShapeCount = 0;
        shapeType = 0;
        currentShape = null;
        currentColor = Color.BLACK;
        setBackground( Color.WHITE );
        addMouseListener(new MouseState());
        addMouseMotionListener(new MouseState());
    }

    public class MouseState extends MouseAdapter implements MouseMotionListener
    {
        public void mousePressed(MouseEvent e)
        {
            if (shapeType == 0)
                currentShape = new MyLine( e.getX() , e.getX(), e.getY(), e.getY(), currentColor );
            else if (shapeType == 1)
                currentShape = new MyOval( e.getX() , e.getX(), e.getY(), e.getY(), currentColor, filledShape);
            else
                currentShape = new MyRectangle( e.getX() , e.getX(), e.getY(), e.getY(), currentColor, filledShape);
        }

        public void mouseReleased (MouseEvent e)
        {

            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            shapes[shapeCount] = currentShape;
            shapeCount++;
            counter = 0;
            currentShapeCount = 0;
            currentShape = null;
            repaint();
        }
       
        public void mouseMoved(MouseEvent e)
        {
            String s = " ( X: " +  e.getX() + " , Y: " + e.getY() + " )";
            statusLabel.setText(s);
        }
        
        public void mouseDragged(MouseEvent e)
        {
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            currentShapes[currentShapeCount] = currentShape;
            currentShapeCount++;
            String s = " ( X: " +  e.getX() + " , Y: " + e.getY() + " )";
            statusLabel.setText(s);
            repaint();
        }
    }

    public void setShapeType(int type)
    {
        shapeType = type;
    }
    
    public void setCurrentColor(Color color)
    {
        currentColor = color;
    }
    
    public void setFilledShape(boolean fill)
    {
        filledShape = fill;
    }

    public int getCounter()
    {
        return counter;
    }
    
    public void clearLastShape()
    {
        if (shapeCount > 0)
        {
            shapeCount--;
            counter++;
        }
        else
            shapeCount = 0;
        repaint();
    }

    public void redrawLastShape(int count)
    {
        if (count > 0)
        {
            shapeCount++;
            counter--;
        }
        repaint();
    }
    
    public void clearDrawing()
    {
        shapeCount = 0;
        counter = 0;
        repaint();
    }

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        for ( int count = 0; count < shapeCount; count++ )
        {
            shapes[count].draw(g);
        }

        for (int count = 0; count < currentShapeCount; count++ )
        {
            currentShapes[count].draw(g);
        }
    }
}

