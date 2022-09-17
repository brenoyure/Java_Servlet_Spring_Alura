package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {

	private static Integer identificadorUnico = 1;

	private static List<Empresa> empresas = new ArrayList<>();

	static {
		
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(identificadorUnico++);

		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(identificadorUnico++);

		Banco.empresas.add(empresa);
		Banco.empresas.add(empresa2);
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

	public Empresa buscaPeloID(Integer id) {
		
		return this.getEmpresas().stream().filter(e -> e.getId() == id).findFirst().orElseThrow();
		
	}
	
}
