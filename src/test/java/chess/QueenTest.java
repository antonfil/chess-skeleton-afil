package chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {
	
	@Test
	public void testStringPresentation(){
		assertEquals("Q", new Queen(Player.White, new Position(1, 'a')).toString());
	}
}