package game;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;import java.util.Enumeration;
import java.util.HashMap;
public class HashLetter {

	int score=0;
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	String fileURL = classLoader.getResource("LetterScore&freq").getFile();
	private static HashMap<Character, Integer> tileScore = new HashMap();
	public HashLetter() throws NumberFormatException, IOException
	{
		Reader r = new FileReader(fileURL);
		BufferedReader br = new BufferedReader(r);
		String s = "";
		while((s = br.readLine()) != null) {
			String[] sp = s.split(",");
			char ch = sp[0].charAt(0);
			int lsc = Integer.parseInt(sp[2]);
			tileScore.put(ch, lsc);
			
		}
	}
	
	public void calScore(String word)
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
	}
	
	public static void main()
	{
		Enumeration<char> k = tileScore.keys();
        while (k.hasMoreElements()) {
            Character key = k.nextElement();
            if(key=='A') {
            	System.out.println("Found it "+tileScore.get(key));
            }
            
        }
	}
}
