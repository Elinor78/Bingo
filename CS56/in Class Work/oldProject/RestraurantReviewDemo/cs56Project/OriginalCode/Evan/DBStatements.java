/*
 * CS56 Advanced Java
 * Class: Database class
 * Author(s): Evan Littmann
 * LAST UPDATE: 5-13-07
 *
 * Purpose: Provide a database connection class capable of running the appropriate SQL queries for a restaurant review
 * program.
 *
 * NOTE: This class assumes all data has been checked before being passed to it!
 */

package edu.smc.cs56Project.database;
import java.sql.*;

public class DBStatements
{
	static final String DRIVER = "jdbc.MySQL"; // This needs to be changed
	static final String DBURL = "localhost";
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	@SuppressWarnings("unused")
	private ResultSetMetaData metaData;
	@SuppressWarnings("unused")
	private int numRows;

	// maintains state of connection
	private boolean connectedToDB = false;

	// basic strings for queries
	private String query = "";
	private final String selQuery = "SELECT * FROM restaurants WHERE ";
	private final String updQuery = "UPDATE restaurants SET ";
	private final String insQuery = "INSERT INTO restaurants (name,city,rating,foodType) VALUES ('Default','Default',5,'Default')";
	private final String delQuery = "DELETE FROM restaurants WHERE ";

	// add these together to determine type of search
	public final int FINDNAME 	= 1;
	public final int FINDTYPE 	= 2;
	public final int FINDCITY	= 3;
	public final int FINDRATING = 4;

	/*
	 * Connect to database function should be called before running any queries
	 */
	public void connectToDB() throws ClassNotFoundException, SQLException
	{
		try
		{
			Class.forName( DRIVER );
		}
		catch( ClassNotFoundException cnf )
		{
			cnf.printStackTrace();
		}

		try
		{
			System.out.println("Connecting to database"); //debug
			connection = DriverManager.getConnection( DBURL );
			statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			connectedToDB = true;
			System.out.println("Connected to database"); //debug
		}
		catch( SQLException sql)
		{
			sql.printStackTrace();
		}
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

		switch(tos)
		{
			case 1: query += "name=" + values[0];
					break;
			case 2: query += "foodType=" + values[1];
					break;
			case 3: query += "city=" + values[2];
					break;
			case 4: query += "rating=" + values[3];
					break;
			case 5: query += "name=" + values[0] + "rating=" + values[3];
					break;
			case 6: query += "foodType=" + values[1] + "rating=" + values[3];
					break;
			case 7: query += "rating=" + values[3] + "city=" + values[2];
					break;
			case 8: query += "rating=" + values[3] + "city=" + values[2] + "name=" + values[0];
					break;
			case 9: query += "rating=" + values[3] + "city=" + values[2] + "foodType=" + values[1];
					break;
			default: query += "rating=" + values[3] + "city=" + values[2] + "foodType=" + values[1] + "name=" + values[0];
					 break;
		}

		try
		{
			System.out.println("Running query:" + query); //debug
			resultSet = statement.executeQuery( query );
			metaData = resultSet.getMetaData();
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
			System.out.println("Finished running query"); //debug
		}
		catch( SQLException sql )
		{
			sql.printStackTrace();
		}
	}
}