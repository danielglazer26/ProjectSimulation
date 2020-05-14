package PoleTekstowe;

import javax.swing.*;

public class MapWindow extends JFrame implements WindowSettings {

    private JPanel panel = new Mapa(rozmiar_mapy);

    public MapWindow() {
        this.setTitle(title);
        this.setBounds((x - a) / 2, (y - b) / 2, a, b);
        this.getContentPane().add(panel);
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
