package chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class RookTest {
	
	@Test
	public void testStringPresentation(){
		assertEquals("R", new Rook(Player.White, new Position(1, 'a')).toString());
	}
}