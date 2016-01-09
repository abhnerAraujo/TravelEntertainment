package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import control.Local;
import model.Conexao;

public class JP_Avaliar extends JPanel {

	private static JTextField tf_numero;
	private static JTextPane tf_descr;
	static JLabel titulo;
	
	public static void attAtb(){
		titulo.setText(Local.getTitulo());
	}
	
	public JP_Avaliar() throws SQLException {
		//caracteristicas do JPanel
				setVisible(false);
				setBackground(SystemColor.menu);
				setBounds(0,0,624, 442);
				setLayout(null);
				
				//Conteudo
				JPanel panel = new JPanel();
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel.setBackground(Color.WHITE);
				panel.setBounds(10, 11, 487, 337);
				add(panel);
				panel.setLayout(null);
				
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.avaliar.setVisible(false);
				Main.pagLocal.setVisible(true);
			}
		});
		btnVoltar.setBounds(426, 408, 89, 23);
		add(btnVoltar);
		
		titulo = new JLabel(Local.getTitulo());
		titulo.setBounds(10, 10, 500, 30);
		titulo.setFont(new Font("Serif", Font.PLAIN, 30));
		panel.add(titulo);

		tf_numero = new JTextField();
		tf_numero.setBackground(new Color(255, 255, 255));
		tf_numero.setBounds(353, 135, 86, 20);
		panel.add(tf_numero);
		tf_numero.setColumns(10);
		
		tf_descr = new JTextPane();
		tf_descr.setBackground(new Color(255, 255, 255));
		tf_descr.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Texto", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		tf_descr.setBounds(10, 219, 467, 107);
		panel.add(tf_descr);
		
		JLabel lblNmero = new JLabel("Nota:");
		lblNmero.setBounds(304, 138, 46, 14);
		panel.add(lblNmero);
		
		JLabel lblSomenteNmeros = new JLabel("notas de 0 a 5");
		lblSomenteNmeros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSomenteNmeros.setBounds(353, 76, 86, 14);
		panel.add(lblSomenteNmeros);
	}

}
