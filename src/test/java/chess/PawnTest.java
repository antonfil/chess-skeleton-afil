package chess;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
	
	@Test
	public void testStringPresentation(){
		assertEquals("P", new Pawn(Player.White, new Position(1, 'a')).toString());
	}
	
	@Test
	public void testAvaliableMoves(){
		GameState gameState = new GameState();
		gameState.newGame();
		
		List<Move> avaliableMoves = gameState.getFigureAt(2, 'e').getAvailableMoves(gameState);
		Move avaliableMove = new Move(new Position(2, 'e'), new Position(4, 'e'));
		assertTrue(avaliableMoves.contains(avaliableMove));
	}
}