package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class TestDict {
	private static int count = 1;
	public static void main(String [] args) throws IOException {
		Dictionary<String, Integer> dict = new Hashtable<String, Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your word : ");
		String test = sc.next();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String fileURL = classLoader.getResource("dictionary.txt").getFile();
		//File tx = new File(class.TestDict.getResource("/dictionary.txt"));
		Reader r = new FileReader(fileURL);
		BufferedReader br = new BufferedReader(r);
		String s = "";
		while((s = br.readLine()) != null) {
			String sp = s;
			dict.put(sp, count++);
		}
		Enumeration<String> k = dict.keys();
        while (k.hasMoreElements()) {
            String key = k.nextElement();
            if(test.equals(key)) {
            	System.out.println("Found it "+dict.get(key));
            }
            
        }
	}

}
