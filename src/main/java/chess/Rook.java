package chess;

public class Rook extends Figure {
	
	public Rook(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "R";
	}
	
}