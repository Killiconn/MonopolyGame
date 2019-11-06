import java.util.*;
//weird
public class Property implements Tile
{
    String name;
    int price;
    PropertyGroup propertyGroup;
    Player owner;
    Boolean status = false;
    int position;
    int rent;

    public Property()
    {
        this.name = name;
        this.price = price;
        this.propertyGroup = propertyGroup;
        this.owner = owner;
        this.status = status;
        this.position = position;
        this.rent = rent;
    }

    public void setToBought(Player player)
    {
        int balance = player.getBalance();
        int newBalance = balance - this.price;

        player.changeBank(newBalance);

        this.status = true;
        player.addProperty(this);
        this.owner = player;
        checkMono();
    }

    public Boolean getBought(Player otherPlayer)
    {
        if (this.status == true) // true == bought, false == available
        {
            int ownersBal = this.owner.getBalance();
            int otherBal = otherPlayer.getBalance();
            
            int newBal = ownersBal + this.rent;
            this.owner.changeBank(newBal);
            
            int otherNewBal = otherBal - this.rent;
            otherPlayer.changeBank(otherNewBal);
            
            return true;
        }
        else
            setToBought(otherPlayer);

        return false;

    }

    public int getPrice()
    {
        return this.price;
    }

    public void mortgage()
    {
        this.rent = 0;
    }

    public void unmortgage()
    {
        this.rent = rent;
    }

    public void landedOn(Player player)
    {
        getBought(player);
    }

    public void checkMono()
    {
        int count = 0;
        for (Property prop : this.owner.ownedProp)
        {
            if (prop.propertyGroup == this.propertyGroup)
                count = count + 1;
        }

        if (count == 3)
            this.propertyGroup.checkMonopoly();
    }
}
