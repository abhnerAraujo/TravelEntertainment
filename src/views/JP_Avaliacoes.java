package views;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Consulta;
import net.proteanit.sql.DbUtils;

public class JP_Avaliacoes extends JPanel {
	private static JTable table;
	private static String mediaNota;
	private static JLabel nota;
	
	public static void actAvaliacoes(){
		try {
			table.setModel(DbUtils.resultSetToTableModel(Consulta.consultaAvaliaçoes()));
			nota.setText(mediaNota);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro."); 
		}
	}
	
	public JP_Avaliacoes() throws SQLException {
		//caracteristicas do JPanel
		setBackground(SystemColor.menu);
		setVisible(false);
		setBounds(0,0,624, 442);
		setLayout(null);
		//Conteudo
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 604, 306);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.avaliacoes.setVisible(false);
				Main.pagLocal.setVisible(true);
			}
		});
		btnVoltar.setBounds(525, 408, 89, 23);
		add(btnVoltar);
		
		JLabel mediaTx = new JLabel("Media da nota:");
		mediaTx.setBounds(10, 335, 150, 23);
		add(mediaTx);
		
		nota = new JLabel("Media");
		nota.setBounds(10, 359, 150, 23);
		nota.setFont(new Font("Serif", Font.PLAIN, 30));
		add(nota);
	}
	
	

	public static String getMediaNota() {
		return mediaNota;
	}

	public static void setMediaNota(String mediaNota) {
		JP_Avaliacoes.mediaNota = mediaNota;
	}
}
