package chess;

public class Position {
	
	public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;
    public static final char MIN_COLUMN = 'a';
    public static final char MAX_COLUMN = 'h';

	private int row;
	private char column;
	
	public Position(int row, char column){
		if (row > MAX_ROW || row < MIN_ROW || column > MAX_COLUMN || column < MIN_COLUMN) throw new RuntimeException("Invalid position.");
		this.row = row;
		this.column = column;
	}
	
	public int getRow(){
		return row;
	}
	
	public char getColumn(){
		return column;
	}
	
	public boolean equals(Position position){
		return this.row == position.row && this.column == position.column;
	}
	
}
