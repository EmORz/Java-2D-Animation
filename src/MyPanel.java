import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final  int PANEL_WIDTH = 500;
    final  int PANEL_HEIGHT = 500;
    Image car;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 2;
    int yVelocity = 1;
    int x =0;
    int y =0;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        car = new ImageIcon("D:\\Java_Projects\\Java2DAnimation\\src\\car.jpg").getImage();
        backgroundImage = new ImageIcon("D:\\Java_Projects\\Java2DAnimation\\src\\background.jpg").getImage();

        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(car, x, y, null);
        g2D.drawImage(backgroundImage, 0, 0, null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= PANEL_WIDTH-car.getWidth(null)|| x < 0) {
            xVelocity*=-1;
        }
        x = x + xVelocity;
        if (y >= PANEL_HEIGHT-car.getHeight(null)|| y < 0) {
            yVelocity*=-1;
        }
        y+=yVelocity;
        repaint();

    }
}
