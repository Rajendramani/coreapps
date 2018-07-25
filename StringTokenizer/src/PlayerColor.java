
public class PlayerColor 
{
	private String _name;
	private String _color;
	
	public PlayerColor(String n, String c)
	{
		_name = n;
		_color = c;
	}
	
	public String toString()
	{
		return String.format("%s : %s"
				, _name, _color);
	}
}
