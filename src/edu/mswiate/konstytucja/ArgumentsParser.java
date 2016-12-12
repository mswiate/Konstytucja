package edu.mswiate.konstytucja;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ArgumentsParser {
	
	//regex
	private final Pattern chapter;
	private final Pattern article;
	private final Pattern multipleArticles;
	
	public ArgumentsParser(){
		//regex
		chapter = Pattern.compile("^R[0-9]+$");
		article = Pattern.compile("^[0-9]+$");
		multipleArticles = Pattern.compile("^[0-9]+-[0-9]+$");
	}
	
	// zwraca tablice sekcji do wyœwietlenia
	public List<Section> parseSections(String[] args, Constitution constitution) throws IllegalArgumentException{
		
		List<Section> sections = new ArrayList<Section>();
		
		
		if(args.length < 2) 
			throw new IllegalArgumentException("There is no section to print."); 
		
		for(int i = 1; i < args.length; ++i){
			
			if(chapter.matcher(args[i]).matches()){
				sections.add(constitution.getChapter( Integer.parseInt( args[i].substring(1) ) ) );
			}
			else if(article.matcher(args[i]).matches()){
				sections.add(constitution.getArticle( Integer.parseInt( args[i].substring(0) ) ) );
			}
			else if(multipleArticles.matcher(args[i]).matches()){
				
				int firstArticle = Integer.parseInt( args[i].substring(0, args[i].indexOf('-')) );
				int lastArticle = Integer.parseInt( args[i].substring( args[i].indexOf('-') + 1 ) );
				
				if(lastArticle < firstArticle )
					throw new IllegalArgumentException("y in x-y must be greater than or equal to x"); 
				
				for(int j = firstArticle  ; j <= lastArticle ; ++j){
					sections.add(constitution.getArticle(j) );
				}
		
			}
			else{
				throw new IllegalArgumentException("Illegal Argument: " + args[i]);
			}
			
		}
		return sections;
	}
	
	//zwraca œcie¿kê do pliku - pierwszy argument
	public String parseFilePath(String[] args) throws IllegalArgumentException {
		if(args.length == 0)
			throw new IllegalArgumentException("There is no filepath. ");
		return args[0];
	}
}
