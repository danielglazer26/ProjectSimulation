package Projekt;


public abstract class Field {

    private int value;
    private int ownership; //numer miasta posiadającego pole


    public int getValue() {

        return value;
    }


    protected void setValue(int value) {
        this.value = value;
    }

    public int getOwnership() {
        return ownership;
    }

    protected void setOwnership(int ownership) {
        this.ownership = ownership;
    }
}
