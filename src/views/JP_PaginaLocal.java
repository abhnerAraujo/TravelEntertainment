package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import model.Consulta;
import model.Insert;
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
	
	public static String formateDate(String day, String mes, String ano){
		if(day.length() == 1){
			day = "0" + day;
		}
		if(mes.length() == 1){
			mes = "0" + mes;
		}
		String date = ano+"-"+mes+"-"+day+" 12:00:00.0";
		return date;
	}
	
	public static boolean checkDate(JTextField qtdReserv, JTextField diaIn, JTextField mesIn, JTextField anoIn, JTextField anoOut, JTextField diaOut, JTextField mesOut){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		try {
		    if(Integer.parseInt(qtdReserv.getText()) > Local.getDisp()){
				JOptionPane.showMessageDialog(null, "Nao há vagas."); 
		    }else if(Integer.parseInt(qtdReserv.getText()) <= 0) {
		    	JOptionPane.showMessageDialog(null, "Vagas nao pode ser zero."); 
		    }else if((Integer.parseInt(qtdReserv.getText()) < Local.getDisp()) && (Integer.parseInt(qtdReserv.getText()) > 0) ){
		    	System.out.println("ah vagas"); 
		    	try {
				    if((Integer.parseInt(diaIn.getText()) <= 0) || (Integer.parseInt(mesIn.getText()) <= 0)) {
				    	JOptionPane.showMessageDialog(null, "Os campos de data não podem ser zero."); 
				    } else if((Integer.parseInt(anoIn.getText()) < year)){
				    	if(Integer.parseInt(mesIn.getText()) < month){
				    		if(Integer.parseInt(diaIn.getText()) < day){
				    			JOptionPane.showMessageDialog(null, "Escolha uma data no futuro."); 
				    		}
				    	}
				    } else{
				    	System.out.println("entrou na segunda data");
				    	try {
						    if((Integer.parseInt(diaOut.getText()) <= 0) || (Integer.parseInt(mesOut.getText()) <= 0)) {
						    	JOptionPane.showMessageDialog(null, "Os campos de data nao podem ser zero.");
						    
						    } else if((Integer.parseInt(anoOut.getText()) < year) || (Integer.parseInt(anoOut.getText()) < Integer.parseInt(anoIn.getText()))){
						    	JOptionPane.showMessageDialog(null, "Escolha uma data no futuro.");   
						    } else if((Integer.parseInt(mesOut.getText()) < Integer.parseInt(mesIn.getText()))){ 						    
						    	JOptionPane.showMessageDialog(null, "Escolha uma data no futuro.");   
						    } else if((Integer.parseInt(diaOut.getText()) < Integer.parseInt(diaIn.getText()))){
								   JOptionPane.showMessageDialog(null, "Escolha uma data no futuro.");     
						    }else{
						    	JOptionPane.showMessageDialog(null, "tudo vedadeiro.");
						    	return true;
						    }
						} catch (Exception f) {
							JOptionPane.showMessageDialog(null, "Data invalida."); 
						}
				    }
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Data invalida."); 
				}
		    } else {
		    	JOptionPane.showMessageDialog(null, "Erro."); 
		    }
		} catch (Exception f) {
			JOptionPane.showMessageDialog(null, "Insira um numero inteiro."); 
		}
		return false;
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
		
		JTextField qtdReserv = new JTextField();
		qtdReserv.setText("0");
		qtdReserv.setBounds(10, 393, 30, 20);
		add(qtdReserv);
		qtdReserv.setColumns(10);
		
		JLabel qtdReservas = new JLabel("Reservas:");
		qtdReservas.setBounds(10, 359, 150, 23);
		add(qtdReservas);
		
		JLabel dataEntrada = new JLabel("Data de entrada:");
		dataEntrada.setBounds(85, 359, 150, 23);
		add(dataEntrada);
		
		JTextField diaIn = new JTextField();
		diaIn.setText("01");
		diaIn.setBounds(85, 393, 20, 20);
		add(diaIn);
		diaIn.setColumns(10);
		
		JLabel barra1 = new JLabel("/");
		barra1.setBounds(110, 393, 150, 23);
		add(barra1);
		
		JTextField mesIn = new JTextField();
		mesIn.setText("01");
		mesIn.setBounds(120, 393, 20, 20);
		add(mesIn);
		mesIn.setColumns(10);
		
		JLabel barra2 = new JLabel("/");
		barra2.setBounds(145, 393, 150, 23);
		add(barra2);
		
		JTextField anoIn = new JTextField();
		anoIn.setText("2016");
		anoIn.setBounds(155, 393, 40, 20);
		add(anoIn);
		anoIn.setColumns(10);
		
		JLabel dataSaida = new JLabel("Data de Saida:");
		dataSaida.setBounds(200, 359, 150, 23);
		add(dataSaida);
		
		JTextField diaOut = new JTextField();
		diaOut.setText("01");
		diaOut.setBounds(200, 393, 20, 20);
		add(diaOut);
		diaOut.setColumns(10);
		
		JLabel barra3 = new JLabel("/");
		barra3.setBounds(225, 393, 150, 23);
		add(barra3);
		
		JTextField mesOut = new JTextField();
		mesOut.setText("01");
		mesOut.setBounds(235, 393, 20, 20);
		add(mesOut);
		mesOut.setColumns(10);
		
		JLabel barra4 = new JLabel("/");
		barra4.setBounds(260, 393, 150, 23);
		add(barra4);
		
		JTextField anoOut = new JTextField();
		anoOut.setText("2016");
		anoOut.setBounds(270, 393, 40, 20);
		add(anoOut);
		anoOut.setColumns(10);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(408, 359, 89, 23);
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Calendar.getInstance().get(Calendar.YEAR);
				int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
				int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			    boolean bol = checkDate(qtdReserv, diaIn, mesIn, anoIn, anoOut, diaOut, mesOut);
				if(bol){
					String dateIn = formateDate(diaIn.getText(), mesIn.getText(), anoIn.getText());
					String dateOut = formateDate(diaOut.getText(), mesOut.getText(), anoOut.getText());
					try {
						Insert.insertReserva(dateIn, dateOut, Integer.parseInt(qtdReserv.getText()));
						JOptionPane.showMessageDialog(null, "Reserva feita com sucesso."); 
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Erro."); 
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		add(btnReservar);
		
		JButton lblAvaliacoes = new JButton("Avaliações");
		lblAvaliacoes.setBounds(507, 11, 100, 25);
		lblAvaliacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pagLocal.setVisible(false);
				JP_Avaliacoes.actAvaliacoes();
				Main.avaliacoes.setVisible(true);
			}
		});
		add(lblAvaliacoes);
		
		JButton lblAvaliar = new JButton("Avaliar");
		lblAvaliar.setBounds(507, 43, 100, 25);
		lblAvaliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pagLocal.setVisible(false);
				JP_Avaliar.attAtb();
				Main.avaliar.setVisible(true);
			}
		});
		add(lblAvaliar);
	}
}
