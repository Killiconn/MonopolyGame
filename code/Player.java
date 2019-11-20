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
		{	//skip one turn 
			this.setJailStatus(false);
		}
	}

	public void changeBank(int change)
	{

		if (this.getJailStatus() == false)
		{

			int proposedBalance = this.getBalance() + change;
			if (proposedBalance < 0)
			{
				//check if mortgaging is possible
				if ((this.ownedProp.size() > 0) && !(this.ownedProp.get(0).rent == 0))
				{
					//mortgage
					this.mortgageProps();

					if ((this.getBalance() + change) > 0)
					{
						this.bank = this.bank + change;
					}

					else
					{
						//bitch you dead
						//ask bill to include a removePlayer method
						System.out.println("bitch you dead");
					}
				}

				else
				{
					//bitch you still dead
					System.out.println("bitch you dead");
				}

			}

			else
			{
				this.bank = this.bank + change;
			}
		}
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
			// call Property.mortgage()
			prop.mortgage();
		}
	}

	public void addProperty(Property prop)
	{
		this.ownedProp.add(prop);
	}

	public void setJailStatus(Boolean bool)
	{
		this.jailStatus = bool;
	}

	public Boolean getJailStatus()
	{
		return this.jailStatus;
	}

}