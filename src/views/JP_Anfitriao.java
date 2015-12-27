package views;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class JP_Anfitriao extends JPanel {

	/**
	 * Create the panel.
	 */
	public JP_Anfitriao() {
		setBounds(0,0,624, 442);
		setLayout(null);
		
		JButton btnNovoLocal = new JButton("+");
		btnNovoLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNovoLocal.setBounds(565, 45, 49, 23);
		add(btnNovoLocal);
		
		JLabel lblNovoLocal = new JLabel("Novo Local");
		lblNovoLocal.setBounds(494, 49, 61, 14);
		add(lblNovoLocal);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 283, 209);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLocacoesAtivas = new JLabel("Locacoes Ativas");
		lblLocacoesAtivas.setBounds(10, 11, 82, 14);
		panel.add(lblLocacoesAtivas);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(565, 11, 49, 23);
		add(btnVer);
		
		JLabel lblMeusLocais = new JLabel("Meus Locais");
		lblMeusLocais.setBounds(494, 15, 61, 14);
		add(lblMeusLocais);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(426, 408, 89, 23);
		add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(525, 408, 89, 23);
		add(btnSair);

	}
}
