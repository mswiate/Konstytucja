package edu.mswiate.konstytucja;

import java.util.ArrayList;
import java.util.List;

public class Article implements Section {
	
	private int articleNumber;
	
	private final List<Point> points = new ArrayList<Point>();
	
	public Article(int articleNumber){
		this.articleNumber = articleNumber;
	}
	
	public void addPoint(Point point){
		points.add(point);
	}
	
	@Override
	public String toString() {
		StringBuilder contents = new StringBuilder("Art. " + articleNumber + ".\n") ;
		for(Point point:points){
			contents.append(point.toString());
		}
		return contents.toString();
	}

}
