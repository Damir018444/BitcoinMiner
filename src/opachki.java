import javax.swing.*;
import java.awt.*;

public class opachki extends JFrame{
    JLabel error = new JLabel(new ImageIcon("img.jpg"));
    JLabel black = new JLabel(new ImageIcon("black_1080.jpg"));
    JPanel panel = new JPanel();

    opachki(){
        error.setBounds(0,0,new ImageIcon("img.jpg").getIconWidth(),new ImageIcon("img.jpg").getIconHeight());

        panel.setLayout(null);
        panel.add(error);

        this.add(panel);
        this.setUndecorated(true);
        this.setLocation(0,0);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
        this.setVisible(true);
    }
}
