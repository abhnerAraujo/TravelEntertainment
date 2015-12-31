package model;

import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	
	public static void insert() throws SQLException{
		String[] parametro=views.JP_Usuario_Add.params();
        Statement stmt = Conexao.myConn.createStatement();
        stmt.executeUpdate("INSERT INTO USUARIO(EMAIL, NOME, LOGIN, SENHA, BAIRRO, RUA, NUMERO, CEP) "
        		+ "VALUES ('"+parametro[0]+"','"+parametro[1]+"','"+parametro[2]+"','"+parametro[3]+
        		"','"+parametro[4]+"','"+parametro[5]+"',"+Integer.parseInt(parametro[6])+",'"+parametro[7]+"')");
        Conexao.desconectar();
	}
}
