package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.*;

public class Scrabble extends JFrame{
	JButton[][] boardButton=new JButton[15][15];
	JButton[] handButton=new JButton[7];
	private int[] handarray=new int[7];
	private int i=0,j=0;
	
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
	
	public Scrabble(String title) {
		super(title);
		Container MainPane= getContentPane();
		JLayeredPane LayerPane = getLayeredPane();
		ImageIcon board=new ImageIcon(this.getClass().getResource("/3W.png"));
		JPanel MainPanel=new JPanel();
		MainPanel.setPreferredSize(new Dimension(700,700));
		MainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		MainPanel.setLayout(new GridLayout(15,15));
		MainPanel.setMaximumSize(new Dimension(700, 700));
	    MainPanel.setBorder(BorderFactory.createTitledBorder("Test Board"));
	    getContentPane().add(MainPanel);
	    
		JPanel HandPanel=new JPanel();
		HandPanel.setPreferredSize(new Dimension(600,50));
		HandPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		HandPanel.setLayout(new GridLayout(1,7));
		HandPanel.setMaximumSize(new Dimension(600, 50));
	    HandPanel.setBorder(BorderFactory.createTitledBorder("Test HAND"));
	    getContentPane().add(HandPanel);
		
		for(i=0; i<15; i++) {
			for(j=0; j<15; j++) {
				switch(boardarray[i][j]) {
				case 0: boardButton[i][j]= new JButton("");
				break;
				case 1: boardButton[i][j]= new JButton("2L");
				break;
				case 2: boardButton[i][j]= new JButton("3L");
				break;
				case 3: boardButton[i][j]= new JButton("2W");
				break;
				case 4: boardButton[i][j]= new JButton("3W");
						boardButton[i][j].setIcon(board); 
				break;
				}
				
				boardButton[i][j].setFont(new Font("MS UI Gothic", Font.BOLD, 9));
				boardButton[i][j].setForeground(Color.WHITE);
				boardButton[i][j].setBackground(Color.BLACK);
				MainPanel.add(boardButton[i][j]);
			}
		}
		
		Random random = new Random();
		for(i=0; i<7; i++) {
			char randomLetter = (char) (random.nextInt(26) + 'A');
			handButton[i]= new JButton(String.valueOf(randomLetter));
			HandPanel.add(handButton[i]);
		}
		
		JPanel TestPanel=new JPanel();
		TestPanel.setPreferredSize(new Dimension(600,50));
		TestPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		TestPanel.setLayout(new GridLayout(4,1));
		TestPanel.setMaximumSize(new Dimension(50, 500));
	    TestPanel.setBorder(BorderFactory.createTitledBorder("Test option"));
	    getContentPane().add(TestPanel);
		
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
	
	public static void main(String[] args) {
		Scrabble newgame = new Scrabble("Scrabble Game");
	}
}
