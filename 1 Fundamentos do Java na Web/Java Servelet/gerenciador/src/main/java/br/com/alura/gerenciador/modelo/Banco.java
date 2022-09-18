package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {

	private static Integer numeroIdentificador = 1;
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();

	static {

		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(numeroIdentificador++);

		Empresa empresa2 = new Empresa();
		empresa2.setId(numeroIdentificador++);
		empresa2.setNome("Caelum");

		empresas.add(empresa);
		empresas.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("brenoyure");
		u1.setSenha("cstrike");
		
		Usuario u2 = new Usuario();
		u2.setLogin("inacio");
		u2.setSenha("12345");
		
		usuarios.add(u1);
		usuarios.add(u2);

	}

	public void adiciona(Empresa empresa) {
		empresa.setId(numeroIdentificador++);
		Banco.empresas.add(empresa);

	}

	public void remove(Integer id) {
		// Retorna a empresa que será removida através do ID
		Empresa empresaQueSeraRemovida = this.buscaEmpresaPelaID(id);

		// Remove a empresa do ArrayList<T>
		Banco.empresas.remove(empresaQueSeraRemovida);

		// Anula a referência
		empresaQueSeraRemovida = null;
	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(Banco.empresas);
	}

	public Empresa buscaEmpresaPelaID(Integer id) {

		return Banco.empresas.stream().filter(e -> e.getId() == id).findFirst().orElseThrow();

	}
	
	public Usuario existeUsuario(String login, String senha) {
		
		return Banco.usuarios.stream().filter(u -> u.ehIgual(login, senha)).findFirst().orElse(null);
		
	}

}
