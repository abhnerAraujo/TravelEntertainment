package model;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JOptionPane;

import views.Main;

public class Usuario_model {

	public static void mudarSenha(){
		String DBCALL = "{call MUDAR_SENHA(?,?,?)}";

		try
		{
	        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
	        cs.setString(1, Main.login.loginUsuario());
	        cs.setString(2, Main.usuOpcao.newPass());
	        cs.setString(3, Main.login.pass());
	        cs.execute();
	        cs.close();
		}
		catch (SQLRecoverableException exp)
		{
			JOptionPane.showMessageDialog(null, "Conexão com o servidor nao estabelecida!");
		}
		catch (SQLException exp2)
		{
			System.out.println("Deu merda");
		}
	}
	
	public static void deletarUsuario() throws SQLException{
        Statement stmt = Conexao.myConn.createStatement();
        stmt.executeUpdate ("DELETE FROM USUARIO WHERE LOGIN='"+Main.login.loginUsuario()+"'");
        Conexao.myConn.commit();
        stmt.close();
	}
}
