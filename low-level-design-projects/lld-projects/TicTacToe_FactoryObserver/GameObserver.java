// Observer pattern: decouples Game from anything that reacts to game events
public interface GameObserver {
    void onMove(char symbol, int row, int col);
    void onGameEnd(String result);
}
