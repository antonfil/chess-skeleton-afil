package chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
	
	@Test
	public void testStringPresentation(){
		assertEquals("P", new Pawn(Player.White, new Position(1, 'a')).toString());
	}
}