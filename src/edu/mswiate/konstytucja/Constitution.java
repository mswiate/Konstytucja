package edu.mswiate.konstytucja;

import java.util.ArrayList;
import java.util.List;

public class Constitution {
	
	private final List<Article> articles = new ArrayList<Article>();
	private final List<Chapter> chapters = new ArrayList<Chapter>();
	
	Article getArticle(int articleNumber){
		return articles.get(articleNumber - 1);
	}
	
	Chapter getChapter(int ChapterNumber){
		return chapters.get(chapterNumber - 1);
	}
	
	//dodaje rozdzia³
	void addChapter(String chapterNumber, String chapterName, Constitution constitution, int firstArticle, int lastArticle){
		chapters.add( new Chapter( chapterNumber, chapterName, this, firstArticle, lastArticle ) );
	}
	
	//dodaje artyku³
	void addArticle(int articleNumber, List<Point> points){
		articles.add(new Article (this, articleNumber, points));
	}
}
