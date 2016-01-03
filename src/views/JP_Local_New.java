package views;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.SQLException;

public class JP_Local_New extends JPanel {
	private static JTextField tf_titulo;
	private static JTextField tf_disp;
	private static JTextField tf_bairro;
	private static JTextField tf_rua;
	private static JTextField tf_numero;
	private static JTextField tf_cep;
	private static JTextField tf_valor;
	private static JTextField tf_pais;
	private static JTextField tf_cidade;
	private static JTextField tf_locGeo;
	private static JTextPane tf_descr;
	private static JTextField tf_estado;
	//Control
	public void limpaCampos(){
		tf_titulo.setText("");
		tf_disp.setText("");
		tf_bairro.setText("");
		tf_rua.setText("");
		tf_numero.setText("");
		tf_cep.setText("");
		tf_valor.setText("");
		tf_pais.setText("");
		tf_cidade.setText("");
		tf_locGeo.setText("");
		tf_descr.setText("");
		tf_estado.setText("");
	}
	
	private void insertLocal(){
		try {
			model.Insert.insertLocal();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean isNumeric(String number){
		
		try{
			double d = Double.parseDouble(number);
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "O campo de valor diário deve ser numérico!");
			return false;
		}
		return true;
	}
	
	//Até aqui é tudo Control e deve ir para o lugar certo
	public static String[] params(){
		String[] parametros={
		tf_titulo.getText(),
		tf_valor.getText(),
		tf_descr.getText(),
		tf_disp.getText(),
		tf_rua.getText(),
		tf_numero.getText(),
		tf_cep.getText(),
		tf_pais.getText(),
		tf_cidade.getText(),
		tf_estado.getText(),
		tf_locGeo.getText(),
		tf_bairro.getText()
		};
		return parametros;
	}
	/**
	 * Create the panel.
	 */
	public JP_Local_New() {
		//caracteristicas do JPanel
		setVisible(false);
		setBackground(SystemColor.menu);
		setBounds(0,0,624, 442);
		setLayout(null);
		
		//Conteudo
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 487, 337);
		add(panel);
		panel.setLayout(null);
		
		tf_titulo = new JTextField();
		tf_titulo.setBackground(new Color(255, 255, 255));
		tf_titulo.setBounds(66, 11, 140, 20);
		panel.add(tf_titulo);
		tf_titulo.setColumns(10);
		
		tf_disp = new JTextField();
		tf_disp.setBackground(new Color(255, 255, 255));
		tf_disp.setBounds(304, 11, 36, 20);
		panel.add(tf_disp);
		tf_disp.setColumns(100);
		
		tf_bairro = new JTextField();
		tf_bairro.setBackground(new Color(255, 255, 255));
		tf_bairro.setBounds(66, 73, 86, 20);
		panel.add(tf_bairro);
		tf_bairro.setColumns(10);
		
		tf_rua = new JTextField();
		tf_rua.setBackground(new Color(255, 255, 255));
		tf_rua.setBounds(66, 42, 371, 20);
		panel.add(tf_rua);
		tf_rua.setColumns(10);
		
		tf_numero = new JTextField();
		tf_numero.setBackground(new Color(255, 255, 255));
		tf_numero.setBounds(353, 135, 86, 20);
		panel.add(tf_numero);
		tf_numero.setColumns(10);
		
		tf_cep = new JTextField();
		tf_cep.setBackground(new Color(255, 255, 255));
		tf_cep.setText("");
		tf_cep.setBounds(66, 104, 86, 20);
		panel.add(tf_cep);
		tf_cep.setColumns(10);
		
		tf_valor = new JTextField();
		tf_valor.setBackground(new Color(255, 255, 255));
		tf_valor.setBounds(257, 73, 86, 20);
		panel.add(tf_valor);
		tf_valor.setColumns(10);
		
		tf_descr = new JTextPane();
		tf_descr.setBackground(new Color(255, 255, 255));
		tf_descr.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Descri\u00E7\u00E3o", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		tf_descr.setBounds(10, 219, 467, 107);
		panel.add(tf_descr);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 14, 46, 14);
		panel.add(lblTtulo);
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade:");
		lblDisponibilidade.setBounds(216, 14, 78, 14);
		panel.add(lblDisponibilidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 76, 46, 14);
		panel.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 45, 46, 14);
		panel.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(304, 138, 46, 14);
		panel.add(lblNmero);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 107, 46, 14);
		panel.add(lblCep);
		
		JLabel lblValorDaDiria = new JLabel("Valor da Di\u00E1ria:");
		lblValorDaDiria.setBounds(169, 76, 78, 14);
		panel.add(lblValorDaDiria);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 194, 467, 14);
		panel.add(separator);
		
		JLabel lblSomenteNmeros = new JLabel("Somente N\u00FAmeros");
		lblSomenteNmeros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSomenteNmeros.setBounds(353, 76, 86, 14);
		panel.add(lblSomenteNmeros);
		
		tf_pais = new JTextField();
		tf_pais.setBounds(202, 104, 86, 20);
		panel.add(tf_pais);
		tf_pais.setColumns(10);
		
		tf_cidade = new JTextField();
		tf_cidade.setBounds(66, 135, 86, 20);
		panel.add(tf_cidade);
		tf_cidade.setColumns(10);
		
		tf_locGeo = new JTextField();
		tf_locGeo.setBounds(391, 104, 86, 20);
		panel.add(tf_locGeo);
		tf_locGeo.setColumns(10);
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(162, 107, 30, 14);
		panel.add(lblPas);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 138, 46, 14);
		panel.add(lblCidade);
		
		JLabel lblLocalizaoGeogrfica = new JLabel("Localiza\u00E7\u00E3o Geo.:");
		lblLocalizaoGeogrfica.setBounds(304, 107, 98, 14);
		panel.add(lblLocalizaoGeogrfica);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(162, 138, 46, 14);
		panel.add(lblEstado);
		
		tf_estado = new JTextField();
		tf_estado.setBounds(202, 135, 86, 20);
		panel.add(tf_estado);
		tf_estado.setColumns(10);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isNumeric(tf_valor.getText()) && isNumeric(tf_numero.getText()) && isNumeric(tf_disp.getText())){
					insertLocal();
					limpaCampos();
					Main.novoLocal.setVisible(false);
					Main.verLocal.setVisible(true);
				}
			}
		});
		btnAceitar.setBounds(408, 359, 89, 23);
		add(btnAceitar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
				Main.novoLocal.setVisible(false);
				Main.anfitriao.setVisible(true);
			}
		});
		btnVoltar.setBounds(309, 359, 89, 23);
		add(btnVoltar);
		
		JLabel lblCadastrarLocal = new JLabel("Cadastrar\r\n");
		lblCadastrarLocal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastrarLocal.setBounds(507, 11, 107, 45);
		add(lblCadastrarLocal);
		
		JButton btnTeste = new JButton("teste");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertLocal();
			}
		});
		btnTeste.setBounds(10, 359, 89, 23);
		add(btnTeste);
		
	}
}
