package views;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import net.proteanit.sql.DbUtils;
import model.Conexao;
import model.Consulta;

public class JP_Minhas_Reservas extends JPanel {
	private JTable table;
	private BigDecimal reservId;
	
	public JP_Minhas_Reservas() throws SQLException {
			
		//caracteristicas do JPanel
		setVisible(false);
		setBackground(UIManager.getColor("InternalFrame.borderLight"));
		setBounds(0,0,624, 442);
		setLayout(null);
				
		//Conteudo
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 11, 487, 337);
		add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblBuscarLocais = new JLabel("Minhas reservas");
		lblBuscarLocais.setBounds(507, 11, 120, 14);
		add(lblBuscarLocais);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.mnhReserv.setVisible(false);
				Main.hospede.setVisible(true);
			}
		});
		btnCancelar.setBounds(309, 359, 89, 23);
		add(btnCancelar);
		
		JButton deleteReserv = new JButton("Cancelar Reserva");
		deleteReserv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1; 
				linhaSelecionada = table.getSelectedRow(); 
				if (linhaSelecionada >= 0) { 
					reservId =  (BigDecimal) table.getValueAt(linhaSelecionada, 0);
					int id = reservId.intValueExact();
					try {
						model.Insert.cancelReserv(id);
						table.setModel(DbUtils.resultSetToTableModel(Consulta.consultaReservas()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else { 
					JOptionPane.showMessageDialog(null, "É necessário selecionar um local."); 
				}
			}
		});
		deleteReserv.setBounds(10, 359, 166, 23);
		add(deleteReserv);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(408, 359, 89, 23);
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setModel(DbUtils.resultSetToTableModel(Consulta.consultaReservas()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnVer);
			
	}
}
