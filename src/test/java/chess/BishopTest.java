package chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {
	
	@Test
	public void testStringPresentation(){
		assertEquals("B", new Bishop(Player.White, new Position(1, 'a')).toString());
	}
}