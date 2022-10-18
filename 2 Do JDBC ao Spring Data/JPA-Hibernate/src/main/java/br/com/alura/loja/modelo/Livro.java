package br.com.alura.loja.modelo;

public class Livro extends Produto {

	private String autor;

	private Integer numeroDePaginas;

	public Livro() {

	}

	public Livro(String autor, Integer numeroDePaginas) {

		this.autor = autor;
		this.numeroDePaginas = numeroDePaginas;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

}
