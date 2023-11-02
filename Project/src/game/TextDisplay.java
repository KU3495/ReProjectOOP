package game;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextDisplay {
	private JTextArea textF=new JTextArea();
	private JScrollPane scroll= new JScrollPane();
	
	public TextDisplay() {
		textF.setPreferredSize(new Dimension(280,670));
		textF.setFont(new Font("Arial",Font.PLAIN, 50));
		textF.setLineWrap(true);
		textF.setEditable(false);
		textF.setWrapStyleWord(true);
		String test=""; int i;
		for(i=0; i<20; i++) {
			test+=i+"\n";
		}
		textF.setText(test);
		scroll = new JScrollPane(textF);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setBounds(10, 11, 455, 249);
	}

	public JTextArea getTextF() {
		return textF;
	}
	
	public JScrollPane getScroll() {
		return scroll;
	}

	public void setTextF(JTextArea textF) {
		this.textF = textF;
	}
	
	
}
