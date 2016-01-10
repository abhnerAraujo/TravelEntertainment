package views;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JButton;

import model.Conexao;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class JP_Hospede extends JPanel {

	/**
	 * Create the panel.
	 */
	public JP_Hospede() {
		//caracteristicas do JPanel
		setVisible(false);
		setBackground(SystemColor.menu);
		setBounds(0,0,624, 442);
		setLayout(null);
		
		//Conteudo
		JButton btnNovaReserva = new JButton("Nova Reserva");
		btnNovaReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.hospede.setVisible(false);
				Main.buscarLocal.setVisible(true);
			}
		});
		btnNovaReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNovaReserva.setBounds(10, 11, 159, 106);
		add(btnNovaReserva);
		
		JButton btnVerReservas = new JButton("Ver Reservas");
		btnVerReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.hospede.setVisible(false);
				Main.mnhReserv.setVisible(true);
			}
		});
		btnVerReservas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerReservas.setBounds(179, 11, 159, 106);
		add(btnVerReservas);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.login.limpaSenha();
				Main.hospede.setVisible(false);
				Main.login.setVisible(true);
				try {
					Conexao.desconectar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSair.setBounds(513, 408, 101, 23);
		add(btnSair);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.hospede.setVisible(false);
				Main.escolha.setVisible(true);
			}
		});
		btnVoltar.setBounds(402, 408, 101, 23);
		add(btnVoltar);
		setVisible(false);
		
		//Conteudo
		
		
		
	}

}
