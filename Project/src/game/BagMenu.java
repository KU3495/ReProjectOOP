package game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class BagMenu extends JFrame{
	private JTextArea letter=new JTextArea();
	String Text="";
	public BagMenu(String title, Hashtable<String, Integer> tilebag) {
		super(title);
		Container MainPane= getContentPane();
		
		letter.setPreferredSize(new Dimension(500,600));
		letter.setFont(new Font("Arial",Font.PLAIN, 20));
		letter.setLineWrap(true);
		letter.setEditable(false);
		letter.setWrapStyleWord(true);
		
		for(int i=0; i<26; i++) {
			char L=(char) (i+'A');
			String letter=String.valueOf(L);
			//Integer num=tilebag.get(letter);
			Text+= L+": "+tilebag.get(letter)+"\t";
			if(i%2==1) {
				Text+="\n";
			}
		}
		letter.setText(Text);
		
		MainPane.add(letter);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
