package views;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JLabel;

import model.Consulta;
import net.proteanit.sql.DbUtils;

public class JP_Buscar_Local extends JPanel {
	private JTextField tf_procurar;
	private JTable table;
	private static String nomeLugar;
	/**
	 * Create the panel.
	 */
	public JP_Buscar_Local() {
		String[] petStrings = {"Cidade", "Bairro", "Pais", "Estado"};
		
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
		
		JButton btnAceitar = new JButton("Continuar");
		btnAceitar.setBounds(408, 359, 89, 23);
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1; 
				linhaSelecionada = table.getSelectedRow(); 
				if (linhaSelecionada >= 0) { 
					nomeLugar = (String) table.getValueAt(linhaSelecionada, 0);
					try {
						Consulta.setLocal(nomeLugar);
						Main.pagLocal.attAtb();
						Main.buscarLocal.setVisible(false);
						Main.pagLocal.setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro."); 
					}
				} else { 
					JOptionPane.showMessageDialog(null, "É necessário selecionar um local."); 
				}
			}
		});
		add(btnAceitar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.buscarLocal.setVisible(false);
				Main.hospede.setVisible(true);
			}
		});
		btnCancelar.setBounds(309, 359, 89, 23);
		add(btnCancelar);
		
		JLabel procurarPor = new JLabel("Procurar por:");
		procurarPor.setBounds(10, 359, 89, 23);
		add(procurarPor);
		
		JComboBox typeList = new JComboBox(petStrings);
		typeList.setSelectedIndex(0);
		typeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		typeList.setBounds(143, 359, 89, 23);
		add(typeList);
		
		tf_procurar = new JTextField();
		tf_procurar.setText("");
		tf_procurar.setBounds(10, 393, 123, 20);
		add(tf_procurar);
		tf_procurar.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println(tf_procurar.getText());
					table.setModel(DbUtils.resultSetToTableModel(Consulta.consultaLocaisByType(typeList.getSelectedIndex(), tf_procurar.getText())));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnProcurar.setBounds(143, 390, 89, 23);
		add(btnProcurar);
		
		JLabel lblBuscarLocais = new JLabel("Buscar Local");
		lblBuscarLocais.setBounds(507, 11, 94, 14);
		add(lblBuscarLocais);
		
		
	}
}
