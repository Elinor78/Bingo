package edu.smc.cs56Project.gui;



import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import edu.smc.cs56Project.gui.NewDetailsPanel.ItemHandler;

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

	public JRadioButton[] getPriceRadioButtons() {
		return priceRadioButtons;
	}

	public void setPriceRadioButtons(JRadioButton[] priceRadioButtons) {
		this.priceRadioButtons = priceRadioButtons;
	}
	
    public Map getFields() {
    	Map detailsMap = new HashMap();
		String name = getTfName().getText();
		if (!name.equals("")) {
			detailsMap.put("Name", name);
		}
		String address = getTfAddress().getText();
		if (!address.equals("")) {
			detailsMap.put("Address", address);
		}
		String city = getTfCity().getText();
		if ( !city.equals("")) {
			detailsMap.put("City", city);
		}
		String state = getTfState().getText();
		if ( !state.equals("")) {
			detailsMap.put("State", state);
		}
		String zip = getTfZip().getText();
		if ( !zip.equals("")) {
			detailsMap.put("Zip", zip);
		}
		String phone = getTfPhone().getText();
		if ( !phone.equals("")) {
			detailsMap.put("Phone", phone);
		}
		String web = getTfWebURL().getText();
		if ( !web.equals("")) {
			detailsMap.put("Web", web);
		}
		String food = getTfFoodType().getText();
		if ( !food.equals("")) {
			detailsMap.put("Food", food);
		}
		
		

		
		JRadioButton overallButtons[]  = getOverallRadioButtons();
		for (int count = 0; count < rgOverall.getButtonCount(); count++) {
		   String overall = overallButtons[count].getText();
		   if ( overallButtons[count].isSelected()) {
		      detailsMap.put("Overall", overall);
		   }
		}
		
		JRadioButton priceButtons[]  = getPriceRadioButtons();
		for (int count = 0; count < rgPrice.getButtonCount(); count++) {
		   String price = priceButtons[count].getText();
		   if ( priceButtons[count].isSelected()) {
		      detailsMap.put("Price", price);
		   }
		}
		
		JRadioButton foodButtons[]  = getFoodRadioButtons();
		for (int count = 0; count < rgFood.getButtonCount(); count++) {
		   String foods = foodButtons[count].getText();
		   if ( foodButtons[count].isSelected()) {
		      detailsMap.put("Food", foods);
		   }
		}
		
		JRadioButton serviceButtons[]  = getServiceRadioButtons();
		for (int count = 0; count < rgService.getButtonCount(); count++) {
		   String service = serviceButtons[count].getText();
		   if ( serviceButtons[count].isSelected()) {
		      detailsMap.put("Service", service);
		   }
		}
		
		String comments = getTaComments().getText();
		if ( !comments.equals("")) {
			detailsMap.put("Comments", comments);
		}
		return detailsMap;
    }
    
    public void setFields(Map dMap) {
    	HashMap detailsMap = (HashMap)dMap;
       	if (detailsMap.containsKey("Name")){
    		tfName.setText((String)detailsMap.get("Name"));
    	}
       	if (detailsMap.containsKey("Address")){
    		tfAddress.setText((String)detailsMap.get("Address"));
    	}
    	if (detailsMap.containsKey("City")){
    		tfCity.setText((String)detailsMap.get("City"));
    	}
    	if (detailsMap.containsKey("State")){
    		tfState.setText((String)detailsMap.get("State"));
    	}
    	if (detailsMap.containsKey("Zip")){
    		tfZip.setText((String)detailsMap.get("Zip"));
    	}
    	if (detailsMap.containsKey("Phone")){
    		tfPhone.setText((String)detailsMap.get("Phone"));
    	}
    	if (detailsMap.containsKey("Web")){
    		tfWebURL.setText((String)detailsMap.get("Web"));
    	}
    	if (detailsMap.containsKey("FoodType")){
    		tfFoodType.setText((String)detailsMap.get("FoodType"));
    	}
    	if (detailsMap.containsKey("Overall")){
    		String overall = (String)detailsMap.get("Overall");
    		for (int i = 0; i < rgOverall.getButtonCount(); i ++) {
    		   if  (overall.equals((String)overallRadioButtons[i].getText())){
    			  overallRadioButtons[i].setSelected(true);
    		   }
    		} 		
    	}
        if (detailsMap.containsKey("Price")){
        	String price = (String)detailsMap.get("Price");
        	for (int i = 0; i < rgPrice.getButtonCount(); i ++) {
        	   if (price.equals((String)priceRadioButtons[i].getText())){
        	   	   priceRadioButtons[i].setSelected(true);
        	   } 
        	}
        }
        if (detailsMap.containsKey("Food")){
            String food = (String)detailsMap.get("Food");
            for (int i = 0; i < rgFood.getButtonCount(); i ++) {
               if (food.equals((String)foodRadioButtons[i].getText())){
            	   foodRadioButtons[i].setSelected(true);
               } 
            }
        }
        if (detailsMap.containsKey("Service")){
            String service = (String)detailsMap.get("Service");
            for (int i = 0; i < rgFood.getButtonCount(); i ++) {
               if (service.equals((String)serviceRadioButtons[i].getText())){
            	   serviceRadioButtons[i].setSelected(true);
               }
            }
        }
    }
}
