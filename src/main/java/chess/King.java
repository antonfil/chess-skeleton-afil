package chess;

public class King extends Figure {
	
	public King(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "K";
	}
	
}