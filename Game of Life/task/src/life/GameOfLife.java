package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        components();
        setVisible(true);
    }
    private void components () {
        JPanel textDisplay = new JPanel();
        textDisplay.setBounds(0, 0, 300, 20);
        textDisplay.setLayout(new FlowLayout());
        add(textDisplay);
    }

}
