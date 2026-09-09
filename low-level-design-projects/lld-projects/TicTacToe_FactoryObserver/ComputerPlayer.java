import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random random = new Random();

    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        List<int[]> emptyCells = board.getEmptyCells();
        int[] choice = emptyCells.get(random.nextInt(emptyCells.size()));
        System.out.println("Computer " + getSymbol() + " plays: " + choice[0] + "," + choice[1]);
        return choice;
    }
}
