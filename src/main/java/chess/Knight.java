package chess;

import java.util.List;

public class Knight extends Figure {
	
	public Knight(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "N";
	}
	
	public List<Move> getAvailableMoves(GameState gameState){
		throw new RuntimeException("The list of available moves for " + "\"" + toString() + " \" "  + "is not supported yet.");
	}
	
}