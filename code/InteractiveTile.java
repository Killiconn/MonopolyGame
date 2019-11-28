aqimport java.io.*;
import java.util.*;

public class InteractiveTile implements Tile
{
	String tile_id;
	int position;

	public InteractiveTile(String tile_id, int position)
	{
		this.tile_id = "chanceCard";
		this.position = position;
	}

	public void landedOn(Player player) 
	{
		if(tile_id == "Go")
			;
		
		else if(tile_id == "Jail")
			;
		
		else if(tile_id == "FreeParking")
			;

		else if(tile_id == "GoToJail")
			player.changePosition(-this.position + 8);
			player.setJailStatus(true);
	}

	public void passedGo(Player player)
	{
		player.changeBank(200);
	}
}
