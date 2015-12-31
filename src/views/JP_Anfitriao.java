package views;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import model.Conexao;
import model.Consulta;

public class JP_Anfitriao extends JPanel {
	
	private JTable table;
	
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public JP_Anfitriao() throws SQLException {
		//caracteristicas do JPanel
		setBackground(SystemColor.menu);
		setVisible(false);
		setBounds(0,0,624, 442);
		setLayout(null);
		//Conteudo
		
		JButton btnNovoLocal = new JButton("+");
		btnNovoLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.anfitriao.setVisible(false);
				Main.novoLocal.setVisible(true);
			}
		});
		btnNovoLocal.setBounds(10, 362, 61, 23);
		add(btnNovoLocal);
		
		JLabel lblNovoLocal = new JLabel("Novo Local");
		lblNovoLocal.setBounds(81, 366, 99, 14);
		add(lblNovoLocal);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(10, 328, 61, 23);
		add(btnVer);
		
		JLabel lblMeusLocais = new JLabel("Meus Locais");
		lblMeusLocais.setBounds(81, 332, 99, 14);
		add(lblMeusLocais);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.anfitriao.setVisible(false);
				Main.escolha.setVisible(true);
			}
		});
		btnVoltar.setBounds(426, 408, 89, 23);
		add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.anfitriao.setVisible(false);
				Main.login.setVisible(true);
			}
		});
		btnSair.setBounds(525, 408, 89, 23);
		add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 604, 306);
		add(scrollPane);
		
		table = new JTable(DbUtils.resultSetToTableModel(Consulta.consultaReserva(4)));
		scrollPane.setViewportView(table);
		
		JButton btnDesconectar = new JButton("OFF");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Conexao.desconectar();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDesconectar.setBounds(327, 408, 89, 23);
		add(btnDesconectar);
		
	}
}
