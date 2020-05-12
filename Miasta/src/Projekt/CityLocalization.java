package Projekt;

abstract  class CityLocalization  {
    protected static  int setLocalization(int map_size,RandomNumber randomNumber){
        return randomNumber.getRandomNumber(map_size);
    }
    //Tutaj trzeba jakis sensowny warunek wymyślić na ustalanie lokalizacji startowych miast
    //jakoś udało się bez tego, nie wiem czy ta klasa jest potrzebna wgl

}
