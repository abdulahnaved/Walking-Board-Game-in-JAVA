package walking.game;

import walking.game.player.MadlyRotatingBuccaneer;
import walking.game.player.Player;


public class WalkingBoardWithPlayers extends WalkingBoard {

    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int[][] board, int playerCount)
    {
        super(board);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount)
    {
        super(size);
        initPlayers(playerCount);
    }
    
    private void initPlayers(int playerCount)
    {
        if ( playerCount < 2 )
        {
            throw new IllegalArgumentException();
        }
        else
        {
            players = new Player[playerCount];

            players[0] = new MadlyRotatingBuccaneer();

            for ( int i = 1 ; i < players.length ; i++ )
            {
                players[i] = new Player();
            }
        }
    }

    public int[] walk(int... stepCounts)
    {

        int[] playerScores = new int[players.length];

        for ( int step : stepCounts )
        {
            for ( int i = 0 ; i < players.length ; i++ )
            {
                players[i].turn();

                for ( int j = 0 ; j < step ; j++ )
                {
                    int score = moveAndSet(players[i].getDirection(), Math.min(SCORE_EACH_STEP, step));

                    players[i].addToScore(score);
                }

                playerScores[i] = players[i].getScore();
            }
        }
        return playerScores;
    }
}



