package Okienko;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Klasa odpowiadajaca za okno od wprowadzania danych
 */
public class TextWindow extends JFrame implements ActionListener, WindowSettings {

    private final ArrayList<JTextField> text_field = new ArrayList<>();
    private final float[] values = new float[5];
    private final String[] titles = {"Ilość miast", "Powierzchnia mapy", "Ilość tur", "Współczynnik agresji < 0 , 1 >", "Seed"};
    private int easter_egg = 0;

    /**
     * Ustawianie rozmiaru okna, jego polozenie.
     * Ustalenie wartosci domyslnych
     */
    public TextWindow() {


        this.setTitle(title);
        this.setBounds((x - 500) / 2, (y - 300) / 2, 500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = setGridBagConstraints();


        for (int i = 0; i < titles.length; i++) {

            text_field.add(new JTextField(10));

            gbc.gridx = 0;
            gbc.gridy = i;
            inputPanel.add(new JLabel(titles[i]), gbc);
            gbc.gridx = 1;
            inputPanel.add(text_field.get(i), gbc);
        }

        gbc.gridx = 1;
        gbc.gridy = titles.length;
        JButton button = new JButton("Okej");
        inputPanel.add(button, gbc);

        text_field.get(0).setText("5");                        //wartosci startowe
        text_field.get(1).setText("15");
        text_field.get(2).setText("100");
        text_field.get(3).setText("0.8");
        text_field.get(4).setText("2526");


        this.getContentPane().add(inputPanel);


        for (int i = 0; i < titles.length; i++) {
            text_field.get(i).addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (!isNumber(e.getKeyChar())) e.consume();
                }
            });
        }


        button.addActionListener(e -> {
            if (ifCanGoForward()) {
                setVisible(false);
                MapWindow mapWindow = new MapWindow((int) values[0], (int) values[1], (int) values[2], values[3], (int) values[4]);
                mapWindow.timeToDraw(0, (int) values[1], (int) values[2], (int) values[0]);
                WriteToFile.createFile();
                WriteToFile.printToFile(titles, values);
            }
        });

    }

    /**
     * Styl ulozenia etykiet i pol tekstowych w kolumnach
     * @return obiekt stylu
     */
    private static GridBagConstraints setGridBagConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10, 5, 10);
        return gbc;
    }

    /**
     * Sprawdza czy uzytkownik nacisnal poprawny klawisz przy wpisywaniu danych
     * @param c znak wcisniety przez uzytkownika
     * @return prawda jesli zgodny/ falsz jesli niezgodny
     */
    private Boolean isNumber(char c) {
        return (c >= '0' && c <= '9') || c == '.';
    }

    /**
     * Sprawdza czy uzytkownik wprowadzil poprawne dane, jesli nie pokazuje odpowiedni komunikat
     * @return  prawda jesli dane sa zgodne/ falsz jesli niezgodne
     */
    private Boolean ifCanGoForward() {


        for (int i = 0; i < titles.length; i++) {

            try {
                values[i] = Float.parseFloat(text_field.get(i).getText());
                System.out.println("" + values[i]);
            } catch (NumberFormatException s) {
                JOptionPane.showMessageDialog(rootPane, "Uzupełnij pole/a jeśli chcesz kontynuować");
                return false;
            }
        }
        if (values[3] > 1) {
            JOptionPane.showMessageDialog(rootPane, "Współczynnik agresji musi być niewiększy niż 1");
            easter_egg++;
            return false;
        }

        if (values[0] < values[1])
            return true;

        if (easter_egg < 3) {
            JOptionPane.showMessageDialog(rootPane, "Niepoprawna ilość miast. Ilość miast musi być mniejsza niż powierzchnia mapy");
            easter_egg++;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Czy ty naprawdę jesteś taki głupi, że nie potrafisz kilku słów przeczytać? (:");
        }
        return false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
