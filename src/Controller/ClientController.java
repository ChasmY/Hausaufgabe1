package Controller;

import Repository.InMemory.ClientRepositoryMemory;
import model.Client;
import model.Dealer;
import model.User;

import java.util.Comparator;
import java.util.List;

public class ClientController extends ClientRepositoryMemory{

    public ClientRepositoryMemory repo = new ClientRepositoryMemory();

    @Override
    public void add(Client entity) throws Exception {
        super.add(entity);
    }

    @Override
    public void delete(Client entity) {
        super.delete(entity);
    }

    @Override
    public Client findById(String s) throws Exception {
        return super.findById(s);
    }

    @Override
    public void update(String s, Client newEntity) {
        super.update(s, newEntity);
    }

    @Override
    public void printAllClients()
    {
        super.printAllClients();
    }

    @Override
    public int size(){
        return super.size();
    }

    public List<Client> sortByNameAsc(){
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getName));
        //repo.printAllClients();
        return sortedClients;
    }
    public List<Client> sortByNameDsc(){
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getName));
        //repo.printAllClients();
        return sortedClients;

    }

    public List<Client> sortByAgeAsc(){
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getAge));
        //repo.printAllClients();
        return sortedClients;
    }
    public List<Client> sortByAgeDsc(){
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getAge).reversed());
        //repo.printAllClients();
        return sortedClients;
    }

    public List<Client> sortByWonMoneyAsc(){
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getWonMoney));
        //repo.printAllClients();
        return sortedClients;
    }
    public List<Client> sortByWonMoneyDsc(){
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getWonMoney).reversed());
        //repo.printAllClients();
        return sortedClients;
    }

    public List<Client> sortByLostMoneyAsc(){
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getLostMoney));
        //repo.printAllClients();
        return sortedClients;
    }

    public List<Client> sortByLostMoneyDsc(){
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getLostMoney).reversed());
        //repo.printAllClients();
        return sortedClients;
    }

}
