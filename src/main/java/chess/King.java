package chess;

import java.util.List;

public class King extends Figure {
	
	public King(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "K";
	}
	
	public List<Move> getAvailableMoves(GameState gameState){
		throw new RuntimeException("The list of available moves for " + "\"" + toString() + " \" "  + "is not supported yet.");
	}
	
}