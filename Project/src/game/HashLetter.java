package game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
public class HashLetter {

	int score=0;
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	String fileURL = classLoader.getResource("LetterScore&freq.txt").getFile();
	private Hashtable<String, Integer> tileScore = new Hashtable<String, Integer>();
	public HashLetter() throws IOException {
		Reader r = new FileReader(fileURL);
		BufferedReader br = new BufferedReader(r);
		String s = "";
		while((s = br.readLine()) != null) {
			String[] sp = s.split(",");
			String ch = sp[0];
			int sc = Integer.parseInt(sp[2]);
			tileScore.put(ch, sc);
		}
	}
	public void calScore(String word)
	{
		score=0;
		String temp="";
		System.out.println("Hello");
		for(int i=0;i<word.length();i++){
			temp+=word.substring(i, i+1);
			score+=tileScore.get(word.substring(i, i+1));
			temp+=" ";
			
		}
		System.out.println("\nIn calScore met "+temp+" "+score);
	}
	
	public int getScore()
	{
		return score;
	}
	
	
}
