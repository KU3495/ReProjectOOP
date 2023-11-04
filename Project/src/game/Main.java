package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Main extends JFrame implements MouseListener{
	private static final int ROW=15, COL=15;
	private JPanel TextPanel=new JPanel();
	private Board gameBoard;
	private Hand h1;
	private Options Op;
	private TextOption TUI;
	private Player[] player;
	private Dict testdict = null;
	private HashLetter hash = null;
	private String keep = "", wordList="";
	private boolean flagSelect=false; 
	private int memhand=0;
	private int flagPlayer=0;
	private int i,j;
	private JButton BacktoMenu=new JButton("Back To Menu");

	
	public Main(String title){
		super(title);
		try {
			testdict = new Dict();
			hash = new HashLetter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Container MainPane= getContentPane();
		gameBoard = new Board();
		h1 = new Hand();
		Op = new Options();
		TUI = new TextOption();
		player = new Player[2];
		
		for(i=0;i<ROW;i++) {
			for(j=0;j<COL;j++) {
				gameBoard.getBoardButton(i, j).addMouseListener(this);
			}	
		}
		
		for(i=0; i<7; i++)
			h1.getHandButton(i).addMouseListener(this);

		for(i=0; i<3; i++)
			Op.getOpButton(i).addMouseListener(this);

		for(i=0; i<2; i++) {
			int numplayer=i+1;
			player[i]=new Player();
			player[i].getText().setText("Player " + numplayer + " Score: 0");
		}
		
		BacktoMenu.addMouseListener(this);
		
		TextPanel.setPreferredSize(new Dimension(300,670));
		TextPanel.add(player[0].getText());
		TextPanel.add(player[1].getText());
		TextPanel.add(TUI.getTextCheck());
		TextPanel.add(TUI.getTextF());
		
		MainPane.add(gameBoard.getBoard()); //ADD BOARD
		MainPane.add(TextPanel); //ADD TEXTAREA
		MainPane.add(h1.getPYHand()); //ADD HAND
		MainPane.add(Op.getOption()); //ADD OPTION
		MainPane.add(BacktoMenu);
		setSize(1050,800);
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	void showAllPlace() {
		int rows,cals;
		for(rows=0; rows<ROW; rows++) {
			for(cals=0; cals<COL; cals++) {
				int N=cals+1,E=rows+1,S=cals-1,W=rows-1;
				try {
					if(gameBoard.getBoardButton(E, cals).getText()!="" 
					|| gameBoard.getBoardButton(W, cals).getText()!="" 
					|| gameBoard.getBoardButton(rows, N).getText()!="" 
					|| gameBoard.getBoardButton(rows, S).getText()!="") {
						
						gameBoard.getBoardButton(rows,cals).setBorder(BorderFactory.createLineBorder(Color.ORANGE));
					}else {
						gameBoard.getBoardButton(rows,cals).setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}					
				}catch(Exception e) {}
			}
		}
	}
	
	void PickUp(String word) {
		int i;
		for(i=0; i<7; i++) {
			if(h1.getHandButton(i).getText().equals("")) {
				h1.getHandButton(i).setText(word);
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton ex = (JButton)e.getSource();
		for(i=0;i<h1.getHandButtonLength();i++) {
			if(ex.equals(h1.getHandButton(i))) {
				if(h1.getHandButton(i).getBackground().equals(Color.RED) && flagSelect==true){
					keep="";
					System.out.println("In Here");
					h1.getHandButton(i).setBackground(Color.CYAN);
					flagSelect=false;
				}
				else if(flagSelect==false){
					h1.getHandButton(i).setBackground(Color.RED);
					keep=String.valueOf(h1.getHandButton(i).getText());
					System.out.println("Test "+keep);
					flagSelect=true;
					memhand=i;
					
				}
				
			}
				
		}
		
		for(i=0;i<ROW;i++) {
			for(j=0;j<COL;j++) {
				if(ex.equals(gameBoard.getBoardButton(i, j))) {
					if(!gameBoard.getBoardButton(i, j).getText().equals("")) {
						PickUp(gameBoard.getBoardButton(i, j).getText());
						gameBoard.getBoardButton(i, j).setText("");
						System.out.println("in null");
						gameBoard.SetBoard(i, j);
						showAllPlace();
						gameBoard.getBoardButton(7, 7).setBorder(BorderFactory.createLineBorder(Color.ORANGE));
					}	
					else {
						LineBorder border = (LineBorder) gameBoard.getBoardButton(i, j).getBorder();
						if(keep=="" || border.getLineColor()!=Color.ORANGE) return;
						gameBoard.getBoardButton(i, j).setText(String.valueOf(keep));
						gameBoard.getBoardButton(i, j).setForeground(Color.BLACK);
						gameBoard.getBoardButton(i, j).setBackground(Color.WHITE);
						gameBoard.getBoardButton(i, j).setIcon(null);
						gameBoard.getBoardButton(i, j).setFont(new Font("Cordia New",Font.PLAIN,15));
						System.out.println(keep);
						showAllPlace();
						flagSelect=false;
						h1.getHandButton(memhand).setBackground(Color.CYAN);
						h1.getHandButton(memhand).setText("");
						wordList+=keep;
						keep="";
						try {
							if(testdict.checkWord(wordList))
								hash.calScore(wordList);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					}
					
				}
			}	
		}
				
		for(i=0;i<Op.getOpButtonLength();i++) {
			int numplayer=flagPlayer+1;
			if(ex.equals(Op.getOpButton(i))) {
				if(Op.getOpButton(i).getText().equals("Submit")) {
					Op.getOpButton(i).setBackground(Color.RED);
					player[flagPlayer].setScore(hash.getScore());
					player[flagPlayer].setTextScore("Player " + numplayer + " Score: ");
					if(flagPlayer==0){
						TUI.getTextF().setText("TURN PLAYER 2");
						flagPlayer=1;
					}else if(flagPlayer==1){
						TUI.getTextF().setText("TURN PLAYER 1");
						flagPlayer=0;
					}
				}
				
				if(Op.getOpButton(i).getText().equals("Swap")) {
					
				}
				
				if(Op.getOpButton(i).getText().equals("Skip")) {
					if(flagPlayer==0){
						TUI.getTextF().setText("TURN PLAYER 2");
						flagPlayer=1;
					}else if(flagPlayer==1){
						TUI.getTextF().setText("TURN PLAYER 1");
						flagPlayer=0;
					}
				}

				if(Op.getOpButton(i).getText().equals("Check")) {
									
				}
				
			}
		}
		
		if(ex.equals(BacktoMenu)) {
			GameMenu back=new GameMenu("Scrabble");
			dispose();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

}
