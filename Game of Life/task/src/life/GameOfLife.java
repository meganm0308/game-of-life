package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    int generation = 10;
    String[][] state;

    JLabel GenerationLabel = new JLabel();
    JLabel AliveLabel = new JLabel();

    public GameOfLife() throws InterruptedException {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 340);
        setLocationRelativeTo(null);

        int matrixSize = 20;

        int[] aliveNumbers = new int[generation];
        int counter = 0;

        // 1st generation
        state = GenerateState.firstState(matrixSize);

        for (int i = 1; i <= generation; i++) {
            int countAlive = 0;
            for (int j = 0; j < state.length; j++) {
                for (int k = 0; k < state.length; k++) {
                    if (state[j][k].equals("O")) {
                        countAlive += 1;
                    }
                }
            }
            aliveNumbers[counter] = countAlive;
            counter ++;

            //textComponents(i, aliveNumbers[i - 1]);

            JPanel textPanel = new JPanel();
            textPanel.setBounds(0, 0, 300, 40);
            add(textPanel);

            //JLabel GenerationLabel = new JLabel();
            GenerationLabel.setName("GenerationLabel");
            GenerationLabel.setText("Generation #" + i);
            textPanel.add(GenerationLabel);

            //JLabel AliveLabel = new JLabel();
            AliveLabel.setName("AliveLabel");
            AliveLabel.setText("Alive: " + aliveNumbers[i - 1]);
            textPanel.add(AliveLabel);

            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

            repaint();
            field();
            setLayout(null);
            setVisible(true);
            Thread.sleep(1000);

            // get the next generation
            UniverseStates states = new UniverseStates(state);
            states.setCurrentState();
            state = states.getCurrentState();
        }
    }

//    private void textComponents(int generation, int aliveCount) {
//        JPanel textPanel = new JPanel();
//        textPanel.setBounds(0, 0, 300, 40);
//        add(textPanel);
//
//        JLabel GenerationLabel = new JLabel();
//        GenerationLabel.setText("Generation #" + generation);
//        textPanel.add(GenerationLabel);
//
//        JLabel AliveLabel = new JLabel();
//        AliveLabel.setText("Alive: " + aliveCount);
//        textPanel.add(AliveLabel);
//
//        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
//    }

    public void field () {
        JPanel field = new rectangles();
        field.setBounds(0, 40, 300, 300);
        add(field);
    }

    public class rectangles extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    g.setColor(Color.lightGray);
                    g.drawRect(i * 15, j * 15, 15, 15);
                }
            }

            for (int i = 0; i < state.length; i++) {
                for (int j = 0; j < state.length; j++) {
                    if (state[i][j].equals("O")) {
                        g.setColor(Color.black);
                        g.fillRect(i * 15, j * 15, 15, 15);
                    }
                }
            }
        }
    }
}
