package chess;

import java.util.List;

import org.junit.Test;

import static junit.framework.Assert.*;

public class GameStateTest {
	
	@Test
	public void testNewGameCreation(){
		GameState gameState = new GameState();
		gameState.newGame();
		
		Position p = new Position(1, 'a'); assertEquals(gameState.getFigureAt(p), new Rook(Player.White, p));
		p = new Position(1, 'b'); assertEquals(gameState.getFigureAt(p), new Knight(Player.White, p));
		p = new Position(1, 'c'); assertEquals(gameState.getFigureAt(p), new Bishop(Player.White, p));
		p = new Position(1, 'd'); assertEquals(gameState.getFigureAt(p), new Queen(Player.White, p));
		p = new Position(1, 'e'); assertEquals(gameState.getFigureAt(p), new King(Player.White, p));
		p = new Position(1, 'f'); assertEquals(gameState.getFigureAt(p), new Bishop(Player.White, p));
		p = new Position(1, 'g'); assertEquals(gameState.getFigureAt(p), new Knight(Player.White, p));
		p = new Position(1, 'h'); assertEquals(gameState.getFigureAt(p), new Rook(Player.White, p));
		
		for (char c = Position.MIN_COLUMN; c < Position.MAX_COLUMN; c++){
			p = new Position(2, c); assertEquals(gameState.getFigureAt(p), new Pawn(Player.White, p));
		}
		
		for (char c = Position.MIN_COLUMN; c < Position.MAX_COLUMN; c++){
			p = new Position(7, c); assertEquals(gameState.getFigureAt(p), new Pawn(Player.Black, p));
		}
		
		p = new Position(8, 'a'); assertEquals(gameState.getFigureAt(p), new Rook(Player.Black, p));
		p = new Position(8, 'b'); assertEquals(gameState.getFigureAt(p), new Knight(Player.Black, p));
		p = new Position(8, 'c'); assertEquals(gameState.getFigureAt(p), new Bishop(Player.Black, p));
		p = new Position(8, 'd'); assertEquals(gameState.getFigureAt(p), new Queen(Player.Black, p));
		p = new Position(8, 'e'); assertEquals(gameState.getFigureAt(p), new King(Player.Black, p));
		p = new Position(8, 'f'); assertEquals(gameState.getFigureAt(p), new Bishop(Player.Black, p));
		p = new Position(8, 'g'); assertEquals(gameState.getFigureAt(p), new Knight(Player.Black, p));
		p = new Position(8, 'h'); assertEquals(gameState.getFigureAt(p), new Rook(Player.Black, p));
		
		for (int i = 3; i <=6; i++)
			for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++)
				assertNull(gameState.getFigureAt(new Position(i,c)));
	}
	
	@Test
	public void testAvailableMoves(){
		GameState gameState = new GameState();
		gameState.newGame();
		
		List<Move> avaliableMoves = gameState.getAvaliableMoves();
		
		assertEquals(avaliableMoves.size(), (Position.MAX_COLUMN-Position.MIN_COLUMN+1)*2*2);
	}

}
