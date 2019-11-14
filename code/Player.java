import java.util.ArrayList;

public class Player
{
	String name;
	int position;
	int bank;
	ArrayList<Property> ownedProp;

	public Player(String name)
	{
		this.name = name;
		this.position = 0;
		this.bank = 15000;
		this.ownedProp = new ArrayList<Property>();
	}

	public void changePosition(int diceResult)
	{
		this.position = diceResult % 31;

	}

	public void changeBank(int change)
	{
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
		}
	}

	public void addProperty(Property prop)
	{
		this.ownedProp.add(prop);
	}

}