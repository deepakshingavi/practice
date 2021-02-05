import javax.swing.*;
import java.awt.*;

public class DrawDot extends JPanel {

    //GetterSetter gs = new GetterSetter();

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);

        //Graphics2D g2d = (Graphics2D) g;

        //g2d.setColor(Color.black);
        // Random r = new Random();
        for (int i = 0; i <= 0;i++) {
            // int y = 50;
            //g2d.fillOval(gs.getX(), y, 30, 30);
            // gs.setX(gs.getX()+30);
            System.out.println("30");
//            break;
        }
        System.out.println("exit");
    }


    public static void main(String[] args) {
        DrawDot points = new DrawDot();
        JFrame frame = new JFrame("Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(points);
        frame.setSize(250, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}