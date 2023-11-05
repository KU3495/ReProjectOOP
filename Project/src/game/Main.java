package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main extends JFrame implements MouseListener{
	private static final int ROW=15, COL=15;
	private JPanel TextPanel=new JPanel();
	private Board gameBoard;
	private Hand hand;
	private Options Op;
	private TextOption TUI;
	private Player[] player;
	private Dict dictionary = null;
	private HashLetter hash = null;
	private String keep ="";
	private boolean valid = true, flagDir=false, flagSwap=false, flagSkip=false;
	private int memhand=0, dir=0;
	private int numOfPlayer=0;
	private int i,j,Score=0;
	private int dirCol1=0,dirCol2=0,dirRow1=0,dirRow2=0;
	private int startRow=0, startCol=0;
	private ArrayList<Integer> Special=new ArrayList<Integer>();
	private ArrayList<String> ArrWord=new ArrayList<String>();
	private JButton BacktoMenu=new JButton("Back To Menu");
	private JButton BagPack=new JButton("TILEBAG");

	
	private int[][] status=new int[15][15];
	
	public Main(String title){
		super(title);
		try {
			dictionary = new Dict();
			hash = new HashLetter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Container MainPane= getContentPane();
		gameBoard = new Board();
		hand = new Hand();
		Op = new Options();
		TUI = new TextOption();
		player = new Player[2];
		
		for(i=0;i<ROW;i++) {
			for(j=0;j<COL;j++) {
				gameBoard.getBoardButton(i, j).addMouseListener(this);
			}	
		}
		
		for(i=0; i<7; i++)
			hand.getHandButton(i).addMouseListener(this);

		for(i=0; i<4; i++)
			Op.getOpButton(i).addMouseListener(this);

		for(i=0; i<2; i++) {
			int numplayer=i+1;
			player[i]=new Player();
			player[i].getText().setText("Player " + numplayer + " Score: 0");
		}
		
		BacktoMenu.addMouseListener(this);
		
		TextPanel.setPreferredSize(new Dimension(350,670));
		TextPanel.add(player[0].getText());
		TextPanel.add(player[1].getText());
		TextPanel.add(TUI.getTextCheck());
		TextPanel.add(TUI.getTextF());
		BagPack.addMouseListener(this);
		TextPanel.add(BagPack);
		TextPanel.setBackground(Color.BLACK);
		
		MainPane.add(gameBoard.getBoard()); //ADD BOARD
		MainPane.add(TextPanel); //ADD TEXTAREA
		MainPane.add(hand.getPYHand()); //ADD HAND
		MainPane.add(Op.getOption()); //ADD OPTION
		MainPane.add(BacktoMenu);
		
		//SetHand();
		
		for(int k=0; k<7; k++) {
			String random=hand.getBag().getLetter();
			if(random=="") {
				k--;
			}else {
				player[0].setArrHand(random);
				hand.getBag().RemoveFromBag(random);				
			}
		}
		
		for(int k=0; k<7; k++) {
			String random=hand.getBag().getLetter();
			if(random=="") {
				k--;
			}else {
				player[1].setArrHand(random);
				hand.getBag().RemoveFromBag(random);
			}
		}
		SetHand();
		
		setSize(1055,800);
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
		MainPane.setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void showAllPlace() {
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
	
	public void PickUp(String word) {
		int i;
		for(i=0; i<7; i++) {
			if(hand.getHandButton(i).getText().equals("")) {
				hand.getHandButton(i).setText(word);
				break;
			}
		}
	}
	
	public void checkWord(int row, int col, int dir, boolean flagSubmmit) {
		int i,j;
		int memrow=0,memcol=0;
		String word1="",word2="";
		try {
			if(dir==0) {
				//FindStartCol
				i=row; j=col;
				while(!gameBoard.getBoardButton(i, j).getText().equals("")) {
					startCol=j;
					j--;
				}
				
				//GetWordCol
				i=memrow=row; j=startCol;
				while(!gameBoard.getBoardButton(i, j).getText().equals("")) {
					word1+=gameBoard.getBoardButton(i, j).getText();
					
					if(status[i][j]==0 && gameBoard.getBoardArray(i, j) > 0) {
						int sp=gameBoard.getBoardArray(i, j);
						Special.add(sp);
					}else {
						Special.add(0);
					}
					
					//GetWordRow
					if(status[i][j]==0 && 
						(!gameBoard.getBoardButton(i-1, j).getText().equals("")||
						!gameBoard.getBoardButton(i+1, j).getText().equals(""))) {
						
						while(!gameBoard.getBoardButton(i, j).getText().equals("")) {
							System.out.println("Col");
							startRow=i;
							i--;
						}
						
						i=startRow;
						while(!gameBoard.getBoardButton(i, j).getText().equals("")) {
							word2+=gameBoard.getBoardButton(i, j).getText();
							i++;
						}
						if(dictionary.checkWord(word2))
							ArrWord.add(word2);
						else
							valid = false;
						
						i=memrow;
					}
					
					if(flagSubmmit) {
						status[i][j]=1;						
					}
					j++;
					word2="";
				}
				
				if(dictionary.checkWord(word1)) {
					ArrWord.add(word1);
					System.out.println("In here");
					System.out.println(ArrWord);
				}
				else
					valid = false;
				
			}else if(dir==1) {
				//FindStartRow
				i=row; j=col;
				while(!gameBoard.getBoardButton(i, j).getText().equals("")) {
					startRow=i;
					i--;
				}
				
				//GetWordRow
				j=memcol=col; i=startRow;
				while(!gameBoard.getBoardButton(i, j).getText().equals("")) {
					word1+=gameBoard.getBoardButton(i, j).getText();
					
					if(status[i][j]==0 && gameBoard.getBoardArray(i, j) > 0) {
						int sp=gameBoard.getBoardArray(i, j);
						Special.add(sp);
					}else {
						Special.add(0);
					}
					
					//GetWordCol
					if(status[i][j]==0 && 
						(!gameBoard.getBoardButton(i, j-1).getText().equals("")
						||!gameBoard.getBoardButton(i, j+1).getText().equals(""))) {
						while(!gameBoard.getBoardButton(i, j).getText().equals("")) {
							System.out.println("Row");
							startCol=j;
							j--;
						}
						
						j=startCol;
						while(!gameBoard.getBoardButton(i, j).getText().equals("")) {
							word2+=gameBoard.getBoardButton(i, j).getText();
							j++;
						}
						
						if(dictionary.checkWord(word2))
							ArrWord.add(word2);
						else
							valid = false;
						
						j=memcol;
					}
					
					if(flagSubmmit) {
						status[i][j]=1;						
					}
					i++;
					word2="";
				}
				
				if(dictionary.checkWord(word1)) {
					ArrWord.add(word1);
					System.out.println("In here");
					System.out.println(ArrWord);
				}
				else
					valid = false;
			}
		}catch(Exception ex) {
			
		}
		
		System.out.println(Special);
	}
	
	public boolean Swap() {
		boolean ConfirmSwap=false;
		int i;
		String L;
		for(i=0; i<7; i++) {
			if(hand.getHandButton(i).getBackground().equals(Color.YELLOW)) {
				L=hand.getHandButton(i).getText();
				hand.getBag().AddToBag(L);
				hand.getHandButton(i).setText("");
				hand.getHandButton(i).setBackground(Color.CYAN);
				int handspace=hand.getHandSpace();
				for(int k=0; k<handspace; k++) {
					L=String.valueOf(hand.getBag().getLetter());
					if(hand.getBag().RemoveFromBag(L)) {
						//hand.getBag().RemoveFromBag(L);
						PickUp(L);
					}else k--;
				}
				ConfirmSwap=true;
			}
		}
		return ConfirmSwap;
	}
	
	public void SetHand() {
		int i;
		for(i=0; i<7; i++) {
			hand.getHandButton(i).setText(player[numOfPlayer].getArrHand(i));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton ex = (JButton)e.getSource();

		//Hand
		if(!flagSwap && !flagSkip) {
			for(i=0;i<hand.getHandButtonLength();i++) {
				if(ex.equals(hand.getHandButton(i))) {
					if(hand.getHandButton(i).getBackground().equals(Color.RED)){
						keep="";
						System.out.println("In Here");
						hand.getHandButton(i).setBackground(Color.CYAN);
					}else{
						hand.getHandButton(memhand).setBackground(Color.CYAN);
						hand.getHandButton(i).setBackground(Color.RED);
						keep=String.valueOf(hand.getHandButton(i).getText());
						System.out.println("Test "+keep);
						memhand=i;
					}
					
				}
				
			}			
		}else if(!flagSkip){
			for(i=0;i<hand.getHandButtonLength();i++) {
				if(ex.equals(hand.getHandButton(i))) {
					if(hand.getHandButton(i).getBackground().equals(Color.YELLOW)){
						hand.getHandButton(i).setBackground(Color.CYAN);
					}else{
						hand.getHandButton(i).setBackground(Color.YELLOW);
					}
				}
					
			}
		}
		
		//Board
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
						gameBoard.getBoardButton(i, j).setBackground(Color.WHITE);
						gameBoard.getBoardButton(i, j).setIcon(null);
						System.out.println(keep);
						showAllPlace();
						hand.getHandButton(memhand).setBackground(Color.CYAN);
						hand.getHandButton(memhand).setText("");
						keep="";
						
						startRow=i;
						startCol=j;
						
						if(!flagDir) {
							System.out.println(i+" "+j);
							dirRow1=i;
							dirCol1=j;
							flagDir=true;
						}else {
							if(dirRow1==i && dirCol1!=j) {
								System.out.println(i+"++++"+j);
								dir=0;
							}else if(dirRow1!=i && dirCol1==j) {
								System.out.println(i+"----"+j);
								dir=1;								
							}
						}
					}
					
				}
			}	
		}
		
		//Option
		int numplayer=numOfPlayer+1;
		
		//Submit
		if(ex.equals(Op.getOpButton(0)) && !flagSwap && !flagSkip) {
					
			checkWord(startRow, startCol, dir, true);
			for(String str : ArrWord){
				hash.calScore(str,Special);
				Score+=hash.getScore();
				System.out.println("Score of "+ str +": "+hash.getScore());							
			}
			TUI.getTextCheck().setText("Valid: " + valid + " Score: " + Score);

			player[numOfPlayer].setScore(Score);
			player[numOfPlayer].setTextScore("Player " + numplayer + " Score: ");
				
			int handspace=hand.getHandSpace();
			for(int k=0; k<handspace; k++) {
				String L=String.valueOf(hand.getBag().getLetter());
				if(hand.getBag().RemoveFromBag(L)) {
					//hand.getBag().RemoveFromBag(L);
					PickUp(L);
				}else k--;
			}
			
			
			if(Score!=0) {
				for(int k=0; k<7; k++) {
					player[numOfPlayer].setArrHand(hand.getHandButton(k).getText());				
				}
				if(numOfPlayer==0){
					TUI.getTextF().setText("TURN PLAYER 2");
					numOfPlayer=1;
					
				}else if(numOfPlayer==1){
					TUI.getTextF().setText("TURN PLAYER 1");
					numOfPlayer=0;
				}				
			}
					
			if(flagDir) {
				flagDir=false;
			}
					
			hash.setScore(0);
			ArrWord.removeAll(ArrWord);
			Special.removeAll(Special);
			startRow=-1;
			startCol=-1;
			Score=0;
			SetHand();
		}
		
		//Swap
		if(ex.equals(Op.getOpButton(1)) && !flagSkip) {
			if(Op.getOpButton(1).getBackground().equals(Color.YELLOW)) {
				Op.getOpButton(1).setBackground(Color.WHITE);
				if(Swap()) {
					Op.getOpButton(2).setBackground(Color.CYAN);
					flagSkip=true;
				}
				flagSwap=false;
			}else {
				Op.getOpButton(1).setBackground(Color.YELLOW);
				flagSwap=true;
			}
		}
		
		//Skip
		if(ex.equals(Op.getOpButton(2)) && !flagSwap) {
			
			for(int k=0; k<7; k++) {
				player[numOfPlayer].setArrHand(hand.getHandButton(k).getText());				
			}
			
			if(numOfPlayer==0){
				TUI.getTextF().setText("TURN PLAYER 2");
				numOfPlayer=1;
			}else if(numOfPlayer==1){
				TUI.getTextF().setText("TURN PLAYER 1");
				numOfPlayer=0;
			}
			Op.getOpButton(2).setBackground(Color.WHITE);
			flagSkip=false;
			SetHand();
		}
		
		//Check
		if(ex.equals(Op.getOpButton(3)) && !flagSwap && !flagSkip) {
			checkWord(startRow, startCol, dir, false);
			System.out.println("////// "+ArrWord);
			for(String str : ArrWord) {
				hash.calScore(str,Special);
				Score+=hash.getScore();
				System.out.println("Score of "+str+": "+hash.getScore());
			}
			TUI.getTextCheck().setText("Valid: " + valid + " Score: " + Score);

			if(flagDir) {
				flagDir=false;
			}
			ArrWord.removeAll(ArrWord);
			Special.removeAll(Special);
			Score=0;
		}
		
		//Back to menu
		if(ex.equals(BacktoMenu)) {
			GameMenu back=new GameMenu("Scrabble");
			dispose();
		}
		
		if(ex.equals(BagPack)) {
			BagMenu bag=new BagMenu("Tilebag",hand.getBag().gettilebag());
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
