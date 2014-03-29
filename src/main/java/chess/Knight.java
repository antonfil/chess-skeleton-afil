package chess;

public class Knight extends Figure {
	
	public Knight(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "N";
	}
	
}