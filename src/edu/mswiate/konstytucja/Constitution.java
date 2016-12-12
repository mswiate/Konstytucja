package edu.mswiate.konstytucja;

import java.util.ArrayList;
import java.util.List;

public class Constitution {
	
	private final List<Article> articles = new ArrayList<Article>();
	private final List<Chapter> chapters = new ArrayList<Chapter>();
	
	public Constitution(){
		
	}
	
	public Article getArticle(int articleNumber) {
		if(articleNumber > articles.size())
			throw new IndexOutOfBoundsException("There is no such article: " + articleNumber +
												" in this Constitution ");
		return articles.get(articleNumber - 1);
	}
	
	public Chapter getChapter(int chapterNumber) {
		if( chapterNumber > chapters.size())
			throw new IndexOutOfBoundsException("There is no such Chapter: " + chapterNumber +
												" in this Constitution ");
		return chapters.get(chapterNumber - 1);
	}
	
	//dodaje rozdzia³
	void addChapter(Chapter chapter){
		chapters.add(chapter);
	}
		
	//dodaje artyku³
	void addArticle(Article article){
		articles.add(article);
	}
}
