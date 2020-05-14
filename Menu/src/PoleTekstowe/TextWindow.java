package PoleTekstowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextWindow extends JFrame implements ActionListener, WindowSettings {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JLabel etykieta1 = new JLabel("Ilość miast");
    private JLabel etykieta2 = new JLabel("Powierzchnia mapy");
    private JLabel etykieta3 = new JLabel("Ilość tur");
    private JTextField ilosc_miast = new JTextField(10);
    private JTextField powierzchnia_mapy = new JTextField(10);
    private JTextField ilosc_tur = new JTextField(10);
    private JButton przycisk = new JButton("Okej");

    public TextWindow(){

        this.setTitle(title);
        this.setBounds(1000, 500, 500, 300);
        panel1.add(etykieta1);
        panel1.add(etykieta2);
        panel1.add(etykieta3);

        panel2.add(ilosc_miast);
        panel2.add(powierzchnia_mapy);
        panel2.add(ilosc_tur);

        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        this.getContentPane().add(przycisk, BorderLayout.SOUTH);

        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MapWindow().setVisible(true);
            }
        });

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
