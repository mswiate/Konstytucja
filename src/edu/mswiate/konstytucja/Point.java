package edu.mswiate.konstytucja;

public class Point implements Section {
	
	private String contents;
	
	public Point(String contents){
		this.contents = contents;
	}
	
	@Override
	public void show() {
		System.out.println(contents);
	}
	

}
