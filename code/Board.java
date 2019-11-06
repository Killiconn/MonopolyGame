public class Board
{
    private LinkTiles board;
    private PropertyGroup [] propGroups; // Eight property groups
    private String [] props;    // List of property names
    private String [] corners;  // List of corner tiles

    public Board()
    {
        // create board
        board = new LinkTiles();

        // Making property groups
        propGroups = new PropertyGroup [8];
        propGroups[0] = new PropertyGroup("Brown", 100);  // Colour, price
        propGroups[1] = new PropertyGroup("Grey", 200);
        propGroups[2] = new PropertyGroup("Pink", 300);
        propGroups[3] = new PropertyGroup("Orange", 400);
        propGroups[4] = new PropertyGroup("Red", 500);
        propGroups[5] = new PropertyGroup("Yellow", 600);
        propGroups[6] = new PropertyGroup("Khaki", 700);
        propGroups[7] = new PropertyGroup("Blue", 800);

        // create list of propert names
        props = new String [] {"b1","b2","b3","g1","g2","g3","p1","p2","p3","o1","o2","o3","r1","r2","r3","y1","y2","y3","k1","k2","k3","bl1","bl2","bl3"};

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

    public int numTiles()
    {
        return this.board.lengthList();
    }
}