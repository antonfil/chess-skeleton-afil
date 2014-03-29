package chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {
	
	@Test
	public void testStringPresentation(){
		assertEquals("N", new Knight(Player.White, new Position(1, 'a')).toString());
	}
}
