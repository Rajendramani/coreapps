import java.util.Random;
import java.util.StringTokenizer;


public class Tokenizer 
{
	public static void main(String[] args)
	{
		//given two Strings
		String colors = "red|orange|yellow|green|blue|indigo|violet";
		String players = "John David Mike Jerry Sally Tina Jenni";
		
		StringTokenizer allColors = new StringTokenizer(colors, "\\|");
		while (allColors.hasMoreTokens())
		{
			System.out.println("COLOR: " + allColors.nextToken());
		}
		StringTokenizer allPlayers = new StringTokenizer(players);
		//needed later:
		int size = allPlayers.countTokens();
		while (allPlayers.hasMoreTokens())
		{
			System.out.println("PLAYER: " + allPlayers.nextToken());
		}
		
		boolean completed = false;
		String usedPlayers = "";
		String usedColors = "";
		Random r = new Random();

		int currentCreated = 0;
		PlayerColor[] playerColors = new PlayerColor[size];
		while (!completed)
		{
			boolean validPlayer = false;
			int nextPlayer = -1;
			String player = "";
			while (!validPlayer)
			{
				nextPlayer = r.nextInt(size);
				StringTokenizer usedPlayersTemp = new StringTokenizer(usedPlayers, "\\|");
				boolean isValid = true;
				if (usedPlayers.length() > 0)
				{
					while(usedPlayersTemp.hasMoreTokens())
					{
						if (Integer.parseInt(usedPlayersTemp.nextToken()) == nextPlayer)
						{
							isValid = false;
							break;
						}
					}
				}
				if (isValid)
				{
					validPlayer = true;
					usedPlayers = usedPlayers + nextPlayer + "|";
				}
			}
			
			allPlayers = new StringTokenizer(players);
			int index = 0;
			while (allPlayers.hasMoreTokens())
			{
				String s = allPlayers.nextToken();
				if (index == nextPlayer)
				{
					player = s;
				}
				index++;
			}
			 
			
			boolean validColor = false;
			int nextColor = -1;
			String color = "";
			while(!validColor)
			{
				nextColor = r.nextInt(size);
				StringTokenizer usedColorsTemp = new StringTokenizer(usedColors, "\\|");
				boolean isValid = true;
				if (usedColors.length() > 0)
				{
					while(usedColorsTemp.hasMoreTokens())
					{
						if (Integer.parseInt(usedColorsTemp.nextToken()) == nextColor)
						{
							isValid = false;
							break;
						}
					}
				}
				if (isValid)
				{
					validColor = true;
					usedColors = usedColors + nextColor + "|";
				}
			}
			allColors = new StringTokenizer(colors, "\\|");
			index = 0;
			while (allColors.hasMoreTokens())
			{
				String s = allColors.nextToken();
				if (index == nextColor)
				{
					color = s;
				}
				index++;
			}
			PlayerColor pc = new PlayerColor(player, color);
			playerColors[currentCreated++] = pc;
			if (currentCreated == size)
			{
				completed = true;
			}
		}
		for (PlayerColor pc : playerColors)
		{
			System.out.println("Next Player/Color combination: " + pc.toString());
		}
	}
}
