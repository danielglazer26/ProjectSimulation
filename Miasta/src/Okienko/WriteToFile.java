package Okienko;

import Projekt.City;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Klasa dpowiadajaca za zapis danych do pliku
 */

abstract class WriteToFile {

    static FileWriter fileWriter;

    /**
     * Tworzy plik Simulation.csv
     */
    public static void createFile() {
        try {
            fileWriter = new FileWriter("Simulation.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Zapisuje dane wpisane przez uzytkownika przy starcie programu
     * @param t tablica etykiet poszczegolnych danych
     * @param v tablica wprowadzonych danych
     */
    public static void printToFile(String[] t, float[] v) {
        try {
            for (int i = 0; i < t.length; i++) {
                fileWriter.write(t[i] + ": " + v[i] + "\n");
            }
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Zapisuje parametry koncowe jakie miasto uzyskalo po zakonczeniu symulacji
     * @param c ArrayLista miast
     */
    public static void printToFile(ArrayList<City> c) {
        try {
            for (int i = 0; i < c.size(); i++) {
                fileWriter.write((i + 1) + ". Miasto" + "\n" + "Poziom miasta: " + c.get(i).getCity_level() + "\n" + "Wartość miasta: " + c.get(i).getFortune() + "\n\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
