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
    private JLabel foodRating = new JLabel("Food Rating");
    private JLabel serviceRating = new JLabel("Service Rating");
//    @SuppressWarnings("unused")
    private JLabel review = new JLabel("Review");
    private JLabel webURL = new JLabel("Web URL");
    private JLabel foodType = new JLabel("Food Type");
    
    private JTextField tfName = new JTextField(10);
    private JTextField tfAddress = new JTextField(20);
    private JTextField tfCity = new JTextField(20);
    private JTextField tfState = new JTextField(3);
    private JTextField tfZip = new JTextField(10);
    private JTextField tfPhone = new JTextField(10);
    private JTextField tfWebURL = new JTextField(20);
    private JTextField tfFoodType = new JTextField(20);
    
    private JTextArea taComments = new JTextArea(5, 20);
    private JRadioButton overallRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4") };

    private JRadioButton priceRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4") };

    private JRadioButton serviceRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4") };

    private JRadioButton foodRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4") };

    private ButtonGroup rgOverall = new ButtonGroup();
    private ButtonGroup rgPrice = new ButtonGroup();
    private ButtonGroup rgFood = new ButtonGroup();
    private ButtonGroup rgService = new ButtonGroup();

    public NewDetailsPanel()
    {
        for (int i = 0; i < Array.getLength(overallRadioButtons); i++) {
            rgOverall.add(overallRadioButtons[i]);
        }
        for (int i = 0; i < Array.getLength(priceRadioButtons); i++) {
            rgPrice.add(priceRadioButtons[i]);
        }
        for (int i = 0; i < Array.getLength(foodRadioButtons); i++) {
            rgFood.add(foodRadioButtons[i]);
        }
        for (int i = 0; i < Array.getLength(serviceRadioButtons); i++) {
            rgService.add(serviceRadioButtons[i]);
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
        int row = 0;
        addComponent(name, row++, 0, 8, 1);
        addComponent(tfName, row++, 0, 8, 1);
        addComponent(address, row++, 0, 2, 1);
        addComponent(tfAddress, row++, 0, 8, 1);
        addComponent(city, row++, 0, 2, 1);
        addComponent(tfCity, row++, 0, 8, 1);
        addComponent(state, row++, 0, 2, 1);
        addComponent(tfState, row++, 0, 2, 1);
        addComponent(zip, row++, 0, 2, 1);
        addComponent(tfZip, row++, 0, 2, 1);
        addComponent(phone, row++, 0, 10, 1);
        addComponent(tfPhone, row++, 0, 2, 1);
        addComponent(webURL, row++, 0, 10, 1);
        addComponent(tfWebURL, row++, 0, 10, 1);
        addComponent(foodType, row++, 0, 10, 1);
        addComponent(tfFoodType, row++, 0, 10, 1);
        addComponent(overall, row++, 0, 2, 1);
        for (int i = 0; i < rgOverall.getButtonCount(); i++) {
            addComponent(overallRadioButtons[i], row, i * 2, 2, 1);
        }
        row++;
        addComponent(price, row++, 0, 2, 1);
        for (int i = 0; i < rgPrice.getButtonCount(); i++) {
            addComponent(priceRadioButtons[i], row, i * 2, 2, 1);
        }
        row++;
        addComponent(foodRating, row++, 0, 10, 1);
        for (int i = 0; i < rgFood.getButtonCount(); i++) {
            addComponent(foodRadioButtons[i], row, i * 2, 2, 1);
        }
        row++;
        addComponent(serviceRating, row++, 0, 10, 1);
        for (int i = 0; i < rgService.getButtonCount(); i++) {
            addComponent(serviceRadioButtons[i], row, i * 2, 2, 1);
        }
        row++;
        addComponent(comments, row++, 0, 2, 1);
        addComponent(taComments, row++, 0, 10, 10);
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
        overallRadioButtons[0].setEnabled(isEditable);
/*        rgKids.setEditable(isEditable);
        overallRadioButtons[]
            setEditable(isEditable); */
        this.updateUI();
    }

    public ButtonGroup getRgFood()
    {
        return rgFood;
    }

    public void setRgFood( ButtonGroup rgFood )
    {
        this.rgFood = rgFood;
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

    public JRadioButton[] getFoodRadioButtons() {
		return foodRadioButtons;
	}

	public void setFoodRadioButtons(JRadioButton[] foodRadioButtons) {
		this.foodRadioButtons = foodRadioButtons;
	}

	public JRadioButton[] getOverallRadioButtons() {
		return overallRadioButtons;
	}

	public void setOverallRadioButtons(JRadioButton[] overallRadioButtons) {
		this.overallRadioButtons = overallRadioButtons;
	}

	public JRadioButton[] getServiceRadioButtons() {
		return serviceRadioButtons;
	}

	public void setServiceRadioButtons(JRadioButton[] serviceRadioButtons) {
		this.serviceRadioButtons = serviceRadioButtons;
	}

	public JTextField getTfFoodType() {
		return tfFoodType;
	}

	public void setTfFoodType(JTextField tfFoodType) {
		this.tfFoodType = tfFoodType;
	}

	public JTextField getTfWebURL() {
		return tfWebURL;
	}

	public void setTfWebURL(JTextField tfWebURL) {
		this.tfWebURL = tfWebURL;
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
