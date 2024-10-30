package walking.game.player;

import walking.game.util.Direction;


public class Player {
    
    private int score;
    protected Direction direction = Direction.UP;

    public Player()
    {
        
    }


    public int getScore()
    {
        return this.score;
    }

    public Direction getDirection()
    {
        return this.direction;
    }

    public void addToScore(int score)
    {
        this.score = this.score + score;
    }

    public void turn()
    {
        if ( this.direction == Direction.UP)
        {
            this.direction = Direction.RIGHT;
        }
        else if (this.direction == Direction.RIGHT)
        {
            this.direction = Direction.DOWN;
        }
        else if ( this.direction == Direction.DOWN)
        {
            this.direction = Direction.LEFT;
        }
        else
        {
            this.direction = Direction.UP;
        }
    }
    
}




