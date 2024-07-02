package DAO;

import Models.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.function.Consumer;

public class FuncionarioDAO {

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

    public List<Funcionario> findAll() {
        final List<Funcionario>[] funcionarios = new List[1];
        inSession(factory, entityManager -> {
            funcionarios[0] = entityManager.createQuery("select f from Funcionario f", Funcionario.class).getResultList();
        });
        return funcionarios[0];
    }

    public void save(Funcionario funcionario) {
        inSession(factory, entityManager -> {
            entityManager.persist(funcionario);
        });
    }

    public void delete(Funcionario funcionario) {
        inSession(factory, entityManager -> {
            entityManager.remove(funcionario);
        });
    }

    public Funcionario findById(int id) {
        final Funcionario[] funcionario = new Funcionario[1];
        inSession(factory, entityManager -> {
            funcionario[0] = entityManager.find(Funcionario.class, id);
        });
        return funcionario[0];
    }

    public void update(Funcionario funcionario) {
        inSession(factory, entityManager -> {
            entityManager.merge(funcionario);
        });
    }
}
