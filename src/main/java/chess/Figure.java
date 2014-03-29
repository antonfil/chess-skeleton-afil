package chess;

public abstract class Figure {
	
	private Player player;
	private Position position;
	
	public Figure(Player player, Position position){
		if (player == null || position == null) throw new NullPointerException("Figure's player and position can't be null");
		this.player = player;
		this.position = position;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Position getPosition(){
		return position;
	}
	
	@Override
	public boolean equals(Object object){
		return (object instanceof Figure) 
				&& ((Figure)object).player.equals(this.player)
				&& ((Figure)object).position.equals(this.position)
				&& object.getClass().equals(this.getClass());
	}
	
	@Override
	public abstract String toString();
}