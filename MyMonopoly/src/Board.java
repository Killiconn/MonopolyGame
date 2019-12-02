public class Board
{
    private LinkTiles board;
    private PropertyGroup [] propGroups; // Eight property groups
    private String [] props;    // List of property names
    private String [] corners;  // List of corner tiles
    private Player [] playersAlive;  // List of players

    public Board()
    {
        // create board
        board = new LinkTiles();

        // Making property groups
        propGroups = new PropertyGroup [8];
        propGroups[0] = new PropertyGroup("Nissan/Brown", 100);  // Colour, price
        propGroups[1] = new PropertyGroup("Kia/LightBlue", 200);
        propGroups[2] = new PropertyGroup("Opel/Pink", 300);
        propGroups[3] = new PropertyGroup("Toyota/Orange", 400);
        propGroups[4] = new PropertyGroup("Renault/Red", 500);
        propGroups[5] = new PropertyGroup("Volkswagen/Yellow", 600);
        propGroups[6] = new PropertyGroup("Ford/Green", 700);
        propGroups[7] = new PropertyGroup("McLaren/DarkBlue", 800);

        // create list of propert names
        props = new String [] {"Micra","Juke","Qashqai","C'eed","Rio","Sportage","Corsa","Astra","Insignia","Yaris","Prius","Corolla","Clio","Kadjar","Megane","Polo","Golf","Passat","Fiesta","Focus","Mondeo","Spider","GT","Speedtail"};

        // create list of corner tiles
        corners = new String [] {"Go", "Jail", "FreeParking", "GoToJail"};

        // First create all the Tile instances, gonna create a small board first as a POC
        // Board will consist of 24 properties, 4 corner tiles, 4 action tiles
        // So 32 tiles in all
        // Tiles 0, 8, 16, 24 are corner tiles
        // Tiles 4, 12, 20, 28 are Action Card tiles
        // Every other tile is a property
        
        Property temp;
        int index;
        for(int i=0; i<32; i++)
        {
            // Corner Tile Check
            if(i%8 == 0)
            {
                // Create InteractiveTile object and add it to board LinkTiles object
                board.add(new InteractiveTile(corners[i/8], i));  // tileName, position
            }

            // ActionCard check
            else if(i%4 == 0)
            {
                // Community Chest
                if((i/4)%2 == 0)
                {
                    board.add(new ActionCard("communityCard", i)); // tileName, position
                }

                else
                {
                    board.add(new ActionCard("chanceCard", i)); // tileName, position
                }
            }

            // Properties
            else
            {
                // get index of property in props
                // index will be 0 -> 23
                index = i - (i/4) - 1;

                // create property
                temp = new Property(props[index], propGroups[index/3], i); // name, propertyGroup, position

                // add property to property group and board
                // propGroups[index/3].addProperty(temp);
                board.add(temp);
            }
        }
    }

    public void begin(int numPlayers, int time)
    {
        this.setTime(time);
        playersAlive = new Player [numPlayers];
        for(int i=0; i<numPlayers; i++)
        {
            playersAlive[i] = new Player("Player_" + (i+1));
            System.out.println("Welcome, " + playersAlive[i].name);
        }
        this.startGame();
    }

    public int numTiles()
    {
        return this.board.lengthList();
    }

    public void setTime(int time)
    {
        return;
    }

    public void startGame()
    {
        int outcome;  // Dice roll outcome
        Dice dice = new Dice();
        Tile temp;
        Player p;
        int counter=0;
        // Run ten times just to show it working
        for(int j=0; j<1000; j++)
        {
            for(int i=0; i<playersAlive.length; i++)
            {
                p = playersAlive[i];                        // players Alive
                if(p != null)
                {
                    outcome = dice.roll();                  // Dice roll
                    if((p.position + outcome) > 32){p.changeBank(200);} // Passed on go
                    p.changePosition(outcome);              // change the players position
                    temp = this.board.getTile(p.position);  // get the tile the player landed on
                    temp.landedOn(p);                       // Invoke landedOn method in Tile

                    // Check if players are still alive
                    if(p.getBalance() <= 0)
                    {
                        // p.unmortgageAll();
                        System.out.print(p.name + ", you have ran out of money. Your properties have been mortgaged but it is not enough to bring you back from bankrupcty\n");
                        playersAlive[i] = null;
                    }

                    else
                    {
                        System.out.println(p.name + " : Money -> " + p.getBalance() + ", Position -> " + p.position + ", No. Properties -> " + p.ownedProp.size());
                    }

                    counter++;
                }
            }
            if(counter == 1){break;}
            
            counter = 0;
        }
        for(Player pp : playersAlive)
        {
            if(pp != null){System.out.println("The winner is " + pp.name);}
        }
        this.endGame();
    
    }

    public void endGame()
    {
        System.exit(0);
    }
}
