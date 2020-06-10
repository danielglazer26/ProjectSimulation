package Okienko;


import Projekt.RandomNumber;
import Projekt.TurnSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MapWindow extends JFrame implements WindowSettings, ActionListener {

    private static int current_turn;
    private final Timer timer;
    private final TurnSystem turnSystem;
    private int window_resizable = 50;
    private int delay = 1000;
    private JButton bar, bar2, bar3;
    private Boolean is_paused = true;
    private ImageIcon img1 = new ImageIcon("button_left.png");
    private ImageIcon img2 = new ImageIcon("button_right.png");
    private ImageIcon img3 = new ImageIcon("square.png");
    private ImageIcon img4 = new ImageIcon("play.png");

    public MapWindow(int number_cities, int map_size, int turn_number, float agression_rate, int seed) {

        turnSystem = new TurnSystem(turn_number, map_size, number_cities, agression_rate, new RandomNumber(seed));

        this.setTitle(title);
        while (true) {
            if (map_size * window_resizable + 60 < y) {
                break;
            } else {
                window_resizable--;
            }
        }
        this.setResizable(false);
        this.setSize((5 + map_size) * window_resizable + 38, map_size * window_resizable + 60);
        this.setLocationRelativeTo(null);

        this.getContentPane().add(new DrawMap(map_size, window_resizable, turnSystem.citiesEvolution.getMap().viewMap(), turnSystem.citiesEvolution.getCity_table()));
        buttonCreator(map_size);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(delay, e -> {
            current_turn++;
            timeToDraw(current_turn, map_size, turn_number, number_cities);
            repaint();

        });

    }


    public static int getCurrent_Turn() {
        return current_turn;
    }


    protected void timeToDraw(int i, int map_size, int turn_number, int number_cities) {
        current_turn = i;
        if (i < turn_number) {
            timer.start();
            turnSystem.simulationTurn(i, map_size, number_cities);
            repaint();
        } else {
            timer.stop();
            WriteToFile.printToFile(turnSystem.citiesEvolution.getCity_table());
        }
    }

    private void buttonCreator(int map_size) {

        img1.setImage(img1.getImage().getScaledInstance(window_resizable * 2, window_resizable, java.awt.Image.SCALE_SMOOTH));
        img2.setImage(img2.getImage().getScaledInstance(window_resizable * 2, window_resizable, java.awt.Image.SCALE_SMOOTH));
        img3.setImage(img3.getImage().getScaledInstance(window_resizable, window_resizable, java.awt.Image.SCALE_SMOOTH));

        bar = new DelayButton(img1);
        bar2 = new DelayButton(img2);
        bar3 = new DelayButton(img3);

        bar.addActionListener(this);
        bar2.addActionListener(this);
        bar3.addActionListener(this);

        bar.setBounds(map_size * window_resizable + 20, (map_size - 1) * window_resizable + 5, window_resizable * 2, window_resizable);
        bar3.setBounds(map_size * window_resizable + 20 + 2 * window_resizable, (map_size - 1) * window_resizable + 5, window_resizable, window_resizable);
        bar2.setBounds(map_size * window_resizable + 20 + 2 * window_resizable + window_resizable, (map_size - 1) * window_resizable + 5, window_resizable * 2, window_resizable);

        this.getLayeredPane().add(bar);
        this.getLayeredPane().add(bar2);
        this.getLayeredPane().add(bar3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bar2) {
            if (delay > 1000)
                this.delay -= 1000;
            else if (delay > 100)
                this.delay -= 100;
            timer.setDelay(delay);
        } else if (e.getSource() == bar) {
            if (delay >= 1000)
                this.delay += 1000;
            else
                this.delay += 100;
            timer.setDelay(delay);
        } else if (e.getSource() == bar3) {
            if (is_paused) {
                timer.stop();
                is_paused = false;
                bar3.setIcon(img4);
            } else {
                timer.start();
                is_paused = true;
                bar3.setIcon(img3);
            }
        }
    }
}
