import java.util.*;
//weird
public class PropertyGroup
{
	String colour;
	int groupPrice;
	ArrayList<Property> properties;


	public PropertyGroup(String colour, int groupPrice)
	{
		this.colour = colour;
		this.groupPrice = groupPrice;
		this.properties = new ArrayList<Property>();
	}

	public int getPrice()
	{
		return 0;
	}

	public void addProperty(String name, PropertyGroup propertyGroup, int position)
	{

	}

	public void checkMonopoly()
	{
		for (Property prop : properties)
		{
			if (prop.propertyGroup.colour == this.colour)
				prop.rent = prop.rent * 2;
			else
				continue;
		}
	}
}