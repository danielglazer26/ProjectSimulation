package Okienko;


import Projekt.RandomNumber;
import Projekt.TurnSystem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MapWindow extends JFrame implements WindowSettings, ActionListener {

    private static int current_turn;
    public int delay = 1000;
    private final Timer timer;
    private final TurnSystem turnSystem;
    private JButton bar, bar2, bar3;
    private Boolean is_paused = true;

    public MapWindow(int number_cities, int map_size, int turn_number, float agression_rate, int seed) {

        turnSystem = new TurnSystem(turn_number, map_size, number_cities, agression_rate, new RandomNumber(seed));

        this.setTitle(title);
        this.setBounds((x - (5 + map_size) * 50 + 38) / 2, (y - map_size * 50 + 60) / 2, (5 + map_size) * 50 + 38, map_size * 50 + 60);
        this.setResizable(false);

        this.getContentPane().add(new DrawMap(map_size, turnSystem.citiesEvolution.getMap().viewMap(), turnSystem.citiesEvolution.getCity_table()));
        buttonCreator(map_size);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current_turn++;
                timeToDraw(current_turn, map_size, turn_number, number_cities);
                repaint();

            }
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

        bar = new DelayButton(new ImageIcon("button_left.png"));
        bar2 = new DelayButton(new ImageIcon("button_right.png"));
        bar3 = new DelayButton(new ImageIcon("square.png"));
        bar.addActionListener(this);
        bar2.addActionListener(this);
        bar3.addActionListener(this);
        bar.setBounds(map_size * 50 + 20, (map_size - 1) * 50 + 10, 100, 50);
        bar3.setBounds(map_size * 50 + 120, (map_size - 1) * 50 + 10, 50, 50);
        bar2.setBounds(map_size * 50 + 170, (map_size - 1) * 50 + 10, 100, 50);
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
                bar3.setIcon(new ImageIcon("play.png"));
            } else {
                timer.start();
                is_paused = true;
                bar3.setIcon(new ImageIcon("square.png"));
            }
        }
    }
}
