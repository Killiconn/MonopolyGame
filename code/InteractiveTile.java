import java.io.*;
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
			assert true;
		
		else if(tile_id == "Jail")
			assert true;
		
		else if(tile_id == "FreeParking")
			assert true;

		else if(tile_id == "GoToJail")
<<<<<<< HEAD
			player.changePosition(8);
=======
			player.changePosition(-this.posistion + 8);
>>>>>>> 2202e783d68382549845c05ec858c7f951dfc9e0
			player.setJailStatus(true);
	}

	public void passedGo(Player player)
	{
<<<<<<< HEAD
		player.changeBank(player.getBalance() + 200);
=======
		player.changeBank(200);
>>>>>>> 2202e783d68382549845c05ec858c7f951dfc9e0
	}
}
