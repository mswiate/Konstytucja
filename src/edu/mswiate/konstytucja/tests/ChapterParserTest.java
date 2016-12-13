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
		text.add("Rozdzia³ nazwa");
		text.add("Rozdzia³ nazwa");
		text.add("Art. 1.");
		text.add("zapewnia wolnoœci i prawa cz³owieka i obywatela oraz bezpieczeñstwo obywateli,");
		text.add("1) strze¿e dziedzictwa narodowego oraz zapewnia ochronê œrodowiska, kieruj¹c siê");
		text.add("2. zasad¹ zrównowa¿onego rozwoju.");
		text.add("zasad¹ zrównowa¿onego rozwoju.");
		assertEquals(cp.parse(0,5,text).toString(),"Rozdzia³ nazwa\nRozdzia³ nazwa\nArt. 1.\n" +
				"zapewnia wolnoœci i prawa cz³owieka i obywatela oraz bezpieczeñstwo obywateli, \n" +
				"1) strze¿e dziedzictwa narodowego oraz zapewnia ochronê œrodowiska, kieruj¹c siê \n" +
				"2. zasad¹ zrównowa¿onego rozwoju. \n");
	}
	

}
