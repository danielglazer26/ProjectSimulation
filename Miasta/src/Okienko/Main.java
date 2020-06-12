
/**
 * @author Pawel Helisz
 * @author Daniel Glazer
 * @since 10.06.2020
 */
package Okienko;

/**
 * Klasa startowa
 */
public abstract class Main {

        /**
         *Uruchamia pierwsze okno
         */
    public static void main(String[] args) {

        new FirstWindow().setVisible(true); //wywołuje pierwsze okno z komunikatem

    }

}
