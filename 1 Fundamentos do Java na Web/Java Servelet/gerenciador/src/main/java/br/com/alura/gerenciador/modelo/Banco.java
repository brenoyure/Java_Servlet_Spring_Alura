package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Banco {

	private static Integer numeroIdentificador = 1;
	private static List<Empresa> empresas = new ArrayList<>();

	static {

		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(numeroIdentificador++);

		Empresa empresa2 = new Empresa();
		empresa2.setId(numeroIdentificador++);
		empresa2.setNome("Caelum");

		empresas.add(empresa);
		empresas.add(empresa2);

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

	public void editarEmpresaPeloID(Integer id, String nomeDaEmpresa, Date dataDeAbertura) {

		try {
			Empresa empresa = this.buscaEmpresaPelaID(id);
			empresa.setNome(nomeDaEmpresa);
			empresa.setDataAbertura(dataDeAbertura);

		} catch (NullPointerException e) {
			System.err.println("Empresa não encontrada.");
		}

	}

}
