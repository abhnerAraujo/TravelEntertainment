package control;

public class Local {
	
	private String titulo="";
	private String Descricao="";
	private int disp=0;
	private int valor_dia=0;
	private String login="";
	private String bairro="";
	private String rua="";
	private int numero=0;
	private String cep="";
	
	
	public Local(String login){
		this.login=login;
	}
	
	public void setLocal(String titulo, int valor, String descri, int disp, String login, String bairro, String rua, int num, String cep){
		this.titulo=titulo;
		this.valor_dia=valor;
		this.Descricao=descri;
		this.disp=disp;
		this.login=login;
		this.bairro=bairro;
		this.rua=rua;
		this.numero=num;
		this.cep=cep;
	}
	
	public void ConstruirLocal(){
		
	}
}
