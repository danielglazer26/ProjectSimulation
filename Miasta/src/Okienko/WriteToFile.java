package Okienko;

import Projekt.City;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

abstract class WriteToFile {

    static FileWriter fileWriter;


    public static void createFile() {
        try {
            fileWriter = new FileWriter("Simulation.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printToFile(String[] t, float[] v) {
        try {
            for (int i = 0; i < t.length; i++) {
                fileWriter.write(t[i] + ": " + v[i] +"\n");
            }
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printToFile(ArrayList<City> c) {
        try {
            for (int i = 0; i < c.size(); i++) {
                fileWriter.write((i+1)+". Miasto"+"\n" + "Poziom miasta: " +c.get(i).getCity_level() +"\n" + "Wartość miasta: " + c.get(i).getFortune() + "\n\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
