package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class Scrabble extends JFrame implements MouseListener{
	public JButton[][] boardButton=new JButton[15][15];
	public JButton[] handButton=new JButton[7];
	private int[] handarray=new int[7];
	private int i=0,j=0;
	public JPanel MainPanel=new JPanel();
	public JPanel HandPanel=new JPanel();
	
	private int[][] boardarray={
            {4, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 4},
            {0, 3, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 3, 0, 0, 0, 2, 0, 2, 0, 0, 0, 3, 0, 0},
            {2, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 2},
            {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0},
            {4, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 4},
            {0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
            {2, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 2},
            {0, 0, 3, 0, 0, 0, 2, 0, 2, 0, 0, 0, 3, 0, 0},
            {0, 3, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0},
            {4, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 4}
        };
	
	public void Swap() {
		Random random = new Random();
		for(i=0; i<7; i++) {
			char randomLetter = (char) (random.nextInt(26) + 'A');
			handButton[i]= new JButton(String.valueOf(randomLetter));
			HandPanel.add(handButton[i]);
		}
	}
	
	public Scrabble(String title) {
		super(title);
		Container MainPane= getContentPane();
		JLayeredPane LayerPane = getLayeredPane();
		ImageIcon icon2w=new ImageIcon(this.getClass().getResource("/2Wnew.png"));
		ImageIcon icon3w=new ImageIcon(this.getClass().getResource("/3Wnew.png"));
		ImageIcon icon2L=new ImageIcon(this.getClass().getResource("/2Lnew.png"));
		ImageIcon icon3L=new ImageIcon(this.getClass().getResource("/3Lnew.png"));
		
		MainPanel.setPreferredSize(new Dimension(675,675));
		MainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		MainPanel.setLayout(new GridLayout(15,15));
		MainPanel.setMaximumSize(new Dimension(675, 675));
	    MainPanel.setBorder(BorderFactory.createTitledBorder("Test Board"));
	    //getContentPane().add(MainPanel);
	    
		for(i=0; i<15; i++) {
			for(j=0; j<15; j++) {
				boardButton[i][j]= new JButton("");
				switch(boardarray[i][j]) {
				case 1: 
						boardButton[i][j].setIcon(icon2L);
				break;
				case 2: 
						boardButton[i][j].setIcon(icon3L); 
				break;
				case 3: 
						boardButton[i][j].setIcon(icon2w);
				break;
				case 4: 
						boardButton[i][j].setIcon(icon3w); 
				break;
				}
				
				//boardButton[i][j].setFont(new Font("MS UI Gothic", Font.BOLD, 9));
				//boardButton[i][j].setForeground(Color.WHITE);
				boardButton[i][j].setBackground(Color.DARK_GRAY);
				MainPanel.add(boardButton[i][j]);
			}
		}
		
		HandPanel.setPreferredSize(new Dimension(600,50));
		HandPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		HandPanel.setLayout(new GridLayout(1,7));
		HandPanel.setMaximumSize(new Dimension(600, 50));
		HandPanel.setBorder(BorderFactory.createTitledBorder("Test HAND"));
		//getContentPane().add(HandPanel);
		
		Random random = new Random();
		for(i=0; i<7; i++) {
			char randomLetter = (char) (random.nextInt(26) + 'A');
			handButton[i]= new JButton(String.valueOf(randomLetter));
			HandPanel.add(handButton[i]);
		}
		handButton[6]= new JButton("SWAP");
		HandPanel.add(handButton[6]);
		
		JPanel TestPanel=new JPanel();
		TestPanel.setPreferredSize(new Dimension(600,50));
		TestPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		TestPanel.setLayout(new GridLayout(4,1));
		TestPanel.setMaximumSize(new Dimension(50, 500));
	    TestPanel.setBorder(BorderFactory.createTitledBorder("Test option"));
	    //getContentPane().add(TestPanel);
		
		MainPane.add(MainPanel);
		MainPane.add(HandPanel);
		//MainPane.add(TestPanel);

		/*LayerPane.add(MainPanel, Integer.valueOf(0));
		LayerPane.add(HandPanel, Integer.valueOf(0));
		LayerPane.add(TestPanel, Integer.valueOf(1));*/
		
		setSize(1000,800);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Scrabble newgame = new Scrabble("Scrabble Game");
	}
}
