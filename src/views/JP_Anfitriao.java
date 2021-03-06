package views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.SystemColor;
import java.math.BigDecimal;
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

import java.awt.Font;

import javax.swing.SwingConstants;

public class JP_Anfitriao extends JPanel {
	
	private JTable table;
	private static BigDecimal idLugar;
	
	public static String[] params(String tipo){
		String[] parametros={idLugar.toString(), tipo};
		return parametros;
	}
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
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.anfitriao.setVisible(false);
				Main.meusLocais.setVisible(true);
				
			}
		});
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
				Main.login.limpaSenha();
				try {
					Conexao.desconectar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Main.anfitriao.setVisible(false);
				Main.login.setVisible(true);
			}
		});
		btnSair.setBounds(525, 408, 89, 23);
		add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 604, 306);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnVer_1 = new JButton("Ver");
		btnVer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setModel(DbUtils.resultSetToTableModel(Consulta.consultaReserva()));
				} catch (SQLException exp) {
					exp.printStackTrace();
				}
			}
		});
		btnVer_1.setBounds(10, 391, 61, 23);
		add(btnVer_1);
		
		JLabel lblLocaisAtivos = new JLabel("Locais Ativos");
		lblLocaisAtivos.setBounds(81, 395, 83, 14);
		add(lblLocaisAtivos);
		
		JButton btnCheckIn = new JButton("Check in");
		btnCheckIn.setToolTipText("Sinalizar check in");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1; 
				linhaSelecionada = table.getSelectedRow(); 
				if (linhaSelecionada >= 0) { 
					idLugar = (BigDecimal) table.getValueAt(linhaSelecionada, 0);
					try {
						System.out.println(idLugar);
						boolean bol = Consulta.checkCheckIn(idLugar); // false = falta fazer check in, true = Possui checkin
						if(bol == true){
							JOptionPane.showMessageDialog(null, "Check in feito em: "+Consulta.getDataIn()+".");
						}else{
							model.Insert.insertCheckInOut("1");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else { 
					JOptionPane.showMessageDialog(null, "É necessário selecionar um local."); 
				}
			}
		});
		btnCheckIn.setBounds(426, 332, 95, 23);
		add(btnCheckIn);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setToolTipText("Sinalizar check out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1; 
				linhaSelecionada = table.getSelectedRow(); 
				if (linhaSelecionada >= 0) { 
					idLugar = (BigDecimal) table.getValueAt(linhaSelecionada, 0);
					try {
						System.out.println(idLugar);
						boolean bol = Consulta.checkCheckOut(idLugar); // false = falta fazer check in, true = Possui checkin
						if(bol == true){
							JOptionPane.showMessageDialog(null, "Check out feito em: "+Consulta.getDataOut()+".");
						}else{
							model.Insert.insertCheckInOut("2");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else { 
					JOptionPane.showMessageDialog(null, "É necessário selecionar um local."); 
				}
			}
		});
		btnCheckOut.setBounds(525, 332, 95, 23);
		add(btnCheckOut);
		
	}
}
