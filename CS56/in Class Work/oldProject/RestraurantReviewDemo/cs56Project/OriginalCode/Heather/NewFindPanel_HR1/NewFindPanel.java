/*
 * CS56 Advanced Java
 * Class: NewFindPanel
 * Author(s): Dalton Lee
 * LAST UPDATE: 5-25-07
 *
 * Purpose: Displays fields for specifying search parameters. These fields
 * include: restaurant name, city, food type, and overall rating,
 * 
 */

package edu.smc.cs56Project.gui;

import java.awt.*;
import javax.swing.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.smc.cs56Project.patterns.Observer;
import edu.smc.cs56Project.patterns.Subject;

public class NewFindPanel extends JPanel implements Subject {
    private ArrayList<Observer> observers;
    
    private GridBagConstraints constraints;
    private GridBagLayout layout;
    
    private JLabel name = new JLabel("Name of Restaurant");
    private JLabel city = new JLabel("City");
    private JLabel state = new JLabel("State");
    private JLabel zip = new JLabel("Zip Code");
    private JLabel price = new JLabel("Price");
    private JLabel kidsFriendly = new JLabel("Kids Friendly");
    
    private JTextField tfName = new JTextField(10);
    private JTextField tfCity = new JTextField(10);
    private JTextField tfState = new JTextField(10);
    private JTextField tfZip = new JTextField(10);
    
    private JRadioButton priceRadioButtons[] = { new JRadioButton("$"),
            new JRadioButton("$$"), new JRadioButton("$$$"),
            new JRadioButton("$$$$") };
    private JRadioButton kidsRadioButtons[] = { new JRadioButton("Poor"),
            new JRadioButton("Fair"), new JRadioButton("Good"),
            new JRadioButton("Excellent") };

    private ButtonGroup rgPrice = new ButtonGroup();
    private ButtonGroup rgKids = new ButtonGroup();

    // NewFindPanel constructor
    public NewFindPanel()
    {
        observers = new ArrayList<Observer>();
        
        // Set up button groups for the radio buttons
        for (int i = 0; i < Array.getLength(priceRadioButtons); i++) {
            rgPrice.add(priceRadioButtons[i]);
        }
        for (int i = 0; i < Array.getLength(kidsRadioButtons); i++) {
            rgKids.add(kidsRadioButtons[i]);
        }

        // Set layout type
        layout = new GridBagLayout();
        this.setLayout(layout);
        constraints = new GridBagConstraints();

        // Add components to panel using GridBagLayout
        constraints.fill = ( GridBagConstraints.BOTH );
        addComponent(name, 0, 0, 2, 1);
        addComponent(tfName, 0, 2, 8, 1);
        addComponent(city, 1, 0, 2, 1);
        addComponent(tfCity, 1, 2, 8, 1);
        addComponent(state, 2, 0, 2, 1);
        addComponent(tfState, 2, 2, 8, 1);
        addComponent(zip, 3, 0, 2, 1);
        addComponent(tfZip, 3, 2, 8, 1);
        addComponent(price, 4, 0, 2, 1);

        for (int i = 0; i < rgPrice.getButtonCount(); i++) {
            addComponent(priceRadioButtons[i], 4, i + 2, 1, 1);
        }
        addComponent(kidsFriendly, 5, 0, 2, 1);
        for (int i = 0; i < rgKids.getButtonCount(); i++) {
            addComponent(kidsRadioButtons[i], 5, i + 2, 1, 1);
        }

        this.setVisible(true);
    }

    private void addComponent( Component component, int row, int column,
            int width, int height )
    {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(component, constraints);
        this.add(component);
    }

    public ButtonGroup getRgKids()
    {
        return rgKids;
    }

    public void setRgKids( ButtonGroup rgKids )
    {
        this.rgKids = rgKids;
    }

    public ButtonGroup getRgPrice()
    {
        return rgPrice;
    }

    public void setRgPrice( ButtonGroup rgPrice )
    {
        this.rgPrice = rgPrice;
    }

    public JTextField getTfCity()
    {
        return tfCity;
    }

    public void setTfCity( JTextField tfCity )
    {
        this.tfCity = tfCity;
    }

    public JTextField getTfName()
    {
        return tfName;
    }

    public void setTfName( JTextField tfName )
    {
        this.tfName = tfName;
    }

    public JTextField getTfState()
    {
        return tfState;
    }

    public void setTfState( JTextField tfState )
    {
        this.tfState = tfState;
    }

    public JTextField getTfZip()
    {
        return tfZip;
    }

    public void setTfZip( JTextField tfZip )
    {
        this.tfZip = tfZip;
    }
    
    public String getNameString()
    {
        return tfName.getText();
    }

    // Satisfy contract for Subject interface
    public void registerObserver( Observer o )
    {
        observers.add(o);
    }

    // Satisfy contract for Subject interface
    public void removeObserver( Observer o )
    {
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }

    // Satisfy contract for Subject interface
    public void notifyObservers()
    {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(this, null);
        }
    }
    
}

