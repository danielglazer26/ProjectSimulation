
package Okienko;

import javax.swing.*;

public class DelayButton extends JButton {
    public DelayButton(ImageIcon imageIcon) {
        super(imageIcon);
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(true);
        this.setFocusPainted(false);
    }
}
