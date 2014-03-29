package chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class KingTest {
	
	@Test
	public void testStringPresentation(){
		assertEquals("K", new King(Player.White, new Position(1, 'a')).toString());
	}
}