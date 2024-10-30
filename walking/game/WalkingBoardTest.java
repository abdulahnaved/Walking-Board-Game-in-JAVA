package walking.game;

import walking.game.util.Direction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import walking.game.WalkingBoard;

import static org.junit.jupiter.api.Assertions.*;



public class WalkingBoardTest 
{

    @ParameterizedTest
    @CsvSource(
        {
            "5",
            "2",
            "10 "
        }
    )
    public void testSimpleInit(int size )
    {
        WalkingBoard board = new WalkingBoard(size);

        assertEquals(size, board.getTiles().length);
        assertEquals(size, board.getTiles()[0].length);
        
        assertEquals(board.BASE_TILE_SCORE, board.getTile(0,0)); 
        assertEquals(board.BASE_TILE_SCORE, board.getTile(size-1,0)); 
        assertEquals(board.BASE_TILE_SCORE, board.getTile(0,size-1)); 
        assertEquals(board.BASE_TILE_SCORE, board.getTile(size-1,size-1)); 
    }
    

    @ParameterizedTest
    @CsvSource(
        {
            "2,1,3", "4,5,3", "0,3,8", "1,0,3", "3,0,4"
        }
    )
    public void testCustomInit(int x , int y ,int expected )
    {


        int[][] tiles = new int[][]
        {
            {2,5,6,8,9},
            {3,5},
            {1,0,3,4},
            {4},
            {6,3,7,4,9,1,4,2}
        };


        WalkingBoard board = new WalkingBoard(tiles);

        assertEquals(expected, board.getTile(x, y));

        tiles[x][y] = 9;

        assertEquals(expected , board.getTile(x, y));

        tiles = board.getTiles();

        tiles[x][y] = 6;

        assertEquals(expected, board.getTile(x,y));

    }

    @Test
    public void testMoves()
    {
        WalkingBoard board = new WalkingBoard(8);

        int[] initialPosition = {0,0};
        assertArrayEquals(initialPosition , board.getPosition());

        assertEquals(3, board.moveAndSet(Direction.RIGHT, 2));
        assertEquals(2, board.getTile(0,1 ));
        assertArrayEquals(new int[] {0,1}, board.getPosition());

        assertEquals(3, board.moveAndSet(Direction.DOWN, 5));
        assertEquals(5, board.getTile(1, 1));
        assertArrayEquals(new int[] {1,1}, board.getPosition());

        assertEquals(3, board.moveAndSet(Direction.LEFT, 1));
        assertEquals(1, board.getTile(1, 0));
        assertArrayEquals(new int[] {1,0}, board.getPosition());

        assertEquals(3,board.moveAndSet(Direction.UP, 3));
        assertEquals(3, board.getTile(0,0 ));
        assertArrayEquals(new int[] {0,0}, board.getPosition());

        int[] expectedPosition = {0,0};
        assertArrayEquals(expectedPosition , board.getPosition());

        assertEquals(0,board.moveAndSet(Direction.UP, 2));

        assertArrayEquals(expectedPosition, board.getPosition());
    }
}
