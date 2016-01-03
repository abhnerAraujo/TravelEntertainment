package model;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import views.Main;

public class Insert {
	
	public static void insertUsuario() throws SQLException{
		String[] parametro=views.JP_Usuario_Add.params();
        Statement stmt = Conexao.myConn.createStatement();
        stmt.executeUpdate("INSERT INTO USUARIO(EMAIL, NOME, LOGIN, SENHA, BAIRRO, RUA, NUMERO, CEP) "
        		+ "VALUES ('"+parametro[0]+"','"+parametro[1]+"','"+parametro[2]+"','"+parametro[3]+
        		"','"+parametro[4]+"','"+parametro[5]+"',"+Integer.parseInt(parametro[6])+",'"+parametro[7]+"')");
        stmt.close();
        
	}
	public static void insertLocal() throws SQLException{
		String[] parametro=views.JP_Local_New.params();
		try{
		String DBCALL = "{call CADASTRAR_LOCAL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
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
        Conexao.myConn.commit();
        cs.executeUpdate();
        cs.close();
        JOptionPane.showMessageDialog(null,"Local cadastrado com sucesso!");
		}catch(SQLException se){
			JOptionPane.showMessageDialog(null, "Erro! Cadastro não efetuado!");
		}
	}
	
}
