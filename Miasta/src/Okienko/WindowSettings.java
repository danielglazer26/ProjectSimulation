package Okienko;

import java.awt.*;

public interface WindowSettings  {

    int x = Toolkit.getDefaultToolkit().getScreenSize().width; //pobieranie rozdzielczosci ekranu
    int y = Toolkit.getDefaultToolkit().getScreenSize().height;
    String title = "Simulation";
}
