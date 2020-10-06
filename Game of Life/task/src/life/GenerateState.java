package life;


public class GenerateState {
    private String[][] pastState;

    public GenerateState(String[][] pastState) {
        this.pastState = pastState;
    }

    public String[][] nextState () {
        String[] neighbors = new String[8];
        String[][] newState = new String[pastState.length][pastState.length];

        for (int i = 0; i < pastState.length; i++) {
            for (int j = 0; j < pastState.length; j++) {
                int topX = i - 1 < 0 ? pastState.length - 1 : i - 1;
                int leftY = j - 1 < 0 ? pastState.length - 1 : j - 1;
                int bottomX = i + 1 > pastState.length - 1 ? 0 : i + 1;
                int rightY = j + 1 > pastState.length - 1 ? 0 : j + 1;
                neighbors[0] = pastState[topX][leftY];
                neighbors[1] = pastState[topX][j];
                neighbors[2] = pastState[topX][rightY];
                neighbors[3] = pastState[i][leftY];
                neighbors[4] = pastState[i][rightY];
                neighbors[5] = pastState[bottomX][leftY];
                neighbors[6] = pastState[bottomX][j];
                neighbors[7] = pastState[bottomX][rightY];

                int numOfNeighbors = 0;
                for (String neighbor : neighbors) {
                    if (neighbor.equals("O")) {
                        numOfNeighbors += 1;
                    }
                }
                // create new state based on past state
                if (pastState[i][j].equals("O")) {
                    if (numOfNeighbors == 2 || numOfNeighbors == 3) {
                        newState[i][j] = "O";
                    } else {
                        newState[i][j] = " ";
                    }
                } else {
                    if (numOfNeighbors == 3) {
                        newState[i][j] = "O";
                    } else {
                        newState[i][j] = " ";
                    }
                }
            }
        }
        return newState;
    }
}
