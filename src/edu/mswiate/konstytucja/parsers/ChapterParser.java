package edu.mswiate.konstytucja.parsers;

import java.util.List;
import java.util.regex.Pattern;

import edu.mswiate.konstytucja.Constitution;
import edu.mswiate.konstytucja.sections.Chapter;

public class ChapterParser implements Parser {
	
	private final Pattern articleStart;
	private final Pattern subchapterStart;
	Constitution constitution;
	
	private ArticleParser ap;
	private PointParser pp;
	
	public ChapterParser(Constitution constitution){
		articleStart = Pattern.compile("^Art. [0-9]+.$");
		subchapterStart = Pattern.compile("^[A-Z Ø•å∆è—”£\\s]+$");
		this.constitution = constitution;
		
		ap = new ArticleParser(constitution);
		pp = new PointParser();
	}
	
	/*
	 * Rozdzia≥ ma postac:
	 * 
	 * Rozdzia≥ [0-9]
	 * Nazwa rozdzialu
	 * [Artykul]
	 * 
	 * Tworzy rozdzial z artykulami i podrozdzialami 
	 *	
	 */
	public Chapter parse(int firstLine, int lastLine,  List<String> text){
		
		String chapterNumber = text.get(firstLine).substring(9); // od 9 indeksu zaczyna sie numer rozdzia≥u
		String chapterName = text.get(firstLine + 1);
		
		Chapter chapter = new Chapter(chapterNumber, chapterName);
		
		int sectionFirstLine = firstLine + 2;
		
		for(int i = firstLine + 2; i <= lastLine; ++i){
			String line = text.get(i);
			
			if(articleStart.matcher(line ).matches()){//rozpoznaje artykul
				
				if(sectionFirstLine < i )// jesli poprzednia sekcja to byl artykul lub jest to pierwszy artykul
					chapter.addSection(ap.parse(sectionFirstLine, i - 1,text));
				
				sectionFirstLine = i;
			}
			else if(subchapterStart.matcher(line ).matches()){//rozpoznaje podrozdzial
				
				if(sectionFirstLine < i )// jesli poprzednia sekcja byl artykul
					chapter.addSection(ap.parse(sectionFirstLine, i - 1,text));			
				
				chapter.addSection(pp.parse(i, i,text));
				sectionFirstLine = i + 1; //ustawia na pierwsza linie po tytule podrozdzialu
				
			}
		}	
		// dodaje ostatni artykul rozdzialu
		chapter.addSection(ap.parse(sectionFirstLine, lastLine,text));		
		return chapter;		
	}
}
