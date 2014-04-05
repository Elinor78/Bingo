// ResturantPanel.java
// A customized JPanel class thatwill be used to store and
// display review information

import java.awt.*;
import javax.swing.*;

public class ResturantPanel extends JFrame
	{

	// Define all storage variables

	// Identification Number
	private int ID;

	// Names
	private String restaurantName;
	private String chefName;

	// Location Strings to store data
	private String location;
	private String locationStreet;
	private String locationCity;
	private int locationZipCode;
	private String locationState;
	private String locationCountry;

	// Contact string information
	private String contactPhone;
	private String contactFax;
	private String contactInternet;
	private String contactEmail;

	// Hours information
	private String hoursTime;
	private String hoursDays;

	// Type of food
	private String foodType;

	// Serves Alcohol
	private String alcoholType;
	private String alcoholBring;

	// Star Rating
	private int rateFood;
	private int rateService;
	private int rateAmbiance;
	private int rateOverall;

	// Cost information
	private int mealCost;

	//Meal information
	private String mealsServed;
	private String dressCode;
	private String noiseLevel;
	private boolean kidFriendly;

	// Description
	private String inBrief;

	// Display Pannels
	private JPanel picturePanel;		// This will display the selected Picture
	private JPanel namePanel;			// This will display the Resturant Name
	private JPanel locationPanel;		// This will display the Resturant Location
	private JPanel foodTypePanel;		// This will display the type of food
	private JPanel ratingPanel;			// This will display the overal Rating

	// Internal components definition
	// Rating Drop box material
	private String stars[] = { "oneStar.png", "twoStars.png", "threeStars.png", "fourStars.png" };
	private Icon starsIcon[] = { new ImageIcon( stars[0] ), new ImageIcon( stars[1] ),
		new ImageIcon( stars[2] ), new ImageIcon( stars[3] ) };

	// Labels for display functionality
	private JLabel pictureLabel;			//This will display the selected Star rating
	private JLabel nameLabel;
	private JLabel locationLabel;
	private JLabel typeLabel;
	private JLabel starLabel;

	// Define Display Area
	private Container container;


	// Method Seclarations
	// Get Methods to retrieve data from pannel

	int getID ()		// This is used to retrieve the ID for the individual Pannel
		{
		return ID;
		}

	String getRestaurantName ()
		{
		return restaurantName;
		}

	String getChefName ()
		{
		return chefName;
		}

	String getLocationStreet ()
		{
		return locationStreet;
		}

	String getLocationCity ()
		{
		return locationCity;
		}

	int getLocationZipCode ()
		{
		return locationZipCode;
		}

	String getLocationState ()
		{
		return locationState;
		}

	String getLocationCountry ()
		{
		return locationCountry;
		}

	String getContactPhone ()
		{
		return contactPhone;
		}

	String getContactFax()
		{
		return contactFax;
		}

	String getContactInternet ()
		{
		return contactInternet;
		}

	String getContactEmail ()
		{
		return contactEmail;
		}

	String getHoursTime ()
		{
		return hoursTime;
		}

	String getHoursDays ()
		{
		return hoursDays;
		}

	String getFoodType ()
		{
		return foodType;
		}

	String getAlcoholType ()
		{
		return alcoholType;
		}

	String getAlcoholBring ()
		{
		return alcoholBring;
		}

	int getRateFood ()
		{
		return rateFood;
		}

	int getRateService ()
		{
		return rateService;
		}

	int getRateAmbiance ()
		{
		return rateAmbiance;
		}

	int getRateOverall ()
		{
		return rateOverall;
		}

	int getMealCost ()
		{
		return mealCost;
		}

	String getMealsServed ()
		{
		return mealsServed;
		}

	String getDressCode ()
		{
		return dressCode;
		}

	String getNoiseLevel ()
		{
		return noiseLevel;
		}

	boolean getKidFriendly ()
		{
		return kidFriendly;
		}

	String getInBrief ()
		{
		return inBrief;
		}

	// Set Methods to Set fields in the  pannel

	void setID ( int x )
		{
		ID = x;
		return;
		}

	void setRestaurantName ( String x )
		{
		restaurantName = x;
		nameLabel.setText ( restaurantName );
		return;
		}

	void setChefName ( String x )
		{
		chefName = x;
		return;
		}

	void setLocation ( )
		{
		location = locationStreet + ", " + locationCity + ", " + locationState;
		locationLabel.setText ( location );
		return;
		}

	void setLocationStreet ( String x )
		{
		locationStreet = x;
		return;
		}

	void setLocationCity ( String x )
		{
		locationCity = x;
		return;
		}

	void setLocationZipCode ( int x )
		{
		locationZipCode = x;
		return;
		}

	void setLocationState ( String x )
		{
		locationState = x;
		return ;
		}

	void setLocationCountry ( String x )
		{
		locationCountry = x;
		return;
		}

	void setContactPhone ( String x )
		{
		contactPhone = x;
		return;
		}

	void setContactFax ( String x )
		{
		contactFax = x;
		return;
		}

	void setContactInternet ( String x )
		{
		contactInternet = x;
		return;
		}

	void setContactEmail ( String x )
		{
		contactEmail = x;
		return;
		}

	void setHoursTime ( String x )
		{
		hoursTime  = x;
		return;
		}

	void setHoursDays ( String x )
		{
		hoursDays = x;
		return;
		}

	void setFoodType ( String x )
		{
		foodType = x;
		typeLabel.setText ( foodType );
		return;
		}

	void setAlcoholType ( String x )
		{
		alcoholType = x;
		return;
		}

	void setAlcoholBring ( String x )
		{
		alcoholBring = x;
		return;
		}

	void setRateFood ( int x )
		{
		rateFood = x;
		setRateOverall();
		return;
		}

	void setRateService ( int x )
		{
		rateService = x;
		setRateOverall();
		return;
		}

	void setRateAmbiance ( int x )
		{
		rateAmbiance = x;
		setRateOverall();
		return;
		}

	void setRateOverall ()
		{
		rateOverall = ( rateFood + rateService + rateAmbiance )/3;
		starLabel.setIcon( starsIcon[ rateOverall ] );
		return;
		}

	void setMealCost ( int x )
		{
		mealCost = x;
		return;
		}

	void setMealsServed ( String x )
		{
		mealsServed = x;
		return;
		}

	void setDressCode ( String x )
		{
		dressCode = x;
		return;
		}

	void setNoiseLevel ( String x )
		{
		noiseLevel = x;
		return;
		}

	void setKidFriendly ( boolean x)
		{
		kidFriendly = x;
		return ;
		}

	void setInBrief ( String x )
		{
		inBrief = x;
		return;
		}

	// Set up GUI
	public ResturantPanel()
		{
		//Label Window
		super( "Class Project: Resturant Review Program" );

		//Initialize Container
		container = getContentPane();
		container.setLayout( new FlowLayout() );

 		picturePanel = new JPanel();
 		namePanel = new JPanel();
 		locationPanel = new JPanel();
 		foodTypePanel = new JPanel();
 		ratingPanel = new JPanel();

		pictureLabel = new JLabel( );
		picturePanel.add( pictureLabel );

		nameLabel = new JLabel( );
		namePanel.add( nameLabel );

		locationLabel = new JLabel( );
		locationPanel.add( locationLabel );

		typeLabel = new JLabel( );
		foodTypePanel.add( typeLabel );

		starLabel = new JLabel( );
		ratingPanel.add( starLabel );


		container.add( picturePanel );
		container.add( namePanel );
		container.add( locationPanel );
		container.add( foodTypePanel );
		container.add( ratingPanel );



		// Temp displays. Only to show that they work

		setRestaurantName ( "Juipter Special" );

		setLocationStreet ( "111 Java Place" );
		setLocationCity ( "111 Java Town" );
		setLocationState ( "Group Land" );
		setLocation ( );

		setFoodType ( "Spacy" )
;

		setRateOverall ();

		setSize( 600, 400 );
		setVisible( true );
		}

   public static void main( String args[] )
      {
      ResturantPanel application = new ResturantPanel();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      }

} // end class ResturantPanel

