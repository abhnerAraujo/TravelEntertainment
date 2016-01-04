package model;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import views.Main;

public class Login_model {
	
	public String existe() throws SQLException{
		String DBCALL = "{call EXISTE(?,?)}";
        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, Main.login.loginUsuario());
        cs.setString(3, Main.login.pass());
        String output = cs.getString(1);
        cs.close();
        return output;
	}
}
