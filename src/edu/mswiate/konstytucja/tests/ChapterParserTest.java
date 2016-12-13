package edu.mswiate.konstytucja.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.mswiate.konstytucja.Constitution;
import edu.mswiate.konstytucja.parsers.ChapterParser;

public class ChapterParserTest {

	@Test
	public void testParse() {
		Constitution c = new Constitution();
		List<String> text = new ArrayList<String>();
		ChapterParser cp = new ChapterParser(c);
		text.add("Rozdzia� nazwa");
		text.add("Rozdzia� nazwa");
		text.add("Art. 1.");
		text.add("zapewnia wolno�ci i prawa cz�owieka i obywatela oraz bezpiecze�stwo obywateli,");
		text.add("1) strze�e dziedzictwa narodowego oraz zapewnia ochron� �rodowiska, kieruj�c si�");
		text.add("2. zasad� zr�wnowa�onego rozwoju.");
		text.add("zasad� zr�wnowa�onego rozwoju.");
		assertEquals(cp.parse(0,5,text).toString(),"Rozdzia� nazwa\nRozdzia� nazwa\nArt. 1.\n" +
				"zapewnia wolno�ci i prawa cz�owieka i obywatela oraz bezpiecze�stwo obywateli, \n" +
				"1) strze�e dziedzictwa narodowego oraz zapewnia ochron� �rodowiska, kieruj�c si� \n" +
				"2. zasad� zr�wnowa�onego rozwoju. \n");
	}
	

}
