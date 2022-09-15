package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
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

	public static void ordenarLista() {
		Banco.empresas.sort(null);
	}
	
	public void remove(Integer id) {

		Iterator<Empresa> it = Banco.empresas.iterator();

		while (it.hasNext()) {
			if (it.next().getId() == id)
				it.remove();

		}

	}

	public Empresa buscaPeloID(Integer id) {
		for(Empresa e : Banco.empresas) {
			if (e.getId() == id)
				return e;
		}
		
		return null;
		
	}
	
}
