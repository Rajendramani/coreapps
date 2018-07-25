package ServerInterop;

public class MySQLOperations 
{
	/* TABLES */
	/**
	 * Get the query to Create a table
	 * @param tableName name of table
	 * @param fieldList List of [field_name] [TYPE] ([size]) <optional default/null/notnull/auto-increment>,
	 * @return query syntax to create the table 
	 */
	public static String CREATE_TABLE_QUERY(String tableName, String fieldList)
	{
		//%s (1) ==> Table Name
		//%s (2) --> List of [field_name] [TYPE] ([size]) <optional default/null/notnull/auto-increment>,
		return String.format("CREATE TABLE %s (%s) ENGINE=MyISAM"
								, tableName 
								, fieldList);
	}
	
	/**
	 * Get the query to drop a table
	 * @param tableName the table to drop
	 * @return Query syntax to drop a table
	 */
	public static String DELETE_TABLE_QUERY(String tableName)
	{
		//%s ==> Table Name
		return "DROP TABLE " + tableName;
	}
	
	/**
	 * Get the query to check if a table exists
	 * @param dbName the database schema
	 * @param tableName the table name
	 * @return the query to check for table existence
	 */
	public static String TABLE_EXISTS_QUERY(String dbName, String tableName)
	{
		//%s (1) --> db name
		//%s (2) --> table name
		return String.format(
				"SELECT count(*) as ExistsCount from information_schema.tables " +
				"WHERE table_schema = '%s' " + 
				"AND table_name = '%s'"
				, dbName
				, tableName);
	}
	/* END TABLES */
	
}
