package edu.smc.cs56Project.database;
/*
 * CS56 Adv Java
 * Database class
 * Evan Littmann
 * LAST UPDATE: 5-26-07
 *
 * Purpose: Provide a database connection class capable of running the appropriate SQL queries for a restaurant review
 * program.
 *
 * NOTE: This class assumes all data has been checked before being passed to it!
 */

import java.sql.*;
import javax.swing.table.*;
import edu.smc.cs56Project.patterns.*;

public class dbstatements3 extends AbstractTableModel implements Subject, Observer
{
	static final String DRIVER = "com.mysql.jdbc.Driver"; // This needs to be changed
	static final String DBURL = "jdbc:mysql//localhost/restaurants?user=user&password=password";
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numRows;

	// maintains state
	private boolean connectedToDB = false;
//	private boolean addAnd = false;

	// basic strings for queries
	private String query = "";
	private final String selQuery = "SELECT * FROM restaurants WHERE ";
	private final String updQuery = "UPDATE restaurants SET ";
	private final String insQuery = "INSERT INTO restaurants (name,address,cuisine,foodRat,serviceRat,ambianceRat,overallRat) VALUES ('Default','Default','Default',1,1,1,1)";
	private final String delQuery = "DELETE FROM restaurants WHERE ";

	// values for columns
	private String name;
	private String chef;
	private String address;
	private String city;
	private String state;
	private int zip;
	private float foodRat;
	private float serviceRat;
	private float ambianceRat;
	private float overallRat;
	private String cuisine;
	private String phone;
	private String fax;
	private String website;
	private String email;
	private String review;

	/*
	 * Connect to database function should be called before running any queries
	 */
	public void connectToDB() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException
	{
		try
		{
			Class.forName( DRIVER ).newInstance();
		}
		catch( ClassNotFoundException cnf )
		{
			cnf.printStackTrace();
		}
		catch( IllegalAccessException iae )
		{
			iae.printStackTrace();
		}
		catch( InstantiationException ie )
		{
			ie.printStackTrace();
		}

		try
		{
			System.out.println("Connecting to database"); //debug
			connection = DriverManager.getConnection( DBURL );
			statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
			connectedToDB = true;
			System.out.println("Connected to database"); //debug
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	/*
	 * The following three methods were borrowed from Adam Olsen's code
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
    public int getRowCount() throws IllegalStateException {
        if (!connectedToDB)
            throw new IllegalStateException("Connection to database failed.");

        return numRows;
    }

    public int getColumnCount() throws IllegalStateException {
        if (!connectedToDB)
            throw new IllegalStateException("Connection to database failed.");

        try{
            return metaData.getColumnCount();
        }

        catch(SQLException exSQL){
            exSQL.printStackTrace();
        }

        return 0;
    }

    public Object getValueAt(int row, int column) throws IllegalStateException {
        if (!connectedToDB)
            throw new IllegalStateException("Connection to database failed.");

        try{
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        }

        catch(SQLException exSQL){
            exSQL.printStackTrace();
        }

        return "";
    }

	/*
	 * Disconnect from database function can be called after one or many queries are run
	 */
	public void disconnectFromDB() throws SQLException
	{
		try
		{
			System.out.println("Closing database connection"); //debug
			statement.close();
			connection.close();
			System.out.println("No longer connected to database"); //debug
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}
		finally
		{
			connectedToDB = false;
		}
	}

	/*
	 * Generic search function should have array of values to search for and search type passed to it
	 * values[] should always be a four element array in the following order: name, foodType, city, rating
	 * See comment at the top for how to use tos integer
	 */
	public void find( int tos, String values[] ) throws SQLException, IllegalStateException
	{
		if( !connectedToDB )
			throw new IllegalStateException( "Not connected" );

		query = selQuery;

		// build sql query here

		try
		{
			System.out.println("Running query:" + query); //debug
			resultSet = statement.executeQuery( query );
			metaData = resultSet.getMetaData();
			numRows = resultSet.getRow();
			System.out.println("Finished running query"); //debug
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}
	}

	/*
	 * Generic record updating function which should have the column names and new values passed in as arrays of equal length
	 * The record number to change should be passed in via id
	 */
	public void updateEntry( int id, String cols[], String changes[] ) throws SQLException, IllegalStateException
	{
		if( !connectedToDB )
			throw new IllegalStateException( "Not connected" );

		query = updQuery;
		for( int i = 0; i < cols.length; i++ )
		{
			query += cols[i] + "=" + changes[i];
			if( i != (cols.length - 1) )
				query += ",";
		}

		try
		{
			System.out.println("Running query:" + query); //debug
			resultSet = statement.executeQuery( query );
			metaData = resultSet.getMetaData();
			numRows = resultSet.getRow();
			System.out.println("Finished running query"); //debug
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}
	}

	/*
	 * New entry function
	 */
	public void newEntry() throws SQLException, IllegalStateException
	{
		if( !connectedToDB )
			throw new IllegalStateException( "Not connected" );

		query = insQuery;

		try
		{
			System.out.println("Running query:" + query); //debug
			resultSet = statement.executeQuery( query );
			metaData = resultSet.getMetaData();
			numRows = resultSet.getRow();
			System.out.println("Finished running query"); //debug
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}
	}

	/*
	 * Delete function:
	 * Pass in id # of record to delete
	 */
	public void delEntry( int id ) throws SQLException, IllegalStateException
	{
		if( !connectedToDB )
			throw new IllegalStateException( "Not connected" );

		query = delQuery;
		query += "id=" + id;

		try
		{
			System.out.println("Running query:" + query); //debug
			resultSet = statement.executeQuery( query );
			metaData = resultSet.getMetaData();
			numRows = resultSet.getRow();
			System.out.println("Finished running query"); //debug
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}
	}

	/*
	 * Select all function
	 */
	public void giveMeAll() throws SQLException, IllegalStateException
	{
		if( !connectedToDB )
			throw new IllegalStateException( "Not connected" );

		query = selQuery;
		query += "1=1";

		try
		{
			System.out.println("Running query:" + query); //debug
			resultSet = statement.executeQuery( query );
			metaData = resultSet.getMetaData();
			numRows = resultSet.getRow();
			System.out.println("Finished running query"); //debug
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}
	}

	/*
	 * Getter and setter methods
	 */

	public String getAddress() throws SQLException
	{
		try
		{
			address = resultSet.getString("address");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return address;
	}

	public void setAddress(String add) throws SQLException
	{
		try
		{
			resultSet.updateString("address", add );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public float getAmbianceRat() throws SQLException
	{
		try
		{
			ambianceRat = resultSet.getFloat("ambianceRat");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return ambianceRat;
	}

	public void setAmbianceRat(float ambianceRat) throws SQLException
	{
		try
		{
			resultSet.updateFloat("ambianceRat", ambianceRat);
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getChef() throws SQLException
	{
		try
		{
			chef = resultSet.getString("chef");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return chef;
	}

	public void setChef(String chef) throws SQLException
	{
		try
		{
			resultSet.updateString("chef", chef);
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getCity() throws SQLException
	{
		try
		{
			city = resultSet.getString("city");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return city;
	}

	public void setCity(String city) throws SQLException
	{
		try
		{
			resultSet.updateString("city", city );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getCuisine() throws SQLException
	{
		try
		{
			cuisine = resultSet.getString("cuisine");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return cuisine;
	}

	public void setCuisine(String cuisine) throws SQLException
	{
		try
		{
			resultSet.updateString("cuisine", cuisine );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getEmail() throws SQLException
	{
		try
		{
			email = resultSet.getString("email");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return email;
	}

	public void setEmail(String email) throws SQLException
	{
		try
		{
			resultSet.updateString("email", email );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getFax() throws SQLException
	{
		try
		{
			fax = resultSet.getString("fax");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return fax;
	}

	public void setFax(String fax) throws SQLException
	{
		try
		{
			resultSet.updateString("fax", fax );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public float getFoodRat() throws SQLException
	{
		try
		{
			foodRat = resultSet.getFloat("foodRat");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return foodRat;
	}

	public void setFoodRat(float foodRat) throws SQLException
	{
		try
		{
			resultSet.updateFloat("foodRat", foodRat);
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getName() throws SQLException
	{
		try
		{
			name = resultSet.getString("name");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return name;
	}

	public void setName(String name) throws SQLException
	{
		try
		{
			resultSet.updateString("name", name);
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public float getOverallRat() throws SQLException
	{
		try
		{
			overallRat = resultSet.getFloat("overallRat");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return overallRat;
	}

	public void setOverallRat(float overallRat) throws SQLException
	{
		try
		{
			resultSet.updateFloat("overallRat", overallRat);
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getPhone() throws SQLException
	{
		try
		{
			phone = resultSet.getString("phone");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return phone;
	}

	public void setPhone(String phone) throws SQLException
	{
		try
		{
			resultSet.updateString("phone", phone );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getReview() throws SQLException
	{
		try
		{
			review = resultSet.getString("review");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return review;
	}

	public void setReview(String review) throws SQLException
	{
		try
		{
			resultSet.updateString("review", review );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public float getServiceRat() throws SQLException
	{
		try
		{
			serviceRat = resultSet.getFloat("serviceRat");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return serviceRat;
	}

	public void setServiceRat(float serviceRat) throws SQLException
	{
		try
		{
			resultSet.updateFloat("serviceRat", serviceRat);
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getState() throws SQLException
	{
		try
		{
			state = resultSet.getString("state");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return state;
	}

	public void setState(String state) throws SQLException
	{
		try
		{
			resultSet.updateString("state", state );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public String getWebsite() throws SQLException
	{
		try
		{
			website = resultSet.getString("website");
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}

		return website;
	}

	public void setWebsite(String website) throws SQLException
	{
		try
		{
			resultSet.updateString("website", website );
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
	}

	public int getZip() throws SQLException
	{
		try
		{
			zip = resultSet.getInt("zip");
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}

		return zip;
	}

	public void setZip(int zip) throws SQLException
	{
		try
		{
			resultSet.updateInt("zip", zip);
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}
	}

    public void notifyObservers()
    {
        // TODO Auto-generated method stub
        
    }

    public void registerObserver( Observer o )
    {
        // TODO Auto-generated method stub
        
    }

    public void removeObserver( Observer o )
    {
        // TODO Auto-generated method stub
        
    }

    public void update( Subject s, Object arg )
    {
        // TODO Auto-generated method stub
        
    }
}