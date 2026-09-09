import java.util.ArrayList;
import java.util.List;

public class Board {
    private final char[][] grid = new char[3][3];

    public Board() {
        for (char[] row : grid) java.util.Arrays.fill(row, '-');
    }

    public boolean placeMark(int row, int col, char symbol) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || grid[row][col] != '-') {
            return false;
        }
        grid[row][col] = symbol;
        return true;
    }

    public List<int[]> getEmptyCells() {
        List<int[]> cells = new ArrayList<>();
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (grid[r][c] == '-') cells.add(new int[]{r, c});
        return cells;
    }

    public boolean isFull() {
        return getEmptyCells().isEmpty();
    }

    public boolean hasWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) return true;
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) return true;
        return false;
    }

    public void print() {
        for (char[] row : grid) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
    }
}
