//package BoundedShapeDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DrawFrame extends JFrame
{
    private DrawPanel drawingPanel;
    private JComboBox colorBox;
    private JComboBox shapeBox;
    private JCheckBox filledBox;
    private JPanel topPanel;
    private JLabel statusBar;

    public DrawFrame()
    {
        String colorNames [] = {"Black" , "Red" , "Blue" , "Cyan" , "Dark Gray" , "Green" , "Light Gray" , "Magneta" , "Orange" , "Pink" , "Yellow" , "Gray" , "White"};
        final Color colorList [] = {Color.BLACK, Color.RED , Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW, Color.GRAY , Color.WHITE};
        String shapeList [] = {"Line" , "Oval" , "Rectangle"};
        JButton undoButton = new JButton("Undo");
        JButton redoButton = new JButton("Redo");
        JButton clearButton = new JButton("Clear");
        colorBox = new JComboBox(colorNames);
        colorBox.setMaximumRowCount(5);
        shapeBox = new JComboBox(shapeList);
        filledBox = new JCheckBox("Filled");
        topPanel = new JPanel();
        statusBar = new JLabel();
        drawingPanel = new DrawPanel(statusBar);

        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.add(undoButton);
        topPanel.add(redoButton);
        topPanel.add(clearButton);
        topPanel.add(colorBox);
        topPanel.add(shapeBox);
        topPanel.add(filledBox);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        undoButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                drawingPanel.clearLastShape();
            }
        });

        redoButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                drawingPanel.redrawLastShape(drawingPanel.getCounter());
            }
        });

        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                drawingPanel.clearDrawing();
            }
        });

        colorBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent i)
            {
                if (i.getStateChange() == ItemEvent.SELECTED)
                    drawingPanel.setCurrentColor(colorList[colorBox.getSelectedIndex()]);
            }
        });

        shapeBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent i)
            {
                if (i.getStateChange() == ItemEvent.SELECTED)
                    drawingPanel.setShapeType(shapeBox.getSelectedIndex());
            }
        });

         filledBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent i)
            {
                if (i.getSource() == filledBox)
                    drawingPanel.setFilledShape(filledBox.isSelected());
            }
        });
    }
}
