import java.io.*;
import java.util.*;

public class ActionCard implements Tile
{
	String tile_id;
	int position;
	File chance = new File("chance.txt");
	File communityChest = new File("community.txt");
	
	Random rand = new Random();

	public ActionCard(String tile_id, int position)
	{
		this.tile_id = "chanceCard";
		this.position = position;
		this.chance = chance;
		this.communityChest = communityChest;
	}

	public void landedOn(Player player) 
	{
		if(tile_id == "chanceCard")
			chanceOutcome(player);
		else
			communityOutcome(player);
	}

	public void chanceOutcome(Player player) 
	{
		int lineinFile = rand.nextInt(11); //12 lines in each of the files
		ArrayList<String> listofChance = new ArrayList<String>(); //Make a list of all outcomes in the file
		try
		{
			Scanner chanceScan = new Scanner(chance); 
			
			while (chanceScan.hasNextLine())
			{
				listofChance.add(chanceScan.nextLine()); //add all to list because you cant just get a random line from a file
			}
			chanceScan.close();
		}
		catch (FileNotFoundException ex)
		{
		}
		
		String randomChance = listofChance.get(lineinFile); //your outcome for the GUI


		if(lineinFile == 0)//Advance to Go (Collect $200)
		{
			player.changeBank(player.getBalance() + 200);
			player.changePosition(0);
		}

		else if(lineinFile == 1)//Advance to *** —If you pass Go, collect $200
		{
			player.changePosition(10); 
			if(position > 10)
				player.changeBank(player.getBalance() + 200);
		}

		else if(lineinFile == 2)//Advance to *** – If you pass Go, collect $200
		{
			player.changePosition(18); 
			if(position > 18)
				player.changeBank(player.getBalance() + 200);
		}

		else if(lineinFile == 3)//Bank pays you dividend of $50
		{
			player.changeBank(player.getBalance() + 50);
		}

		else if(lineinFile == 4)//Go Back 3 Spaces
		{
			player.changePosition(position - 3);
		}

		else if(lineinFile == 5)//Go to Jail–Go directly to Jail–Do not pass Go, do not collect $200
		{
			player.changePosition(8);
		}

		else if(lineinFile == 6)//Make general repairs on all your property–For each house pay $25–For each hotel $100
		{
			player.changeBank(player.getBalance() - (player.ownedProp.size() * 25));
		}

		else if(lineinFile == 7)//Pay poor tax of $15
		{
			player.changeBank(player.getBalance() - 15);
		}

		else if(lineinFile == 8)//Take a trip to Reading Railroad–If you pass Go, collect $200
		{
			player.changePosition(26); 
			if(position > 26)
				player.changeBank(player.getBalance() + 200);
		}

		else if(lineinFile == 9)//Your building and loan matures—Collect $150
		{
			player.changeBank(player.getBalance() + 150);
		}
		
		else if(lineinFile == 10)//You have won a crossword competition—Collect $100
		{
			player.changeBank(player.getBalance() + 100);
		}

		else if(lineinFile == 11)//You inherit $100
		{
			player.changeBank(player.getBalance() + 100);
		}
	}


	public void communityOutcome(Player player)
	{
		int lineinFile = rand.nextInt(11);
		ArrayList<String> listofCommunity = new ArrayList<String>();//List of all possible outcomes for community
		try
		{
			Scanner communityScan = new Scanner(communityChest);

			while (communityScan.hasNextLine())
			{
				listofCommunity.add(communityScan.nextLine());
			}
			communityScan.close();
		}
		catch (FileNotFoundException ex)
		{
		}
		
		String randomCommunity = listofCommunity.get(lineinFile);

		if(lineinFile == 0)//Advance to Go (Collect $200)
		{
			player.changeBank(player.getBalance() + 200);
			player.changePosition(0);
		}
		
		else if(lineinFile == 1)//Advance to Illinois Ave—If you pass Go, collect $200
		{
			player.changeBank(player.getBalance() + 150);
		}

		else if(lineinFile == 2)//Bank error in your favor—Collect $200
		{
			player.changeBank(player.getBalance() + 150);
		}

		else if(lineinFile == 3)//Doctor's fee—Pay $50
		{
			player.changeBank(player.getBalance() - 50);
		}

		else if(lineinFile == 4)//Go to Jail–Go directly to jail–Do not pass Go–Do not collect $200
		{
			player.changePosition(8);
		}

		else if(lineinFile == 5)//Holiday Fund matures—Receive $100
		{
			player.changeBank(player.getBalance() + 100);
		}

		else if(lineinFile == 6)//Income tax refund–Collect $20
		{
			player.changeBank(player.getBalance() + 20);
		}

		else if(lineinFile == 7)//Life insurance matures–Collect $100
		{
			player.changeBank(player.getBalance() + 100);
		}

		else if(lineinFile == 8)//Pay hospital fees of $100
		{
			player.changeBank(player.getBalance() - 100);
		}

		else if(lineinFile == 9)//Pay school fees of $150
		{
			player.changeBank(player.getBalance() - 150);
		}

		else if(lineinFile == 10)//You are assessed for street repairs–$40 per house
		{
			player.changeBank(player.getBalance() - (player.ownedProp.size() * 40));
		}

		else if(lineinFile == 11)//You have won second prize in a beauty contest–Collect $10
		{
			player.changeBank(player.getBalance() + 10);
		}
	}
}