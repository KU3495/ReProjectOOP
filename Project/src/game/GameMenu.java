package game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameMenu extends JFrame implements MouseListener{
	private JPanel mainPanel=new JPanel();
	private JButton[] mainButton= new JButton[3];
	private JLabel Title=new JLabel();
	
	public GameMenu(String title) {
		super(title);
		Container MainPane= getContentPane();

		mainPanel.setPreferredSize(new Dimension(200,200));
		//mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.setLayout(new GridLayout(4,1,0,5));
		mainPanel.setMaximumSize(new Dimension(200, 200));
		
		Title.setText("<html><h1><strong><i>Scrabble</i></strong></h1></html>");

		mainButton[0]= new JButton("Start");
		mainButton[0].addMouseListener(this);
		
		mainButton[1]= new JButton("How to play");
		mainButton[1].addMouseListener(this);
		
		mainButton[2]= new JButton("Exit");
		mainButton[2].addMouseListener(this);

		mainPanel.add(Title);
		mainPanel.add(mainButton[0]);
		mainPanel.add(mainButton[1]);
		mainPanel.add(mainButton[2]);
		MainPane.add(mainPanel);

		setSize(400,300);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton ex = (JButton)e.getSource();
		if(ex.equals(mainButton[0])) {
			Main start=new Main("Scrabble");
			dispose();
		}
		
		if(ex.equals(mainButton[1])) {
			How2Play how=new How2Play("How To Play");
			dispose();
		}
		
		if(ex.equals(mainButton[2])) {
			dispose();
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
	
}
