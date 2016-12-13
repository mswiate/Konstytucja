package edu.mswiate.konstytucja.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.mswiate.konstytucja.Constitution;
import edu.mswiate.konstytucja.parsers.ArticleParser;

public class ArticleParserTest {

	@Test
	public void testParse() {
		Constitution c = new Constitution();
		List<String> text = new ArrayList<String>();
		ArticleParser ap = new ArticleParser(c);
		text.add("Art. 1.");
		text.add("zapewnia wolnoœci i prawa cz³owieka i obywatela oraz bezpieczeñstwo obywateli,");
		text.add("1) strze¿e dziedzictwa narodowego oraz zapewnia ochronê œrodowiska, kieruj¹c siê");
		text.add("2. zasad¹ zrównowa¿onego rozwoju.");
		text.add("zasad¹ zrównowa¿onego rozwoju.");
		assertEquals(ap.parse(0,4,text).toString(),"Art. 1.\n" +
				"zapewnia wolnoœci i prawa cz³owieka i obywatela oraz bezpieczeñstwo obywateli, \n" +
				"1) strze¿e dziedzictwa narodowego oraz zapewnia ochronê œrodowiska, kieruj¹c siê \n" +
				"2. zasad¹ zrównowa¿onego rozwoju. zasad¹ zrównowa¿onego rozwoju. \n");
	}

}
