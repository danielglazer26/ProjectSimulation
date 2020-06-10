package Projekt;

/**
 * Pole reprezentujace pustynie
 */
class Sand extends Field {
    /**wartosc pola*/
    private final int value = 5;

    protected Sand() {
        super.setValue(value);
    }

}