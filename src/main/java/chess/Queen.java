package chess;

import java.util.List;

public class Queen extends Figure {
	
	public Queen(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "Q";
	}
	
	public List<Move> getAvailableMoves(GameState gameState){
		throw new RuntimeException("The list of available moves for " + "\"" + toString() + " \" "  + "is not supported yet.");
	}
	
}