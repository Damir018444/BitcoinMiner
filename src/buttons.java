import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

class button_1 extends JButton{

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    private Color but_color = new Color(25,25,25);
    private int radius = 50;

    public button_1() {
        setBackground(but_color);
        setContentAreaFilled(false);
        setVerticalAlignment(BOTTOM);
        setForeground(new Color(205,205,205));
        setFont(new Font("Calibri", Font.BOLD,30));
        setFocusable(false);
        setBorderPainted(false);
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                but_color = new Color(28,28,28);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                but_color = new Color(24,24,24);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                but_color = new Color(24,24,24);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                but_color = new Color(28,28,28);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(but_color);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }
}