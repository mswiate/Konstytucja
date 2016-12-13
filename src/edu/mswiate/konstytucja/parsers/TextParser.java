package edu.mswiate.konstytucja.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import edu.mswiate.konstytucja.Constitution;

public class TextParser {
	
	private Constitution constitution;
	private String filePath;
	
	// do przechowywania tekstu konstytucji
	private final List<String> text = new ArrayList<String>(); 
	
	private ChapterParser cp; 
	private final Pattern chapterStart;

	public TextParser(Constitution constitution, String filePath){
		this.constitution = constitution;
		this.filePath = filePath;
		
		chapterStart = Pattern.compile("^Rozdzia³ [IVX]+$");
		cp = new ChapterParser(constitution);
	}
	
	// zamienia forme tekstowa na obiektowa 
	public void parse() throws IOException{
		
		initialParse();
		
		int chapterFirstLine = 0;
		
		for(int i = 1; i < text.size(); ++i){// rozpoznaje i dodaje rozdzialy do constitution
			
			String line = text.get(i);
			
			if(chapterStart.matcher(line ).matches()){
				constitution.addChapter( cp.parse( chapterFirstLine, i - 1, text ) );
				chapterFirstLine = i;
			}
			
		}
		// dodaje ostatni rozdzial- po ktorym nie pojawia sie wzorzec "rozdzia³ "
		constitution.addChapter(cp.parse(chapterFirstLine, text.size() - 1, text));
	}
	
	
	//odrzuca preambule, wzorce i scala linie oddzielone '-'
	private void initialParse() throws IOException{
		try(BufferedReader br = new BufferedReader( new FileReader( new File( this.filePath ) ) ); ){
			
			boolean preamble = true;
			boolean hyphenatedWord = false; // czy poprzednie linia zawierala slowo rozdzielone '-'
			
			StringBuilder prevLine = new StringBuilder(); // do scalania linii rozdzielonych '-'
			
			for(String line ; ( line = br.readLine() ) != null ; ){
				
				if( line.equals("Rozdzia³ I") ){
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
	
}
