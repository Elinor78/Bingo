// ResturantPanel.java
// A customized JPanel class thatwill be used to store and
// display review information

import java.awt.*;
import javax.swing.*;

public class ResturantPanel extends JPanel
	{
	// Define all storage variables

	// Identification Number
	private int ID;

	// Names
	private String restaurantName;
	private String chefName;

	// Location Strings to store data
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
		return;
		}

	void setChefName ( String x )
		{
		chefName = x;
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
} // end class ResturantPanel

