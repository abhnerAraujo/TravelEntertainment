package control;

public class Local {
	
	private static String titulo="";
	private static String Descricao="";
	private static int disp=0;
	private static int valor_dia=0;
	private static String login="";
	private static String pais="";
	private static String bairro="";
	private static String rua="";
	private static int numero=0;
	private static String cep="";
	private static String estado="";
	private static String cidade="";
	private static int id;
	
	
	public Local(String login){
		this.setLogin(login);
	}
	//TO USANDO ISSO TUDO PRA ALIMENTAR A PAGINA DE UM LOCAL NA HORA DE ADICIONAR RESERVA, PROCUREI E NAO ACHEI AONDE VOCE TAVA USANDO ISSO
	public static void setLocal(String titulo, int valor, String descri, int disp, String login, String pais, String bairro, String rua, int num, String cep, String estado, String cidade, int id){
		setTitulo(titulo);
		setValor_dia(valor);
		setPais(pais);
		setDescricao(descri);
		setDisp(disp);
		setLogin(login);
		setBairro(bairro);
		setRua(rua);
		setNumero(num);
		setCep(cep);
		setEstado(estado);
		setCidade(cidade);
		setId(id);
	}
	
	public void ConstruirLocal(){
		
	}

	public static int getValor_dia() {
		return valor_dia;
	}

	public static void setValor_dia(int valor_dia) {
		Local.valor_dia = valor_dia;
	}

	public static String getTitulo() {
		return titulo;
	}

	public static void setTitulo(String titulo) {
		Local.titulo = titulo;
	}

	public static String getDescricao() {
		return Descricao;
	}

	public static void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public static int getDisp() {
		return disp;
	}

	public static void setDisp(int disp) {
		Local.disp = disp;
	}

	public static String getLogin() {
		return login;
	}

	public static void setLogin(String login) {
		Local.login = login;
	}

	public static String getRua() {
		return rua;
	}

	public static void setRua(String rua) {
		Local.rua = rua;
	}

	public static int getNumero() {
		return numero;
	}

	public static void setNumero(int numero) {
		Local.numero = numero;
	}

	public static String getBairro() {
		return bairro;
	}

	public static void setBairro(String bairro) {
		Local.bairro = bairro;
	}

	public static String getCep() {
		return cep;
	}

	public static void setCep(String cep) {
		Local.cep = cep;
	}

	public static String getPais() {
		return pais;
	}

	public static void setPais(String pais) {
		Local.pais = pais;
	}
	public static String getEstado() {
		return estado;
	}
	public static void setEstado(String estado) {
		Local.estado = estado;
	}
	public static String getCidade() {
		return cidade;
	}
	public static void setCidade(String cidade) {
		Local.cidade = cidade;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Local.id = id;
	}
}
