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
	private int[] handarray=new int[7];
	private int i=0,j=0;
	public void RandomHand() {
		//Random random = new Random();
		/*handButton[0] = new JButton("I");
		handButton[1] = new JButton("S");
		handButton[2] = new JButton("H");
		handButton[3] = new JButton("T");
		handButton[4] = new JButton("I");
		handButton[5] = new JButton("S");
		handButton[6] = new JButton("S");*/
		
		try {
			bag=new TileBag();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(i=0; i<7; i++) {
			//char randomLetter = (char) (random.nextInt(26) + 'A');
			//handButton[i]= new JButton(String.valueOf(randomLetter));
			
			String random=String.valueOf(bag.getLetter());
			bag.RemoveFromBag(random);
			handButton[i] = new JButton(random);
			
			handButton[i].setBackground(Color.CYAN);
			HandPanel.add(handButton[i]);
			//bag.DisplayBag();
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
		System.out.println("//// "+count);
		return count;
	}
	
}
