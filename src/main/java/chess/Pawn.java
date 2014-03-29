package chess;

public class Pawn extends Figure {

	public Pawn(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "P";
	}
	
}
