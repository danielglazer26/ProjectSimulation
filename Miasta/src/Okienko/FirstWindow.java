package Okienko;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Klasa odpowiadająca za okienko startowe
 */
public class FirstWindow extends JFrame implements ActionListener, WindowSettings {

    /**
     * Ustala rozmiar i wyglad okna startowego.
     */
    public FirstWindow() {

        this.setIconImage(MapElements.getImage("city_icon.png"));
        this.setBounds((x - 500) / 2, (y - 300) / 2, 500, 300);
        this.setTitle(title);

        JPanel panel1 = new JPanel() {
            public void paint(Graphics g) {
                g.drawImage(MapElements.getImage("first_window_background.png"), 0, 0, 500, 265, (img, infoflags, x, y, width, height) -> false);

                Font currentFont = g.getFont();
                Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
                g.setFont(newFont);
                this.setForeground(Color.RED);

                g.drawString("Witamy w symulacji", 180, 15);
                g.drawString("Naciśnij ENTER aby kontynuować", 130, 240);
            }
        };
        add(panel1);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    new TextWindow().setVisible(true);
                    setVisible(false);
                }

            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}