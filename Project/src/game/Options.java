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
	private JButton Check=new JButton("Check");
	private JButton[] OpButton=new JButton[4];
	
	public Options() {
		OpButton[0]=Submit;
		OpButton[1]=Swap;
		OpButton[2]=Skip;
		OpButton[3]=Check;
		
		OptionPanel.add(OpButton[0]);
		OptionPanel.add(OpButton[1]);
		OptionPanel.add(OpButton[2]);
		OptionPanel.add(OpButton[3]);
		OptionPanel.setBackground(Color.BLACK);

	}
	
	public JButton getOpButton(int i) {
		return OpButton[i];
	}

	public JPanel getOption() {
		return OptionPanel;
	}
	
	public int getOpButtonLength() {
		return OpButton.length;
	}
	
	public void Check() {
		
	}
}
