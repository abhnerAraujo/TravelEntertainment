package model;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import control.Local;
import views.Main;

public class Insert {
	
	public static void insertUsuario() throws SQLException{
		String[] parametro=views.JP_Usuario_Add.params();
        Statement stmt = Conexao.myConn.createStatement();
        stmt.executeUpdate("INSERT INTO USUARIO(EMAIL, NOME, LOGIN, SENHA, BAIRRO, RUA, NUMERO, CEP) "
        		+ "VALUES ('"+parametro[0]+"','"+parametro[1]+"','"+parametro[2]+"','"+parametro[3]+
        		"','"+parametro[4]+"','"+parametro[5]+"',"+Integer.parseInt(parametro[6])+",'"+parametro[7]+"')");
        Conexao.myConn.commit();
        stmt.close();
	}
	
	public static void insertLocal() throws SQLException{
		String[] parametro=views.JP_Local_New.params();
		try{
			String DBCALL = "{call CADASTRAR_LOCAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
	        cs.setString(1, parametro[0]);
	        cs.setInt(2, Integer.parseInt(parametro[1]));
	        cs.setString(3, parametro[2]);
	        cs.setInt(4, Integer.parseInt(parametro[3]));
	        cs.setString(5, Main.login.loginUsuario());
	        cs.setString(6, parametro[4]);
	        cs.setString(7, parametro[5]);
	        cs.setInt(8, Integer.parseInt(parametro[6]));
	        cs.setString(9, parametro[7]);
	        cs.setString(10, parametro[8]);
	        cs.setString(11, parametro[9]);
	        cs.setString(12, parametro[10]);
	        cs.setString(13, parametro[11]);
	        cs.setInt(14, Integer.parseInt(parametro[3]));
	        Conexao.myConn.commit();
	        cs.executeUpdate();
	        cs.close();
	        JOptionPane.showMessageDialog(null,"Local cadastrado com sucesso!");
		}catch(SQLException se){
			JOptionPane.showMessageDialog(null, "Erro! Cadastro não efetuado!");
		}
	}
	
	public static void insertCheckInOut(String tipo) throws SQLException{
		String[] parametro=views.JP_Anfitriao.params(tipo);
		try{
			String DBCALL = "{call CHECK_IN_OUT(?,?)}";
	        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
	        cs.setInt(1, Integer.parseInt(parametro[0]));
	        cs.setInt(2, Integer.parseInt(parametro[1]));
	        Conexao.myConn.commit();
	        cs.executeUpdate();
	        cs.close();
	        if(tipo.equals("1")){
	        	JOptionPane.showMessageDialog(null,"Check in registrado com sucesso!");
	        }else if(tipo.equals("2")){
	        	JOptionPane.showMessageDialog(null,"Check Out registrado com sucesso!");
	        }
		}catch(SQLException se){
			JOptionPane.showMessageDialog(null, "Erro! Cadastro não efetuado!");
		}
	}
	
	public static void insertReserva(String dataIn, String dataOut, int qtdHosp) throws SQLException, ParseException{
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		java.sql.Date dataE = new java.sql.Date(fmt.parse(dataIn).getTime());
		java.sql.Date dataS = new java.sql.Date(fmt.parse(dataOut).getTime());
	
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); //data do sistema
		System.out.println(sqlDate);
		try{
			String DBCALL = "{call NOVA_RESERVA(?,?,?,?,?,?)}";
	        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
	        cs.setString(1, Main.login.loginUsuario());
	        cs.setInt(2, Local.getId());
	        cs.setDate(3, dataE);
	        cs.setDate(4, dataS);
	        cs.setDate(5, sqlDate);
	        cs.setInt(6, qtdHosp);
	        Conexao.myConn.commit();
	        cs.executeUpdate();
	        cs.close();
	        System.out.println("Fez tudo");
		}catch(SQLException se){
			System.out.println("Outro erro de sql");
			JOptionPane.showMessageDialog(null, "Erro! Reserva não efetuada!");
		}
	}
	
	public static void cancelReserv(int reservId) throws SQLException{
		try{
			String DBCALL = "{call CANCELA_RESERVA(?)}";
	        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
	        cs.setInt(1, reservId);
	        Conexao.myConn.commit();
	        cs.executeUpdate();
	        cs.close();
			JOptionPane.showMessageDialog(null, "Reserva Cancelada.");
		}catch(SQLException se){
			JOptionPane.showMessageDialog(null, "Erro! Cancelmento não efetuado!");
		}
	}
}