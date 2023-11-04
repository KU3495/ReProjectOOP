package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import java.util.Random;

public class TileBag {
	private Hashtable<String, Integer> tilebag = new Hashtable<String, Integer>();
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	String fileURL = classLoader.getResource("LetterScore&freq.txt").getFile();
	
	public TileBag() throws IOException {
		Reader r = new FileReader(fileURL);
		BufferedReader br = new BufferedReader(r);
		String s = "";
		while((s = br.readLine()) != null) {
			String[] sp = s.split(",");
			String ch = sp[0];
			int sc = Integer.parseInt(sp[1]);
			tilebag.put(ch, sc);
		}
	}
	
	public boolean RemoveFromBag(String word){
		if(tilebag.containsKey(word) && tilebag.get(word)>0) {
			int w=0;
			w=tilebag.get(word)-1;
			tilebag.put(word, w);
			return true;
		}
		return false;
	}
	
	public char getLetter() {
		Random ran=new Random();		
		char randomLetter = (char) (ran.nextInt(26) + 'A');
		return randomLetter;
	}
	
	public void DisplayBag() {
		int i;
		for(i=0; i<26; i++) {
			char t= (char) (i+'A');
			String w=String.valueOf(t);
			System.out.println(w + " ////// " + tilebag.get(w));
		}
		System.out.println("//////");
	}
}
