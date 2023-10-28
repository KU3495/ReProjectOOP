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
			System.out.println(sc+"Hello");
			tileScore.put(ch, sc);
		}
		Enumeration<String> k = tileScore.keys();
        while (k.hasMoreElements()) {
            String key = k.nextElement();
            if(key.equals("Z")) {
            	System.out.println("Found it "+tileScore.get(key));
            }
            
        }
	}
	/*public void calScore(String word)
	{
		Character temp;
		for(int i=0;i<word.length();i++)
		{
			temp=word.charAt(i);
			if(tileScore.get(temp) != null);
			{
				System.out.println(tileScore.get(temp));
			}
			
		}
	}*/
	public static void main(String[] args) {
		
	}
	
}
