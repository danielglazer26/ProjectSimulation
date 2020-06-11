/*
UWAGA !!!

*Program nie zawiera na razie żadnych zabezpieczeń przeciwko błednym danym
*Nie posiada na razie wersji okienkowej, która jest prawie skończona


 */
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
