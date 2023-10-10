package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Board{
	private JButton[][] boardButton=new JButton[15][15];
	private int i=0,j=0;
	private JPanel MainPanel=new JPanel();
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
	public Board() {
		ImageIcon icon2w=new ImageIcon(this.getClass().getResource("/2Wnew.png"));
		ImageIcon icon3w=new ImageIcon(this.getClass().getResource("/3Wnew.png"));
		ImageIcon icon2L=new ImageIcon(this.getClass().getResource("/2Lnew.png"));
		ImageIcon icon3L=new ImageIcon(this.getClass().getResource("/3Lnew.png"));
		
		MainPanel.setPreferredSize(new Dimension(675,675));
		MainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		MainPanel.setLayout(new GridLayout(15,15));
		MainPanel.setMaximumSize(new Dimension(675, 675));
	    MainPanel.setBorder(BorderFactory.createTitledBorder("Test Board"));

	    
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
				boardButton[i][j].setBackground(Color.DARK_GRAY);
				MainPanel.add(boardButton[i][j]);
			}
		}
	}
	
	public JPanel getBoard() {
		return MainPanel;
	}
	public void setBoardButton(int i,int j,String key) {
		
	}


}

