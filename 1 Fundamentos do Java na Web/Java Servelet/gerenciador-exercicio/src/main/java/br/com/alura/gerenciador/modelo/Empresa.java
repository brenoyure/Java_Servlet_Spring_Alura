package br.com.alura.gerenciador.modelo;

import java.util.Date;

public class Empresa implements Comparable<Empresa> {

	private Integer id;
	private String nome;
	private Date dataDeAbertura = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {

		if (nomeEmBrancoOuNulo(nome))
			throw new NullPointerException("Campo Nome da Empresa não pode ficar nulo ou em branco.");

		if (nomeComecaComLetraMinuscula(nome))
			throw new IllegalArgumentException("Nome da Empresa deve começar com letra maiúscula.");

		this.nome = nome;
	}

	public void setDataDeAbertura(Date dataDeAbertura) {

		if (dataVaziaOuNula(dataDeAbertura))
			throw new NullPointerException("Campo data não pode ser nulo ou vazio.");

		this.dataDeAbertura = dataDeAbertura;
	}

	public Date getDataDeAbertura() {
		return this.dataDeAbertura;
	}

	@Override
	public int compareTo(Empresa outraEmpresa) {
		return this.nome.compareToIgnoreCase(outraEmpresa.nome);
	}

	@Override
	public String toString() {
		return this.nome;
	}

	private boolean nomeComecaComLetraMinuscula(String nome) {
		return nome.charAt(0) == nome.toLowerCase().charAt(0);
	}

	private boolean nomeEmBrancoOuNulo(String nome) {
		return nome == null || nome == "";
	}

	private boolean dataVaziaOuNula(Date data) {
		return data == null;
	}

}
