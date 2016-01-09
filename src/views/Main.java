package views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Rectangle;
import java.sql.SQLException;

import javax.swing.JPanel;

import model.Conexao;

public class Main {

	private JFrame frame;
	public static JP_Login login;
	public static JP_Local_New novoLocal;
	public static JP_Anfitriao anfitriao;
	public static JP_Local_Cadastrado verLocal;
	public static JP_PaginaLocal pagLocal;
	public static JP_Escolha escolha;
	public static JP_Hospede hospede;
	public static JP_Buscar_Local buscarLocal;
	public static JP_Usuario_Opcoes usuOpcao;
	public static JP_Usuario_Add novoUsu;
	public static JP_MeusLocais meusLocais;
	public static JP_Minhas_Reservas mnhReserv;
	public static JP_Avaliacoes avaliacoes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		try {
			initialize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Travel Entertainment");
		frame.setResizable(false);
		
		login= new JP_Login();
		frame.getContentPane().add(login);
		
		novoLocal = new JP_Local_New();
		frame.getContentPane().add(novoLocal);
		
		anfitriao = new JP_Anfitriao();
		frame.getContentPane().add(anfitriao);
		
		verLocal = new JP_Local_Cadastrado();
		frame.getContentPane().add(verLocal);
		
		pagLocal = new JP_PaginaLocal();
		frame.getContentPane().add(pagLocal);
		
		mnhReserv = new JP_Minhas_Reservas();
		frame.getContentPane().add(mnhReserv);
		
		escolha = new JP_Escolha();
		frame.getContentPane().add(escolha);
		
		hospede = new JP_Hospede();
		frame.getContentPane().add(hospede);
		
		buscarLocal = new JP_Buscar_Local();
		frame.getContentPane().add(buscarLocal);
		
		usuOpcao = new JP_Usuario_Opcoes();
		frame.getContentPane().add(usuOpcao);
		
		novoUsu = new JP_Usuario_Add();
		frame.getContentPane().add(novoUsu);
		
		meusLocais = new JP_MeusLocais();
		frame.getContentPane().add(meusLocais);
		
		avaliacoes = new JP_Avaliacoes();
		frame.getContentPane().add(avaliacoes);
		
	}
}
