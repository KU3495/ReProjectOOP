package game;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Player {
	private int Score=0;
	
	private JTextArea textF=new JTextArea();
	
	public Player() {
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
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		System.out.println("TEST");
		Score += score;
	}
	
	public JTextArea getText() {
		return textF;
	}

	public void setTextScore()
	{
		System.out.println(Score);
		textF.setText(String.valueOf(Score));
	}
	
}
