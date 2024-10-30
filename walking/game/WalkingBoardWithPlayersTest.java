package walking.game;

import walking.game.WalkingBoardWithPlayers;
import walking.game.util.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class WalkingBoardWithPlayersTest 
{
    @Test
    public void walk1()
    {
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(10, 6);

        int[] scores = board.walk( 4,5,1,3,6);

        int[][] resultBoard = {
            {3, 4, 4, 3, 4, 4, 4, 4, 4, 4},
            {3, 3, 3, 6, 3, 3, 3, 3, 3, 5},
            {3, 3, 3, 6, 3, 3, 3, 3, 3, 5},
            {3, 3, 3, 6, 3, 3, 3, 3, 3, 5},
            {3, 3, 3, 6, 3, 3, 3, 3, 3, 5},
            {3, 3, 3, 6, 3, 3, 3, 3, 3, 5},
            {3, 3, 3, 6, 6, 6, 6, 6, 6, 6},
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 5},
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 5},
            {3, 3, 3, 1, 1, 1, 1, 1, 1, 5}
        };

        int[][] tiles = board.getTiles();
        
        for ( int i = 0 ; i < tiles.length ; i++ )
        {
            for ( int j = 0 ; j < tiles[i].length ; j++ )
            {
                assertEquals(resultBoard[i][j] , tiles[i][j]);
            }
        }

        int[] resultScores = {21,59,36,16,3,3};

        for ( int i = 0 ; i < scores.length ; i++ )
        {
            assertEquals(resultScores[i], scores[i]);
        }

    }

    @Test
    public void walk2()
    {
        assertThrows(IllegalArgumentException.class, () -> new WalkingBoardWithPlayers(10, 1));

        int[][] tiles = 
        {
            {11, 3, 8, 7},
            {6, 4, 9},
            {2, 13, 5, 12, 1},
            {10},
            {14, 9, 2, 5, 7}
        };
        


        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(tiles,3);

        int[] scores = board.walk(7,3,1,4);

        int[][] resultBoard = 
        {
            {4, 1, 1, 7},
            {4, 4, 9},
            {4, 13, 5, 12, 3},
            {4},
            {4, 9, 3, 5, 7}
        };
        

        tiles = board.getTiles();

        for ( int i = 0 ; i < tiles.length ; i++ )
        {
            for ( int j = 0 ; j < tiles[i].length ; j++ )
            {
                assertEquals(resultBoard[i][j] , tiles[i][j]);
            }
        }

        int[] resultScores = {40,38,11};

        for ( int i = 0 ; i < scores.length ; i++ )
        {
            assertEquals(resultScores[i], scores[i]);
        }
    }

    
}
