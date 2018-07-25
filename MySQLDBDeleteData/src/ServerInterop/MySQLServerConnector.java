package ServerInterop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import org.json.JSONObject;

public class MySQLServerConnector implements ServerConnector
{
	private final String FORNAME = "com.mysql.jdbc.Driver";
	private final String CONSTRFORMAT = "jdbc:mysql://%s/%s?user=%s&password=%s";
	private String _serverName;
	private String _dbName;
	private String _userName;
	private String _password;
	
	public MySQLServerConnector(String path, String dbconnectionkey) throws IOException
	{
		if (path == null || path.length() == 0) 
			throw new IllegalArgumentException("Must include a valid path");
		if (dbconnectionkey == null || dbconnectionkey.length() == 0) 
			throw new IllegalArgumentException("Must include a valid db connection key");
		
		//read the file
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String nextLine;
		StringBuilder sb = new StringBuilder();
		while ((nextLine = br.readLine()) != null)
		{
			sb.append(nextLine);
		}
		
		if (br != null) {
			br.close();
			br= null;
		}
		
		if (fr != null){ 
			fr.close();
			fr = null;
		}
		
		//set up connection
		JSONObject obj = new JSONObject(sb.toString());
		_serverName = obj.getJSONObject(dbconnectionkey).getString("server");
		_dbName = obj.getJSONObject(dbconnectionkey).getString("database");
		_userName = obj.getJSONObject(dbconnectionkey).getString("username");
		_password = obj.getJSONObject(dbconnectionkey).getString("password");
	}
	

	
	@Override
	public Connection getConnection() {
		try {
			Class.forName(FORNAME);
			Connection cn = DriverManager.getConnection(getConnectionURL());
			return cn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getConnectionURL() {
		return String.format(CONSTRFORMAT
				, _serverName
				, _dbName
				, _userName
				, _password);
	}

	@Override
	public String getConnectionDetails() {
		return String.format("MySQL Database: %s:%s attempting connection as %s\n"
				, _serverName
				, _dbName
				, _userName);
	}
	
	@Override
	public String getTablesSchemaQuery() {
		return String.format("select table_name from information_schema.tables "
								+ "where table_schema = '%s'", _dbName);
	}

	@Override
	public String getDBName()
	{
		return _dbName;
	}
	
	@Override
	public String getServername()
	{
		return _serverName;
	}
	
	@Override
	public String getUserName()
	{
		return _userName;
	}
}
