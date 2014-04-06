/*
 * CS56 Advanced Java
 * Class: FindPanel
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-25-07
 *
 * Purpose: Displays fields for specifying search parameters. These fields
 * include: restaurant name, city, food type, and overall rating,
 *
 */

package edu.smc.cs56Project.gui;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.smc.cs56Project.patterns.Observer;
import edu.smc.cs56Project.patterns.Subject;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import java.awt.event.KeyEvent;

public class FindPanel extends JPanel implements Subject {
    private ArrayList<Observer> observers;
    
    private JTextField nameField = null;
    private JLabel nameLabel = null;
    private JLabel cityLabel = null;
    private JTextField citytField = null;
    private JLabel foodTypeLabel = null;
    private JTextField foodTypetField = null;

    // FindPanel constructor
    public FindPanel()
    {
        super();
        observers = new ArrayList<Observer>();
        initialize();
    }

    // Initialize FindPanel and add components
    private void initialize()
    {
        foodTypeLabel = new JLabel();
        foodTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        foodTypeLabel.setPreferredSize(new Dimension(128, 17));
        foodTypeLabel.setText("Food Type: ");
        foodTypeLabel.setName("cityLabel");
        cityLabel = new JLabel();
        cityLabel.setText("City: ");
        cityLabel.setName("cityLabel");
        cityLabel.setPreferredSize(new Dimension(128, 17));
        cityLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel = new JLabel();
        nameLabel.setText("Restaurant Name: ");
        nameLabel.setName("nameLabel");
        nameLabel.setComponentOrientation(ComponentOrientation.UNKNOWN);
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(200, 800));
        this.setComponentOrientation(ComponentOrientation.UNKNOWN);
        this.setBounds(new Rectangle(0, 0, 200, 800));
        this.setBackground(new Color(255, 204, 153));
        this.add(nameLabel, null);
        this.add(getNameField(), null);
        this.add(cityLabel, null);
        this.add(getCitytField(), null);
        this.add(foodTypeLabel, null);
        this.add(getFoodTypetField(), null);
        this.validate();
    }

    private JTextField getNameField()
    {
        if (nameField == null) {
            nameField = new JTextField();
            nameField.setEditable(true);
            nameField.setFont(new Font("Arial", Font.PLAIN, 14));
            nameField.setPreferredSize(new Dimension(128, 21));
            nameField.setName("nameField");
            nameField.setText("Name");
            nameField.addCaretListener(new javax.swing.event.CaretListener() {
                public void caretUpdate( javax.swing.event.CaretEvent e )
                {
                    System.out.println("caretUpdate()"); // TODO
                                                            // Auto-generated
                                                            // Event stub
                                                            // caretUpdate()
                }
            });
        }
        return nameField;
    }
    
    private JTextField getCitytField()
    {
        if (citytField == null) {
            citytField = new JTextField();
            citytField.setPreferredSize(new Dimension(128, 20));
            citytField.setText("City");
            citytField.setFont(new Font("Arial", Font.PLAIN, 14));
        }
        return citytField;
    }

    private JTextField getFoodTypetField()
    {
        if (foodTypetField == null) {
            foodTypetField = new JTextField();
            foodTypetField.setFont(new Font("Arial", Font.PLAIN, 14));
            foodTypetField.setText("Food Type");
            foodTypetField.setPreferredSize(new Dimension(128, 20));
        }
        return foodTypetField;
    }

    public String getNameString()
    {
        return nameField.getText();
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
