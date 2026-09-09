// Factory pattern: hides player construction logic from the caller (Game/Main)
public class PlayerFactory {
    public static Player createPlayer(String type, char symbol) {
        switch (type.toUpperCase()) {
            case "HUMAN":
                return new HumanPlayer(symbol);
            case "COMPUTER":
                return new ComputerPlayer(symbol);
            default:
                throw new IllegalArgumentException("Unknown player type: " + type);
        }
    }
}
