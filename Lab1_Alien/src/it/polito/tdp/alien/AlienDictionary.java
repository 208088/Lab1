package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	private List<WordEnhanced> dictionary= new ArrayList<WordEnhanced>();
	
	public void addWord(String alien, String trans){
		for (WordEnhanced w : dictionary) {
			if (w.compare(alien)!=null){
				w.setTranslation(trans);
				return; }
		}
		WordEnhanced w= new WordEnhanced(alien, trans);
		dictionary.add(w);
	}
	
	public String translateWord(String alien){
		for (WordEnhanced w : dictionary) {
			if(w.compare(alien)!=null){
				return w.getTranslate();
			}
		}
		return null;
	}

	public String trovaParoleAssociate(String alien) {
	   char[] l= alien.toCharArray();
	   int numP=-1; int pos=-1; 
	   for (int i=0; i< l.length ; i++) {
		if (l[i]=='?'){ numP++; pos=i;}
		else if (!Character.isLetter(l[i])) return null;
		if(numP>1) return null;
	   }
	   String a;
	   String res="";
	   for (WordEnhanced w : dictionary) {
		   char[] c=w.getAlien().toCharArray();
		   c[pos]='?';
		   a="";
		   for (char d : c) {
			a+=d;
		   }
		if (a.compareTo(alien)==0){
			res+="Parola: "+ w.getAlien() + "\nSignificati: " + w.getTranslate()+ "\n";
			}
		
	}
		return res;
	}

}
