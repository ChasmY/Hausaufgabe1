package Repository;

import model.User;

public interface CrudRepo<ID, E> {
    void add(E entity) throws Exception;
    void delete(E entity);
    void update(ID id,E newEntity);
    E findById(ID id) throws Exception;

}
