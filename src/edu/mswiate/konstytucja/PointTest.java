package edu.mswiate.konstytucja;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testToString() {
		assertEquals(new Point("jaka� tre�� punktu").toString(), "jaka� tre�� punktu\n");
	}

}
