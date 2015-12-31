package views;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JP_Buscar_Local extends JPanel {
	private JTextField tf_procurar;

	/**
	 * Create the panel.
	 */
	public JP_Buscar_Local() {
		
		//caracteristicas do JPanel
		setVisible(false);
		setBackground(UIManager.getColor("InternalFrame.borderLight"));
		setBounds(0,0,624, 442);
		setLayout(null);
		
		//Conteudo
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 11, 487, 337);
		add(panel);
		panel.setLayout(null);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.setBounds(408, 359, 89, 23);
		add(btnAceitar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.buscarLocal.setVisible(false);
				Main.hospede.setVisible(true);
			}
		});
		btnCancelar.setBounds(309, 359, 89, 23);
		add(btnCancelar);
		
		tf_procurar = new JTextField();
		tf_procurar.setText("Cidade, estado, bairro...");
		tf_procurar.setBounds(10, 360, 123, 20);
		add(tf_procurar);
		tf_procurar.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProcurar.setBounds(143, 359, 89, 23);
		add(btnProcurar);
		
		JLabel lblBuscarLocais = new JLabel("Buscar Local");
		lblBuscarLocais.setBounds(507, 11, 94, 14);
		add(lblBuscarLocais);
		
		
	}
}
