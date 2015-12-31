package views;

import java.awt.SystemColor;

import javax.swing.JPanel;

public class Painel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Painel() {
		//Pra ficar DRY no grau, fiz um painel padrao
		setBackground(SystemColor.menu);
		setVisible(false);
		setBounds(0,0,624, 442);
		setLayout(null);
	}

}
