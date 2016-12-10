package model;

import dao.MercadoriaDAO;
import to.MercadoriaTO;

public class Mercadoria {
	
	private int codigo;
	private String tipo;
	private String nome;
	private double quantidade;
	private double preco;
	private String negocio;
	
	public Mercadoria(int codigo, String tipo, String nome, double quantidade, double preco, String negocio) {
		
		this.codigo = codigo;
		this.tipo = tipo;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.negocio = negocio;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNegocio() {
		return negocio;
	}
	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}
	
	public void criar() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = getTO();
		dao.incluir(to);
	}

	public MercadoriaTO getTO() {
		MercadoriaTO to = new MercadoriaTO();
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setTipo(tipo);
		to.setQuantidade(quantidade);
		to.setPreco(preco);
		to.setNegocio(negocio);
		return to;
	}

	public void atualizar() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCodigo(codigo);
		dao.excluir(to);
	}

	public void carregar() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = dao.carregar(codigo);
		nome = to.getNome();
		tipo = to.getTipo();
		quantidade = to.getQuantidade();
		preco = to.getPreco();
		negocio = to.getNegocio();
	}

	
}
