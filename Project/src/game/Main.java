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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Main extends JFrame implements MouseListener{
	private static final int ROW=15, COL=15;
	private Board gameBoard;
	private Hand h1;
	private Options Op;
	private TextDisplay TUI;
	private Player[] player;
	private Player player1=new Player();
	private Player player2=new Player();
	private int memhand=0;
	private String keep = "", wordList="";
	private boolean flagSelect=false;
	
	public Main(String title){
		super(title);
		Container MainPane= getContentPane();
		gameBoard = new Board();
		h1 = new Hand();
		Op = new Options();
		TUI = new TextDisplay();
		player = new Player[2];
		
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				gameBoard.getBoardButton(i, j).addMouseListener(this);
			}	
		}
		for(int i=0; i<7; i++) {
			h1.getHandButton(i).addMouseListener(this);
		}
		for(int i=0; i<3; i++) {
			Op.getOpButton(i).addMouseListener(this);
		}
		
		MainPane.add(gameBoard.getBoard()); //ADD BOARD
		//MainPane.add(player1.getScroll()); //ADD PLAYER1
		//MainPane.add(player2.getScroll()); //ADD PLAYER2
		MainPane.add(TUI.getScroll()); //ADD TEXTAREA
		MainPane.add(h1.getPYHand()); //ADD HAND
		MainPane.add(Op.getOption()); //ADD OPTION
		setSize(1000,800);
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
		//getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
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

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton ex = (JButton)e.getSource();
		for(int i=0;i<h1.getHandButtonLength();i++) {
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
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				if(ex.equals(gameBoard.getBoardButton(i, j))) {
					if(!gameBoard.getBoardButton(i, j).getText().equals("")) {
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
						//ShowPlace(i, j);
						System.out.println(keep);
						showAllPlace();
						flagSelect=false;
						h1.getHandButton(memhand).setBackground(Color.CYAN);
						h1.getHandButton(memhand).setText("");
						wordList+=keep;
						keep="";
						try {
							TestDict testdict = new TestDict(wordList);
							HashLetter hash = new HashLetter();
							//hash.calScore(wordList);
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					}
					
				}
			}	
		}
		
		for(int i=0;i<3;i++) {
			if(ex.equals(Op.getOpButton(0))) {
				Op.getOpButton(0).setBackground(Color.BLACK);
			}
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
