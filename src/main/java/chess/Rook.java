package chess;

import java.util.List;

public class Rook extends Figure {
	
	public Rook(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "R";
	}
	
	public List<Move> getAvailableMoves(GameState gameState){
		throw new RuntimeException("The list of available moves for " + "\"" + toString() + " \" "  + "is not supported yet.");
	}
	
}