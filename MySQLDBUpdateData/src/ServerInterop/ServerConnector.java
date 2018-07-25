package ServerInterop;
import java.sql.Connection;

public interface ServerConnector 
{
	Connection getConnection();
	String getConnectionURL();
	String getConnectionDetails();
	String getTablesSchemaQuery();
	String getDBName();
	String getServername();
	String getUserName();
}
