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
		System.out.println(tilebag);
	}
	
	public boolean RemoveFromBag(String letter){
		if(tilebag.containsKey(letter) && tilebag.get(letter)>0) {
			int L=tilebag.get(letter)-1;
			tilebag.put(letter, L);
			return true;
		}
		return false;
	}
	
	public void AddToBag(String letter) {
		int L=tilebag.get(letter)+1;
		tilebag.put(letter, L);
	}
	
	public String getLetter() {
		Random ran=new Random();
		char randomchar = (char) (ran.nextInt(26) + 'A');
		System.out.println("Random: "+randomchar);
		String randomLetter=String.valueOf(randomchar);
		
		if(tilebag.get(randomLetter)>0) {
			System.out.println("value: "+tilebag.get(randomLetter));
			int L=tilebag.get(randomLetter)-1;
			tilebag.put(String.valueOf(randomLetter), L);
			System.out.println("Afvalue: "+tilebag.get(randomLetter)+ " get: "+ tilebag.get(randomLetter));
			return randomLetter;
		}return "-";
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
	
	public Hashtable<String, Integer> gettilebag(){
		return tilebag;
	}
}
