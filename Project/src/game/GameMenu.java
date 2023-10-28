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
import javax.swing.JPanel;

public class GameMenu extends JFrame implements MouseListener{
	private JPanel mainPanel=new JPanel();
	private JButton[] mainButton= new JButton[3];
	
	public GameMenu(String title) {
		super(title);
		Container MainPane= getContentPane();

		mainPanel.setPreferredSize(new Dimension(200,200));
		mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.setLayout(new GridLayout(2,1,0,100));
		mainPanel.setMaximumSize(new Dimension(200, 200));
		mainButton[0]= new JButton("Start");
		mainButton[0].addMouseListener(this);
		mainButton[1]= new JButton("Exit");

		mainPanel.add(mainButton[0]);
		mainPanel.add(mainButton[1]);
		MainPane.add(mainPanel);

		setSize(1000,800);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton ex = (JButton)e.getSource();
		for(int i=0;i<mainButton.length;i++) {
			if(ex.equals(mainButton[i])) {
				Main start=new Main("Scrabble");
				dispose();
			}
		}
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
