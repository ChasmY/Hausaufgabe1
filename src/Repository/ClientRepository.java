package Repository;

import model.Client;

public interface ClientRepository {
    void populateClients();

    void add(Client entity);

    void delete(Client s);

    void update(String s, Client newEntity);

    Client findById(String s);
}
