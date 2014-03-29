package chess;

import java.util.List;

public class Bishop extends Figure {
	
	public Bishop(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "B";
	}
	
	public List<Move> getAvailableMoves(GameState gameState){
		throw new RuntimeException("The list of available moves for " + "\"" + toString() + " \" "  + "is not supported yet.");
	}
	
}