package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import control.Local;

public class JP_PaginaLocal extends JPanel{
	static JLabel procurarPor;
	static JLabel lb_estado;
	static JLabel lb_cidade;
	static JLabel lb_pais;
	static JLabel lb_descr;
	static JLabel lb_cep;
	static JLabel lb_disp;
	static JLabel lb_bairro;
	static JLabel lb_rua;
	static JLabel lb_numero;
	static JLabel lb_valor;
	
	public static void attAtb(){
		procurarPor.setText(Local.getTitulo());
		lb_estado.setText(Local.getEstado());
		lb_cidade.setText(Local.getCidade());
		lb_pais.setText(Local.getPais());
		lb_descr.setText(Local.getDescricao());
		lb_cep.setText(Local.getCep());
		lb_disp.setText(Integer.toString(Local.getDisp()));
		lb_bairro.setText(Local.getBairro());
		lb_rua.setText(Local.getRua());
		lb_numero.setText(Integer.toString(Local.getNumero()));
		lb_valor.setText(Integer.toString(Local.getValor_dia()));
	}
	
	public JP_PaginaLocal() {
		
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
		
		procurarPor = new JLabel(Local.getTitulo());
		procurarPor.setBounds(10, 10, 500, 30);
		procurarPor.setFont(new Font("Serif", Font.PLAIN, 30));
		panel.add(procurarPor);
		
		lb_disp = new JLabel(Integer.toString(Local.getDisp()));
		lb_disp.setBackground(new Color(255, 255, 255));
		lb_disp.setBounds(280, 42, 173, 20);
		panel.add(lb_disp);
		
		lb_bairro = new JLabel(Local.getBairro());
		lb_bairro.setBackground(new Color(255, 255, 255));
		lb_bairro.setBounds(66, 73, 173, 20);
		panel.add(lb_bairro);
		
		lb_rua = new JLabel(Local.getRua());
		lb_rua.setBackground(new Color(255, 255, 255));
		lb_rua.setBounds(66, 42, 173, 20);
		panel.add(lb_rua);
		
		lb_numero = new JLabel(Integer.toString(Local.getNumero()));
		lb_numero.setBackground(new Color(255, 255, 255));
		lb_numero.setBounds(66, 170, 46, 14);
		panel.add(lb_numero);
		
		lb_cep = new JLabel(Local.getCep());
		lb_cep.setBackground(new Color(255, 255, 255));
		lb_cep.setText("");
		lb_cep.setBounds(66, 104, 86, 20);
		panel.add(lb_cep);
		
		lb_valor = new JLabel(Integer.toString(Local.getValor_dia()));
		lb_valor.setBackground(new Color(255, 255, 255));
		lb_valor.setBounds(280, 73, 173, 20);
		panel.add(lb_valor);
		
		lb_descr = new JLabel(Local.getDescricao());
		lb_descr.setBackground(new Color(255, 255, 255));
		lb_descr.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Descri\u00E7\u00E3o", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		lb_descr.setBounds(10, 219, 467, 107);
		panel.add(lb_descr);
		
		JLabel lblDisponibilidade = new JLabel("Vagas:");
		lblDisponibilidade.setBounds(216, 45, 78, 14);
		panel.add(lblDisponibilidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 76, 46, 14);
		panel.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 45, 46, 14);
		panel.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 170, 60, 14);
		panel.add(lblNmero);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 107, 46, 14);
		panel.add(lblCep);
		
		JLabel lblValorDaDiria = new JLabel("Di\u00E1ria:");
		lblValorDaDiria.setBounds(216, 76, 78, 14);
		panel.add(lblValorDaDiria);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 194, 467, 14);
		panel.add(separator);
		
		lb_pais = new JLabel(Local.getPais());
		lb_pais.setBounds(280, 104, 173, 20);
		panel.add(lb_pais);
		
		lb_cidade = new JLabel(Local.getCidade());
		lb_cidade.setBounds(66, 135, 173, 20);
		panel.add(lb_cidade);
		
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(216, 107, 30, 14);
		panel.add(lblPas);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 138, 46, 14);
		panel.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(216, 138, 46, 14);
		panel.add(lblEstado);
		
		lb_estado = new JLabel(Local.getEstado());
		lb_estado.setBounds(280, 135, 86, 20);
		panel.add(lb_estado);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pagLocal.setVisible(false);
				Main.buscarLocal.setVisible(true);
			}
		});
		btnCancelar.setBounds(309, 359, 89, 23);
		add(btnCancelar);
	}
}
