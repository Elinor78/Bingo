/*
 * CS56 Advanced Java
 * Class: FindPanel
 * Author(s): Dalton Lee
 * LAST UPDATE: 5-31-07
 *
 * Purpose: Contains fields for entering search parameters.  The search
 * parameters include: name, city, food type, amd overall rating.
 * 
 */

package edu.smc.cs56Project.gui;

import java.awt.*;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.SystemColor;

public class FindPanel extends JPanel {
    private GridBagConstraints constraints;
    private GridBagLayout layout;

    private JLabel name;
    private JLabel city;
    private JLabel state;
    private JLabel zip;
    private JLabel foodType;
    private JLabel price;
    private JLabel overallRating;

    private JTextField tfName;
    private JTextField tfCity;
    private JTextField tfState;
    private JTextField tfZip;
    private JTextField tfFoodType;
    
    private JRadioButton[] priceRadioButtons = 
        { new JRadioButton("$    "), new JRadioButton("$$  "), 
          new JRadioButton("$$$  "), new JRadioButton("$$$$") };
   
    private JRadioButton[] overallRadioButtons = 
        { new JRadioButton("1"), new JRadioButton("2"),
          new JRadioButton("3"), new JRadioButton("4") };
  
    private ButtonGroup rgPrice;
    private ButtonGroup rgOverall;
    
    public FindPanel()
    {
        // Create components
        name = new JLabel("Name");
        city = new JLabel("City");
        state = new JLabel("State");
        zip = new JLabel("Zip Code");
        foodType = new JLabel("Cusine"); 
        price = new JLabel("Price");
        overallRating = new JLabel("Overall Rating");

        tfName = new JTextField(10);
        tfCity = new JTextField(10);
        tfState = new JTextField(10);
        tfZip = new JTextField(10);
        tfFoodType = new JTextField(20);

        // Create button groups
        rgPrice = new ButtonGroup();
        rgOverall = new ButtonGroup();
        
        for (int i = 0; i < Array.getLength(priceRadioButtons); i++) {
            rgPrice.add(priceRadioButtons[i]);
        }
        for (int i = 0; i < Array.getLength(overallRadioButtons); i++) {
            rgOverall.add(overallRadioButtons[i]);
        }

        // Set up GridBagLayout and add components 
        layout = new GridBagLayout();
        this.setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.fill = ( GridBagConstraints.BOTH );
        
        int row = 0;
        addComponent(name, row++, 0, 8, 1);
        addComponent(tfName, row++, 0, 8, 1);
        addComponent(city, row++, 0, 5, 1);
        addComponent(tfCity, row++, 0, 8, 1);
        addComponent(state, row++, 0, 5, 1);
        addComponent(tfState, row++, 0, 8, 1);
        addComponent(zip, row++, 0, 5, 1);
        addComponent(tfZip, row++, 0, 8, 1);
        addComponent(foodType, row++, 0, 5, 1);
        addComponent(tfFoodType, row++, 0, 8, 1);        
        
        addComponent(price, row++, 0, 5, 1);
        for (int i = 0; i < rgPrice.getButtonCount(); i++) {
            priceRadioButtons[i].setBackground( new Color( 255, 255, 204 ));
            addComponent(priceRadioButtons[i], row, i * 2, 2, 1);
        }
        row++;
        
        addComponent(overallRating, row++, 0, 5, 1);
        for (int i = 0; i < rgOverall.getButtonCount(); i++) {
            overallRadioButtons[i].setBackground( new Color( 255, 255, 204 ));
            addComponent(overallRadioButtons[i], row, i * 2, 2, 1);
        }
        row++;
        
        // Disable search parameters that are awaiting implementation
        tfState.setEnabled(  false );
        tfState.setBackground( new Color( 238, 238, 238 ));
        tfZip.setEnabled( false );
        tfZip.setBackground( new Color( 238, 238, 238 ));
        for (int i = 0; i < rgPrice.getButtonCount(); i++)
            priceRadioButtons[i].setEnabled( false );
        
        this.setVisible(true);
    }

    // Helps GridBagLayout add components to the panel
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

    // Get a HashMap of search parameters 
	public HashMap<String, String> getFields() {		
		tfZip.setEnabled(false);
		tfZip.setBackground(SystemColor.control);
		HashMap<String, String> findMap = new HashMap<String, String>();
		String name = tfName.getText();
		if (!name.equals("")) {
			findMap.put("Name", name);
		}
		String city = tfCity.getText();
		if ( !city.equals("")) {
			findMap.put("City", city);
		}
		String foodType = tfFoodType.getText();
		if ( !foodType.equals("")) {
			findMap.put("Food", foodType);
		}
		for (int count = 0; count < rgOverall.getButtonCount(); count++) {
		   String overall = overallRadioButtons[count].getText();
		   if ( overallRadioButtons[count].isSelected()) {
		      findMap.put("Overall", overall);
		   }
		}
		return findMap;
	}
}
