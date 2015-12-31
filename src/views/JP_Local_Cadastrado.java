package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class JP_Local_Cadastrado extends JPanel {
	

	private JTextField tf_titulo;
	private JTextField tf_disp;
	private JTextField tf_bairro;
	private JTextField tf_rua;
	private JTextField tf_numero;
	private JTextField tf_cep;
	private JTextField tf_valor;

	/**
	 * Create the panel.
	 */
	public JP_Local_Cadastrado() {

		//caracteristicas do JPanel
		setBackground(SystemColor.menu);
		setBounds(0,0,624, 442);
		setLayout(null);
		setVisible(false);
		
		//Conteudo
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 487, 337);
		add(panel);
		panel.setLayout(null);
		
		tf_titulo = new JTextField();
		tf_titulo.setForeground(Color.WHITE);
		tf_titulo.setEditable(false);
		tf_titulo.setBackground(SystemColor.text);
		tf_titulo.setBounds(391, 11, 86, 20);
		panel.add(tf_titulo);
		tf_titulo.setColumns(10);
		
		tf_disp = new JTextField();
		tf_disp.setForeground(Color.WHITE);
		tf_disp.setEditable(false);
		tf_disp.setBackground(SystemColor.text);
		tf_disp.setBounds(391, 42, 86, 20);
		panel.add(tf_disp);
		tf_disp.setColumns(100);
		
		tf_bairro = new JTextField();
		tf_bairro.setForeground(Color.WHITE);
		tf_bairro.setEditable(false);
		tf_bairro.setBackground(SystemColor.text);
		tf_bairro.setBounds(10, 11, 86, 20);
		panel.add(tf_bairro);
		tf_bairro.setColumns(10);
		
		tf_rua = new JTextField();
		tf_rua.setForeground(Color.WHITE);
		tf_rua.setEditable(false);
		tf_rua.setBackground(SystemColor.text);
		tf_rua.setBounds(10, 42, 86, 20);
		panel.add(tf_rua);
		tf_rua.setColumns(10);
		
		tf_numero = new JTextField();
		tf_numero.setForeground(Color.WHITE);
		tf_numero.setEditable(false);
		tf_numero.setBackground(SystemColor.text);
		tf_numero.setBounds(10, 73, 86, 20);
		panel.add(tf_numero);
		tf_numero.setColumns(10);
		
		tf_cep = new JTextField();
		tf_cep.setForeground(Color.WHITE);
		tf_cep.setEditable(false);
		tf_cep.setBackground(SystemColor.text);
		tf_cep.setText("");
		tf_cep.setBounds(10, 104, 86, 20);
		panel.add(tf_cep);
		tf_cep.setColumns(10);
		
		tf_valor = new JTextField();
		tf_valor.setForeground(Color.WHITE);
		tf_valor.setEditable(false);
		tf_valor.setBackground(SystemColor.text);
		tf_valor.setBounds(391, 73, 86, 20);
		panel.add(tf_valor);
		tf_valor.setColumns(10);
		
		JTextPane tf_descr = new JTextPane();
		tf_descr.setForeground(Color.WHITE);
		tf_descr.setEditable(false);
		tf_descr.setBackground(SystemColor.text);
		tf_descr.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Descri\u00E7\u00E3o", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		tf_descr.setBounds(10, 207, 467, 119);
		panel.add(tf_descr);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setBounds(335, 14, 46, 14);
		panel.add(lblTtulo);
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade");
		lblDisponibilidade.setBounds(303, 45, 78, 14);
		panel.add(lblDisponibilidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(106, 14, 46, 14);
		panel.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(106, 45, 46, 14);
		panel.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(106, 76, 46, 14);
		panel.add(lblNmero);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(106, 107, 46, 14);
		panel.add(lblCep);
		
		JLabel lblValorDaDiria = new JLabel("Valor da Di\u00E1ria");
		lblValorDaDiria.setBounds(303, 76, 78, 14);
		panel.add(lblValorDaDiria);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(212, 12, 36, 108);
		panel.add(separator);
		
		JButton btnAceitar = new JButton("Atualizar");
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceitar.setBounds(408, 359, 89, 23);
		add(btnAceitar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(309, 359, 89, 23);
		add(btnVoltar);
		
		JLabel lblCadastrarLocal = new JLabel("Cadastrar Local");
		lblCadastrarLocal.setBounds(507, 11, 107, 72);
		add(lblCadastrarLocal);

				
		
	}

}
