package chess;

public class Bishop extends Figure {
	
	public Bishop(Player player, Position position) {
		super(player, position);
	}

	@Override
	public String toString(){
		return "B";
	}
	
}