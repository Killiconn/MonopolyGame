import java.util.*;
public class Runner
{
    public static void main(String [] args)
    {
        Board board = new Board();
        // args will contain two things, 1. How many players are playing 2. How many minutes the game will run for
        //int numPlayers = Integer.parseInt(args[0]);
        //int timeLength = Integer.parseInt(args[1]);
        //board.begin(numPlayers, time);
        System.out.println(board.numTiles());
    }
}