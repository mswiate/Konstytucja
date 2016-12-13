package edu.mswiate.konstytucja.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.mswiate.konstytucja.sections.Article;
import edu.mswiate.konstytucja.sections.Point;

public class ArticleTest {
	
	@Test
	public void testToString() {
		Article article = new Article(23);
		article.addPoint(new Point("Konstytucja Rzeczypospolitej Polskiej "));
		article.addPoint(new Point("1)Konstytucja Rzeczypospolitej"));
		article.addPoint(new Point("tttttt"));
		assertEquals(article.toString(), "Art. 23.\n"
				+ "Konstytucja Rzeczypospolitej Polskiej \n"
				+ "1)Konstytucja Rzeczypospolitej\n"
				+ "tttttt\n");
	}

}
