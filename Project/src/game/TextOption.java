package game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextOption {
	private JTextArea textF=new JTextArea();
	private JTextArea textCheck= new JTextArea();
	
	public TextOption() {
		//textF.setPreferredSize(new Dimension(280,270));
		textF.setPreferredSize(new Dimension(280,40));
		textF.setFont(new Font("Arial",Font.PLAIN, 30));
		textF.setLineWrap(true);
		textF.setEditable(false);
		textF.setWrapStyleWord(true);
		textF.setText("TURN PLAYER 1");
		
		textCheck.setPreferredSize(new Dimension(280,40));
		textCheck.setFont(new Font("Arial",Font.PLAIN, 30));
		textCheck.setLineWrap(true);
		textCheck.setEditable(false);
		textCheck.setWrapStyleWord(true);
	}
	
	public JTextArea getTextF() {
		return textF;
	}
	
	public JTextArea getTextCheck() {
		return textCheck;
	}
}
