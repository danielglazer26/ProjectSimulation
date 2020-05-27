package Okienko;


import Projekt.RandomNumber;
import Projekt.TurnSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapWindow extends JFrame implements WindowSettings, ActionListener {

    Timer timer;
    TurnSystem turnSystem;
    static int current_turn;

    public MapWindow(int number_cities, int map_size, int turn_number, float agression_rate, int seed) {

        RandomNumber randomNumber = new RandomNumber(seed);
        turnSystem = new TurnSystem(turn_number, map_size, number_cities, agression_rate, randomNumber);

        this.setTitle(title);
        this.setBounds((x - (5 + map_size) * 50 + 38) / 2, (y - map_size * 50 + 60) / 2, (5 + map_size) * 50+ 38, map_size * 50 + 60);
        this.setResizable(true);

        JPanel map_panel = new DrawMap(map_size, turnSystem.citiesEvolution.getMap().viewMap(), turnSystem.citiesEvolution.getCity_table());
        this.getContentPane().add(map_panel);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current_turn++;
                timeToDraw(current_turn, map_size, turn_number, number_cities);
                repaint();

            }
        });

    }

    void timeToDraw(int i, int map_size, int turn_number, int number_cities) {
        current_turn = i;
        if (i < turn_number) {
            timer.start();
            turnSystem.simulationTurn(i, map_size, turn_number, number_cities);
            repaint();
        } else {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public static int getCurrent_Turn(){
        return current_turn;
    }
}
