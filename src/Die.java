public class Die {
    /** Instance Variables **/
    private int sides;
    private int scores1;
    private int scores;
    private int num;
    /** Constructors **/
    public Die()
    {
        sides = 3;
    }

    public Die(int numSides)
    {
        sides = numSides;
    }

    /** Methods **/
    public int getSides()
    {
        return sides;
    }

    /**
     * Returns a random int between 1 and
     * the number of sides on the Die
     */
    public int roll()
    {
        int num = (int)(Math.random()*sides)+ 1;
        return num;
    }

    /**
     * Rolls the dice the numRolls times
     * and returns the max value of the rolls
     */
    public int getMaxRoll(int numRolls)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<numRolls; i++)
        {
            int num = roll();
            max = Math.max(max, num);
        }

        return max;
    }

    /**
     * TODO: Write a method that rolls the
     * die numRolls times and returns the
     * min value of the rolls
     */
    //Gets the move made by the player
    public String getMove(int num1)
    {
        num = num1;
        String Move = "error";
        if (num == 1)
        {
            Move = "Paper";
        }
        else if (num == 2)
        {
            Move = "Scissors";
        }
        else if (num == 3)
        {
            Move = "Rock";
        }
        return Move;
    }

    //Increases the score for the player if the win
    public int getScore(int num, int num1)
    {
        scores = 0;
        if (num == 3 && num1 == 2)
        {
            return scores + 1;
        }
        else if (num == 2 && num1 == 1)
        {
            return scores + 1;
        }
        else if (num == 1 && num1 == 3)
        {
            return scores + 1;
        }
        else if (num == num1)
        {
            return scores + 1;
        }
        return scores;
    }

    //Increases the score for the cpu if they win
    public int getScore1(int num,int num1)
    {
        scores1 = 0;
        if (num == 2 && num1 == 3)
        {
            return scores1 + 1;
        }
        else if (num == 1 && num1 == 2)
        {
            return scores1 + 1;
        }
        else if (num == 3 && num1 == 1)
        {
            return scores1 + 1;
        }
        else if (num == num1)
        {
            return scores1 + 1;
        }
        return scores1;
    }

}
