import java.io.*;
import java.util.*;

public class ActionCard extends Tile
{
	String tile_id;
	int position;
	File chance = new File("/home/killian/Documents/thirdyear/CA314/ca314-monoply/code/chance.txt");
	File communityChest = new File("/home/killian/Documents/thirdyear/CA314/mytest/community.txt");
	
	Random rand = new Random();

	public ActionCard()
	{
		this.tile_id = tile_id;
		this.position = position;
		this.chance = chance;
		this.communityChest = communityChest;
	}

	public static void landedOn(Player player)
	{
		if(tile_id == "chanceCard")
			chanceOutcome(player);
		else
			communityOutcome(player);
	}

	public void chanceOutcome(Player player) throws FileNotFoundException
	{
		ArrayList<String> listofChance = new ArrayList<String>(); //Make a list of all outcomes in the file
		Scanner chanceScan = new Scanner(chance); 
		int lineinFile = rand.nextInt(15); //16 lines in each of the files
		
		while (chanceScan.hasNextLine())
		{
			listofChance.add(chanceScan.nextLine()); //add all to list because you cant just get a random line from a file
		}
		chanceScan.close();
		
		String randomChance = listofChance.get(lineinFile); //your outcome for the GUI


		if(lineinFile == 0)//Advance to Go (Collect $200)
		{
			player.changeBank(player.getBalance() + 200);
			player.changePosistion(0);
		}
		else if(lineinFile == 1)//Advance to *** —If you pass Go, collect $200
		{
			player.changePosistion("Where ever we want???") //i choose 8
			if(position > 8)
				player.changeBank(player.getBalance() + 200)
		}


	}
	public void communityOutcome(Player player) throws FileNotFoundException
	{
		ArrayList<String> listofCommunity = new ArrayList<String>();//List of all possible outcomes for community
		Scanner communityScan = new Scanner(communityChest);
		int lineinFile = rand.nextInt(15);

		if(tile_id == "communityCard")
		{
			while (communityScan.hasNextLine())
			{
    			listofCommunity.add(communityScan.nextLine());
			}
			communityScan.close();
			//String randomChance = listofCommunity.get(lineinFile);
			//System.out.println(randomChance);
		}
	}
}