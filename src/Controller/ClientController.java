package Controller;

import Repository.InMemory.ClientRepositoryMemory;
import model.Client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientController extends ClientRepositoryMemory{

    private ArrayList<Client> allClients;

    private ClientRepositoryMemory sortedallClients;
    public ClientController(ArrayList<Client> allClients){
        this.allClients=allClients;
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

    public void sortByNameAsc(){
        List<Client> sortedAllClients= allClients;
        sortedAllClients.sort(Comparator.comparing(Client::getName));
        printAllClients();
    }
    public void sortByNameDsc(){
        List<Client> sortedAllClients= allClients;
        sortedAllClients.sort(Comparator.comparing(Client::getName));
        printAllClients();
    }

    public void sortByAgeAsc(){
        List<Client> sortedAllClients= allClients;
        sortedAllClients.sort(Comparator.comparing(Client::getAge));
        printAllClients();
    }
    public void sortByAgeDsc(){
        List<Client> sortedAllClients= allClients;
        sortedAllClients.sort(Comparator.comparing(Client::getAge).reversed());
        printAllClients();
    }

    public void sortByWinningsAsc(){
        List<Client> sortedAllClients= allClients;
        sortedAllClients.sort(Comparator.comparing(Client::getAge));
        printAllClients();
    }
    public void sortByWinningsDsc(){
        List<Client> sortedAllClients= allClients;
        sortedAllClients.sort(Comparator.comparing(Client::getAge).reversed());
        printAllClients();
    }

    public void sortByLossesAsc(){
        List<Client> sortedAllClients= allClients;
        sortedAllClients.sort(Comparator.comparing(Client::getAge));
        printAllClients();
    }

    public void sortByLossesDsc(){
        List<Client> sortedAllClients= allClients;
        sortedAllClients.sort(Comparator.comparing(Client::getAge).reversed());
        printAllClients();
    }
    public void printAllClients()
    {
        for (Client client :sortedallClients.getList())
            System.out.println(client.getName() + " " + client.getPassword() + " " + client.getAge() + " "
                    + client.getCurrentMoney() + " " + client.getWinnings() + " " + client.getLosses());

    }

}
