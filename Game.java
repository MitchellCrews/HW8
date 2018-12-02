import javax.swing.*; // allows us to use JOptionPane if we need it


public class Game
{ 
    private static int total = 0; // Keeps track of total solutions

    public static void main(String[] args)
    { 
        Piece game[] = new Piece[15];

        SetUp(game, 0); // top of triangle will be open
        Play(game, ""); // Plays the game
        System.out.println("Complete: " + total + " total solutions."); // show the user that we are done
    }
    
    // Plays the game and prints progress
    private static void Play(Piece g[], String s)
    { 
        Piece game[] = CopyGame(g); // create a copy of the board so we don't change the original
        Piece copy[]; // another copy for later
        
        if (Won(game))
        {
			System.out.println (s + " " + total);
            // we won
            total++;
        }
        
        if (Stuck(game)) // check if we are stuck
        {
            return;
        }
        
        // loop through the Pieces
        for (int p = 0; p < game.length; p++)
        { 
            // loop through each Piece's moves
            for (int m = 0; m < game[p].getTotal(); m++)
            {               
                if (ValidMove(game, p, m))
                { 
                    String temp = s; // temp copy of s
                    copy = CopyGame(game); // copy of game so we don't change original

                    s += p + "|" + game[p].getMoves(m) + " "; //move
                    
                    Play(MakeMove(CopyGame(game), p, m), s); // Play after move
                                        
                    s = temp; // restore previous string
                    game = CopyGame(copy); // restore previous gamestate
                }
            }
        }
    }
    
    // this function returns the string version of the game board
    // 1 means the space is occupied, 0 means the space is open
    private static String PrintGame(Piece game[])
    {
        String output = ""; 
        
        for (int c = 0; c < game.length; c++) // loop through pieces
        { 
            if (game[c].OccupiedSpace())
                output += "1 ";
            else
                output += "0 ";
        }
        
        return output;
    }
    
    // return true if the game is stuck (no moves left), false otherwise
    private static boolean Stuck(Piece game[])
    {
        for (int c = 0; c < game.length; c++) // loop through pieces
               for (int d = 0; d < game[c].getTotal(); d++) // loop through each piece's moves
                    if (ValidMove(game, c, d))
                        return false;
                        
        return true;
    } 
    
    // return true if the game is solved, false otherwise
    private static boolean Won(Piece game[])
    {
        int remaining = 0;
        
        // check to see how many pieces are still left
        for (int c = 0; c < game.length; c++)
        {
            if (game[c].OccupiedSpace())
                remaining++;
        }
        
        return (remaining == 1); // if 1 piece remains, we won. If not then this game is the French Military w/out Napoleon
    }
    
    // makes this run's m-th move
    private static Piece[] MakeMove(Piece g[], int p, int m)
    {
        Piece game[] = CopyGame(g); // create copy of g so we don't change it
        
        // make sure this is a ValidMove just in case
        if (ValidMove(game, p, m))
        {
            game[game[p].getMoves(m)].NewPos(1); // add piece to destination
            game[game[p].Middle(m)].Remove(); // move jumped piece off the board
            game[p].Remove(); // get rid of piece that moved
        }
        
        return game; // return new board
    }
    
    // true if this is a valid move, false otherwise
    private static boolean ValidMove(Piece g[], int p, int m)
    {
        Piece game[] = CopyGame(g); // create a copy of g so we don't change it
        
        if (game[p].OccupiedSpace()) // make sure the piece is still in play
            if (!game[game[p].getMoves(m)].OccupiedSpace()) // destination is empty
                if (game[game[p].Middle(m)].OccupiedSpace()) // middle is occupied
                    return true; // valid move
        
        return false; // invalid move
    }
    
    // This function returns a copy of the parameter
    public static Piece[] CopyGame (Piece game[])
    {
        Piece to[] = new Piece[game.length];
        SetUp(to, 0); // set the array up w/ moves, middle and total
        
        for (int c = 0; c < game.length; c++) // loop through the pieces in the parameter
        {
            to[c].SetTo(game[c]); // set the piece's values to the same as in parameter
        }
        
        return to;
    }
    
    // set the game up
    private static void SetUp(Piece game[], int open)
    {
        for (int c = 0; c < game.length; c++) // loop through pieces
        {
            game[c] = new Piece(c); // create the new pieces
        }
        
        game[open].Remove(); // remove the piece that isn't in use
    }
} // end Game class 
