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

    public Property(String name, PropertyGroup propertyGroup, int position)
    {
        this.name = name;
        this.price = price;
        this.propertyGroup = propertyGroup;
        this.owner = owner;
        this.status = status;
        this.position = position;
        this.rent = rent;
    }

    public void optionToBuy(Player currentPlayer)
    {
        int balance = currentPlayer.getBalance();
        int newBalance = balance - this.price;

        currentPlayer.changeBank(newBalance);

        this.status = true;
        currentPlayer.addProperty(this);
        this.owner = currentPlayer;
        checkMono();
    }

    public void getBought(Player currentPlayer)
    {
        System.out.println("Would you like to buy this property? [Yes/No]");
        Scanner in = new Scanner(System.in);
        String answer = in.next();
        answer = answer.toLowerCase();
        String yes = "yes";
        String no = "no";

        while (true)
        {
            if (answer.equals(yes) && currentPlayer.getBalance() > this.price)
            {
                optionToBuy(currentPlayer);
                break;
            }
            else if (answer.equals(no))
            {
                break;
            }
            else if (!(answer.equals(yes) || answer.equals(no)))
            {
                System.out.println("Would you like to buy this property? [Yes/No] - Please enter Yes or No");
                answer = in.next();
                answer = answer.toLowerCase();
            }
            else
            {
                System.out.println("You do not have enough funds!");
                break;
            }
        }

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

    public void landedOn(Player currentPlayer)
    {
        if (this.status == true) // true == bought, false == available
        {
            int ownersBal = this.owner.getBalance();
            int otherBal = currentPlayer.getBalance();
            
            int newBal = ownersBal + this.rent;
            this.owner.changeBank(newBal);
            
            int otherNewBal = otherBal - this.rent;
            currentPlayer.changeBank(otherNewBal);
        }
        else
            getBought(currentPlayer);
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
