import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board = new Board();
    private final Player playerX;
    private final Player playerO;
    private final List<GameObserver> observers = new ArrayList<>();

    public Game(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    private void notifyMove(char symbol, int row, int col) {
        for (GameObserver o : observers) o.onMove(symbol, row, col);
    }

    private void notifyEnd(String result) {
        for (GameObserver o : observers) o.onGameEnd(result);
    }

    public void play() {
        Player current = playerX;
        while (true) {
            board.print();
            int[] move = current.makeMove(board);
            if (!board.placeMark(move[0], move[1], current.getSymbol())) {
                System.out.println("Invalid move, try again.");
                continue;
            }
            notifyMove(current.getSymbol(), move[0], move[1]);

            if (board.hasWinner(current.getSymbol())) {
                board.print();
                notifyEnd(current.getSymbol() + " wins!");
                return;
            }
            if (board.isFull()) {
                board.print();
                notifyEnd("Draw");
                return;
            }
            current = (current == playerX) ? playerO : playerX;
        }
    }
}
