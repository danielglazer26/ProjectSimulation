package Projekt;

abstract  class CityLocalization  {
    protected static  int setLocalization(int map_size){
        return RandomNumber.getRandomNumber(map_size);
    }
    //Tutaj trzeba jakis sensowny warunek wymyślić na ustalanie lokalizacji startowych miast
}
