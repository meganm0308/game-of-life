package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    private static String[][] firstState (int matrixSize) {
        String[][] state = new String[matrixSize][matrixSize];

        final Random random = new Random();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                state[i][j] = random.nextBoolean()? "O" : " ";
            }
        }
        return state;
    }

    private static void printState (String[][] state) {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                System.out.print(state[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int matrixSize = scanner.nextInt();
        int generations = 10;

        // 1st generation
        String[][] state = firstState(matrixSize);

        for (int i = 1; i <= generations; i++) {
            // print the ith generation
            int countAlive = 0;
            for (int j = 0; j < state.length; j++) {
                for (int k = 0; k < state.length; k++) {
                    if (state[j][k].equals("O")) {
                        countAlive += 1;
                    }
                }
            }
            System.out.println("Generation #" + i);
            System.out.println("Alive: " + countAlive);
            printState(state);

            // get the next generation
            UniverseStates states = new UniverseStates(state);
            states.setCurrentState();
            state = states.getCurrentState();

            System.out.print("\033[H\033[2J");
            System.out.flush();
            Thread.sleep(1000);
        }
    }
}