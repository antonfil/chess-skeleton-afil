package chess;

import chess.Bishop;
import chess.Figure;
import chess.King;
import chess.Knight;
import chess.Pawn;
import chess.Player;
import chess.Position;
import chess.Queen;
import chess.Rook;


/**
 * Class that represents the current state of the game.  Basically, what pieces are in which positions on the
 * board.
 */
public class GameState {
    
    private Figure[][] positions = new Figure[Position.MAX_ROW-Position.MIN_ROW+1][Position.MAX_COLUMN-Position.MIN_COLUMN+1];

    private Player currentPlayer = Player.White;

    /**
     * Create the game state.
     */
    public GameState() {
    	newGame();
    }
    
    public void newGame(){
    	for (int i = 0; i < positions.length; i++)
    		for (int j = 0; j < positions[0].length; j++){
    			positions[i][j] = null;
    		}
    	
    	addFigure(new Rook(Player.White, new Position(1, 'a')));
    	addFigure(new Knight(Player.White, new Position(1, 'b')));
    	addFigure(new Bishop(Player.White, new Position(1, 'c')));
    	addFigure(new Queen(Player.White, new Position(1, 'd')));
    	addFigure(new King(Player.White, new Position(1, 'e')));
    	addFigure(new Bishop(Player.White, new Position(1, 'f')));
    	addFigure(new Knight(Player.White, new Position(1, 'g')));
    	addFigure(new Rook(Player.White, new Position(1, 'h')));
    	
    	for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++){
    		addFigure(new Pawn(Player.White, new Position(2, c)));
    	}
    	
    	for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++){
    		addFigure(new Pawn(Player.Black, new Position(7, c)));
    	}
    	
    	addFigure(new Rook(Player.Black, new Position(8, 'a')));
    	addFigure(new Knight(Player.Black, new Position(8, 'b')));
    	addFigure(new Bishop(Player.Black, new Position(8, 'c')));
    	addFigure(new Queen(Player.Black, new Position(8, 'd')));
    	addFigure(new King(Player.Black, new Position(8, 'e')));
    	addFigure(new Bishop(Player.Black, new Position(8, 'f')));
    	addFigure(new Knight(Player.Black, new Position(8, 'g')));
    	addFigure(new Rook(Player.Black, new Position(8, 'h')));
    }
    
    private void addFigure(Figure figure){
    	positions[figure.getPosition().getRow()-Position.MIN_ROW][figure.getPosition().getColumn()-Position.MIN_COLUMN] = figure;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Figure getFigureAt(Position position) {
    	return positions[position.getRow()-Position.MIN_ROW][position.getColumn()-Position.MIN_COLUMN];
    }
    
    public Figure[][] getPositions() {
    	return positions;
    }

}
