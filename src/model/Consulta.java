package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import views.Main;

public class Consulta {

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
}
