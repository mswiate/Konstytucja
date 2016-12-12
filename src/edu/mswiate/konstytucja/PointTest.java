package edu.mswiate.konstytucja;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testToString() {
		assertEquals(new Point("jakaœ treœæ punktu").toString(), "jakaœ treœæ punktu\n");
	}

}
