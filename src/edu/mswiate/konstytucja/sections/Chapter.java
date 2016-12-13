package edu.mswiate.konstytucja.sections;

import java.util.ArrayList;
import java.util.List;

public class Chapter implements Section {
	
	private String chapterNumber;
	private String chapterName;
	
	//zawiera obiekty klas Article i Point (podrozdzia³y)
	private final List<Section> sections = new ArrayList<Section>();
	
	public Chapter(String chapterNumber, String chapterName){
		this.chapterName = chapterName;
		this.chapterNumber = chapterNumber;
	}
	
	public void addSection(Section section){
		sections.add(section);
	}
	
	@Override
	public String toString() {
		StringBuilder contents = new StringBuilder("Rozdzia³ " + chapterNumber + "\n" + chapterName + "\n") ;
		for(Section section : sections){
			contents.append(section.toString());
		}
		return contents.toString();
		
	}

	
}
