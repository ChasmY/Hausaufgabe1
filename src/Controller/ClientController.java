package Controller;

import Repository.InMemory.ClientRepositoryMemory;
import model.Client;

import java.util.List;

public class ClientController extends ClientRepositoryMemory{
    public ClientController(List<Client> allClients){
        super(allClients);
    }

    @Override
    public void add(Client entity) {
        super.add(entity);
    }

    @Override
    public void delete(Client s) {
        super.delete(s);
    }

    @Override
    public Client findById(String s) {
        return super.findById(s);
    }

    @Override
    public void update(String s, Client newEntity) {
        super.update(s, newEntity);
    }


}
