package control;

import javax.swing.JOptionPane;

public class VerificarAddUsuario {

	public static boolean verificar(){
		String[] parametros;
		parametros=views.JP_Usuario_Add.params();
		for (int i=0;i<parametros.length;i++){
			if(parametros[i]==""){
				System.out.println("2");
				JOptionPane.showMessageDialog(null,"Existem Campos nulos! Preencha todos corretamente.");
				return false;
			}
		}
		return true;
	}
	
}
