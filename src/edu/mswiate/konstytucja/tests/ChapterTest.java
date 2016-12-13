package edu.mswiate.konstytucja.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.mswiate.konstytucja.sections.Article;
import edu.mswiate.konstytucja.sections.Chapter;
import edu.mswiate.konstytucja.sections.Point;

public class ChapterTest {

	@Test
	public void testToString() {
		Chapter ch = new Chapter("numer","nazwa");
		ch.addSection(new Point("AAA "));

		Article article = new Article(23);
		article.addPoint(new Point("Konstytucja Rzeczypospolitej Polskiej "));
		article.addPoint(new Point("1)Konstytucja Rzeczypospolitej"));
		article.addPoint(new Point("tttttt"));
		ch.addSection(article);
		ch.addSection(new Point("TTTT"));
		assertEquals(ch.toString(), "Rozdzia³ numer\n"
				+ "nazwa\n"
				+ "AAA \n"
				+ "Art. 23.\n"
				+ "Konstytucja Rzeczypospolitej Polskiej \n"
				+ "1)Konstytucja Rzeczypospolitej\n"
				+ "tttttt\n"
				+ "TTTT\n");
	}

}
