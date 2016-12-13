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
		text.add("Rzeczpospolita Polska strze¿e niepodleg³oœci i nienaruszalnoœci swojego terytorium,");
		text.add("zapewnia wolnoœci i prawa cz³owieka i obywatela oraz bezpieczeñstwo obywateli,");
		text.add("strze¿e dziedzictwa narodowego oraz zapewnia ochronê œrodowiska, kieruj¹c siê");
		text.add("zasad¹ zrównowa¿onego rozwoju.");
		assertEquals(pp.parse(1, 2, text).toString(),"zapewnia wolnoœci i prawa cz³owieka i obywatela oraz bezpieczeñstwo obywateli,"
				+ " strze¿e dziedzictwa narodowego oraz zapewnia ochronê œrodowiska, kieruj¹c siê \n");
	}

}
