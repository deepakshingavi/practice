
import javax.swing.*;
import java.awt.*;

public class Gui {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {

                    JFrame frame = new JFrame("OZU Restaurant Application");

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 1080);
                    frame.setMinimumSize(new Dimension(800, 1080));

                    JTabbedPane tabbedPane = new JTabbedPane();

                    JPanel orderPanel = new JPanel();
                    tabbedPane.add("Order", orderPanel);

                    JPanel restaurantPanel = new JPanel();
                    tabbedPane.add("Restaurant", restaurantPanel);

                    JButton newOrder = new JButton("New Order");
                    orderPanel.add(newOrder);


                    frame.add(tabbedPane);

                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}