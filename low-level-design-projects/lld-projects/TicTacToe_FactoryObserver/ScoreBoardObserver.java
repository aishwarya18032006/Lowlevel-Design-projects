public class ScoreBoardObserver implements GameObserver {
    private int totalMoves = 0;

    @Override
    public void onMove(char symbol, int row, int col) {
        totalMoves++;
        System.out.println("[ScoreBoard] Move #" + totalMoves + " by " + symbol + " at (" + row + "," + col + ")");
    }

    @Override
    public void onGameEnd(String result) {
        System.out.println("[ScoreBoard] Game over in " + totalMoves + " moves. Result: " + result);
    }
}
