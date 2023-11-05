package game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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
	
	public void calScore(String word, ArrayList<Integer> Sp)
	{
		score=0;
		int Keep=0,Multi=1;
		String temp="";
		for(int i=0;i<word.length();i++){
			temp+=word.substring(i, i+1);
			switch(Sp.get(i)) {
			case 1:
				Keep=tileScore.get(word.substring(i, i+1))*2;
				break;
			case 2:
				Keep=tileScore.get(word.substring(i, i+1))*3;
				break;
			case 3:
				Keep=tileScore.get(word.substring(i, i+1));
				Multi=2;
				break;
			case 4:
				Keep=tileScore.get(word.substring(i, i+1));
				Multi=3;
				break;
			default:
				Keep=tileScore.get(word.substring(i, i+1));
				break;
			}
			System.out.println(i+" ////// "+ Sp.get(i)+" "+ Keep+" Multi: "+Multi);
			score+=Keep;
			temp+=" ";
			
		}
		System.out.println("BeScore: "+score);
		score=score*Multi;
		System.out.println("\nIn calScore met "+temp+" "+score);
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score) {	
		this.score=score;
	}
	
}
