package edu.mswiate.konstytucja;

import java.util.ArrayList;
import java.util.List;

public class Article implements Section {
	
	private int articleNumber;
	private Constitution constitution;
	
	private final List<Point> points = new ArrayList<Point>();
	
	public Article(Constitution constitution, int articleNumber){
		this.articleNumber = articleNumber;
		this.constitution = constitution;
	}
	
	public void addPoint(Point point){
		
	}
	
	@Override
	public void show() {
		System.out.println("Art. " + articleNumber + "." );
		for(Point point:points){
			point.show();
		}
	}

}
