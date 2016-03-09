package to;


public class AlunoTO {

	// Atributos
	private int codigoAluno;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rg;
	private long cpf;
	private String login;
	private int senha;

	// Metodo Construtor
	public AlunoTO(int codigoAluno, String nome, String endereco,
			String telefone, String email, String rg, long cpf, String login,
			int senha) {
		this.codigoAluno = codigoAluno;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
	}

	public AlunoTO() 
	{
		this.codigoAluno = 0;
		this.nome = "";
		this.endereco = "";
		this.telefone = "";
		this.email = "";
		this.rg = "";
		this.cpf = 0;
		this.login = "";
		this.senha = 0;
	}

	// Metodos de acesso (Gets)
	public int getCodigoAluno() {
		return codigoAluno;
	}

	public int getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getRg() {
		return rg;
	}

	public long getCpf() {
		return cpf;
	}

	public String getLogin() {
		return login;
	}

	// Metodos modificadores (Sets)
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	

}// fim da classe aluno