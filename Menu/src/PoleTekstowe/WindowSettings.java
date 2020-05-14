package PoleTekstowe;

import java.awt.*;

public interface WindowSettings  {

    final int rozmiar_mapy = 10;
    int x = Toolkit.getDefaultToolkit().getScreenSize().width;
    int y = Toolkit.getDefaultToolkit().getScreenSize().height;
    int a = rozmiar_mapy * 50 + 38;
    int b = rozmiar_mapy * 50 + 60;
    String title = "Simulation";
}
