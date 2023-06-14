package brutepasta.persistencia;

import brutepasta.entidades.Caninos;
import brutepasta.entidades.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CaninoPersistencia {
	public static boolean incluir(Caninos canino) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(canino);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean alterar(Caninos canino) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(canino);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean excluir(Caninos canino) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(canino);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Caninos procurarPorNome(Caninos canino) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Caninos where nome = :param");
		consulta.setParameter("param", canino.getNome());
		List<Caninos> caninos = consulta.getResultList();
		if (!caninos.isEmpty()) {
			return caninos.get(0);
		}
		return null;
	}

	public static Caninos procurarCaninoPorLT(Caninos canino) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Caninos where situacao = :param");
		consulta.setParameter("param", canino.getNome());
		List<Caninos> caninos = consulta.getResultList();
		if (!caninos.isEmpty()) {
			return caninos.get(0);
		}
		return null;
	}

	public static List<Cliente> getClientes(Cliente cliente) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Cliente where nome like :param");
		consulta.setParameter("param", "%" + cliente.getNome() + "%");
		List<Cliente> clientes = consulta.getResultList();
		return clientes;
	}
}
