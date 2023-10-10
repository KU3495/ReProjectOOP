package game;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Test extends JFrame{
	private Board gameBoard;
	public Test(String title){
		super(title);
		Container MainPane= getContentPane();
		gameBoard = new Board();
		MainPane.add(gameBoard.getBoard());
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

}
