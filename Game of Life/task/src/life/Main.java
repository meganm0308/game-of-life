package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    private static void firstState (int matrixSize, int seed) {
        final Random random = new Random(seed);
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(random.nextBoolean()? "O" : " ");
            }
            System.out.print("\n");
        }

    }

    public static void main(String[] args) {
        int matrixSize = scanner.nextInt();
        int seed = scanner.nextInt();
        firstState(matrixSize, seed);
    }
}
