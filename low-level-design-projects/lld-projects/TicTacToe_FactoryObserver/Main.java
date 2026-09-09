public class Main {
    public static void main(String[] args) {
        // PlayerFactory hides the concrete Player subclass from Main
        Player playerX = PlayerFactory.createPlayer("COMPUTER", 'X');
        Player playerO = PlayerFactory.createPlayer("COMPUTER", 'O');

        Game game = new Game(playerX, playerO);
        game.addObserver(new ScoreBoardObserver());
        game.play();
    }
}
