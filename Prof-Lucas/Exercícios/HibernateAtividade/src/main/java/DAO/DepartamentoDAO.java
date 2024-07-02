package DAO;

import Models.Departamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.function.Consumer;

public class DepartamentoDAO {

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

    public List<Departamento> findAll() {
        final List<Departamento>[] departamentos = new List[1];
        inSession(factory, entityManager -> {
            departamentos[0] = entityManager.createQuery("select d from Departamento d", Departamento.class).getResultList();
        });
        return departamentos[0];
    }

    public void save(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.persist(departamento);
        });
    }

    public void delete(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.remove(departamento);
        });
    }

    public Departamento findById(int id) {
        final Departamento[] departamento = new Departamento[1];
        inSession(factory, entityManager -> {
            departamento[0] = entityManager.find(Departamento.class, id);
        });
        return departamento[0];
    }

    public void update(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.merge(departamento);
        });
    }
}
