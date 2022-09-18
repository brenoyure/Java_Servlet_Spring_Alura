package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {

	private static Integer identificadorUnico = 1;

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();

	static {
		
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(identificadorUnico++);

		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(identificadorUnico++);

		Usuario u1 = new Usuario();
		u1.setLogin("brenoyure");
		u1.setSenha("cstrike");

		Usuario u2 = new Usuario();
		u2.setLogin("inacio");
		u2.setSenha("12345");
		
		Banco.empresas.add(empresa);
		Banco.empresas.add(empresa2);
		
		Banco.usuarios.add(u1);
		Banco.usuarios.add(u2);
		
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(identificadorUnico++);
		Banco.empresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(Banco.empresas);
	}

	public boolean naoEstiverVazio() {
		return !this.getEmpresas().isEmpty();
	}
	
	public void remove(Integer id) {

		Banco.empresas.remove(this.buscaPeloID(id));

	}

	private static Usuario buscaPeloUsuario(String login, String senha) {
		
		return Banco.usuarios.stream().filter(u -> u.ehIgual(login, senha)).findFirst().orElse(null);
	}
	
	public static boolean usuarioExiste(String login, String senha) {
		
		return Banco.usuarios.contains(buscaPeloUsuario(login, senha));
		
	}
	
	public Empresa buscaPeloID(Integer id) {
		
		return this.getEmpresas().stream().filter(e -> e.getId() == id).findFirst().orElseThrow();
		
	}
	
}
