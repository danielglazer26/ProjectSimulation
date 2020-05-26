package Okienko;

import java.awt.*;

public interface WindowSettings  {

    int x = Toolkit.getDefaultToolkit().getScreenSize().width; //pobieranie rozdzielczosci ekranu
    int y = Toolkit.getDefaultToolkit().getScreenSize().height;
    //int a = rozmiar_mapy * 50 + 38;
    //int b = rozmiar_mapy * 50 + 60;
    String title = "Simulation";
}
