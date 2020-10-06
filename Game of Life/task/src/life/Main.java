package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    private static String[][] firstState (int matrixSize, long seed) {
        String[][] state = new String[matrixSize][matrixSize];

        final Random random = new Random(seed);
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

    public static void main(String[] args) {
        int matrixSize = scanner.nextInt();
        long seed = scanner.nextInt();
        int generations = scanner.nextInt();
        String[][] state = firstState(matrixSize, seed);

        if (generations >= 1) {
            for (int i = 0; i < generations; i++) {
                UniverseStates states = new UniverseStates(state);
                states.setCurrentState();
                state = states.getCurrentState();
            }
        }
        printState(state);
    }
}
