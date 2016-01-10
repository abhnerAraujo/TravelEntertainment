package control;

import javax.swing.JOptionPane;

import views.Main;

public class Usuario_control {

	public static void mudarSenha(){
		
		model.Usuario_model.mudarSenha();
		Main.login.setPass();
		if(Main.login.pass().equals(Main.usuOpcao.newPass())){
			JOptionPane.showMessageDialog(null, "Senha alterada com Sucesso!" );
			
		}
		
	}
	
	
}
