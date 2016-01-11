package views;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class JP_Usuario_Opcoes extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the panel.
	 */
	public String newPass(){
		String senha="";
		for (int i=0;i<passwordField_2.getPassword().length;i++){
			senha=senha+passwordField_2.getPassword()[i];
		}
		return senha;
	}
	
	private String getPass(char[] pass){
		String senha="";
		for (int i=0;i<pass.length;i++){
			senha=senha+pass[i];
		}
		return senha;
	}
	
	private boolean senhasIguais(){
		System.out.println(getPass(passwordField.getPassword()));
		System.out.println(Main.login.pass());
		if(getPass(passwordField.getPassword()).equals(Main.login.pass())){
			if(getPass(passwordField_1.getPassword()).equals(getPass(passwordField_2.getPassword()))){
				return true;
			}
		}
		return false;
	}
	
	public JP_Usuario_Opcoes() {
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
		
		JLabel lblMudarASenha = new JLabel("Mudar a Senha");
		lblMudarASenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMudarASenha.setBounds(10, 11, 108, 21);
		panel.add(lblMudarASenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 39, 148, 21);
		panel.add(passwordField);
		
		JLabel lblAtual = new JLabel("Atual");
		lblAtual.setBounds(10, 39, 65, 21);
		panel.add(lblAtual);
		
		JLabel lblNova = new JLabel("Nova");
		lblNova.setBounds(10, 71, 65, 21);
		panel.add(lblNova);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(85, 71, 148, 21);
		panel.add(passwordField_1);
		
		JLabel lblConfirma = new JLabel("Confirma");
		lblConfirma.setBounds(10, 103, 65, 21);
		panel.add(lblConfirma);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(85, 103, 148, 21);
		panel.add(passwordField_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 165, 467, 50);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 69, 0));
		panel_1.setBounds(10, 288, 467, 38);
		panel.add(panel_1);
		
		JLabel lblDeletarSuaConta = new JLabel("Deletar sua Conta");
		lblDeletarSuaConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblDeletarSuaConta);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.Usuario_model.deletarUsuario();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1); 
				}
			}
		});
		panel_1.add(btnDeletar);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(senhasIguais()){
					control.Usuario_control.mudarSenha();
				}
			}
		});
		btnAceitar.setBounds(85, 131, 89, 23);
		panel.add(btnAceitar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField_1.setText(null);
				passwordField.setText(null);
				passwordField_2.setText(null);
				Main.usuOpcao.setVisible(false);
				Main.escolha.setVisible(true);
			}
		});
		btnVoltar.setBounds(525, 408, 89, 23);
		add(btnVoltar);

		
		
	}
}
