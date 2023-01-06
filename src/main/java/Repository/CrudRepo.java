package Repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface CrudRepo<ID, E> {


    void addList(E entity);
    void delete(E entity);
    void update(ID id,E newEntity);
    E findById(ID id) throws Exception;
}
