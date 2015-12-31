package views;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

import java.awt.Font;
import java.sql.SQLException;

public class JP_Usuario_Add extends JPanel {
	private static JTextField tfNome;
	private static JTextField tfLogin;
	private static JPasswordField pfSenha;
	private static JPasswordField pfConfirmaSenha;
	private static JTextField tfEmail;
	private static JTextField tfBairro;
	private static JTextField tfRua;
	private static JTextField tfNumero;
	private static JTextField tfCep;
	
	//Validaçao da senha
	private boolean ConfirmaSenha(){
		String senha="";
		for (int i=0;i<pfSenha.getPassword().length;i++){
			senha=senha+pfSenha.getPassword()[i];
		}
		String confirmaSenha="";
		for (int i=0;i<pfConfirmaSenha.getPassword().length;i++){
			confirmaSenha=confirmaSenha+pfConfirmaSenha.getPassword()[i];
		}
		if (senha.equals(confirmaSenha)){
			return true;
		}
		return false;
	}
	
	//Campos do painel
	public static String[] params(){
		String confirmaSenha="";
		for (int i=0;i<pfConfirmaSenha.getPassword().length;i++){
			confirmaSenha=confirmaSenha+pfConfirmaSenha.getPassword()[i];
		}
		String[] parametros={tfEmail.getText(),tfNome.getText(),tfLogin.getText(),
				confirmaSenha,tfBairro.getText(),tfRua.getText(),tfNumero.getText(),tfCep.getText()};
		return parametros;
	}

	/**
	 * Create the panel.
	 */
	public JP_Usuario_Add() {
		
		//caracteristicas do JPanel
		setBackground(SystemColor.menu);
		setBounds(0,0,624, 442);
		setLayout(null);
		setVisible(false);
		
		//Conteudo
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 487, 337);
		add(panel);
		panel.setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(219, 42, 151, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(380, 42, 46, 20);
		panel.add(lblNome);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(10, 42, 86, 20);
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(10, 73, 86, 20);
		panel.add(pfSenha);
		
		pfConfirmaSenha = new JPasswordField();
		pfConfirmaSenha.setBounds(10, 104, 86, 20);
		panel.add(pfConfirmaSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(106, 73, 77, 20);
		panel.add(lblSenha);
		
		JLabel lblCorfirmarSenha = new JLabel("Corfirmar Senha");
		lblCorfirmarSenha.setBounds(106, 104, 86, 20);
		panel.add(lblCorfirmarSenha);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(106, 42, 46, 20);
		panel.add(lblLogin);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(219, 73, 151, 20);
		panel.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(380, 73, 46, 20);
		panel.add(lblEmail);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 166, 467, 20);
		panel.add(separator);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereo.setBounds(10, 172, 77, 14);
		panel.add(lblEndereo);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConta.setBounds(10, 11, 63, 14);
		panel.add(lblConta);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(75, 199, 86, 20);
		panel.add(tfBairro);
		tfBairro.setColumns(10);
		
		tfRua = new JTextField();
		tfRua.setBounds(75, 230, 402, 20);
		panel.add(tfRua);
		tfRua.setColumns(10);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(75, 261, 86, 20);
		panel.add(tfNumero);
		tfNumero.setColumns(10);
		
		tfCep = new JTextField();
		tfCep.setBounds(219, 199, 86, 20);
		panel.add(tfCep);
		tfCep.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 202, 46, 14);
		panel.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 233, 46, 14);
		panel.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(10, 264, 46, 14);
		panel.add(lblNmero);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(183, 202, 26, 14);
		panel.add(lblCep);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(control.VerificarAddUsuario.verificar()){
					//chama o insert
					try {
						model.Insert.insert();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					Main.novoUsu.setVisible(false);
					Main.escolha.setVisible(true);
				}
			}
		});
		btnAceitar.setBounds(408, 359, 89, 23);
		add(btnAceitar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novoUsu.setVisible(false);
				Main.login.setVisible(true);
			}
		});
		btnCancelar.setBounds(309, 359, 89, 23);
		add(btnCancelar);
		
		JLabel lblCadastrarLocal = new JLabel("Cadastrar Usu\u00E1rio");
		lblCadastrarLocal.setBounds(507, 11, 107, 72);
		add(lblCadastrarLocal);


				
	}
}
