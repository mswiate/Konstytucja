package edu.mswiate.konstytucja;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArgumentsParserTest {

	@Test
	public void testParseFilePath() {
		String[] t = {"t","1","2"};
		assertEquals(new ArgumentsParser().parseFilePath(t),"t");
	}
	
	@Test
	public void testParseSections() {
		//ZMIENIC SCIEZKE DO PLIKU !!!
		String[] args = {"sciezka","1","R2","240-243"};
		Constitution c = new Constitution();
		TextParser tp = new TextParser(c, new ArgumentsParser().parseFilePath(args));
		try{
			tp.parse();
		}
		catch(Exception ex){
			
		}
		
		assertEquals(new ArgumentsParser().parseSections(args,c).get(0).toString(), c.getArticle(1).toString());
		assertEquals(new ArgumentsParser().parseSections(args,c).get(1).toString(), c.getChapter(2).toString());
		assertEquals(new ArgumentsParser().parseSections(args,c).get(2).toString(), c.getArticle(240).toString());
		assertEquals(new ArgumentsParser().parseSections(args,c).get(5).toString(), c.getArticle(243).toString());
	}

}
