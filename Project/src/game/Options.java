package game;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Options {
	private JPanel option=new JPanel();
	private JButton Submit=new JButton("Submit");
	private JButton Swap=new JButton("Swap");
	private JButton Skip=new JButton("Skip");
	private JButton[] OpButton=new JButton[3];
	
	public Options() {
		OpButton[0]=Submit;
		OpButton[1]=Swap;
		OpButton[2]=Skip;
		
		option.add(OpButton[0]);
		option.add(OpButton[1]);
		option.add(OpButton[2]);
	}
	
	public JButton getOpButton(int i) {
		return OpButton[i];
	}

	public JPanel getOption() {
		return option;
	}
}
