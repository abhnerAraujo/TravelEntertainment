package model;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.Types;

import javax.swing.JOptionPane;

import views.Main;

public class Login_model {
	
	public static String existe() throws SQLException{
		String output="";
		String DBCALL = "{call EXISTE(?,?,?)}";
			
		try
		{
			Conexao.conexao();
	        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
	        cs.registerOutParameter(1, Types.VARCHAR);
	        cs.setString(2, Main.login.loginUsuario());
	        cs.setString(3, Main.login.pass());
	        cs.execute();
	        
	        output = cs.getString(1);
	        cs.close();
	        Conexao.desconectar();
	        return output;
		}
		catch (SQLRecoverableException exp)
		{
			JOptionPane.showMessageDialog(null, "Conexão com o servidor nao estabelecida!");
		}catch (SQLException exp2)
		{
			
		}
		return output;
	        
		
	}
}
