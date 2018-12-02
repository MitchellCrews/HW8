public class Piece
{ // start class Piece
    private static final int REMOVED = -1; // final so that it the REMOVED value is always the same
    private int place; // determines whether or not it is in use (could be a boolean, but i'm lazy)

    private int moves[]; // all the pieces moves
    private int middle[]; // all middle pieces for each move
    private int total;   // number of moves and middle pieces
    
    public Piece() // no args constructer
    { // start constructor
        place = 1; 
        moves = new int[4]; 
        middle = new int[4]; 
        total = 0; 
    } // end constructor
    
    public Piece(int x) // int arg constructor
    { 
        place = x; // set the place equal to the param
        SetMoves(); // set up the piece's moves
    } // end constructor
    
    // this function returns the piece that is the middle of a jump
    public int Middle(int m)
    {
        return middle[m];
    }
    
    // this function returns the value of the piece's place
    public int getPlace()
    { 
        return place; 
    } 
    
    // this function returns the piece that is the end of jump
    public int getMoves(int m)
    { 
        return moves[m]; 
    } 
    
    // returns the total number of moves for this piece
    public int getTotal()
    { 
        return total; 
    } 
    
    // this function sets this Piece equal to P
    public void SetTo(Piece p)
    { 
        this.place = p.place; 
    } 
    
    // return true if the piece is still in play, false otherwise
    public boolean OccupiedSpace() // in bounds -1 < x < 15
    { 
        return ((place >= 0) && (place < 15)); 
    } 
    
    // changes the pieces place
    public void NewPos(int x)
    { 
        place = x; 
    } 
    
    // sets the pieces value to -1 (ie off the board)
    public void Remove()
    { 
        place = REMOVED; 
    } 
    
    // sets this pieces moves, middle, and total moves values
    public void SetMoves()
    { 
        int[] moves = new int[4]; // array that will hold the moves for this piece
		int[] middle = new int[4]; // array that will hold the middle pieces for each move
		int total = 0; // will hold total number of moves for this piece
		int x = place; 

		// switch statement for each piece
		switch (x)
		{ 
			case 0: // first piece
				/*
					Possible Moves:
						3, 5
				*/
				moves[0] = 3; moves[1] = 5;
				middle[0] = 1; middle[1] = 2; 
				total = 2; 
			break;
			
			case 1: // second piece
				/*
					Possible Moves:
						6, 8
				*/
				moves[0] = 6; moves[1] = 8;
				middle[0] = 3; middle[1] = 4;
				total = 2; 
			break;
			
			case 2: // third piece
				/*
					Possible Moves:
						7, 9
				*/
				moves[0] = 7; moves[1] = 9;
				middle[0] = 4; middle[1] = 5;
				total = 2; 
			break;
			
			case 3: // fourth piece
				/*
					Possible Moves:
						10, 0, 5, 12
				*/
				moves[0] = 10; moves[1] = 0; moves[2] = 5; moves[3] = 12;
				middle[0] = 6;  middle[1] = 1; middle[2] = 4; middle[3] = 7;
				total = 4;
			break;
			
			case 4: // fifth piece
				/*
					Possible Moves:
						11, 13
				*/
				moves[0] = 11; moves[1] = 13; 
				middle[0] = 7;  middle[1] = 8;
				total = 2; 
			break;
			
			case 5: // sixth piece
				/*
					Possible Moves:
						12, 3, 0, 14
				*/
				moves[0] = 12; moves[1] = 3; moves[2] = 0; moves[3] = 14;
				middle[0] = 8;  middle[1] = 4; middle[2] = 2; middle[3] = 9;
				total = 4;
			break;
			
			case 6: // seventh piece
				/*
					Possible Moves:
						1, 8, 
				*/
				moves[0] = 1; moves[1] = 8;
				middle[0] = 3; middle[1] = 7;
				total = 2;
			break;
			
			case 7: // eighth piece
				/*
					Possible Moves:
						2
				*/
				moves[0] = 2; moves[1] = 9; 
				middle[0] = 4; middle[1] = 8; 
				total = 2; 
			break;
			
			case 8: // ninth piece
				/*
					Possible Moves:
						1
				*/
				moves[0] = 1; moves[1] = 6; 
				middle[0] = 4; middle[1] = 7; 
				total = 2; 
			break;
			
			case 9: // tenth piece
				/*
					Possible Moves:
						7, 2
				*/
				moves[0] = 7; moves[1] = 2; 
				middle[0] = 8; middle[1] = 5; 
				total = 2; 
			break;
			
			case 10: // eleventh piece
				/*
					Possible Moves:
						3, 12
				*/
				moves[0] = 3; moves[1] = 12; 
				middle[0] = 6; middle[1] = 11; 
				total = 2; 
			break;
			
			case 11: // twelfth piece
				/*
					Possible Moves:
						4, 13
				*/
				moves[0] = 4; moves[1] = 13; 
				middle[0] = 7; middle[1] = 12; 
				total = 2; 
			break;
			
			case 12: // thirteenth piece
				/*
					Possible Moves:
						10, 3, 5, 14
				*/
				moves[0] = 10; moves[1] = 3; moves[2] = 5; moves[3] = 14; 
				middle[0] = 11; middle[1] = 7; middle[2] = 8; middle[3] = 13; 
 				total = 4; 
			break;
			
			case 13: // fourteenth piece
				/*
					Possible Moves:
						11, 4
				*/
				moves[0] = 11; moves[1] = 4; 
				middle[0] = 12; middle[1] = 8; 
				total = 2; 
			break;
			
			case 14: // fifteenth piece
				/*
					Possible Moves:
						12, 5
				*/
				moves[0] = 12; moves[1] = 5; 
				middle[0] = 13; middle[1] = 9; 
				total = 2; 
			break;
		} // end switch

		this.moves = moves; // set this piece's moves equal to the possible moves
		this.middle = middle; // set this piece's middle equal to the possible middle
		this.total = total; // set this piece's total equal to the total moves
	} // end SetMoves function
} // end Piece class 
