package Repository.InMemory;

import Repository.CrudRepo;
import model.Client;
import model.Dealer;
import model.User;

import java.util.ArrayList;
import java.util.Objects;

import static java.sql.Types.NULL;

public class ClientRepositoryMemory implements CrudRepo<String, Client> {
    private final ArrayList<Client> allClients = new ArrayList<>();

    public ClientRepositoryMemory() {
        populate();
    }

    public ArrayList<Client> getAllClients(){return allClients;}

    private void populate(){
        Client client = new Client("Ion", "134", 78, 300);
        Client client1 = new Client("Marie", "124", 30, 5000);
        Client client2 = new Client("Georgiana", "3215", 43, 1200);
        Client client3 = new Client("Georgica", "2213",23, 3200);
        Client client4 = new Client("Hagrid", "71002", 73, 4900);
        Client client5 = new Client("Viorel", "1234", 80, 10000);
        Client client6 = new Client("Traian", "3245", 49, 200);
        Client client7 = new Client("Claudiu", "2991", 21, 1700);
        Client client8 = new Client("Ioana", "49121", 26, 1990);
        Client client9 = new Client("Riana", "12221", 30, 2300);
        this.allClients.add(client);
        this.allClients.add(client1);
        this.allClients.add(client2);
        this.allClients.add(client3);
        this.allClients.add(client4);
        this.allClients.add(client5);
        this.allClients.add(client6);
        this.allClients.add(client7);
        this.allClients.add(client8);
        this.allClients.add(client9);
    }

    @Override
    public void add(Client entity) throws Exception {
        try {
            if (entity.getAge() > 18 || entity.getCurrentMoney() <= 0)
                this.allClients.add(entity);
        }
        catch (RuntimeException e){
            throw new Exception("You are too young! Or you can't add negative amount of money");
        }
    }

    @Override
    public void delete(Client entity) {
        this.allClients.remove(entity);
    }

    @Override
    public void update(String s, Client newEntity) {
        for (Client client : allClients)
            if (Objects.equals(client.getName(), s))
                client = newEntity;
    }

    @Override
    public Client findById(String s) throws Exception {
        boolean found = false;
        Client c = new Client("", "", NULL, NULL);
        for(Client client: allClients)
            if(Objects.equals(client.getName(), s)) {
                found = true;
                c = client;
                break;
            }
        try{
            if(found)
                return c;
        }
        catch(RuntimeException e){
            throw new Exception("No ID found");
        }
        return null;
    }

    public int size() {
        int k = 0;
        for (User user : allClients)
            k += 1;
        return k;
    }

    public void printAllClients()
    {
        for (Client client : allClients)
            System.out.println(client.getName() + " " + client.getPassword() + " " + client.getAge() + " " + client.getLostMoney() + " " +
                    client.getWonMoney() + " " + client.getCurrentMoney() + " " + client.getLostGames() + " " + client.getWonGames() );

    }
}
