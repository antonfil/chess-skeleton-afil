package chess;

public class Queen extends Figure {
	
	public Queen(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "Q";
	}
	
}