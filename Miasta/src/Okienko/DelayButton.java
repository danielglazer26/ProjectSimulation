package Okienko;

import javax.swing.*;

/**
 * Klasa rozszerzajaca klase JButton.
 * Ustala specyfikacje przyciskow
 */
public class DelayButton extends JButton {
    public DelayButton(ImageIcon imageIcon) {
        super(imageIcon);
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(true);
        this.setFocusPainted(false);
    }
}
