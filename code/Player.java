import java.util.ArrayList;

public class Player
{
	String name;
	int position;
	int bank;
	ArrayList<Property> ownedProp;
	Boolean jailStatus;

	public Player(String name)
	{
		this.name = name;
		this.position = 0;
		this.bank = 15000;
		this.ownedProp = new ArrayList<Property>();
		this.jailStatus = false;
	}

	public void changePosition(int diceResult)
	{
		//check if player is in jail
		if (this.getJailStatus() != true)
		{
			this.position = (this.position + diceResult) % 31;
		}
		else
		{
			this.setJailStatus(false);
		}
	}

	public void changeBank(int change)
	{
		//checks to make sure above 0
		//if not, mortgage
		//check if props are already mortgaged
		//check if player is in jail
		this.bank = this.bank + change;
	}

	public int getBalance()
	{
		return this.bank;
	}

	public void mortgageProps()
	{
		for (Property prop: ownedProp)
		{
			this.bank = this.bank + (prop.price / 2);
			//balance return int
			//release properties to be available to buy?
			// call Property.mortgage()
		}
	}

	public void addProperty(Property prop)
	{
		this.ownedProp.add(prop);
	}

	public Boolean setJailStatus(Boolean bool)
	{
		this.jailStatus = bool;
	}

	public Boolean getJailStatus()
	{
		return this.jailStatus;
	}

}