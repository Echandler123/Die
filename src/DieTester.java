//Elijah Chandler
//2/13/23
import java.util.Scanner;
public class DieTester {
    private int score;
    private int score2;
    private int overall;
    private int overall1;
    private String round;
    public static void main(String[] args)
    {
        DieTester dt  = new DieTester();
        dt.playGame();
    }
    /*
    Plays all 5 rounds of the game. Prints the instructions creates the Die Tester view object and opens the window.
    Takes in the users name. Creates the die object and rolls it to create the computers moves.Calls the Die tester view
    methods: instructions, round, move, setmove,setcomp move, points, and overallwinner. Also calls getwinner to compare
    the moves of the computer and user and get overall which returns the string of the overall winner
     */
    public void playGame()
    {
        DieTesterViewer DTV = new DieTesterViewer(this);
        Scanner scanner = new Scanner(System.in);
        Die d1 = new Die();
        DTV.instructions(DTV.getGraphics());
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
            DTV.repaint();
            System.out.println();
            round = "Round: " + i;
            DTV.round(DTV.getGraphics(),round);
            DTV.round(DTV.getGraphics(),round);
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
            String Overall = ": " + overall;
            String Overall1 = ": " + overall1;
            DTV.points(DTV.getGraphics(),Overall,Overall1);
            System.out.println(winners);;
            System.out.println("Your points :" + overall);
            System.out.println("Cpu's points :" + overall1);
        }
        DTV.overallwinner(DTV.getGraphics(),this.getOverall(overall,overall1));
        DTV.overallwinner(DTV.getGraphics(),this.getOverall(overall,overall1));
        System.out.println(this.getOverall(overall,overall1));
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
                "To play you and the " + "\n" + "computer choose between 3 options rock paper and scissors"
                + "\n" + "rock wins against scissors; paper wins against rock; and scissors wins " + "\n" +
                "against paper. After you run the program the computer will ask for your " + "\n" +
                "name and once you input that you can use 1 2 3 on the keyboard to choose" + "\n" +
                "your move with 1 representing paper 2 representing scissors and 3 " + "\n" +
                "representing rock. If you try to input anything else the program will " + "\n" +
                "say error and give no one a point that round." + "\n" + "the computer will also choose" + "\n" +
                "after that the image in the window of the computer's and your choice gets bigger" + "\n" +
                "you will play 5 games and at the end it will show both of your total points and who wins" + "\n" +
                "whoever gets the most points wins");
        System.out.println();
    }
}
