package model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
