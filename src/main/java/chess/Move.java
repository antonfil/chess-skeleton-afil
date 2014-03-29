package chess;

public class Move {

	private Position from;
	private Position to;
	
	public Move(Position from, Position to){
		this.from = from;
		this.to = to;
	}
	
	public Position getFrom(){
		return from;
	}
	
	public Position getTo(){
		return to;
	}
	
	@Override
	public boolean equals(Object move){
		return (move instanceof Move) && this.from.equals(((Move)move).from) && this.to.equals(((Move)move).to);
	}
	
	@Override
	public String toString(){
		return from.toString() + " " + to.toString();
	}
	
}
