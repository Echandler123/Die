import java.util.Scanner;
public class DieTester {
    private int score;
    private int score2;
    private int overall;
    private int overall1;
    public static void main(String[] args)
    {
        DieTester dt  = new DieTester();
        dt.playGame();
    }

    //runs the game
    public void playGame()
    {
        DieTesterViewer DTV = new DieTesterViewer(this);
        DTV.repaint();
        Scanner scanner = new Scanner(System.in);
        Die d1 = new Die();
        printInstructions();
        System.out.println("What is your name?");
        String Name = scanner.nextLine();
        System.out.println();
        Die d2 = new Die();
        score = 0;
        score2 = 0;
        overall = 0;
        overall1 = 0;
        for(int i = 1; i < 6;i++)
        {

            System.out.println();
            System.out.println("Round: " + i);
            System.out.println("Pick your move: ");
            int num = scanner.nextInt();
            System.out.println("Your move is:");
            System.out.println(d1.getMove(num));
            DTV.setMove(num);
            DTV.Move(DTV.getGraphics());
            System.out.println("Their move is:");
            int num1 = d2.roll();
            System.out.println(d2.getMove(num1));
            DTV.setCompmove(num1);
            DTV.Move(DTV.getGraphics());
            String winners = getWinner(num, num1);
            score = d1.getScore(num,num1);
            score2 = d2.getScore1(num,num1);
            overall = overall + score;
            overall1 = overall1 + score2;
            System.out.println(winners);
            System.out.println("Your points :" + overall);
            System.out.println("Cpu's points :" + overall1);
        }

        String overallwinners = getOverall(overall,overall1);
        System.out.println(overallwinners);
    }
    //Compares both moves and sees who wins the round
    public static String getWinner(int num, int num1)
    {
        String winner = "";
        if (num < 1 && num > 3)
        {
            winner = "Error";
        }
        else if (num == num1)
        {
            winner = "It's a tie this round!";

        }
        else if (num == 2 && num1 == 3)
        {
            winner = "Cpu wins this round!";
        }
        else if (num == 3 && num1 == 2)
        {
            winner = "You win this round!";
        }
        else if (num == 1 && num1 == 2)
        {
            winner = "Cpu Wins this round!";
        }
        else if (num == 2 && num1 == 1)
        {
            winner = "You win this round!";
        }
        else if (num == 1 && num1 == 3)
        {
            winner = "You win this round!";
        }
        else if (num == 3 && num1 == 1)
        {
            winner = "Cpu wins this round!";
        }
        return winner;
    }

    //Gets takes in the 2 final scores compares them to
    //figure out who the final winner is
    public static String getOverall(int overall, int overall1)
    {
        String overallwinner = "";
        if (overall1 > overall)
        {
            overallwinner = "Cpu wins!";
        }
        else if (overall > overall)
        {
            overallwinner = "You win!";
        }
        else if (overall1 == overall)
        {
            overallwinner = "Its a tie!";
        }
        return overallwinner;
    }

    //Prints the instructions of the game
    public void printInstructions()
    {
        System.out.println("This game is rock paper scissors in rock paper" + "\n" +
                "scissor you are usually playing against one other person but in this " + "\n" +
                "version you are playing against the computer. To play you and the " + "\n" +
                "computer choose between 3 options rock paper and scissors in the game " + "\n" +
                "rock wins against scissors; paper wins against rock; and scissors wins " + "\n" +
                "against paper.After you run the program the computer will ask for your " + "\n" +
                "name andonce you input that you can use 1 2 3 on the keyboard to play " + "\n" +
                "your first round   with 1 represting paper 2 represting scissors and 3 " + "\n" +
                "represting rock. If you try to input anything else the program will " + "\n" +
                "say error and give no one a point that round. Then after you input " + "\n" +
                "your choice the computer will also choose after this the program " + "\n" +
                "will show a message of who wins and the winner get a point added to" + "\n" +
                "you total score and if it is a tie the both you and the computer" + "\n" +
                "will get a point. You will play 5 games against the computer and " + "\n" +
                "whoever gets the most points wins");
        System.out.println();
    }
}
