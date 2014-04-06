/*
 * CS56 Advanced Java
 * Class: DetailsPanel
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-22-07
 *
 * Purpose: Displays restaurant details including picture, name, location, 
 * contact information, food type, rating, and brief review. 
 * 
 */

package edu.smc.cs56Project.gui;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JLabel;

import edu.smc.cs56Project.patterns.Observer;
import edu.smc.cs56Project.patterns.Subject;

public class DetailsPanel extends JPanel implements Subject {
    private ArrayList<JComponent> components;
    private ArrayList<Observer> observers;
    
    private JLabel nameLabel = null;
    private JLabel cityLabel = null;
    private JLabel foodTypeLabel = null;
    private JTextField nameField = null;
    private JTextField cityField = null;
    private JTextField foodTypeField = null;
    
    // DetailsPanel constructor
    public DetailsPanel()
    {
        super();
        components = new ArrayList<JComponent>();
        initialize();
    }
    
    // Initialize DetailsPanel and add components
    private void initialize()
    {
        foodTypeLabel = new JLabel();
        foodTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        foodTypeLabel.setText("Food Type: ");
        foodTypeLabel.setPreferredSize(new Dimension(128, 17));
        cityLabel = new JLabel();
        cityLabel.setFont(new Font("Arial", Font.BOLD, 14));
        cityLabel.setText("City: ");
        cityLabel.setPreferredSize(new Dimension(128, 17));
        nameLabel = new JLabel();
        nameLabel.setText("Restaurant Name: ");
        nameLabel.setPreferredSize(new Dimension(128, 17));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.setLayout( new FlowLayout() );
        this.setPreferredSize( new Dimension( 200, 800 ) );
        this.setBounds( new Rectangle( 0, 0, 200, 800 ) );
        this.setBackground(new Color(255, 255, 204));
        this.add(nameLabel, null);
        this.add( getNameField() );
        components.add( getNameField() );
        this.add(cityLabel, null);
        this.add(getCityField(), null);
        components.add( getCityField() );
        this.add(foodTypeLabel, null);
        this.add(getFoodTypeField(), null);
        components.add( getFoodTypeField() );
        this.validate();
    }
    
    private JTextField getNameField()
    {
        if (nameField == null) {
            nameField = new JTextField();
            nameField.setEditable(false);
            nameField.setFont(new Font("Arial", Font.PLAIN, 14));
            nameField.setPreferredSize(new Dimension(128, 21));
            nameField.setText("Name");
            nameField.addCaretListener(new javax.swing.event.CaretListener() {
                public void caretUpdate( javax.swing.event.CaretEvent e )
                {
                    System.out.println("caretUpdate()"); // TODO Auto-generated Event stub caretUpdate()
                }
            });
        }
        return nameField;
    }

    private JTextField getCityField()
    {
        if (cityField == null) {
            cityField = new JTextField();
            cityField.setFont(new Font("Arial", Font.PLAIN, 14));
            cityField.setText("City");
            cityField.setEditable(false);
            cityField.setPreferredSize(new Dimension(128, 21));
        }
        return cityField;
    }

    private JTextField getFoodTypeField()
    {
        if (foodTypeField == null) {
            foodTypeField = new JTextField();
            foodTypeField.setFont(new Font("Arial", Font.PLAIN, 14));
            foodTypeField.setText("Food Type");
            foodTypeField.setEditable(false);
            foodTypeField.setPreferredSize(new Dimension(128, 21));
        }
        return foodTypeField;
    }
    
    public void setIsEditable( boolean isEnabled)
    {
        for (int i = 0; i < components.size(); i++) 
            components.get(i).setEnabled( isEnabled );
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
            observer.update( this, null );
        }
        
    }
    
}

