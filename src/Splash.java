import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        add(image);
        setSize(800, 600);
        setLocation(240, 40);

        t = new Thread(this);
        t.start();
        setVisible(true);

    }

    public void run() {
        try {
            Thread.sleep(4000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new Splash();
    }

}
