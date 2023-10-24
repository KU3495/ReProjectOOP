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
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;

public class Test_Scrabble extends JFrame implements MouseListener{
	private static final int ROW=15, COL=15;
	
	private JButton[][] boardButton=new JButton[ROW][COL];
	private JButton[] handButton=new JButton[7];
	private int[] handarray=new int[7];
	private int[][] statusShow=new int[ROW][COL];
	private int i=0,j=0,memhand=0;
	private JPanel MainPanel=new JPanel();
	private JPanel HandPanel=new JPanel();
	private String keep = "";
	private Boolean flagSelect=false;
	
	ImageIcon icon2w=new ImageIcon(this.getClass().getResource("/2Wnew.png"));
	ImageIcon icon3w=new ImageIcon(this.getClass().getResource("/3Wnew.png"));
	ImageIcon icon2L=new ImageIcon(this.getClass().getResource("/2Lnew.png"));
	ImageIcon icon3L=new ImageIcon(this.getClass().getResource("/3Lnew.png"));
	
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
	
	public void Swap() {
		Random random = new Random();
		for(i=0; i<7; i++) {
			char randomLetter = (char) (random.nextInt(26) + 'A');
			handButton[i]= new JButton(String.valueOf(randomLetter));
			HandPanel.add(handButton[i]);
		}
	}
	
	public void ShowPlace(int rows, int cals) {
		int N=cals+1,E=rows+1,S=cals-1,W=rows-1;
		
		try {
			if(boardButton[E][cals].getText()=="") {
				boardButton[E][cals].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
				statusShow[E][cals]++;
			}
		
			if(boardButton[W][cals].getText()=="") {
				boardButton[W][cals].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
				statusShow[W][cals]++;
			}
		
			if(boardButton[rows][N].getText()=="") {
				boardButton[rows][N].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
				statusShow[rows][N]++;
			}
		
			if(boardButton[rows][S].getText()=="") {
				boardButton[rows][S].setBorder(BorderFactory.createLineBorder(Color.ORANGE));	
				statusShow[rows][S]++;
			}
		}catch(Exception e) {}
	}
	
	public void UnShowPlace(int rows, int cals) {
		int N=cals+1,E=rows+1,S=cals-1,W=rows-1;
		
		try {
			if(boardButton[E][cals].getText()=="") {
				statusShow[E][cals]--;
				if(statusShow[E][cals]==0) {
					boardButton[E][cals].setBorder(BorderFactory.createLineBorder(Color.BLACK));									
				}
			}
		
			if(boardButton[W][cals].getText()=="") {
				statusShow[W][cals]--;
				if(statusShow[W][cals]==0) {
					boardButton[W][cals].setBorder(BorderFactory.createLineBorder(Color.BLACK));												
				}
			}
		
			if(boardButton[rows][N].getText()=="") {
				statusShow[rows][N]--;
				if(statusShow[rows][N]==0) {
					boardButton[rows][N].setBorder(BorderFactory.createLineBorder(Color.BLACK));												
				}
			}
		
			if(boardButton[rows][S].getText()=="") {
				statusShow[rows][S]--;
				if(statusShow[rows][S]==0) {
					boardButton[rows][S].setBorder(BorderFactory.createLineBorder(Color.BLACK));												
				}
			}
		}catch(Exception e) {}
	}
	
	void showAllPlace() {
		int rows,cals;
		for(rows=0; rows<ROW; rows++) {
			for(cals=0; cals<COL; cals++) {
				int N=cals+1,E=rows+1,S=cals-1,W=rows-1;
				try {
					if(boardButton[E][cals].getText()!="" || boardButton[W][cals].getText()!="" || 
						boardButton[rows][N].getText()!="" || boardButton[rows][S].getText()!="") {
						
						boardButton[rows][cals].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
					}else {
						boardButton[rows][cals].setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}					
				}catch(Exception e) {
					
				}
			}
		}
	}
	
	public Test_Scrabble(String title) {
		super(title);
		Container MainPane= getContentPane();
		JLayeredPane LayerPane = getLayeredPane();
		
		MainPanel.setPreferredSize(new Dimension(675,675));
		MainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		MainPanel.setLayout(new GridLayout(ROW,COL));
		MainPanel.setMaximumSize(new Dimension(675, 675));
	    MainPanel.setBorder(BorderFactory.createTitledBorder("Test Board"));
	    //getContentPane().add(MainPanel);
	    
		for(i=0; i<COL; i++) {
			for(j=0; j<ROW; j++) {
				boardButton[i][j]= new JButton("");
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
						//boardButton[i][j].setText("S"); 
						boardButton[i][j].setForeground(Color.YELLOW); 
						boardButton[i][j].setBackground(Color.ORANGE);
						boardButton[i][j].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
				break;
				}
				
				//boardButton[i][j].setFont(new Font("MS UI Gothic", Font.BOLD, 9));
				//boardButton[i][j].setForeground(Color.WHITE);
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
			handButton[i].setBackground(Color.CYAN);
			handButton[i].addMouseListener(this);
			HandPanel.add(handButton[i]);
		}

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
		
		//Test
		for(int i=0;i<boardButton.length;i++) {
			for(int j=0;j<boardButton[i].length;j++) {
				boardButton[i][j].addMouseListener(this);
			}	
		}
		//Test
		
		setSize(1000,800);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton ex = (JButton)e.getSource();
		for(int i=0;i<handButton.length;i++) {
			if(ex.equals(handButton[i])) {
				if(handButton[i].getBackground().equals(Color.RED) && flagSelect==true){
					keep="";
					System.out.println("In Here");
					handButton[i].setBackground(Color.CYAN);
					flagSelect=false;
				}
				else if(flagSelect==false){
					handButton[i].setBackground(Color.RED);
					keep=String.valueOf(handButton[i].getText());
					System.out.println("Test "+keep);
					flagSelect=true;
					memhand=i;
				}
			}
		}
		for(int i=0;i<boardButton.length;i++) {
			for(int j=0;j<boardButton[i].length;j++) {
				if(ex.equals(boardButton[i][j])) {
					if(!boardButton[i][j].getText().equals("")) {
						boardButton[i][j].setText("");
						System.out.println("in null");
						boardButton[i][j].setBackground(Color.DARK_GRAY);
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
							boardButton[i][j].setForeground(Color.YELLOW); 
							boardButton[i][j].setBackground(Color.ORANGE);
							boardButton[i][j].setBorder(BorderFactory.createLineBorder(Color.ORANGE));

						break;
						}
						showAllPlace();
						boardButton[7][7].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
						//UnShowPlace(i, j);
					}	
					else {
						LineBorder border = (LineBorder) boardButton[i][j].getBorder();
						if(keep=="" || border.getLineColor()!=Color.ORANGE) return;
						boardButton[i][j].setText(String.valueOf(keep));
						boardButton[i][j].setForeground(Color.BLACK);
						boardButton[i][j].setBackground(Color.WHITE);
						boardButton[i][j].setIcon(null);
						boardButton[i][j].setFont(new Font("Cordia New",Font.PLAIN,15));
						//ShowPlace(i, j);
						System.out.println(keep);
						showAllPlace();
						flagSelect=false;
						handButton[memhand].setBackground(Color.CYAN);
						keep="";
					}
					
				}
			}	
		}
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
		Test_Scrabble newgame = new Test_Scrabble("Scrabble Game");
	}
}
