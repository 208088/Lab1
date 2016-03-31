package it.polito.tdp.alien;

public class Word {
	private String alienWord;
	private String translate;
	
	
	public Word() {
		super();
	}

	public Word(String alienWord, String translate) {
		super();
		this.alienWord = alienWord;
		this.translate = translate;
	}

	public String compare(String alien){
		if (alien.compareTo(alienWord)==0) return alien;
		return null;
	}
	
	public String getTranslate() {
		return translate;
	}

	public void setTranslation(String trans) {
		// TODO Auto-generated method stub
		translate=trans;
	}

}
