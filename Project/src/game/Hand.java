package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Hand {
	private JButton[] handButton=new JButton[7];
	private JPanel HandPanel=new JPanel();
	private TileBag bag=null;
	private int i=0,j=0;
	public Hand() {
		HandPanel.setPreferredSize(new Dimension(600,50));
		HandPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		HandPanel.setLayout(new GridLayout(1,7));
		HandPanel.setMaximumSize(new Dimension(600, 50));
		HandPanel.setBackground(Color.BLACK);
		try {
			bag=new TileBag();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(i=0; i<7; i++) {
			
			handButton[i] = new JButton();
			handButton[i].setBackground(Color.CYAN);
			HandPanel.add(handButton[i]);
		}
	}
	public JPanel getPYHand() {
		return HandPanel;
	}
	public void setHandButton(int i) {
		handButton[i].setBackground(Color.CYAN);
	}
	public JButton getHandButton(int i) {
		return handButton[i];
	}
	public int getHandButtonLength() {
		return handButton.length;
	}
	
	public TileBag getBag() {
		return bag;
	}
	public int getHandSpace() {
		int i,count=0;
		for(i=0; i<7; i++) {
			if(handButton[i].getText()=="") {
				count++;
			}
		}

		return count;
	}

}
