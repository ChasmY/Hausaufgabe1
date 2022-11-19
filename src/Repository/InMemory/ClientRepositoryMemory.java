package Repository.InMemory;

import Repository.ClientRepository;
import model.Client;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class ClientRepositoryMemory implements ClientRepository {
    private ArrayList<Client> allClients = new ArrayList<>();

    
    @Override
    public void populateClients(){
        Client c1 = new Client("Ion", "134", 78, 300);
        Client c2 = new Client("Marie", "124", 30, 5000);
        this.allClients.add(c1);
        this.allClients.add(c2);
    }

    public ArrayList<Client> getList(){return allClients;}
    @Override
    public void add(Client entity) {
        this.allClients.add(entity);
    }

    @Override
    public void delete(Client s) {
        this.allClients.remove(s);
    }

    @Override
    public void update(String s, Client newEntity) {
        for(User user: allClients)
            if(Objects.equals(user.getName(), s))
                user = newEntity;
    }

    @Override
    public Client findById(String s) {
        for(Client user: allClients)
            if(Objects.equals(user.getName(), s))
                return user;
        return null;
    }
}
