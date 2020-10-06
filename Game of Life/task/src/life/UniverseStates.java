package life;

public class UniverseStates {
    private String[][] pastState;
    private String[][] currentState;

    public UniverseStates(String[][] pastState) {
        this.pastState = pastState;
    }

    public String[][] getCurrentState() {
        return currentState;
    }

    public void setCurrentState() {
        currentState = new String[pastState.length][pastState.length];
        GenerateState generator = new GenerateState(pastState);
        currentState = generator.nextState();
    }
}
