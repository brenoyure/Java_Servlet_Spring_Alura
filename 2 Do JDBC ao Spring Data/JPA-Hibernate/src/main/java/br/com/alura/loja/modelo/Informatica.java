package br.com.alura.loja.modelo;

public class Informatica extends Produto {

	private String marca;

	private String modelo;

	public Informatica() {

	}

	public Informatica(String marca, String modelo) {

		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

}
