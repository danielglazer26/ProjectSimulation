package Projekt;
//nowa wersja

abstract  class Field {

   private int value;
   private int ownership; //numer miasta posiadającego pole


    protected int getValue() {

        return value;
    }


    protected void setValue(int value) {
        this.value = value;
    }

    protected int getOwnership(){

        return ownership;
    }

    protected void setOwnership(int ownership){this.ownership=ownership;}
}
