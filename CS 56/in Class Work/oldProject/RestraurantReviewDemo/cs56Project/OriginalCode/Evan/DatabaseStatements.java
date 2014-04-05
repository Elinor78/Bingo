  /*
 * CS56 Adv Java
 * Database class
 * Evan Littmann
 * LAST UPDATE: 5-21-07
 *
 * Purpose: Provide a database connection class capable of running the appropriate SQL queries for a restaurant review
 * program.
 *
 * NOTE: This class assumes all data has been checked before being passed to it!
 * 
 */
package edu.smc.cs56Project.database;
import java.sql.*;
import javax.swing.table.*;

public class DatabaseStatements extends AbstractTableModel
{
	static final String DRIVER = "com.mysql.jdbc.Driver"; // This needs to be changed
	static final String DBURL = "jdbc:mysql://localhost/restaurants?user=user&password=password";
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numRows;

	// maintains state of connection
	private boolean connectedToDB = false;

	// basic strings for queries
	private String query = "";
	private final String selQuery = "SELECT * FROM restaurants WHERE ";
	private final String updQuery = "UPDATE restaurants SET ";
	private final String insQuery = "INSERT INTO restaurants (name,address,cuisine,foodRat,serviceRat,ambianceRat,overallRat) VALUES ('Default','Default','Default',1,1,1,1)";
	private final String delQuery = "DELETE FROM restaurants WHERE ";

	// add these together to determine type of search
//	public final int FINDNAME 	= 1;
//	public final int FINDTYPE 	= 3;
//	public final int FINDCITY	= 5;
//	public final int FINDRATING = 7;

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
	public void find( /*int tos,*/ String values[] ) throws SQLException, IllegalStateException
	{
		if( !connectedToDB )
			throw new IllegalStateException( "Not connected" );

		query = selQuery;

		if( values[0] != null )
			query += "name=" + values[0];
		if( values[0] != null )
			query += "city=" + values[1];
		if( values[0] != null )
			query += "foodType=" + values[1];
		if( values[0] != null )
			query += "rating=" + values[3];

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