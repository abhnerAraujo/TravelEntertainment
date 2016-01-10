package views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;

public class JP_EscolherTipo extends JPanel {

	/**
	 * Create the panel.
	 */
	public JP_EscolherTipo() {
		setBounds(0,0,624, 442);
		setLayout(null);
		
		JButton btnHospede = new JButton("H\u00F3spede");
		btnHospede.setBounds(10, 77, 89, 78);
		add(btnHospede);
		
		JButton btnAnfitriao = new JButton("Anfitri\u00E3o");
		btnAnfitriao.setBounds(10, 287, 89, 78);
		add(btnAnfitriao);
		
		JLabel lblBemVindoDe = new JLabel("Bem Vindo de volta!");
		lblBemVindoDe.setBounds(395, 11, 132, 14);
		add(lblBemVindoDe);
		
	}

}
