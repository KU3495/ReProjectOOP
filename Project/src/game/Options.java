package game;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Options {
	private JPanel OptionPanel=new JPanel();
	private JButton[] OpButton=new JButton[4];
	
	public Options() {
		OpButton[0]=new JButton("Submit");
		OpButton[1]=new JButton("Swap");
		OpButton[2]=new JButton("Skip");
		OpButton[3]=new JButton("Check");
		int i;
		for(i=0; i<4; i++) {
			OpButton[i].setBackground(Color.WHITE);
		}
		
		OptionPanel.add(OpButton[0]);
		OptionPanel.add(OpButton[1]);
		OptionPanel.add(OpButton[2]);
		OptionPanel.add(OpButton[3]);
		OptionPanel.setBackground(Color.GRAY);

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
