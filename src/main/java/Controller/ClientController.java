package Controller;

import Repository.InMemory.ClientRepositoryMemory;
import model.Client;

import javax.persistence.Table;
import java.util.Comparator;
import java.util.List;

@Table(name="Clients")
public class ClientController extends ClientRepositoryMemory{

    public ClientRepositoryMemory repo = new ClientRepositoryMemory();

    public ClientController() {
        super();
    }

//    @Override
    public void add(Client entity){
        super.addList(entity);

    }

    @Override
    public void delete(Client entity) {
        super.delete(entity);
    }

    @Override
    public Client findById(Integer id) throws Exception {
        return super.findById(id);
    }

    @Override
    public void update(Integer id, Client newEntity) {

        super.update(id, newEntity);
    }

    @Override
    public void printAllClients(List<Client> clientList)
    {

        super.printAllClients(clientList);
    }

    @Override
    public int size(){
        return super.size();
    }

    public List<Client> sortByIdAsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getIdClient));
        repo.printAllClients(sortedClients);
        return sortedClients;
    }

    public List<Client> sortByIdDsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getIdClient).reversed());
        repo.printAllClients(sortedClients);
        return sortedClients;
    }

    public List<Client> sortByNameAsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getName));
        repo.printAllClients(sortedClients);
        return sortedClients;
    }
    public List<Client> sortByNameDsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getName).reversed());
        repo.printAllClients(sortedClients);
        return sortedClients;

    }

    public List<Client> sortByAgeAsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getAge));
        repo.printAllClients(sortedClients);
        return sortedClients;
    }
    public List<Client> sortByAgeDsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getAge).reversed());
        repo.printAllClients(sortedClients);
        return sortedClients;
    }

    public List<Client> sortByWonMoneyAsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getWonMoney));
        repo.printAllClients(sortedClients);
        return sortedClients;
    }
    public List<Client> sortByWonMoneyDsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getWonMoney).reversed());
        repo.printAllClients(sortedClients);
        return sortedClients;
    }

    public List<Client> sortByLostMoneyAsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getLostMoney));
        repo.printAllClients(sortedClients);
        return sortedClients;
    }

    public List<Client> sortByLostMoneyDsc(){
        repo.getTable();
        List<Client> sortedClients = repo.getAllClients();
        sortedClients.sort(Comparator.comparing(Client::getLostMoney).reversed());
        repo.printAllClients(sortedClients);
        return sortedClients;
    }

}
