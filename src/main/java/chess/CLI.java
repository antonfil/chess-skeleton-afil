package chess;

import java.io.*;
import java.util.List;

/**
 * This class provides the basic CLI interface to the Chess game.
 */
public class CLI {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final BufferedReader inReader;
    private final PrintStream outStream;

    private GameState gameState = null;

    public CLI(InputStream inputStream, PrintStream outStream) {
        this.inReader = new BufferedReader(new InputStreamReader(inputStream));
        this.outStream = outStream;
        writeOutput("Welcome to Chess!");
    }

    /**
     * Write the string to the output
     * @param str The string to write
     */
    private void writeOutput(String str) {
        this.outStream.println(str);
    }

    /**
     * Retrieve a string from the console, returning after the user hits the 'Return' key.
     * @return The input from the user, or an empty-length string if they did not type anything.
     */
    private String getInput() {
        try {
            this.outStream.print("> ");
            return inReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from input: ", e);
        }
    }

    void startEventLoop() {
        writeOutput("Type 'help' for a list of commands.");
        gameState = new GameState();

        while (true) {
            showBoard();
            writeOutput(gameState.getCurrentPlayer() + "'s Move");

            String input = getInput();
            if (input == null) {
                break; // No more input possible; this is the only way to exit the event loop
            } else if (input.equals("help")) {
                showCommands();
            } else if (input.equals("new")) {
                gameState.newGame();
            } else if (input.equals("board")) {
                writeOutput("Current Board State:");
            } else if (input.equals("quit")) {
                writeOutput("Goodbye!");
                System.exit(0);
            } else if (input.equals("list")) {
            	writeOutput(writeAvailableMoves(gameState));
            } else if (input.startsWith("move")) {
                writeOutput("Sorry; 'move' is not yet implemented");
            } else {
                writeOutput("I didn't understand that.  Type 'help' for a list of commands.");
            }
        }
    }

    private void showBoard() {

        writeOutput(getBoardAsString(gameState));
    }

    private void showCommands() {
        writeOutput("Possible commands: ");
        writeOutput("    'help'                       Show this menu");
        writeOutput("    'quit'                       Quit Chess");
        writeOutput("    'new'                        Create a new game");
        writeOutput("    'board'                      Show the chess board");
        writeOutput("    'list'                       List all possible moves");
        writeOutput("    'move <colrow> <colrow>'     Make a move");
    }

    /**
     * Display the board for the user(s)
     */
    public String getBoardAsString(GameState gameState) {
        StringBuilder builder = new StringBuilder();

        printColumnLabels(builder);
        for (int i = Position.MAX_ROW; i >= Position.MIN_ROW; i--) {
            printSeparator(builder);
            printSquares(i, builder, gameState);
        }

        printSeparator(builder);
        printColumnLabels(builder);

        return builder.toString();
    }


    private void printSquares(int rowLabel, StringBuilder builder, GameState gameState) {
        builder.append(rowLabel);
        for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
        	Figure figure = gameState.getFigureAt(new Position(rowLabel, c));
            builder.append(" | ").append(figure != null ? figure : " ");
        }
        builder.append(" | ").append(rowLabel).append(NEWLINE);
    }

    private void printSeparator(StringBuilder builder) {
        builder.append("  +---+---+---+---+---+---+---+---+").append(NEWLINE);
    }

    private void printColumnLabels(StringBuilder builder) {
        builder.append("   ");
        for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
            builder.append(" ").append(c).append("  ");
        }

        builder.append(NEWLINE);
    }
    
    private String writeAvailableMoves(GameState gameState){
    	StringBuilder builder = new StringBuilder();
    	
    	List<Move> avaliableMoves = gameState.getAvaliableMoves();
    	builder.append(NEWLINE);
    	for (int i = 0; i < avaliableMoves.size(); i++){
    		builder.append(avaliableMoves.get(i));
    		builder.append(NEWLINE);
    	}
    	
    	return builder.toString();
    }

    public static void main(String[] args) {
        CLI cli = new CLI(System.in, System.out);
        cli.startEventLoop();
    }
}
