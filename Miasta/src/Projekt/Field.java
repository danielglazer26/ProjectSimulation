package Projekt;

/**
 * Klasa odpowiedzialna za poszczegolne pola na mapie
 */
public abstract class Field {
    /**wartosc pola*/
    private int value;
    /**numer miasta posiadajacego pole*/
    private int ownership;

    /**
     *
     * @return zwraca wartosc pola
     */
    public int getValue() {

        return value;
    }

    /**
     *
     * @param value wartosc pola
     */
    protected void setValue(int value) {
        this.value = value;
    }

    /**
     *
     * @return zwraca numer miasta posiadajacego pole
     */
    public int getOwnership() {
        return ownership;
    }

    /**
     * Ustawia numer miasta
     * @param ownership numer miasta posiadajacego pole
     */
    protected void setOwnership(int ownership) {
        this.ownership = ownership;
    }
}
