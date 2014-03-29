package chess;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure {

	public Pawn(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "P";
	}
	
	public List<Move> getAvailableMoves(GameState gameState){
		List<Move> avalibaleMoves = new ArrayList<Move>();
		addVerticalMoves(avalibaleMoves, gameState);
		addDiagonalMoves(avalibaleMoves, gameState);
		
		return avalibaleMoves;
	}
	
	private void addVerticalMoves(List<Move> moves, GameState gameState){
		Position currentPos = getPosition();
		
		if (getPlayer().equals(Player.White) && currentPos.getRow() == Position.MAX_ROW) return;
		if (getPlayer().equals(Player.Black) && currentPos.getRow() == Position.MIN_ROW) return;
		
		int increment = (getPlayer().equals(Player.White)) ? 1 : -1;
		boolean moveFurther = false;
		if (gameState.getFigureAt(currentPos.getRow()+increment, currentPos.getColumn()) == null){
			moves.add(new Move(
							currentPos,
							new Position(currentPos.getRow()+increment, currentPos.getColumn())
							));
			moveFurther = true;
		}
		if (moveFurther && getDoneMovesCount() == 0){
			if (gameState.getFigureAt(currentPos.getRow()+increment+increment, currentPos.getColumn()) == null){
				moves.add(new Move(
								currentPos,
								new Position(currentPos.getRow()+increment+increment, currentPos.getColumn())
								));
			}
		}
	}
	
	private void addDiagonalMoves(List<Move> moves, GameState gameState){
		Position currentPos = getPosition();
		
		if (getPlayer().equals(Player.White) 
			&& currentPos.getRow() != Position.MAX_ROW
			&& currentPos.getColumn() != Position.MAX_COLUMN
			&& gameState.getFigureAt(currentPos.getRow()+1, (char)(currentPos.getColumn()+1)) != null
			&& !gameState.getFigureAt(currentPos.getRow()+1, (char)(currentPos.getColumn()+1)).getPlayer().equals(Player.White)
			&& !(gameState.getFigureAt(currentPos.getRow()+1, (char)(currentPos.getColumn()+1)) instanceof King)
			)
		{
			moves.add(new Move(
					currentPos,
					new Position(currentPos.getRow()+1, (char)(currentPos.getColumn()+1))
					));
		}
		
		if (getPlayer().equals(Player.White) 
			&& currentPos.getRow() != Position.MAX_ROW
			&& currentPos.getColumn() != Position.MIN_COLUMN
			&& gameState.getFigureAt(currentPos.getRow()+1, (char)(currentPos.getColumn()-1)) != null
			&& !gameState.getFigureAt(currentPos.getRow()+1, (char)(currentPos.getColumn()-1)).getPlayer().equals(Player.White)
			&& !(gameState.getFigureAt(currentPos.getRow()+1, (char)(currentPos.getColumn()-1)) instanceof King)
			)
		{
			moves.add(new Move(
					currentPos,
					new Position(currentPos.getRow()+1, (char)(currentPos.getColumn()-1))
					));
		}
		
		if (getPlayer().equals(Player.Black) 
			&& currentPos.getRow() != Position.MIN_ROW
			&& currentPos.getColumn() != Position.MAX_COLUMN
			&& gameState.getFigureAt(currentPos.getRow()-1, (char)(currentPos.getColumn()+1)) != null
			&& !gameState.getFigureAt(currentPos.getRow()-1, (char)(currentPos.getColumn()+1)).getPlayer().equals(Player.Black)
			&& !(gameState.getFigureAt(currentPos.getRow()-1, (char)(currentPos.getColumn()+1)) instanceof King)
			)
		{
			moves.add(new Move(
					currentPos,
					new Position(currentPos.getRow()-1, (char)(currentPos.getColumn()+1))
					));
		}
		
		if (getPlayer().equals(Player.Black) 
			&& currentPos.getRow() != Position.MIN_ROW
			&& currentPos.getColumn() != Position.MIN_COLUMN
			&& gameState.getFigureAt(currentPos.getRow()-1, (char)(currentPos.getColumn()-1)) != null
			&& !gameState.getFigureAt(currentPos.getRow()-1, (char)(currentPos.getColumn()-1)).getPlayer().equals(Player.Black)
			&& !(gameState.getFigureAt(currentPos.getRow()-1, (char)(currentPos.getColumn()-1)) instanceof King)
			)
		{
			moves.add(new Move(
					currentPos,
					new Position(currentPos.getRow()-1, (char)(currentPos.getColumn()-1))
					));
		}

	}
	
}
