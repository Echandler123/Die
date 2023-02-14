//Elijah Chandler
//2/13/23
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
public class DieTesterViewer extends JFrame {
    private final int WINDOW_WIDTH = 1400;
    private final int WINDOW_HEIGHT = 800;
    private Image Rock;
    private Image Paper;
    private Image Scissors;
    private Image background;
    private DieTester DT;
    private int move = 0;
    private int compmove = 0;
    //takes in the observer creates the image for the rock, paper, and scissors, and makes the window for the game
    public DieTesterViewer(DieTester DT)
    {
        Scissors = new ImageIcon("Resources/Scissors.png").getImage();
        Paper = new ImageIcon("Resources/Paper.png").getImage();
        Rock = new ImageIcon("Resources/Rock.png").getImage();
        background = new ImageIcon("Resources/background.png").getImage();
        this.setTitle("Rock Paper Scissors Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.DT = DT;
    }
    //draws the background,the player's and the computer's rock paper and scissor images and calls the move method
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.drawImage(background,0, 0,WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setColor(Color.black);
        g.drawImage(Rock,25, 100,170,200, this);
        g.drawImage(Paper,275, 100,250,225, this);
        g.drawImage(Scissors, 625, 100,100,200, this);
        g.drawImage(Rock,25, 500,170,200, this);
        g.drawImage(Paper,275, 500,250,225, this);
        g.drawImage(Scissors, 625, 500,100,200, this);
        this.Move(g);
    }
    public void setCompmove(int compmove)
    {
        this.compmove = compmove;
    }

    public void setMove(int move)
    {
        this.move = move;
    }
    /*
    makes both the player's and the computer's image that they chose for their move get bigger on the screen while
    covering the smaller version with a white square
     */
    public void Move(Graphics g)
    {
        if (compmove == 1)
        {
            g.setColor(Color.white);
            g.fillRect(275, 100,250,225);
            g.drawImage(Paper,275, 100,350,290, this);
        }
        else if (compmove == 2)
        {
            g.setColor(Color.white);
            g.fillRect( 625, 100,100,200);
            g.drawImage(Scissors, 625, 100,150,300, this);
        }
        else if (compmove == 3)
        {
            g.setColor(Color.white);
            g.fillRect(25, 100,170,200);
            g.drawImage(Rock,25, 100,255,300, this);
        }
        if (move == 1)
        {
            g.setColor(Color.white);
            g.fillRect(275, 500,250,225);
            g.drawImage(Paper,275, 500,350,290, this);
        }
        else if (move == 2)
        {
            g.setColor(Color.white);
            g.fillRect(625, 500,100,200);
            g.drawImage(Scissors, 625, 500,150,300, this);
        }
        else if (move == 3)
        {
            g.setColor(Color.white);
            g.fillRect(25, 500,170,200);
            g.drawImage(Rock,25, 500,255,300, this);
        }
    }
    //draws the overall winner on the screen
    public void overallwinner(Graphics g,String winner)
    {
        g.setFont(new Font("SERIF",Font.ITALIC,160));
        g.setColor(Color.black);
        g.drawString(winner, 300, 450);
    }
    //draws the overall points for bother the player and the computer at the end of the 5 rounds
    public void points(Graphics g,String points, String points1)
    {
        g.setFont(new Font("SERIF",Font.ITALIC,50));
        g.setColor(Color.black);
        g.drawString(points,1075,250);
        g.drawString(points1,1275,250);
    }
    //draws what round it is on the screen
    public void round(Graphics g,String round)
    {
        g.setFont(new Font("SERIF",Font.ITALIC,100));
        g.setColor(Color.black);
        g.drawString(round,950,450);
    }
    //draws the instructions on the window
    public void instructions(Graphics g)
    {
        g.setFont(new Font("SERIF",Font.ITALIC,25));
        g.setColor(Color.black);
        g.drawString("This game is rock paper scissors in rock paper. To play you and the computer choose between 3 options rock paper and scissors. Rock", 0,350);
        g.drawString("wins against scissors paper wins against rock and scissors wins against paper. After you run the program the computer will ask for your" , 0,375);
        g.drawString("name and once you input it you can use 1 2 3 on the keyboard to choose your move. 1 represents paper 2 represents scissors and 3", 0,400);
        g.drawString("representing rock. If you try to input anything else the program will say error and give no one a point that round. The computer", 0,425);
        g.drawString("will also choose after that the image in the window of the computer's and your choice gets bigger. You will play 5 games and at ", 0,450);
        g.drawString("it will show both of your total points and who wins whoever gets the most points wins", 0,475);
    }
}
