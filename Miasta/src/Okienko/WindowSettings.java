package Okienko;

import java.awt.*;

/**
 * Interfejs odpowiadajacy za przechowywanie tytulu programu i rozmiaru monitora
 */
public interface WindowSettings {

    int x = Toolkit.getDefaultToolkit().getScreenSize().width; //pobieranie rozdzielczosci ekranu
    int y = Toolkit.getDefaultToolkit().getScreenSize().height;
    String title = "Simulation";
}
