package model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.Local;
import views.Main;

public class Consulta {
	
	private static String dataIn = null;
	private static String dataOut = null;
	static PreparedStatement ps;
	
	public static ResultSet consultaReserva() throws SQLException{
		ps = Conexao.myConn.prepareStatement("SELECT FR.ID_RESERVA, FR.LOGIN, FR.DATA_ENTRADA AS ENTRADA, FR.DATA_SAIDA AS SAIDA"
				+ " FROM FAZ_RESERVA FR,LUGAR LU"
				+ " WHERE FR.ID_LUGAR=LU.ID_LUGAR AND LU.LOGIN='"+Main.login.loginUsuario()+"' AND DATA_SAIDA>SYSDATE");
		Conexao.myRs = ps.executeQuery();
		
		return Conexao.myRs;
	}
	
	public static ResultSet consultaLocais() throws SQLException{
		ps = Conexao.myConn.prepareStatement("SELECT TITULO, VALOR_DIA AS DIARIA, DISPONIBILIDADE, BAIRRO "
				+ "FROM LUGAR WHERE "
				+ "LOGIN='"+Main.login.loginUsuario()+"'");
		Conexao.myRs = ps.executeQuery();
		return Conexao.myRs;
	}
	
	public static ResultSet consultaReservas() throws SQLException{
		ps = Conexao.myConn.prepareStatement("SELECT R.ID_RESERVA, L.TITULO, R.DATA_ENTRADA, R.DATA_SAIDA "
				+ "FROM FAZ_RESERVA R, LUGAR L WHERE "
				+ "R.LOGIN='"+Main.login.loginUsuario()+"' AND L.ID_LUGAR = R.ID_LUGAR");
		Conexao.myRs = ps.executeQuery();
		return Conexao.myRs;
	}
	
	public static ResultSet consultaLocaisByType(int index, String busca) throws SQLException{
		String Type = null;
		if( index == 0){
			Type = "CIDADE";
		}else if (index == 1){
			Type = "BAIRRO";
		}else if (index == 2){
			Type = "PAIS";
		}else if (index == 3){
			Type = "ESTADO";
		}
		System.out.println(Type);

		System.out.println(busca);
		ps = Conexao.myConn.prepareStatement("SELECT TITULO, VALOR_DIA AS DIARIA, DISPONIBILIDADE, BAIRRO "
				+ "FROM LUGAR WHERE "
				+ ""+Type+"='"+busca+"'");
		Conexao.myRs = ps.executeQuery();
		return Conexao.myRs;
	}
	
	public static void setLocal(String nomeLocal) throws SQLException{
		ps = Conexao.myConn.prepareStatement("SELECT TITULO, VALOR_DIA AS DIARIA, DESCRICAO, DISPONIBILIDADE, LOGIN, PAIS, BAIRRO, RUA, NUMERO, CEP, ESTADO, CIDADE, ID_LUGAR "
				+ "FROM LUGAR WHERE "
				+ " TITULO ='"+nomeLocal+"'");
		Conexao.myRs = ps.executeQuery();
		
		List rowValues = new ArrayList();
		while (Conexao.myRs.next()) {
		    rowValues.add(Conexao.myRs.getString("TITULO"));
		    rowValues.add(Integer.toString(Conexao.myRs.getInt("DIARIA")));
		    rowValues.add(Conexao.myRs.getString("DESCRICAO"));
		    rowValues.add(Integer.toString(Conexao.myRs.getInt("DISPONIBILIDADE")));
		    rowValues.add(Conexao.myRs.getString("LOGIN"));
		    rowValues.add(Conexao.myRs.getString("PAIS"));
		    rowValues.add(Conexao.myRs.getString("BAIRRO"));
		    rowValues.add(Conexao.myRs.getString("RUA"));
		    rowValues.add(Integer.toString(Conexao.myRs.getInt("NUMERO")));
		    rowValues.add(Conexao.myRs.getString("CEP"));
		    rowValues.add(Conexao.myRs.getString("ESTADO"));
		    rowValues.add(Conexao.myRs.getString("CIDADE"));
		    rowValues.add(Integer.toString(Conexao.myRs.getInt("ID_LUGAR")));
		}
		String [] contactListNames = (String[]) rowValues.toArray(new String[rowValues.size()]);
		Local.setLocal(contactListNames[0], Integer.parseInt(contactListNames[1]), contactListNames[2], Integer.parseInt(contactListNames[3]), contactListNames[4], contactListNames[5], contactListNames[6], contactListNames[7], Integer.parseInt(contactListNames[8]), contactListNames[9], contactListNames[10], contactListNames[11], Integer.parseInt(contactListNames[12]));
	}
	
	public static boolean checkCheckIn(BigDecimal idReserva) throws SQLException{
		ps = Conexao.myConn.prepareStatement("SELECT LO.DATA_INICIO"
				+ " FROM LUGAR LU, LOCACAO LO"
				+ " WHERE LO.ID_RESERVA='"+idReserva+"' AND LU.ID_LUGAR=LO.ID_LUGAR AND LU.LOGIN='"+Main.login.loginUsuario()+"'");
		Conexao.myRs = ps.executeQuery();
		
		try {
			while (Conexao.myRs.next()) {	
				setDataIn(Conexao.myRs.getString("DATA_INICIO"));
				System.out.println(getDataIn());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
	        return false;
	    }
		
		if(getDataIn() != null){
			return true;
		}
		return false;
	}
	
	public static boolean checkCheckOut(BigDecimal idReserva) throws SQLException{
		ps = Conexao.myConn.prepareStatement("SELECT LO.DATA_FIM"
				+ " FROM LUGAR LU, LOCACAO LO"
				+ " WHERE LO.ID_RESERVA='"+idReserva+"' AND LU.ID_LUGAR=LO.ID_LUGAR AND LU.LOGIN='"+Main.login.loginUsuario()+"'");
		Conexao.myRs = ps.executeQuery();
		
		try {
			while (Conexao.myRs.next()) {	
				setDataOut(Conexao.myRs.getString("DATA_FIM"));
				System.out.println(getDataOut());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
	        return false;
	    }
		
		if(getDataOut() != null){
			return true;
		}
		return false;
	}
	
	//setter and getters

	public static String getDataIn() {
		return dataIn;
	}

	public static void setDataIn(String data) {
		Consulta.dataIn = data;
	}
		
	public static String getDataOut() {
		return dataOut;
	}

	public static void setDataOut(String data) {
		Consulta.dataOut = data;
	}
}
