package br.com.alura.gerenciador.modelo;

public class Usuario {

	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	protected void setLogin(String login) {
		this.login = login;
	}

	protected String getSenha() {
		return senha;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}

	protected boolean ehIgual(String login, String senha) {
		if (!this.login.equals(login)) {
			return false;
		}

		if (!this.senha.equals(senha)) {
			return false;
		}

		return true;
	}
}
