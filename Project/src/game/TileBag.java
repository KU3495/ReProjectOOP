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
			System.out.println("Afvalue: "+tilebag.get(letter)+ " get: "+ tilebag.get(letter));
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
		
		System.out.println("Bevalue: "+tilebag.get(randomLetter));
		
		if(RemoveFromBag(randomLetter)) {
			return randomLetter;
		}else return "-";
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

	public boolean checkBag() {
		int i;
		for(i=0; i<26; i++) {
			char L=(char) (i+'A');
			String letter=String.valueOf(L);
			if(tilebag.get(letter)>0) {
				return false;
			}
		}
		return true;
	}
}
