package edu.mswiate.konstytucja;

public class Chapter implements Section {
	
	private String chapterNumber;
	private String chapterName;
	private Constitution constitution;
	
	private int firstArticle;
	private int lastArticle;
	
	public Chapter(String chapterNumber, String chapterName, Constitution constitution, int firstArticle, int lastArticle){
		this.chapterName = chapterName;
		this.chapterNumber = chapterNumber;
		this.constitution = constitution;
		this.firstArticle = firstArticle;
		this.lastArticle = lastArticle;
	}
	
	
	@Override
	public void show() {
		System.out.println("Rozdzia³ " + chapterNumber);
		System.out.println(chapterName);
		for(int i = firstArticle; i < lastArticle; ++i){
			constitution.getArticle(i).show();
		}		
	}

	
}
