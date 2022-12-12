package Controller;

import Repository.InMemory.ClientRepositoryMemory;
import model.Client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientController extends ClientRepositoryMemory{

    ClientRepositoryMemory allClients;
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
        allClients.getList().sort(Comparator.comparing(Client::getName));
        printAllClients();
    }
    public void sortByNameDsc(){
        allClients.getList().sort(Comparator.comparing(Client::getName));
        printAllClients();
    }

    public void sortByAgeAsc(){
        allClients.getList().sort(Comparator.comparing(Client::getAge));
        printAllClients();
    }
    public void sortByAgeDsc(){
        allClients.getList().sort(Comparator.comparing(Client::getAge).reversed());
        printAllClients();
    }

    public void sortByWonMoneyAsc(){
        allClients.getList().sort(Comparator.comparing(Client::getWonMoney));
        printAllClients();
    }
    public void sortByWonMoneyDsc(){
        allClients.getList().sort(Comparator.comparing(Client::getWonMoney).reversed());
        printAllClients();
    }

    public void sortByLostMoneyAsc(){
        allClients.getList().sort(Comparator.comparing(Client::getLostMoney));
        printAllClients();
    }

    public void sortByLostMoneyDsc(){
        allClients.getList().sort(Comparator.comparing(Client::getLostMoney).reversed());
        printAllClients();
    }
    public void printAllClients()
    {
        for (Client client : allClients.getList())
            System.out.println(client.getName() + " " + client.getPassword() + " " + client.getAge() + " "
                    + client.getCurrentMoney() + " " + client.getWonMoney() + " " + client.getLostMoney());

    }

}
