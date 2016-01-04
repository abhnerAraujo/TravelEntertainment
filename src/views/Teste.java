package views;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import model.Conexao;

public class Teste {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		try{
			String DBCALL = "{call EXISTE(?,?)}";
			String aa="BobDylan";
			String bb="desolationrow";
			Conexao.conexao();
	        CallableStatement cs = Conexao.myConn.prepareCall(DBCALL);
	        
	        cs.registerOutParameter(1, Types.VARCHAR);
	        cs.setString(2, aa);
	        cs.setString(3, bb);
	        cs.execute();
	        
	        String output = cs.getString(1);
	        System.out.println(output);
	        cs.close();
	        Conexao.desconectar();
		}catch (SQLException sql){
			sql.printStackTrace();
			System.out.println("Deu Águia");
			Conexao.desconectar();
		}catch (NullPointerException npe){
			Conexao.desconectar();
		}
	}

}
