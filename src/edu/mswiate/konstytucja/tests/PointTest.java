package edu.mswiate.konstytucja.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.mswiate.konstytucja.sections.Point;

public class PointTest {

	@Test
	public void testToString() {
		assertEquals(new Point("jakaœ treœæ punktu").toString(), "jakaœ treœæ punktu\n");
	}

}
