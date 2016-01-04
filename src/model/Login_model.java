package model;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import views.Main;

public class Login_model {
	
	public static String existe() throws SQLException{
		
			String DBCALL = "{call EXISTE(?,?,?)}";
			Conexao.conexao();
	        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
	        String output="";
	        cs.registerOutParameter(1, Types.VARCHAR);
	        cs.setString(2, Main.login.loginUsuario());
	        cs.setString(3, Main.login.pass());
	        cs.execute();
	        
	        output = cs.getString(1);
	        cs.close();
	        Conexao.desconectar();
	        return output;

	}
}
