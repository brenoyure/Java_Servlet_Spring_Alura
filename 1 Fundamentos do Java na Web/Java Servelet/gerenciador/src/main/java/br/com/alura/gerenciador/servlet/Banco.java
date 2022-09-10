package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
		Iterator<Empresa> it = Banco.empresas.listIterator();

		while (it.hasNext()) {
			if (it.next().getId() == id)
				it.remove();
		}

	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(Banco.empresas);
	}

}
