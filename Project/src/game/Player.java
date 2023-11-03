package game;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Player {
	private int Score;
	
	private JTextArea textF=new JTextArea();
	private JScrollPane scroll= new JScrollPane();
	
	public Player() {
		Score=0;
		textF.setPreferredSize(new Dimension(280,200));
		textF.setFont(new Font("Arial",Font.PLAIN, 30));
		textF.setLineWrap(true);
		textF.setEditable(false);
		textF.setWrapStyleWord(true);
		String test=""; int i;
		/*for(i=0; i<5; i++) {
			test+="test"+"\n";
		}*/
		textF.setText(String.valueOf(Score));
		scroll = new JScrollPane(textF);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
	
	public JScrollPane getScroll() {
		return scroll;
	}

	public void setTextScore(int score)
	{
		textF.setText(String.valueOf(score));
	}
	
}
