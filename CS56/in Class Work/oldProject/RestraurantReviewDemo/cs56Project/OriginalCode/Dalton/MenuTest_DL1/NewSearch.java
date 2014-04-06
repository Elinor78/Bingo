import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.Array;

public class NewSearch extends JPanel {
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
	
	public NewSearch() {
		for (int i = 0; i < Array.getLength(priceRadioButtons); i++) {
			rgPrice.add(priceRadioButtons[i]);
		}
		for (int i = 0; i < Array.getLength(kidsRadioButtons); i++) {
			rgKids.add(kidsRadioButtons[i]);
		}
	   
	   this.setLayout(new FlowLayout());
	   this.add(name);
	   this.add(tfName);


	   this.add(city);
	   this.add(tfCity);
	   this.add(state);
	   this.add(tfState);
	   this.add(zip);
	   this.add(tfZip);

	   this.add(price);

	   for (int i = 0; i < rgPrice.getButtonCount(); i++) {
		   this.add(priceRadioButtons[i]);
	   }
	   this.add(kidsFriendly);
	   for (int i = 0; i < rgKids.getButtonCount(); i++) {
		   this.add(kidsRadioButtons[i]);
	   }

	   
	   this.setVisible(true);
	}
}
