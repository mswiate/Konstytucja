package edu.mswiate.konstytucja.parsers;

import java.util.List;

import edu.mswiate.konstytucja.sections.Section;

public interface Parser {
	
	Section parse(int firstLine, int lastLine,  List<String> text);
	
}
