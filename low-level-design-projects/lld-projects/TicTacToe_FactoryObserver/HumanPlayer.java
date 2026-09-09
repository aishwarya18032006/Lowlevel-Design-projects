import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        System.out.println("Player " + getSymbol() + ", enter row and col (0-2 each): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}
