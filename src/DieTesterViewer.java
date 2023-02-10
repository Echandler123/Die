import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class DieTesterViewer extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private Image Rock;
    private Image Paper;
    private Image Scissors;
    private DieTester DT;
    private int move = 0;
    private int compmove = 0;

    public DieTesterViewer(DieTester DT)
    {
        Scissors = new ImageIcon("Resources/Scissors.png").getImage();
        Paper = new ImageIcon("Resources/Paper.png").getImage();
        Rock = new ImageIcon("Resources/Rock.png").getImage();
        this.setTitle("Rock Paper Scissors Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.DT = DT;
    }
    public void paint(Graphics g)
    {
        g.drawImage(Rock,50, 100,170,200, this);
        g.drawImage(Paper,350, 100,200,175, this);
        g.drawImage(Scissors, 650, 100,100,200, this);
        g.drawImage(Rock,50, 600,170,200, this);
        g.drawImage(Paper,350, 600,200,175, this);
        g.drawImage(Scissors, 650, 600,100,200, this);
        g.setFont(new Font("SERIF",Font.ITALIC,50));
        g.drawString("ScoreBoard",753,75);
        g.drawLine(750,100,1000,100);
        g.drawLine(875,100,875,600);
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
        if (move == 1)
        {
            g.setColor(Color.white);
            g.drawRect(350, 100,200,175);
            g.drawImage(Paper,350, 300,300,262, this);
        }
        else if (move == 2)
        {
            g.setColor(Color.white);
            g.drawRect( 650, 100,100,200);
            g.drawImage(Scissors, 650, 300,150,300, this);
        }
        else if (move == 3)
        {
            g.setColor(Color.white);
            g.drawRect(50, 100,170,200);
            g.drawImage(Rock,50, 300,255,300, this);
        }

        if (compmove == 1)
        {
            g.setColor(Color.white);
            g.drawRect(350, 600,200,175);
            g.drawImage(Paper,350, 400,300,262, this);
        }
        else if (compmove == 2)
        {
            g.setColor(Color.white);
            g.drawRect(650, 600,100,200);
            g.drawImage(Scissors, 650, 400,150,300, this);
        }
        else if (compmove == 3)
        {
            g.setColor(Color.white);
            g.drawRect(50, 600,170,200);
            g.drawImage(Rock,50, 400,255,300, this);
        }
    }


}
