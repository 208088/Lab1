package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced extends Word {
	private String alien;
	private List<String> translations= new ArrayList<String>();

	public WordEnhanced(String alienWord, String translate) {
		this.alien=alienWord;
		translations.add(translate);
		
	}

	@Override
	public String compare(String alien) {
		String s="";
		if ((this.alien).compareTo(alien)==0) {
			for (String a : translations) {
				s+=a+"\n";
			}
		return s;
	}else return null;
	}

	@Override
	public String getTranslate() {
		String s="";
		for (String a : translations) {
			s+=a+"\n";
		}
		return s;
	}

	@Override
	public void setTranslation(String trans) {
		boolean esiste=false;
		for (String s : translations) {
			if(s.compareTo(trans)==0) esiste= true; break;
		}
		if(!esiste){
			translations.add(trans);
		}
	}

	public String getAlien() {
		// TODO Auto-generated method stub
		return alien;
	}

}
