package ServerInterop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager 
{
	Connection cn = null;
	ServerConnector scb = null;
	
	/**
	 * Default constructor.
	 */
	public DBManager()
	{
		//do nothing;
	}
	
	/**
	 * Construct with connection behavior.
	 * @param connectionBehavior
	 */
	public DBManager(ServerConnector connector)
	{
		//set the connector
		scb = connector;
	}
	
	/**
	 * Set the connection behavior.
	 * @param connectionBehavior
	 * @return true on success, else false
	 * @throws IllegalArgumentException if connectionBehavior is null
	 */
	public boolean setConnectionBehavior(ServerConnector connector)
	{
		if (connector == null)
		{
			throw new IllegalArgumentException("Server Connector cannot be null!");
		}
		scb = connector;
		return true;
	}
	
	/**
	 * Open a connection [note, must have first set the connection behavior object!]
	 * @return true on successful db open, else false;
	 * @throws IllegalStateException if the connection behavior is null
	 */
	public boolean openConnection()
	{
		try
		{
			if (scb == null) throw new IllegalStateException ("Cannot open connection without a defined connection behavior!");
			//make sure there isn't an active, open connection
			if (cn != null) closeConnection(false);
			cn = scb.getConnection();
		}
		catch (Exception ex)
		{
			//again, we should have better logging than this...
			ex.printStackTrace();
			return false;
		}
		
		if (cn == null) return false;
		return true;
	}
	
	/**
	 * Close the connection for the DBConnectionManager object
	 * @param keepAlive set to true if don't want to dispose connection object
	 * @return true on success, else false
	 */
	public boolean closeConnection(boolean keepAlive)
	{
		try
		{
			//if not null and open
			if (cn != null) 
			{
				if (!cn.isClosed())
				{
					//close it
					cn.close();
				}
			}
			if (!keepAlive)
			{
				cn = null;
			}
		}
		catch (Exception ex)
		{
			//again, we should have better logging than this...
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Check if manager is connected to an open connection:
	 * @return
	 */
	public boolean isConnected()
	{
		return cn != null;
	}
	
	/**
	 * Execute a statement that does not return a query result.
	 * @return
	 */
	public boolean ExecuteNonQuery(String query)
	{
		try
		{
			Statement st = null;
			st = cn.createStatement();
			int i = st.executeUpdate(query);
			if (i == -1){
				System.out.println("db error : " + query);
				return false;
			}
			st.close();
		}
		catch (Exception ex)
		{
			//again, we should have better logging than this...
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Get the tables from the schema in a query
	 * @return ResultSet containing database tables
	 */
	public ResultSet ExecuteRSGetTableSchema()
	{
		try 
		{
			PreparedStatement pst = cn.prepareStatement(GetTablesSchemaQuery());
			return pst.executeQuery();
		} 
		catch (SQLException e) 
		{
			// TODO Add better logging
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get the connection object for use outside of this manager
	 * @return connection
	 */
	public Connection GetConnection()
	{
		return cn;
	}
	
	/**
	 * Get the connection url based on the SCB
	 * @return
	 */
	public String GetConnectionURL()
	{
		return scb.getConnectionURL();
	}

	/**
	 * Return a query as a string that will get all the schema tables
	 * @return
	 */
	public String GetTablesSchemaQuery()
	{
		return scb.getTablesSchemaQuery();
	}
	
	/**
	 * Get the name of the db.
	 * @return name of the db.
	 */
	public String GetDBName()
	{
		return scb.getDBName();
	}
	
	/**
	 * Get the name of the server.
	 * @return name of the server.
	 */
	public String GetServerName()
	{
		return scb.getServername();
	}
	
	/**
	 * Get the name of the user.
	 * @return name of the user.
	 */
	public String GetUserName()
	{
		return scb.getUserName();
	}
}
