package edu.smc.cs56Project.gui;



import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.reflect.Array;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewDetailsPanel extends JPanel {
    private GridBagConstraints constraints;
    private GridBagLayout layout;
//    @SuppressWarnings("unused")
    private JTextField restaurantName;
    private JLabel name = new JLabel("Name of Restaurant");
    private JLabel address = new JLabel("Address");
    private JLabel city = new JLabel("City");
    private JLabel state = new JLabel("State");
    private JLabel zip = new JLabel("Zip Code");
    private JLabel phone = new JLabel("Phone Number");
    private JLabel comments = new JLabel("Comments");
    private JLabel overall = new JLabel("Overall");
    private JLabel price = new JLabel("Price");
    private JLabel kidsFriendly = new JLabel("Kids Friendly");
//    @SuppressWarnings("unused")
    private JLabel review = new JLabel("Review");
    private JTextField tfName = new JTextField(10);
    private JTextField tfAddress = new JTextField(20);
    private JTextField tfCity = new JTextField(20);
    private JTextField tfState = new JTextField(3);
    private JTextField tfZip = new JTextField(10);
    private JTextField tfPhone = new JTextField(10);
    private JTextArea taComments = new JTextArea(5, 20);
    private JRadioButton overallRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4"), new JRadioButton("5") };

    private JRadioButton priceRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4"), new JRadioButton("5") };

    private JRadioButton kidsRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4"), new JRadioButton("5") };

    private ButtonGroup rgOverall = new ButtonGroup();
    private ButtonGroup rgPrice = new ButtonGroup();
    private ButtonGroup rgKids = new ButtonGroup();

    public NewDetailsPanel()
    {
        for (int i = 0; i < Array.getLength(overallRadioButtons); i++) {
            rgOverall.add(overallRadioButtons[i]);
        }
        for (int i = 0; i < Array.getLength(priceRadioButtons); i++) {
            rgPrice.add(priceRadioButtons[i]);
        }
        for (int i = 0; i < Array.getLength(kidsRadioButtons); i++) {
            rgKids.add(kidsRadioButtons[i]);
        }
        layout = new GridBagLayout();
        this.setLayout(layout);
        constraints = new GridBagConstraints();

        constraints.fill = ( GridBagConstraints.BOTH );
//        addComponent(name, 0, 0, 8, 1);
//        addComponent(tfName, 0, 2, 8, 1);
//        addComponent(address, 1, 0, 2, 1);
//        addComponent(tfAddress, 1, 2, 8, 1);
//        addComponent(city, 2, 0, 2, 1);
//        addComponent(tfCity, 2, 2, 8, 1);
//        addComponent(state, 3, 0, 2, 1);
//        addComponent(tfState, 3, 2, 8, 1);
//        addComponent(zip, 4, 0, 2, 1);
//        addComponent(tfZip, 4, 2, 8, 1);
//        addComponent(phone, 5, 0, 2, 1);
//        addComponent(tfPhone, 5, 2, 8, 1);
 
        addComponent(name, 0, 0, 8, 1);
        addComponent(tfName, 1, 0, 8, 1);
        addComponent(address, 2, 0, 2, 1);
        addComponent(tfAddress, 3, 0, 8, 1);
        addComponent(city, 4, 0, 2, 1);
        addComponent(tfCity, 5, 0, 8, 1);
        addComponent(state, 6, 0, 2, 1);
        addComponent(tfState, 7, 0, 2, 1);
        addComponent(zip, 8, 0, 2, 1);
        addComponent(tfZip, 9, 0, 2, 1);
        addComponent(phone, 10, 0, 10, 1);
        addComponent(tfPhone, 11, 0, 2, 1);

        addComponent(overall, 12, 0, 2, 1);
        for (int i = 0; i < rgOverall.getButtonCount(); i++) {
            addComponent(overallRadioButtons[i], 13, i * 2, 2, 1);
        }
        addComponent(price, 14, 0, 2, 1);
        for (int i = 0; i < rgPrice.getButtonCount(); i++) {
            addComponent(priceRadioButtons[i], 15, i * 2, 2, 1);
        }
        addComponent(kidsFriendly, 16, 0, 10, 1);
        for (int i = 0; i < rgKids.getButtonCount(); i++) {
            addComponent(kidsRadioButtons[i], 17, i * 2, 2, 1);
        }
        addComponent(comments, 18, 0, 2, 1);
        addComponent(taComments, 19, 0, 10, 10);
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
    
    public void setIsEditable( boolean isEditable)
    {
        tfName.setEditable(isEditable);
        tfAddress.setEditable(isEditable);
        tfCity.setEditable(isEditable);
        tfState.setEditable(isEditable);
        tfZip.setEditable(isEditable);
        tfPhone.setEditable(isEditable);
        overallRadioButtons[0].setEditable(isEditable);
        rgKids.setEditable(isEditable);
        rg.setEditable(isEditable);
        this.updateUI();
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

    public ButtonGroup getRgOverall()
    {
        return rgOverall;
    }

    public void setRgOverall( ButtonGroup rgOverall )
    {
        this.rgOverall = rgOverall;
    }

    public JTextField getTfAddress()
    {
        return tfAddress;
    }

    public void setTfAddress( JTextField tfAddress )
    {
        this.tfAddress = tfAddress;
    }

    public JTextField getTfPhone()
    {
        return tfPhone;
    }

    public void setTfPhone( JTextField tfPhone )
    {
        this.tfPhone = tfPhone;
    }

    public JTextArea getTaComments()
    {
        return taComments;
    }

    public void setTaComments( JTextArea taComments )
    {
        this.taComments = taComments;
    }
}
