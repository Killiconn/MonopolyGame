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
<<<<<<< HEAD
		if(tile_id == "Go")
			assert true;
		
		else if(tile_id == "Jail")
			assert true;
		
		else if(tile_id == "FreeParking")
			assert true;

		else if(tile_id == "GoToJail")
=======
        if(tile_id == "GoToJail")
        {
>>>>>>> cdfdca56ca65325a3668a4bc437e13c73eab782b
			player.changePosition(-this.position + 8);
			player.setJailStatus(true);
        }
	}

}
