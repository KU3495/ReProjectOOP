package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame implements MouseListener{
	private Board gameBoard;
	private Player p1;
	private Player p2;
	private String keep = "";
	public Test(String title){
		super(title);
		Container MainPane= getContentPane();
		gameBoard = new Board();
		p1 = new Player();
		MainPane.add(gameBoard.getBoard());
		MainPane.add(p1.getPYHand());
		for(int i=0; i<7; i++) {
			p1.getHandButton(i).addMouseListener(this);
		}
		
		setSize(1000,800);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Test t = new Test("Scrabble");

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton ex = (JButton)e.getSource();
		System.out.println(p1.getHandButtonLength());
		for(int i=0;i<p1.getHandButtonLength();i++) {
			if(ex.equals(p1.getHandButton(i))) {
				p1.setHandButton(i);
				keep=String.valueOf(p1.getHandButton(i).getText());
				System.out.println("Test "+keep);
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
