import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class DieTesterViewer extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private Image Rock;
    private Image Paper;
    private Image Scissors;
    private Image background;
    private DieTester DT;
    private int move = 0;
    private int compmove = 0;

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
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.drawImage(background,0, 0,WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setColor(Color.black);
        g.drawImage(Rock,25, 100,170,200, this);
        g.drawImage(Paper,325, 100,200,175, this);
        g.drawImage(Scissors, 625, 100,100,200, this);
        g.drawImage(Rock,25, 600,170,200, this);
        g.drawImage(Paper,325, 600,200,175, this);
        g.drawImage(Scissors, 625, 600,100,200, this);
        this.Move(g);
    }


    public void setCompmove(int compmove) {
        this.compmove = compmove;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void Move(Graphics g)
    {
        if (compmove == 1)
        {
            g.setColor(Color.white);
            g.fillRect(325, 150,200,175);
            g.drawImage(Paper,325, 100,300,262, this);
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
            g.fillRect(325, 600,200,175);
            g.drawImage(Paper,325, 550,300,262, this);
        }
        else if (move == 2)
        {
            g.setColor(Color.white);
            g.fillRect(625, 600,100,200);
            g.drawImage(Scissors, 625, 600,150,300, this);
        }
        else if (move == 3)
        {
            g.setColor(Color.white);
            g.fillRect(25, 600,170,200);
            g.drawImage(Rock,25, 600,255,300, this);
        }
    }
    public void winner(Graphics g,String winner)
    {
        g.setFont(new Font("SERIF",Font.ITALIC,50));
        g.setColor(Color.black);
        g.drawString(winner, 400, 500);
    }

}
