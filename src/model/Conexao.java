package model;

import java.sql.*;
import java.net.PasswordAuthentication;
import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;


public class Conexao {
    public static Connection myConn = null; 
    public static Statement myStmt = null;
    public static ResultSet myRs = null;


	/**
	 * @param args the command line arguments
	* @throws SQLException 
	 */
    public static void conexao() throws SQLException {

		try {
			// 1. Get a connection to database
			String dburl="jdbc:oracle:thin:@//oracle11g.cin.ufpe.br:1521/Instance01";
			
			Class.forName("oracle.jdbc.OracleDriver");
			myConn = DriverManager.getConnection(dburl,"u_afga","bvqnekhs");
			if (myConn!=null){
				System.out.println("Database connection successful!");
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	

    }
    
    public static void fecharResult() throws SQLException{
    	myRs.close();
    	if(myRs.isClosed()){
    		System.out.println("ResultSet fechado com sucesso!");
    	}
    }
    
    public static void desconectar() throws SQLException{
    	myConn.close();
		if (myConn.isClosed()){
			System.out.println("Database desconnection successful!\n");
		}
    }


}
