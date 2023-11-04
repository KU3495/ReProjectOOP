package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Board{
	private int i=0,j=0;
	private ArrayList<ImageIcon> Icon=new ArrayList<>();
	private JButton[][] boardButton=new JButton[15][15];
	private JPanel MainPanel=new JPanel();
	
	private int[][] boardarray={
            {4, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 4},
            {0, 3, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 3, 0, 0, 0, 2, 0, 2, 0, 0, 0, 3, 0, 0},
            {2, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 2},
            {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0},
            {4, 0, 0, 2, 0, 0, 0, 5, 0, 0, 0, 2, 0, 0, 4},
            {0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
            {2, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 2},
            {0, 0, 3, 0, 0, 0, 2, 0, 2, 0, 0, 0, 3, 0, 0},
            {0, 3, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0},
            {4, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 4}
        };

	private ImageIcon icon2L=new ImageIcon(this.getClass().getResource("/2Lnew.png"));
	private ImageIcon icon3L=new ImageIcon(this.getClass().getResource("/3Lnew.png"));
	private ImageIcon icon2w=new ImageIcon(this.getClass().getResource("/2Wnew.png"));
	private ImageIcon icon3w=new ImageIcon(this.getClass().getResource("/3Wnew.png"));
	
	public Board() {
		Icon.add(icon2L);
		Icon.add(icon3L);
		Icon.add(icon2w);
		Icon.add(icon3w);
		
		MainPanel.setPreferredSize(new Dimension(675,675));
		MainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		MainPanel.setLayout(new GridLayout(15,15));
		MainPanel.setMaximumSize(new Dimension(675, 675));
	    //MainPanel.setBorder(BorderFactory.createTitledBorder("Test Board"));
	    
	    for(i=0; i<15; i++) {
			for(j=0; j<15; j++) {
				boardButton[i][j]= new JButton("");
				SetBoard(i,j);
				MainPanel.add(boardButton[i][j]);
			}
	    }
	}
	
	public void SetBoard(int i, int j) {
				boardButton[i][j].setBackground(Color.DARK_GRAY);
				boardButton[i][j].setForeground(Color.BLACK);
				boardButton[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
				case 5: 
						boardButton[i][j].setBackground(Color.ORANGE);
						boardButton[i][j].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
				break;
				}
	}
	
	public JPanel getBoard() {
		return MainPanel;
	}
	
	public JButton getBoardButton(int x,int y) {
		return boardButton[x][y];
	}
	
	public int getBoardArray(int x,int y) {
		return boardarray[x][y];
	}
	
	public ImageIcon getIcon(int i) {
		return Icon.get(i);
	}
	
	public void setBoardButton(int i,int j,String key) {
		
	}


}

