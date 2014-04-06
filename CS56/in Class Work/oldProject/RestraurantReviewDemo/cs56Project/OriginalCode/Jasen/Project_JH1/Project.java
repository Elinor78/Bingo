// HomeWork 1 Problem13_11.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame
	{
	// OK, I am doing this rough so I will try to comment it as well
	// as I can so that you all can see what I am thinking when I make
	// everything.

	// ------------ Define Components ---------------------

	// Define Layouts
	private FlowLayout layout;

	// Define Labels
	private JLabel menuLabel;	// This is the place holder for any
								// menu that we choose to add up top.
								// Mainly this is so we have an idea of
								// how it might look
	private JLabel sortLabel;	// This is the heading for our sorting area

	private JLabel ratingLabel;	// This is the Label for our Star Rating
	private JLabel nameLabel;	// This is the Label for the Name
	private JLabel locationLabel;	// This is the Label the Location
	private JLabel typeLabel;	// This is the Label for the Food Type

	// Define Check Boxes
	//These will be used for selecting displayed	fields of our review
	private JCheckBox ratingBox;	// Allows the user to View the Ratings
	private JCheckBox nameBox;	// Allows the user to View the Name
	private JCheckBox locationBox;	// Allows the user to View the Location
	private JCheckBox typeBox;	// Allows the user to View the Type

	// Define Radio Buttons
	// The Radio buttons will allow the user to select what field the display
	// will be sorted by
	private JRadioButton ratingRadio;	// Sort by the the Rating
	private JRadioButton nameRadio;		// Sort by the the Name
	private JRadioButton locationRadio;	// Sort by the the Location
	private JRadioButton typeRadio;		// Sort by the the Type

	// Define Radio Button Group
	// This is grouping the Sorting Radio Buttons
	private ButtonGroup sortingGroup;	// The Sorting Radio Group

	// Define Buttons
	private JButton saveButton;	// This will allow the user to save thier review
	private JButton cancelButton;	// This will cancle any review that the
									// user is creating
	private JButton createButton;	// This will trigger our Create Review method
	private JButton helpButton;	// In case we want to create a Help Pop up
								// with instructions

	// Define Combo Box
	// When we allow users to create reviews of thier own this will
	// be the way they select the Star Rating
	private JComboBox ratingCombo;	// We will populate this with the String
   									// Array below

	// Define Combo Box Strings for content
	private String rating[] = { "1 Star", "2 Star", "3 Star", "4 Star", "5 Star"};

	// Define Text Area
	private JTextArea reviewArea;	// This is my temporary display area for
   									// our review.  We will eventually have
   									// to use a self contained pannel that we
   									// can create instances of for our list of
   									// reviews but for now this is ok

	// Define Panels
	private JPanel reviewPanel;	// This is where we will all all of our
   								// instances of the custom pannel we will
   								// create for our reviews

	private JPanel sortingPanel;	// This will have our Sorting Labels, Check
   									// Boxes and Radio buttons
	private JPanel sortingLabelPanel;	// This will display all of the sorting Labels
	private JPanel sortingSelectionPanel;	//This will display our selection items
	private JPanel utilityPanel;	// This will have our utility buttons

	// Define Display Area
	private Container container;

	// Set up GUI
	public Project()
		{
		//Label Window
		super( "Class Project: Resturant Review Program" );

		// ------------ Initialize Components ---------------------

		//Initialize Container
		container = getContentPane();
		container.setLayout( new FlowLayout() );

		// Initialize Layout
		layout = new FlowLayout();

		// Initialize Labels in 2 ways for my later referance
		// These are the various labels that will be used in our program
		menuLabel = new JLabel();
		menuLabel.setText( "Menu" );
		menuLabel.setToolTipText( "This is the area we will have menu options" );

		sortLabel = new JLabel( "Sorting selections:" );
		sortLabel.setToolTipText( "This is the sorting selections Label" );

		ratingLabel = new JLabel( "Rating" );
		ratingLabel.setToolTipText( "This is the Rating selections Label" );

		nameLabel = new JLabel( "Name" );
		nameLabel.setToolTipText( "This is the Name selections Label" );

		locationLabel = new JLabel( "Location" );
		locationLabel.setToolTipText( "This is the Location selections Label" );

		typeLabel = new JLabel( "Type" );
		typeLabel.setToolTipText( "This is the Type selections Label" );


		// Initialize Checkbox Objects
		// These will be used to determin what parts of the review that
		// the user will see.
		ratingBox = new JCheckBox( "" );
		ratingBox.setBackground( Color.GRAY );
		ratingBox.setToolTipText( "This is the Rsturant Rating Check Box" );

		nameBox = new JCheckBox( "" );
		nameBox.setBackground( Color.GRAY );
		nameBox.setToolTipText( "This is the Rsturant Name Check Box" );

		locationBox = new JCheckBox( "" );
		locationBox.setBackground( Color.GRAY );
		locationBox.setToolTipText( "This is the Resturant Location Check Box" );

		typeBox = new JCheckBox( "" );
		typeBox.setBackground( Color.GRAY );
		typeBox.setToolTipText( "This is the Food Type Check Box" );

		// Initialize Radio Buttons
		// The Radio button that is selected will be used to choose what field
		// we sort by.  They should only be visable if the apropriate Check
		// Box is selected.  I have not put labels on these for a reason
		ratingRadio = new JRadioButton( "", true );
		ratingRadio.setBackground( Color.GRAY );
		ratingRadio.setToolTipText( "This is the Rating Radio Button" );

 		nameRadio = new JRadioButton( "", false );
		nameRadio.setBackground( Color.GRAY );
		nameRadio.setToolTipText( "This is the Name Radio Button" );

		locationRadio = new JRadioButton( "", false );
		locationRadio.setBackground( Color.GRAY );
		locationRadio.setToolTipText( "This is the Location Radio Button" );

		typeRadio = new JRadioButton( "", false );
		typeRadio.setBackground( Color.GRAY );
		typeRadio.setToolTipText( "This is the Type Radio Button" );

		// Create logical relationship between JRadioButtons
		sortingGroup = new ButtonGroup();
		sortingGroup.add( ratingRadio );
		sortingGroup.add( nameRadio );
		sortingGroup.add( locationRadio );
		sortingGroup.add( typeRadio );

		// Set up JComboBox
		// This is our list of selectable ratings
		ratingCombo = new JComboBox( rating );
		ratingCombo.setMaximumRowCount( 3 );
		ratingCombo.setBackground( Color.GRAY );
		ratingCombo.setToolTipText( "This is the Rating Combo Box" );

		// This area will set up our Sorting selection area.  This will have our sorting
		// selections and our Utility options

		sortingLabelPanel = new JPanel();
		sortingLabelPanel.add( sortLabel );

		utilityPanel = new JPanel();
		utilityPanel.setLayout( new GridLayout( 2, 1) );

		// Set up Sorting Selection JPanel and set its layout
		// This Panel will be on the Left side of the screen and it is going to
		// have our 4 Labels Check Boxes and Radio Buttons in it.  I am useing
		// a Grid Format to line things up.  We may not go with it but like I said
		// before.  This is a rough sketch version of the code.
		sortingSelectionPanel = new JPanel();
		sortingSelectionPanel.setLayout( new GridLayout( 4, 3) );

		// Add content to Sorting JPanel
		// This will make 3 colloms with 4 rows each.  It will also line up our
		// Labels and Boxes and Buttons
		sortingSelectionPanel.add( ratingLabel );
		sortingSelectionPanel.add( ratingBox );
		sortingSelectionPanel.add( ratingRadio );

		sortingSelectionPanel.add( nameLabel );
		sortingSelectionPanel.add( nameBox );
		sortingSelectionPanel.add( nameRadio );

		sortingSelectionPanel.add( locationLabel );
		sortingSelectionPanel.add( locationBox );
		sortingSelectionPanel.add( locationRadio );

		sortingSelectionPanel.add( typeLabel );
		sortingSelectionPanel.add( typeBox );
		sortingSelectionPanel.add( typeRadio );

		sortingSelectionPanel.setBackground( Color.GRAY );

		// ------------ Fill Display ---------------------

		sortingPanel = new JPanel();

		sortingPanel.add( sortingLabelPanel, BorderLayout.NORTH );
		sortingPanel.add( sortingSelectionPanel );
		sortingPanel.add( utilityPanel );
		 // Add content to container

		container.add( sortingPanel, BorderLayout.WEST  );

		// ------------ Event Handlers associated with the Sorting Panel ---------------------

      setSize( 400, 200 );
      setVisible( true );
      }

   public static void main( String args[] )
      {
      Project application = new Project();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      }
   }  // end class Project