package edu.mswiate.konstytucja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TextParser {
	
	private Constitution constitution;
	private String filePath;
	
	// do przechowywania tekstu konstytucji
	private final List<String> text = new ArrayList<String>(); 
	
	//regex
	private final Pattern chapterStart;
	private final Pattern articleStart;
	private final Pattern subchapterStart;
	private final Pattern pointStart;
	
	public TextParser(Constitution constitution, String filePath){
		this.constitution = constitution;
		this.filePath = filePath;
		
		//regex
		chapterStart = Pattern.compile("^Rozdzia≥ [IVX]+$");
		articleStart = Pattern.compile("^Art. [0-9]+.$");
		subchapterStart = Pattern.compile("^[A-Z Ø•å∆è—”£\\s]+$");
	  	pointStart = Pattern.compile("^[1-9]+[.)] .+$");
	}
	
	// zamienia forme tekstowa na obiektowa 
	public void parse() throws IOException{
		
		initialParse();
		
		int chapterFirstLine = 0;
		
		for(int i = 1; i < text.size(); ++i){// rozpoznaje i dodaje rozdzialy do constitution
			
			String line = text.get(i);
			
			if(chapterStart.matcher(line ).matches()){
				constitution.addChapter( parseChapter( chapterFirstLine, i - 1 ) );
				chapterFirstLine = i;
			}
			
		}
		// dodaje ostatni rozdzial- po ktorym nie pojawia sie wzorzec "rozdzia≥ "
		constitution.addChapter(parseChapter(chapterFirstLine, text.size() - 1));
	}
	
	//odrzuca preambule, wzorce i scala linie oddzielone '-'
	private void initialParse() throws IOException{
		try(BufferedReader br = new BufferedReader( new FileReader( new File( this.filePath ) ) ); ){
			
			boolean preamble = true;
			boolean hyphenatedWord = false; // czy poprzednie linia zawierala slowo rozdzielone '-'
			
			StringBuilder prevLine = new StringBuilder(); // do scalania linii rozdzielonych '-'
			
			for(String line ; ( line = br.readLine() ) != null ; ){
				
				if( line.equals("Rozdzia≥ I") ){
					preamble = false;
				}
				
				if(!preamble && !line.equals("©Kancelaria Sejmu") && !line.equals("2009-11-16")){
					if( hyphenatedWord){
						line = prevLine.append(line).toString();
						hyphenatedWord = false;
						prevLine = new StringBuilder(); // czysci prevLine
					}
					
					if( line.charAt(line.length() - 1) == '-' ){ // jesli linia konczy sie '-' - rozdzielone slowo
						hyphenatedWord = true;
						prevLine.append(line);
						prevLine.deleteCharAt(prevLine.length() - 1); // usuwa '-'
						
					}
					else
						this.text.add( line );
					
				}
			}
		}
	}
	
	/*
	 * Rozdzia≥ ma postac:
	 * 
	 * Rozdzia≥ [0-9]
	 * Nazwa rozdzialu
	 * [Artykul]
	 * 
	 * Tworzy rozdzial z artykulami i podrozdzialami i dodaje artykuly do konstytucji
	 *	
	 */
	private Chapter parseChapter(int firstLine, int lastLine){
		
		String chapterNumber = text.get(firstLine).substring(9); // od 9 indeksu zaczyna sie numer rozdzia≥u
		String chapterName = text.get(firstLine + 1);
		
		Article article;
		
		Chapter chapter = new Chapter(chapterNumber, chapterName);
		
		int sectionFirstLine = firstLine + 2;
		
		for(int i = firstLine + 2; i <= lastLine; ++i){
			String line = text.get(i);
			
			if(articleStart.matcher(line ).matches()){//rozpoznaje artykul
				if(sectionFirstLine < i ){// jesli poprzednia sekcja to byl artykul lub jest to pierwszy artykul
					article = parseArticle(sectionFirstLine, i - 1);
					chapter.addSection(article);
					constitution.addArticle(article);
				}
				sectionFirstLine = i;
			}
			else if(subchapterStart.matcher(line ).matches()){//rozpoznaje podrozdzial
				
				if(sectionFirstLine < i ){// jesli poprzednia sekcja byl artykul
					article = parseArticle(sectionFirstLine, i - 1);
					chapter.addSection(article);
					constitution.addArticle(article);
				}
				
				chapter.addSection(parsePoint(i, i));
				sectionFirstLine = i + 1; //ustawia na pierwsza linie po tytule podrozdzialu
				
			}
		}	
		// dodaje ostatni artykul rozdzialu
		article = parseArticle(sectionFirstLine, lastLine); 
		chapter.addSection(article);
		constitution.addArticle(article);
		
		return chapter;
		
	}
	
	/*
	 * artykul ma postac:
	 * Art. [0-9].
	 * [Punkt]
	 * punkt moze byc w paru liniach
	 * 
	 * zwraca artykul
	 * 
	 */
	private Article parseArticle(int firstLine, int lastLine){
		
		// tworzy artykul; argumentem jest numer artykulu
		Article article = new Article( Integer.parseInt( text.get(firstLine).substring(5, text.get(firstLine).length() - 1) ) );
		
		int pointFirstLine = firstLine + 1;
		
		for(int i = firstLine + 2 ; i <= lastLine ; ++i){//rozpoznaje podpunkty
			String line = text.get(i);
			
			if(pointStart.matcher(line ).matches()){//rozpoznaje poczatek nowego punktu
				article.addPoint(parsePoint(pointFirstLine, i - 1));
				pointFirstLine = i;
			}
		}
		//dodaje ostatni punkt
		article.addPoint(parsePoint(pointFirstLine, lastLine));
		
		return article;
	}
	
	//zwraca punkt (MOZE BYC ON ROZDZIELONY NA PARE LINII)
	private Point parsePoint(int firstLine, int lastLine){
		
		StringBuilder contents = new StringBuilder();

		for(int i = firstLine; i <= lastLine; ++i){
			contents.append(text.get(i) + " ");
		}
		
		return new Point( contents.toString() );
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
