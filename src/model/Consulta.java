package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta {

	static PreparedStatement ps;
	
	public static ResultSet consultaReserva(int id_lugar) throws SQLException{
		ps = Conexao.myConn.prepareStatement("SELECT ID_RESERVA, LOGIN, DATA_ENTRADA AS ENTRADA, DATA_SAIDA AS SAIDA"
				+ " FROM FAZ_RESERVA "
				+ "WHERE ID_LUGAR="+id_lugar+"AND DATA_SAIDA>SYSDATE");
		Conexao.myRs = ps.executeQuery();
		
		return Conexao.myRs;
	}
	
}
