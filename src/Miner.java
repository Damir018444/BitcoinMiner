import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Miner extends JFrame implements ActionListener, MouseListener {
    JPanel panel = new JPanel();

    JLabel pic = new JLabel(new ImageIcon("Bitcoin.png"));
    JLabel coins = new JLabel("0");
    JLabel bitcoin = new JLabel("Биткойн");
    JLabel mining = new JLabel("Майнинг");
    JLabel balance = new JLabel("Баланс:");
    JLabel btc = new JLabel("(BTC)");

    button_1 mine = new button_1();
    button_1 withdraw = new button_1();

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    long bitcoins = 0;
    int cost = 1;
    int seconds = 1;
    boolean is_mining = false;

    Timer timer = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            coins.setText(String.valueOf("+"+bitcoins));
            bitcoins+=cost;
            if (bitcoins>100 && bitcoins<1000){
                cost = 2;
            }if (bitcoins>1000 && bitcoins<10000){
                cost = 1234;
            }if (bitcoins>10000 && bitcoins<100000){
                cost = 12345;
            }if (bitcoins>100000 && bitcoins<1000000){
                cost = 123456;
            }if (bitcoins>1000000 && bitcoins<10000000){
                cost = 1234567;
            }if (bitcoins>10000000) {
                cost = 12345678;
            }
        }
    });


    Timer timer2 = new Timer(800, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (seconds==1) {
                mining.setText("Майнинг");
            } if (seconds == 2) {
                mining.setText("Майнинг.");
            } if (seconds == 3) {
                mining.setText("Майнинг..");
            } if (seconds == 4) {
                mining.setText("Майнинг...");
                seconds = 0;
            }
            seconds++;
        }
    });



    Miner(){
        pic.setBounds(40,125,300,300);

        bitcoin.setBounds(380,20,500,100);
        bitcoin.setFont(new Font("Calibri", Font.BOLD,70));
        bitcoin.setForeground(Color.white);

        mining.setBounds(380,75,500,100);
        mining.setFont(new Font("Calibri", Font.BOLD,40));
        mining.setForeground(Color.white);
        mining.setVisible(false);

        balance.setBounds(390,215,350,100);
        balance.setFont(new Font("Calibri", Font.BOLD,50));
        balance.setForeground(Color.white);

        btc.setBounds(390,250,150,100);
        btc.setFont(new Font("Calibri", Font.BOLD,30));
        btc.setForeground(Color.white);

        coins.setForeground(Color.white);
        coins.setBounds(575,218,300,100);
        coins.setFont(new Font("Calibri", Font.BOLD,50));

        mine.setText("Майнить");
        mine.setBounds(370,425,250,60);
        mine.setFont(new Font("Calibri", Font.BOLD,30)); //TYPE1_FONT
        mine.setForeground(new Color(205,205,205));
        mine.addMouseListener(this);

        withdraw.setText("Вывести");
        withdraw.setBounds(645,425,250,60);
        withdraw.addMouseListener(this);

        panel.add(pic);
        panel.add(coins);
        panel.add(bitcoin);
        panel.add(mining);
        panel.add(balance);
        panel.add(btc);
        panel.add(mine);
        panel.add(withdraw);
        panel.setLayout(null);
        //panel.setBackground(new Color(0xDB000000, true));
        panel.setBackground(new Color(40,40,40));

        this.add(panel);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setTitle("Bitcoin Miner");
        this.setIconImage(new ImageIcon("Bitcoin.png").getImage());
        this.setSize(950,600);
        this.setLocation(((toolkit.getScreenSize().width / 2) - this.getWidth() / 2), ((toolkit.getScreenSize().height / 2) - this.getHeight() / 2));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==mine){
            if (!is_mining) {
                is_mining = true;
                mining.setVisible(true);
                mine.setText("Стоп");
                coins.setForeground(Color.green);
                mine.setForeground(Color.red);
                timer2.start();
                timer.start();
            } else {
                is_mining = false;
                mining.setVisible(false);
                mine.setText("Майнить");
                coins.setForeground(Color.WHITE);
                mine.setForeground(Color.green);
                coins.setText(String.valueOf(bitcoins));
                timer2.stop();
                timer.stop();
            }
        } else if (e.getSource()==withdraw){
            new opachki();
            this.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==mine){
            if (!is_mining){
                mine.setForeground(Color.green);
            } else {
                mine.setForeground(Color.red);
            }
        } else if (e.getSource()==withdraw) {
            withdraw.setForeground(Color.green);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==mine){
            mine.setForeground(new Color(205,205,205));
        } else if (e.getSource()==withdraw) {
            withdraw.setForeground(new Color(205,205,205));
        }
    }
}
