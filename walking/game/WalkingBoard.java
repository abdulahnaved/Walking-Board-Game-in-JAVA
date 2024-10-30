package walking.game;

import java.util.Arrays;

import walking.game.util.Direction;

public class WalkingBoard {
    
    private int[][] tiles;
    private int x;
    private int y;
    public static final int BASE_TILE_SCORE = 3;

    public int[][] getTiles() 
    {
        int[][] copy = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i++) 
        {
            copy[i] = Arrays.copyOf(tiles[i], tiles[i].length);
        }
        return copy;
    }


    public WalkingBoard(int size)
    {
        tiles = new int[size][size];
        for ( int i = 0 ; i < tiles.length ; i++)
        {
            for ( int j = 0 ; j < tiles[0].length ; j++)
            {
                tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }

    public WalkingBoard(int[][] tiles)
    {
        this.tiles = new int[tiles.length][];

        for ( int i = 0 ; i < tiles.length ; i++ )
        {
            this.tiles[i] = new int[tiles[i].length];

            for ( int j = 0 ; j < tiles[i].length ; j++ )
            {
                if ( tiles[i][j] < BASE_TILE_SCORE )
                {
                    this.tiles[i][j] = BASE_TILE_SCORE; 
                }
                else
                {
                    this.tiles[i][j] = tiles[i][j];
                }   
            }
        }
        
    }

    public int[] getPosition()
    {
        return new int[] {this.x, this.y};
    }
    
    public boolean isValidPosition(int x, int y)
    {
        if ( tiles.length > x && x >= 0)
        {
            return tiles[x].length > y && y >= 0;
        }
        else
        {
            return false;
        }
    }

    public int getTile(int x, int y)
    {   
        return tiles[x][y];
    }   

    public static int getXStep(Direction direction)
    {
        if (direction == Direction.DOWN)
        {
            return 1;
        }
        else if (direction == Direction.UP)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    public static int getYStep(Direction direction)
    {
        if (direction == Direction.RIGHT)
        {
            return 1;
        }
        else if (direction == Direction.LEFT)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    
    public int moveAndSet( Direction TODOname, int value)
    {
        if (TODOname == Direction.LEFT || TODOname == Direction.RIGHT)
        {
            if ( isValidPosition(x + getXStep(TODOname) , y + getYStep(TODOname)))
            {
                y = y + getYStep(TODOname);
                int temp = tiles[x][y];
                tiles[x][y] = value;
                return temp;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            if ( isValidPosition(x + getXStep(TODOname), y + getYStep(TODOname)))
            {
                x = x + getXStep(TODOname);
                int temp = tiles[x][y];
                tiles[x][y] = value;
                return temp;
            }
            else
            {
                return 0;
            }   
        }
    }
}





