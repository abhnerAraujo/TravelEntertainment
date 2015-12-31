package views;

import java.awt.SystemColor;

import javax.swing.JPanel;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

import model.Conexao;
import model.Consulta;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class JP_MeusLocais extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public JP_MeusLocais() throws SQLException {
		
		//caracteristicas do JPanel
		setBackground(SystemColor.menu);
		setVisible(false);
		setBounds(0,0,624, 442);
		setLayout(null);
		
		//Conteudo
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 11, 604, 297);
		add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(525, 408, 89, 23);
		add(btnSair);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.meusLocais.setVisible(false);
				Main.anfitriao.setVisible(true);
				try {
					Conexao.fecharResult();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnVoltar.setBounds(426, 408, 89, 23);
		add(btnVoltar);
		
		textField = new JTextField();
		textField.setToolTipText("Id, T\u00EDtulo, ...");
		textField.setBounds(10, 312, 195, 23);
		add(textField);
		textField.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(215, 312, 89, 23);
		add(btnProcurar);
		
		JButton btnVerLocais = new JButton("Ver");
		btnVerLocais.setToolTipText("Ver todos os seus Locais");
		btnVerLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setModel(DbUtils.resultSetToTableModel(Consulta.consultaLocais()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVerLocais.setBounds(314, 312, 89, 23);
		add(btnVerLocais);
				
	}
}
