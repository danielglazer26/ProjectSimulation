package Projekt;

/**
 * Pole reprezentujace jezioro (wode)
 */
class Lake extends Field {
    /**wartosc pola (miasto nie moze istniec na wodzie)*/
    private final int value = -1;

    protected Lake() {
        super.setValue(value);
    }
}