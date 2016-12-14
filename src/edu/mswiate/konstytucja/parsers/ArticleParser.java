package edu.mswiate.konstytucja.parsers;

import java.util.List;
import java.util.regex.Pattern;

import edu.mswiate.konstytucja.Constitution;
import edu.mswiate.konstytucja.sections.Article;

public class ArticleParser implements Parser {
	
	private final Pattern pointStart;
	private Constitution constitution;
	private PointParser pp;
	
	public ArticleParser(Constitution constitution){
		pointStart = Pattern.compile("^[0-9]+[.)] .+$"); 
		pp = new PointParser();
		this.constitution = constitution;
	}
	
	
	/*
	 * artykul ma postac:
	 * Art. [0-9].
	 * [Punkt]
	 * punkt moze byc w paru liniach
	 * 
	 * zwraca artykul i dodaje go do konstytucji
	 * 
	 */
	public Article parse(int firstLine, int lastLine, List<String> text){
		
		// tworzy artykul; argumentem jest numer artykulu	
		Article article = new Article( Integer.parseInt( text.get(firstLine).substring(5, text.get(firstLine).length() - 1) ) );
		
		int pointFirstLine = firstLine + 1;
		
		for(int i = firstLine + 2 ; i <= lastLine ; ++i){//rozpoznaje podpunkty
			String line = text.get(i);
			
			if(pointStart.matcher(line ).matches()){//rozpoznaje poczatek nowego punktu
				article.addPoint( pp.parse(pointFirstLine, i - 1, text ) );
				pointFirstLine = i;
			}
		}
		//dodaje ostatni punkt
		article.addPoint( pp.parse(pointFirstLine, lastLine, text) );
		
		constitution.addArticle(article);
		
		return article;
	}
}
