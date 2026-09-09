public abstract class Player {
    private final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() { return symbol; }

    public abstract int[] makeMove(Board board);
}
