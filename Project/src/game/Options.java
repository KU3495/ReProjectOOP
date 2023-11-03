package game;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Options {
	private JPanel OptionPanel=new JPanel();
	private JButton Submit=new JButton("Submit");
	private JButton Swap=new JButton("Swap");
	private JButton Skip=new JButton("Skip");
	private JButton[] OpButton=new JButton[3];
	
	public Options() {
		OpButton[0]=Submit;
		OpButton[1]=Swap;
		OpButton[2]=Skip;
		
		OptionPanel.add(OpButton[0]);
		OptionPanel.add(OpButton[1]);
		OptionPanel.add(OpButton[2]);
		OptionPanel.setBackground(Color.GRAY);

	}
	
	public JButton getOpButton(int i) {
		return OpButton[i];
	}

	public JPanel getOption() {
		return OptionPanel;
	}
}
