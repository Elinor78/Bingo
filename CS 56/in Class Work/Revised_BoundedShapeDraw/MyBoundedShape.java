//package BoundedShapeDraw;

import java.awt.*;

public abstract class MyBoundedShape extends MyShape
{
    private boolean fillShapeColor;

    public MyBoundedShape()
    {
        super();
        setFill(false);
    }

    public MyBoundedShape(int x1, int x2, int y1, int y2, Color color, boolean fill)
    {
        super(x1, x2, y1, y2, color);
        setFill(fill);
    }

    public void setFill(boolean flag)
    {
        fillShapeColor = flag;
    }

    public int getUpperLeftx()
    {
        return Math.min(getX1() , getX2());
    }

    public int getUpperLefty()
    {
        return Math.min(getY1() , getY2());
    }

    public int getWidth()
    {
        return Math.abs(getX1() - getX2());
    }

    public int getHeight()
    {
        return Math.abs(getY1() - getY2());
    }

    public boolean getFill()
    {
        return fillShapeColor;
    }

    public abstract void draw(Graphics g);
}
