package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import model.Conexao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class JP_Login extends JPanel {
	private JTextField textField;
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	private JButton lblCriarNovo;
	
	private void Autenticacao(){
		String senha="";
		for (int i=0;i<pfSenha.getPassword().length;i++){
			senha=senha+pfSenha.getPassword()[i];
		}
		if (senha.equals("senha")){
			System.out.println("autenticado!");
			Main.login.setVisible(false);
			Main.escolha.setVisible(true);
			pfSenha.setText(null);
			senha="";
		}
		else{
			System.out.println("Inválido!");
			senha="";
		}
	}
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public JP_Login() throws SQLException {
		setLayout(null);
		setBounds(0,0,624, 442);
		
		JLabel lbUsuario = new JLabel("Usu\u00E1rio");
		lbUsuario.setBounds(10, 11, 46, 14);
		add(lbUsuario);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 67, 46, 14);
		add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(10, 92, 86, 20);
		add(pfSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Autenticacao();
				try {
					if(Conexao.myConn.isClosed()){
						Conexao.conexao();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnEntrar.setBounds(10, 136, 104, 23);
		add(btnEntrar);
		
		lblCriarNovo = new JButton("Criar novo");
		lblCriarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Main.login.setVisible(false);
			Main.novoUsu.setVisible(true);
			}
		});
		lblCriarNovo.setBounds(10, 165, 104, 20);
		add(lblCriarNovo);

	}

}