package game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class How2Play extends JFrame implements MouseListener{
	private ImageIcon how=new ImageIcon(this.getClass().getResource("/How_to_Play_Scrabble.png"));
	private JButton back=new JButton("Back");
	public How2Play(String title) {
		super(title);
		Container MainPane= getContentPane();
		JLabel image=new JLabel();
		image.setIcon(how);
		back.setPreferredSize(new Dimension(50,50));
		back.addMouseListener(this);
		MainPane.add(back);
		MainPane.add(image);
		
		setSize(1000,800);
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
		if(ex.equals(back)) {
			GameMenu menu= new GameMenu("Scrabble");
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
