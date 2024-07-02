package DAO;

import Models.Projeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.function.Consumer;

public class ProjetoDAO {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("/hibernate.cfg.xml");

    static void inSession(EntityManagerFactory factory, Consumer<EntityManager> work) {
        var entityManager = factory.createEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            work.accept(entityManager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public List<Projeto> findAll() {
        final List<Projeto>[] projetos = new List[1];
        inSession(factory, entityManager -> {
            projetos[0] = entityManager.createQuery("select p from Projeto p", Projeto.class).getResultList();
        });
        return projetos[0];
    }

    public void save(Projeto projeto) {
        inSession(factory, entityManager -> {
            entityManager.persist(projeto);
        });
    }

    public void delete(Projeto projeto) {
        inSession(factory, entityManager -> {
            entityManager.remove(projeto);
        });
    }

    public Projeto findById(int id) {
        final Projeto[] projeto = new Projeto[1];
        inSession(factory, entityManager -> {
            projeto[0] = entityManager.find(Projeto.class, id);
        });
        return projeto[0];
    }

    public void update(Projeto projeto) {
        inSession(factory, entityManager -> {
            entityManager.merge(projeto);
        });
    }
}
