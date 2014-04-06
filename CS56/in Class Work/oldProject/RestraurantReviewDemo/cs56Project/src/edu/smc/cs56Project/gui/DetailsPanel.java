/*
 * CS56 Advanced Java
 * Class: DetailsPanel
 * Author(s): Dalton Lee
 * LAST UPDATE: 5-31-07
 *
 * Purpose: Displays restaurant details including name, location, 
 * contact information, food type, rating, and brief review. 
 * 
 */

package edu.smc.cs56Project.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.reflect.Array;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DetailsPanel extends JPanel {
    private GridBagConstraints constraints;
    private GridBagLayout layout;

    private JLabel name;
    private JLabel address;
    private JLabel city;
    private JLabel state;
    private JLabel zip;
    private JLabel phone;
    private JLabel webURL;
    private JLabel foodType;
    private JLabel price;
    private JLabel overallRating;
    private JLabel foodRating;
    private JLabel serviceRating;
    private JLabel comments;

    private JTextField tfName;
    private JTextField tfAddress;
    private JTextField tfCity;
    private JTextField tfState;
    private JTextField tfZip;
    private JTextField tfPhone;
    private JTextField tfWebURL;
    private JTextField tfFoodType;
    private JTextArea taComments;

    private JRadioButton priceRadioButtons[] = 
        {new JRadioButton( "$      " ), new JRadioButton( "$$   " ),
         new JRadioButton( "$$$" ), new JRadioButton( "$$$$" )};

    private JRadioButton overallRadioButtons[] = 
        {new JRadioButton( "1" ), new JRadioButton( "2" ), 
         new JRadioButton( "3" ), new JRadioButton( "4" )};

    private JRadioButton serviceRadioButtons[] = 
        {new JRadioButton( "1" ), new JRadioButton( "2" ), 
         new JRadioButton( "3" ), new JRadioButton( "4" )};
    
    private JRadioButton foodRadioButtons[] =
        {new JRadioButton( "1" ), new JRadioButton( "2" ), 
         new JRadioButton( "3" ), new JRadioButton( "4" )};
    
    private ButtonGroup rgPrice;
    private ButtonGroup rgOverall;
    private ButtonGroup rgFood;
    private ButtonGroup rgService;

    public DetailsPanel()
    {
        // Create components
        name = new JLabel( "Name" );
        address = new JLabel( "Address" );
        city = new JLabel( "City" );
        state = new JLabel( "State" );
        zip = new JLabel( "Zip Code" );
        phone = new JLabel( "Phone Number" );
        webURL = new JLabel( "Web Site" );
        foodType = new JLabel( "Cusine" );
        price = new JLabel( "Price" );
        overallRating = new JLabel( "Overall Rating" );
        foodRating = new JLabel( "Food Rating" );
        serviceRating = new JLabel( "Service Rating" );
        comments = new JLabel( "Comments" );

        tfName = new JTextField( 10 );
        tfAddress = new JTextField( 20 );
        tfCity = new JTextField( 20 );
        tfState = new JTextField( 3 );
        tfZip = new JTextField( 10 );
        tfPhone = new JTextField( 10 );
        tfWebURL = new JTextField( 20 );
        tfFoodType = new JTextField( 20 );
        taComments = new JTextArea( 20, 45 );

        // Create button groups
        rgPrice = new ButtonGroup();
        rgOverall = new ButtonGroup();
        rgFood = new ButtonGroup();
        rgService = new ButtonGroup();

        for (int i = 0; i < Array.getLength( priceRadioButtons ); i++) {
            rgPrice.add( priceRadioButtons[i] );
        }
        for (int i = 0; i < Array.getLength( overallRadioButtons ); i++) {
            rgOverall.add( overallRadioButtons[i] );
        }
        for (int i = 0; i < Array.getLength( foodRadioButtons ); i++) {
            rgFood.add( foodRadioButtons[i] );
        }
        for (int i = 0; i < Array.getLength( serviceRadioButtons ); i++) {
            rgService.add( serviceRadioButtons[i] );
        }

        // Set up GridBagLayout and add components
        layout = new GridBagLayout();
        this.setLayout( layout );
        constraints = new GridBagConstraints();
        constraints.fill = ( GridBagConstraints.BOTH  );

        int row = 0;
        addComponent( name, row++, 0, 5, 1 );
        addComponent( tfName, row++, 0, 10, 1 );
        addComponent( address, row++, 0, 5, 1 );
        addComponent( tfAddress, row++, 0, 10, 1 );
        addComponent( city, row++, 0, 5, 1 );
        addComponent( tfCity, row++, 0, 10, 1 );
        addComponent( state, row++, 0, 5, 1 );
        addComponent( tfState, row++, 0, 3, 1 );
        addComponent( zip, row++, 0, 5, 1 );
        addComponent( tfZip, row++, 0, 7, 1 );
        addComponent( phone, row++, 0, 5, 1 );
        addComponent( tfPhone, row++, 0, 7, 1 );
        addComponent( webURL, row++, 0, 5, 1 );
        addComponent( tfWebURL, row++, 0, 10, 1 );
        addComponent( foodType, row++, 0, 5, 1 );
        addComponent( tfFoodType, row++, 0, 10, 1 );
        addComponent( price, row++, 0, 5, 1 );
        for (int i = 0; i < rgPrice.getButtonCount(); i++) {
            priceRadioButtons[i].setBackground( new Color( 255, 255, 204 ));
            addComponent( priceRadioButtons[i], row, i, 1, 1 );
        }
        row++;
        addComponent( overallRating, row++, 0, 5, 1 );
        for (int i = 0; i < rgOverall.getButtonCount(); i++) {
            overallRadioButtons[i].setBackground( new Color( 255, 255, 204 ));
            addComponent( overallRadioButtons[i], row, i, 1, 1 );

        }
        row++;
        addComponent( foodRating, row++, 0, 5, 1 );
        for (int i = 0; i < rgFood.getButtonCount(); i++) {
            foodRadioButtons[i].setBackground( new Color( 255, 255, 204 ));
            addComponent( foodRadioButtons[i], row, i, 1, 1 );
        }
        row++;
        addComponent( serviceRating, row++, 0, 5, 1 );
        for (int i = 0; i < rgService.getButtonCount(); i++) {
            serviceRadioButtons[i].setBackground( new Color( 255, 255, 204 ));
            addComponent( serviceRadioButtons[i], row, i, 1, 1 );
        }
        row++;
        
        taComments.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 153), 1));
        taComments.setLineWrap( true );
        taComments.setWrapStyleWord( true );
        addComponent( comments, row++, 0, 5, 1 );
        addComponent( taComments, row++, 0, 10, 10 );
        
        setIsEditable( false );

        this.setVisible( true );
    }

    // Helps GridBagLayout add components to the panel
    private void addComponent( Component component, int row, int column,
            int width, int height )
    {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints( component, constraints );
        this.add( component );
    }

    // Sets the edit mode for the components
    public void setIsEditable( boolean isEditable )
    {
        tfName.setEditable( isEditable );
        tfAddress.setEditable( isEditable );
        tfCity.setEditable( isEditable );
        tfState.setEditable( isEditable );
        tfZip.setEditable( isEditable );
        tfPhone.setEditable( isEditable );
        tfWebURL.setEditable( isEditable );
        tfFoodType.setEditable( isEditable );
        taComments.setEditable( isEditable );

        for (int i = 0; i < rgPrice.getButtonCount(); i++) {
            priceRadioButtons[i].setEnabled( false );
        }
        for (int i = 0; i < rgOverall.getButtonCount(); i++) {
            overallRadioButtons[i].setEnabled( false );
        }
        for (int i = 0; i < rgFood.getButtonCount(); i++) {
            foodRadioButtons[i].setEnabled( false );
        }
        for (int i = 0; i < rgService.getButtonCount(); i++) {
            serviceRadioButtons[i].setEnabled( false );
        }
    }

    // Get HashMap of the fields
    public HashMap<String, String> getFields()
    {
        HashMap<String, String> detailsMap = new HashMap<String, String>();

        String name = tfName.getText();
        if (!name.equals( "" )) {
            detailsMap.put( "Name", name );
        }
        String address = tfAddress.getText();
        if (!address.equals( "" )) {
            detailsMap.put( "Address", address );
        }
        String city = tfCity.getText();
        if (!city.equals( "" )) {
            detailsMap.put( "City", city );
        }
        String state = tfState.getText();
        if (!state.equals( "" )) {
            detailsMap.put( "State", state );
        }
        String zip = tfZip.getText();
        if (!zip.equals( "" )) {
            detailsMap.put( "Zip", zip );
        }
        String phone = tfPhone.getText();
        if (!phone.equals( "" )) {
            detailsMap.put( "Phone", phone );
        }
        String web = tfWebURL.getText();
        if (!web.equals( "" )) {
            detailsMap.put( "Web", web );
        }
        String food = tfFoodType.getText();
        if (!food.equals( "" )) {
            detailsMap.put( "Food", food );
        }
        for (int count = 0; count < rgPrice.getButtonCount(); count++) {
            String price = priceRadioButtons[count].getText();
            if (priceRadioButtons[count].isSelected()) {
                detailsMap.put( "Price", price );
            }
        }
        for (int count = 0; count < rgOverall.getButtonCount(); count++) {
            String overall = overallRadioButtons[count].getText();
            if (overallRadioButtons[count].isSelected()) {
                detailsMap.put( "Overall", overall );
            }
        }

        for (int count = 0; count < rgFood.getButtonCount(); count++) {
            String foods = foodRadioButtons[count].getText();
            if (foodRadioButtons[count].isSelected()) {
                detailsMap.put( "Food", foods );
            }
        }
        for (int count = 0; count < rgService.getButtonCount(); count++) {
            String service = serviceRadioButtons[count].getText();
            if (serviceRadioButtons[count].isSelected()) {
                detailsMap.put( "Service", service );
            }
        }
        String comments = taComments.getText();
        if (!comments.equals( "" )) {
            detailsMap.put( "Comments", comments );
        }
        return detailsMap;
    }

    public void setFields( HashMap<String, String> hMap )
    {
        HashMap<String, String> detailsMap = hMap;
        if (detailsMap.containsKey( "Name" )) {
            tfName.setText( detailsMap.get( "Name" ) );
        }
        if (detailsMap.containsKey( "Address" )) {
            tfAddress.setText( detailsMap.get( "Address" ) );
        }
        if (detailsMap.containsKey( "City" )) {
            tfCity.setText( detailsMap.get( "City" ) );
        }
        if (detailsMap.containsKey( "State" )) {
            tfState.setText( detailsMap.get( "State" ) );
        }
        if (detailsMap.containsKey( "Zip" )) {
            tfZip.setText( detailsMap.get( "Zip" ) );
        }
        if (detailsMap.containsKey( "Phone" )) {
            tfPhone.setText( detailsMap.get( "Phone" ) );
        }
        if (detailsMap.containsKey( "Web" )) {
            tfWebURL.setText( detailsMap.get( "Web" ) );
        }
        if (detailsMap.containsKey( "FoodType" )) {
            tfFoodType.setText( detailsMap.get( "FoodType" ) );
        }
        if (detailsMap.containsKey( "Overall" )) {
            String overall = detailsMap.get( "Overall" );
            for (int i = 0; i < rgOverall.getButtonCount(); i++) {
                if (overall.equals( overallRadioButtons[i].getText() )) {
                    overallRadioButtons[i].setSelected( true );
                }
            }
        }
        if (detailsMap.containsKey( "Price" )) {
            String price = detailsMap.get( "Price" );
            for (int i = 0; i < rgPrice.getButtonCount(); i++) {
                if (price.equals( priceRadioButtons[i].getText() )) {
                    priceRadioButtons[i].setSelected( true );
                }
            }
        }
        if (detailsMap.containsKey( "Food" )) {
            String food = detailsMap.get( "Food" );
            for (int i = 0; i < rgFood.getButtonCount(); i++) {
                if (food.equals( foodRadioButtons[i].getText() )) {
                    foodRadioButtons[i].setSelected( true );
                }
            }
        }
        if (detailsMap.containsKey( "Service" )) {
            String service = detailsMap.get( "Service" );
            for (int i = 0; i < rgFood.getButtonCount(); i++) {
                if (service.equals( serviceRadioButtons[i].getText() )) {
                    serviceRadioButtons[i].setSelected( true );
                }
            }
        }
    }
    
}
