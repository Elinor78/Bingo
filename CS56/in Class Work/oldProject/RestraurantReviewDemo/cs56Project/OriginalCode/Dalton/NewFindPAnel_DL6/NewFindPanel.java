package edu.smc.cs56Project.gui;



import java.awt.*;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.event.*;

public class NewFindPanel extends JPanel {
    private GridBagConstraints constraints;
    private GridBagLayout layout;
//    @SuppressWarnings("unused")
    private JTextField restaurantName;
    private JLabel name = new JLabel("Name of Restaurant");
    private JLabel city = new JLabel("City");
    private JLabel state = new JLabel("State");
    private JLabel zip = new JLabel("Zip Code");
    private JLabel price = new JLabel("Price");
    private JLabel overallRating = new JLabel("Overall Rating");
    private JLabel foodType = new JLabel("Food Type");    
//    @SuppressWarnings("unused")
    private JLabel review = new JLabel("Review");
    private JTextField tfName = new JTextField(10);
    private JTextField tfCity = new JTextField(10);
    private JTextField tfState = new JTextField(10);
    private JTextField tfZip = new JTextField(10);
    private JTextField tfFoodType = new JTextField(20);
    private JRadioButton priceRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4") };

    private JRadioButton overallRadioButtons[] = { new JRadioButton("1"),
            new JRadioButton("2"), new JRadioButton("3"),
            new JRadioButton("4") };

    private ButtonGroup rgPrice = new ButtonGroup();

    private ButtonGroup rgOverall = new ButtonGroup();
    
    /* For testing purposes */
    JButton jb = new JButton("MapTest");

    public NewFindPanel()
    {
        for (int i = 0; i < Array.getLength(priceRadioButtons); i++) {
            rgPrice.add(priceRadioButtons[i]);
        }
        for (int i = 0; i < Array.getLength(overallRadioButtons); i++) {
            rgOverall.add(overallRadioButtons[i]);
        }

        layout = new GridBagLayout();
        this.setLayout(layout);
        constraints = new GridBagConstraints();

        constraints.fill = ( GridBagConstraints.BOTH );
        
        int row = 0;
        addComponent(name, row++, 0, 8, 1);
        addComponent(tfName, row++, 0, 8, 1);
        addComponent(city, row++, 0, 2, 1);
        addComponent(tfCity, row++, 0, 8, 1);
        addComponent(state, row++, 0, 2, 1);
        addComponent(tfState, row++, 0, 8, 1);
        addComponent(zip, row++, 0, 2, 1);
        addComponent(tfZip, row++, 0, 8, 1);
        addComponent(foodType, row++, 0, 2, 1);
        addComponent(tfFoodType, row++, 0, 8, 1);        
        addComponent(price, row++, 0, 2, 1);

        for (int i = 0; i < rgPrice.getButtonCount(); i++) {
            addComponent(priceRadioButtons[i], row, i * 2, 2, 1);
        }
        row++;
        addComponent(overallRating, row++, 0, 2, 1);
        for (int i = 0; i < rgOverall.getButtonCount(); i++) {
            addComponent(overallRadioButtons[i], row, i * 2, 2, 1);
        }
        row++;
        /* For testing purposes */
        ItemHandler handler = new ItemHandler();
        jb.addActionListener( handler );
        
        
        addComponent(jb, row++, 0, 2, 1);
        
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

    public ButtonGroup getRgOverall()
    {
        return rgOverall;
    }

    public void setRgOverall( ButtonGroup rgOverall )
    {
        this.rgOverall = rgOverall;
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

	public JLabel getFoodType() {
		return foodType;
	}

	public void setFoodType(JLabel foodType) {
		this.foodType = foodType;
	}

	public JTextField getTfFoodType() {
		return tfFoodType;
	}

	public void setTfFoodType(JTextField tfFoodType) {
		this.tfFoodType = tfFoodType;
	}

	public JRadioButton[] getOverallRadioButtons() {
		return overallRadioButtons;
	}

	public void setOverallRadioButtons(JRadioButton[] overallRadioButtons) {
		this.overallRadioButtons = overallRadioButtons;
	}
	
	public Map getFields() {		
		Map findMap = new HashMap();
		String name = getTfName().getText();
		if (!name.equals("")) {
			findMap.put("Name", name);
		}
		String city = getTfCity().getText();
		if ( !city.equals("")) {
			findMap.put("City", city);
		}
		String foodType = getTfFoodType().getText();
		if ( !foodType.equals("")) {
			findMap.put("Food", foodType);
		}
		JRadioButton overallButtons[]  = getOverallRadioButtons();
		for (int count = 0; count < rgOverall.getButtonCount(); count++) {
		   String overall = overallButtons[count].getText();
		   if ( overallButtons[count].isSelected()) {
		      findMap.put("Overall", overall);
		   }
		}
		return findMap;
	}

	private class ItemHandler implements ActionListener {
		public void actionPerformed( ActionEvent e) {
			Map map = getFields();
			String value;
			if (map.containsKey("Name")){
				value = (String)map.get("Name");
				System.out.println("Restaurant name is: " + (String)map.get("Name"));
			}
			if (map.containsKey("City")){
				System.out.println("Restaurant city is" + (String)map.get("City"));
			}
			if (map.containsKey("Food")){
				System.out.println("Restaurant food is " + map.get("Food"));
			}
			if (map.containsKey("Overall")){
				System.out.println("Restaurant rating is" + map.get("Overall"));
			}
		}
	}
}
