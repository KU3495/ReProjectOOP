package game;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Player {
	private int Score=0;
	private String[] Hand= new String[7];
	private JTextArea textF=new JTextArea();
	
	public Player() {
		textF.setPreferredSize(new Dimension(340,40));
		textF.setFont(new Font("Arial",Font.PLAIN, 30));
		textF.setLineWrap(true);
		textF.setEditable(false);
		textF.setWrapStyleWord(true);
		textF.setText(String.valueOf(Score));
		
		for(int i=0; i<7; i++) {
			Hand[i]="";
		}
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

	public void setTextScore(String text)
	{
		System.out.println(Score);
		textF.setText(text+String.valueOf(Score));
	}
	
	public void saveHand(String letter,int index) {
		Hand[index]=letter;
	}
	
	public String getArrHand(int i) {
		String L=Hand[i];
		Hand[i]="";
		return L;
	}
	
	public void setArrHand(String L) {
		int i;
		for(i=0; i<7; i++) {
			if(Hand[i]=="") {
				Hand[i]=L;
				break;
			}
		}
	}
}
