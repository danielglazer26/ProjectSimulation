package PoleTekstowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FirstWindow extends JFrame implements ActionListener, WindowSettings {

    private JLabel etykieta = new JLabel("Witamy w symulacji");
    private JLabel etykieta1 = new JLabel("Nacisnij ENTER by kontynuować");

    public FirstWindow() {

        this.setBounds(1000, 500, 500, 300);
        this.setTitle(title);

        JPanel panel1 = new JPanel();
        panel1.add(etykieta);

        JPanel panel2 = new JPanel();
        panel2.add(etykieta1);

        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.SOUTH);


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