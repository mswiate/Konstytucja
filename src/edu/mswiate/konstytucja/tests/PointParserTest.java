package edu.mswiate.konstytucja.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.mswiate.konstytucja.parsers.PointParser;

public class PointParserTest {

	@Test
	public void testParse() {
		List<String> text = new ArrayList<String>();
		PointParser pp = new PointParser();
		text.add("Rzeczpospolita Polska strze�e niepodleg�o�ci i nienaruszalno�ci swojego terytorium,");
		text.add("zapewnia wolno�ci i prawa cz�owieka i obywatela oraz bezpiecze�stwo obywateli,");
		text.add("strze�e dziedzictwa narodowego oraz zapewnia ochron� �rodowiska, kieruj�c si�");
		text.add("zasad� zr�wnowa�onego rozwoju.");
		assertEquals(pp.parse(1, 2, text).toString(),"zapewnia wolno�ci i prawa cz�owieka i obywatela oraz bezpiecze�stwo obywateli,"
				+ " strze�e dziedzictwa narodowego oraz zapewnia ochron� �rodowiska, kieruj�c si� \n");
	}

}
