package life;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GameOfLife extends JFrame {
    public final static Scanner scanner = new Scanner(System.in);

    int generation = 10;

    public GameOfLife() throws InterruptedException {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        GenerateState generator = new GenerateState();

        int matrixSize = scanner.nextInt();
        for (int i = 1; i <= generation; i++) {
            textComponents(i, generator.countAlive(matrixSize)[i - 1]);
            field();
            setLayout(null);
            setVisible(true);
            Thread.sleep(1000);
        }

    }
    private void textComponents(int generation, int aliveCount) {
        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 0, 300, 40);
        textPanel.setBackground(Color.GREEN);
        add(textPanel);

        JLabel GenerationLabel = new JLabel();
        GenerationLabel.setText("Generation #" + generation);
        textPanel.add(GenerationLabel);

        JLabel AliveLabel = new JLabel();
        AliveLabel.setText("Alive: " + aliveCount);
        textPanel.add(AliveLabel);

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
    }

    private void field () {
        JPanel field = new JPanel();
        field.setBounds(0, 40, 300, 260);
        field.setBackground(Color.BLUE);
        add(field);
    }
}
