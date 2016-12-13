package edu.mswiate.konstytucja.parsers;

import java.util.List;

import edu.mswiate.konstytucja.sections.Point;

public class PointParser implements Parser {
	
	public PointParser(){
		
	}
	
	public Point parse(int firstLine, int lastLine, List<String> text){
		
		StringBuilder contents = new StringBuilder();

		for(int i = firstLine; i <= lastLine; ++i){
			contents.append(text.get(i) + " ");
		}
		
		return new Point( contents.toString() );
		
	}
		
}
