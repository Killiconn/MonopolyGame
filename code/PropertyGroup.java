import java.util.*;

public class PropertyGroup extends Property
{
	String colour;
	int groupPrice;
	ArrayList<Property> properties;


	public PropertyGroup(String colour, int groupPrice, ArrayList<Property> properties)
	{
		this.colour = colour;
		this.groupPrice = groupPrice;
		this.properties = new ArrayList<Property>();
	}

	public int getPrice()
	{

	}

	public void checkMonopoly()
	{
		for (Property prop : properties)
		{
			if (prop.propertyGroup == this.propertyGroup)
				this.rent = rent * 2;
			else
				continue;
		}
	}
}