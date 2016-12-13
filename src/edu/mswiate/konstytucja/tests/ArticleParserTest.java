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
		text.add("zapewnia wolno�ci i prawa cz�owieka i obywatela oraz bezpiecze�stwo obywateli,");
		text.add("1) strze�e dziedzictwa narodowego oraz zapewnia ochron� �rodowiska, kieruj�c si�");
		text.add("2. zasad� zr�wnowa�onego rozwoju.");
		text.add("zasad� zr�wnowa�onego rozwoju.");
		assertEquals(ap.parse(0,4,text).toString(),"Art. 1.\n" +
				"zapewnia wolno�ci i prawa cz�owieka i obywatela oraz bezpiecze�stwo obywateli, \n" +
				"1) strze�e dziedzictwa narodowego oraz zapewnia ochron� �rodowiska, kieruj�c si� \n" +
				"2. zasad� zr�wnowa�onego rozwoju. zasad� zr�wnowa�onego rozwoju. \n");
	}

}
