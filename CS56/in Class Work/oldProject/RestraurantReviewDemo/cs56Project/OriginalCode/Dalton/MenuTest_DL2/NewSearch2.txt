import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.Array;

public class NewSearch2 extends JPanel {
	private GridBagConstraints constraints;
	private GridBagLayout layout;
	private JTextField restaurantName;
	private JLabel name = new JLabel("Name of Restaurant");
	private JLabel city = new JLabel("City");
	private JLabel state = new JLabel("State");
	private JLabel zip = new JLabel("Zip Code");

	private JLabel price = new JLabel("Price");
	private JLabel kidsFriendly = new JLabel("Kids Friendly");
	private JLabel review = new JLabel("Review");
	private JTextField tfName = new JTextField(10);

	private JTextField tfCity = new JTextField(10);
	private JTextField tfState = new JTextField(10);
	private JTextField tfZip = new JTextField(10);

	private JRadioButton priceRadioButtons[] =
	{
			new JRadioButton("1"), new JRadioButton("2"),
			new JRadioButton("3"), new JRadioButton("4"),
			new JRadioButton("5")
	};
	private JRadioButton kidsRadioButtons[] =
	{
			new JRadioButton("1"), new JRadioButton("2"),
			new JRadioButton("3"), new JRadioButton("4"),
			new JRadioButton("5")
	};

	private ButtonGroup rgPrice = new ButtonGroup();
	private ButtonGroup rgKids = new ButtonGroup();
	
	public NewSearch2() {
		for (int i = 0; i < Array.getLength(priceRadioButtons); i++) {
			rgPrice.add(priceRadioButtons[i]);
		}
		for (int i = 0; i < Array.getLength(kidsRadioButtons); i++) {
			rgKids.add(kidsRadioButtons[i]);
		}
	   
	   layout = new GridBagLayout();
	   this.setLayout(layout);
	   constraints = new GridBagConstraints();
	   
	   constraints.fill = (GridBagConstraints.BOTH);
	   addComponent(name,0,0,2,1);
	   addComponent(tfName, 0, 2, 8, 1);
	   addComponent(city, 1,0,2,1);
	   addComponent(tfCity, 1,2,8,1);
	   addComponent(state, 2,0,2,1);
	   addComponent(tfState, 2 ,2,8,1);
	   addComponent(zip, 3,0,2,1);
	   addComponent(tfZip, 3,2,8,1);
	   addComponent(price, 4,0,2,1);

	   for (int i = 0; i < rgPrice.getButtonCount(); i++) {
		   	addComponent(priceRadioButtons[i], 4, i + 2, 1, 1);
	   }
	   addComponent(kidsFriendly, 5,0,2,1);
	   for (int i = 0; i < rgKids.getButtonCount(); i++) {
		   	addComponent(kidsRadioButtons[i], 5, i + 2, 1, 1);
	   }


	   
	   this.setVisible(true);
	}
	
	private void addComponent( Component component, int row, int column,
							   int width, int height)
	{
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints( component, constraints);
		this.add( component);
	}
}


