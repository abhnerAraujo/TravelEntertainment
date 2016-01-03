package model;

import java.sql.SQLException;
import java.sql.Statement;

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
        Statement stmt = Conexao.myConn.createStatement();
        stmt.executeUpdate("EXEC CADASTRAR_LOCAL('Home, sweet home',420,'Lugar bacaninha',4,'BobDylan','Rua Qualquer',32,'11111111','Argelia','Roscovo','Suassuna','1234,5678','Azul Celeste');");
        /*stmt.executeUpdate("EXEC CADASTRAR_LOCAL("+ 
        		"'"+parametro[0]+
        		"',"+Double.parseDouble(parametro[1])+
        		",'"+parametro[2]+
        		"',"+Integer.parseInt(parametro[3])+
        		",'"+Main.login.loginUsuario()+
        		"','"+parametro[4]+
        		"',"+Integer.parseInt(parametro[5])+
        		",'"+parametro[6]+
        		"','"+parametro[7]+
        		"','"+parametro[8]+
        		"','"+parametro[9]+
        		"','"+parametro[10]+
        		"','"+parametro[11]+
        		"');");
        */
        stmt.close();
        
	}
	
}
