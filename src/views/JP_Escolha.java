package views;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import model.Conexao;
import model.Consulta;

public class JP_Escolha extends JPanel {

	/**
	 * Create the panel.
	 */
	public JP_Escolha() {
		//caracteristicas do JPanel
		setBackground(SystemColor.menu);
		setBounds(0,0,624, 442);
		setLayout(null);
		setVisible(false);
		
		//Conteudo
		JButton btnAnfitriao = new JButton("Ir");
		btnAnfitriao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.escolha.setVisible(false);
				Main.anfitriao.setVisible(true);
			}
		});
		btnAnfitriao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAnfitriao.setBounds(525, 11, 89, 77);
		add(btnAnfitriao);
		
		JButton btnHospede = new JButton("Ir");
		btnHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.escolha.setVisible(false);
				Main.hospede.setVisible(true);
			}
		});
		btnHospede.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHospede.setBounds(10, 11, 89, 77);
		add(btnHospede);
		
		JLabel lblHospede = new JLabel("H\u00F3spede");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHospede.setBounds(10, 99, 101, 50);
		add(lblHospede);
		
		JLabel lblAnfitriao = new JLabel("Anfitri\u00E3o");
		lblAnfitriao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnfitriao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnfitriao.setBounds(513, 99, 101, 50);
		add(lblAnfitriao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.login.limpaSenha();
				Main.escolha.setVisible(false);
				Main.login.setVisible(true);
				try {
					Conexao.desconectar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSair.setBounds(525, 408, 89, 23);
		add(btnSair);
		
		JButton btnOpcoes = new JButton("Op\u00E7\u00F5es");
		btnOpcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.escolha.setVisible(false);
				Main.usuOpcao.setVisible(true);
			}
		});
		btnOpcoes.setBounds(426, 408, 89, 23);
		add(btnOpcoes);
		
		JButton btnConectar = new JButton("Connect");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Conexao.conexao();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnConectar.setBounds(10, 408, 89, 23);
		add(btnConectar);
		
		JButton btnDesconnect = new JButton("Desconnect");
		btnDesconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Conexao.desconectar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDesconnect.setBounds(109, 408, 89, 23);
		add(btnDesconnect);
		setVisible(false);
		
		
		
	}
}
