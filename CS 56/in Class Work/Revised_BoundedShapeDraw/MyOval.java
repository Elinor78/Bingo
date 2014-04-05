//package BoundedShapeDraw;

import java.awt.*;

public class MyOval extends MyBoundedShape
{
    public MyOval()
    {
        super();
    }

    public MyOval(int x1, int x2, int y1, int y2, Color color, boolean fill)
    {
        super(x1, x2, y1, y2, color, fill);
    }

    public void draw(Graphics g)
    {
        g.setColor(getColor());
        if (getFill())
            g.fillOval(getUpperLeftx(), getUpperLefty(), getWidth(), getHeight());
        g.drawOval(getUpperLeftx(), getUpperLefty(), getWidth(), getHeight());
    }
}