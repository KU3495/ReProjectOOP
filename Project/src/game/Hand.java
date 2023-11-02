package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Hand {
	private JButton[] handButton=new JButton[7];
	private int[] handarray=new int[7];
	private int i=0,j=0;
	private JPanel HandPanel=new JPanel();
	public void RandomHand() {
		Random random = new Random();
		for(i=0; i<7; i++) {
			char randomLetter = (char) (random.nextInt(26) + 'A');
			handButton[i]= new JButton(String.valueOf(randomLetter));
			handButton[i].setBackground(Color.CYAN);
			HandPanel.add(handButton[i]);
		}
	}
	public Hand() {
		HandPanel.setPreferredSize(new Dimension(600,50));
		HandPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		HandPanel.setLayout(new GridLayout(1,7));
		HandPanel.setMaximumSize(new Dimension(600, 50));
		//HandPanel.setBorder(BorderFactory.createTitledBorder("Test HAND"));
		RandomHand();
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
	
}
