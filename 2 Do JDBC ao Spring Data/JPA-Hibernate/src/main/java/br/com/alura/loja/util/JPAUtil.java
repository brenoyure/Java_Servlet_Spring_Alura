package br.com.alura.loja.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
