package edu.mswiate.konstytucja;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Constitution constitution = new Constitution();
		
		try{
			TextParser tp = new TextParser(constitution, new ArgumentsParser().parseFilePath(args));
			tp.parse(); // zamiana tekstu na forme obiektowa
			
			List<Section> toShow = new ArgumentsParser().parseSections(args, constitution); // utworzenie listy sekcji do wyswietlenia
			
			for(Section sectionToShow : toShow){ //wyswietlanie sekcji
				System.out.println(sectionToShow);
			}
			
		}
		catch(IllegalArgumentException ex){
			System.out.println(ex + " Correct arguments: filepath [Rx] [x] [x-y], where x, y are numbers and y > x");
			System.exit(0);
		}
		catch(FileNotFoundException ex){
			System.out.println(ex);
			System.exit(0);
		}
		catch(IOException | IndexOutOfBoundsException ex){
			System.out.println(ex);
			System.exit(0);
		}
	}
}
