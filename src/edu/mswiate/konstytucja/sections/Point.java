package edu.mswiate.konstytucja.sections;

/*
 * punkt- 
 * nie ma rozroznienia dla:
 * [0-9]) , [0-9]., normalna tresc, nazwa podrozdzialu 
 */
public class Point implements Section {
	
	private String contents;
	
	public Point(String contents){
		this.contents = contents;
	}
	
	@Override
	public String toString() {
		return this.contents + '\n';
	}
	

}
