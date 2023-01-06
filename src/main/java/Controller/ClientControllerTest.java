package Controller;

import model.Client;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.sql.Types.NULL;

class ClientControllerTest {

    ClientController clients = new ClientController();

    ClientControllerTest() throws Exception {}

    @Test
    void add() throws Exception {
        Client client = new Client(11,"Roxi", "2991", 30, 3610);
        Client client1 = new Client(12,"Ady", "8475", 23, 1090);
        clients.add(client);
        assert(clients.size() == 11);
        clients.add(client1);
        assert(clients.size() == 12);

        try{
            Client client2 = new Client(13,"Mircea", "243", 15, 100);
            clients.add(client2);
        }
        catch(RuntimeException e){
            assert true;
        }

        try{
            Client client3 = new Client(13,"Mircea", "243", 19, -100);
            clients.add(client3);
        }
        catch(RuntimeException e){
            assert true;
        }
    }

    @Test
    void delete() throws Exception {
        clients.delete(clients.findById(1));
        assert(clients.size() == 9);
        clients.delete(clients.findById(2));
        assert(clients.size() == 8);
        clients.delete(clients.findById(3));
        assert(clients.size() == 7);
        clients.delete(clients.findById(4));
        assert(clients.size() == 6);
        clients.delete(clients.findById(5));
        assert(clients.size() == 5);
        clients.delete(clients.findById(6));
        assert(clients.size() == 4);
        clients.delete(clients.findById(7));
        assert(clients.size() == 3);
        clients.delete(clients.findById(8));
        assert(clients.size() == 2);
        clients.delete(clients.findById(9));
        assert(clients.size() == 1);
        clients.delete(clients.findById(10));
        assert(clients.size() == 0);

    }

    @Test
    void findById() throws Exception {
        assert(clients.findById(2) == clients.getAllClients().get(1));
        assert(clients.findById(4) == clients.getAllClients().get(3));
        assert(clients.findById(9) == clients.getAllClients().get(8));

        try{
            Client c = new Client(NULL, "", "", NULL, NULL);
            c = clients.findById(17);
        }
        catch (RuntimeException e){
            assert true;
        }
    }

    @Test
    void sortByNameAsc() {
        List<Client> sortedClients = clients.sortByNameAsc();
        Client firstClient = sortedClients.get(0);
        for ( Client client : sortedClients){
            assert(client.getName().compareTo(firstClient.getName()) >= 0);
            firstClient = client;
        }
    }

    @Test
    void sortByNameDsc() {
        List<Client> sortedClients = clients.sortByNameDsc();
        Client firstClient = sortedClients.get(0);
        for ( Client client : sortedClients){
            assert(client.getName().compareTo(firstClient.getName()) <= 0);
            firstClient = client;
        }
    }

    @Test
    void sortByAgeAsc() {
        List<Client> sortedClients = clients.sortByAgeAsc();
        Client firstClient = sortedClients.get(0);
        for ( Client client : sortedClients ){
            assert(client.getAge() >= firstClient.getAge());
            firstClient = client;
        }
    }

    @Test
    void sortByAgeDsc() {
        List<Client> sortedClients = clients.sortByAgeDsc();
        Client firstClient = sortedClients.get(0);
        for ( Client client : sortedClients ){
            assert(client.getAge() <= firstClient.getAge());
            firstClient = client;
        }
    }

    @Test
    void sortByWonMoneyAsc() {
        clients.getAllClients().get(0).setWonMoney(7);
        clients.getAllClients().get(1).setWonMoney(15);
        clients.getAllClients().get(2).setWonMoney(2);
        clients.getAllClients().get(3).setWonMoney(0);
        clients.getAllClients().get(4).setWonMoney(4);
        clients.getAllClients().get(5).setWonMoney(6);
        clients.getAllClients().get(6).setWonMoney(1);
        clients.getAllClients().get(7).setWonMoney(0);
        clients.getAllClients().get(8).setWonMoney(10);
        clients.getAllClients().get(9).setWonMoney(12);

        List<Client> sortedClients = clients.sortByWonMoneyAsc();
        Client firstClient = sortedClients.get(0);
        for ( Client client : sortedClients ){
            assert(client.getWonMoney() >= firstClient.getWonMoney());
            firstClient = client;
        }
    }

    @Test
    void sortByWonMoneyDsc() {
        clients.getAllClients().get(0).setWonMoney(7);
        clients.getAllClients().get(1).setWonMoney(15);
        clients.getAllClients().get(2).setWonMoney(2);
        clients.getAllClients().get(3).setWonMoney(0);
        clients.getAllClients().get(4).setWonMoney(4);
        clients.getAllClients().get(5).setWonMoney(6);
        clients.getAllClients().get(6).setWonMoney(1);
        clients.getAllClients().get(7).setWonMoney(0);
        clients.getAllClients().get(8).setWonMoney(10);
        clients.getAllClients().get(9).setWonMoney(12);

        List<Client> sortedClients = clients.sortByWonMoneyDsc();
        Client firstClient = sortedClients.get(0);
        for ( Client client : sortedClients ){
            assert(client.getWonMoney() <= firstClient.getWonMoney());
            firstClient = client;
        }
    }

    @Test
    void sortByLostMoneyAsc() {

        clients.getAllClients().get(0).setLostMoney(5);
        clients.getAllClients().get(1).setLostMoney(13);
        clients.getAllClients().get(2).setLostMoney(0);
        clients.getAllClients().get(3).setLostMoney(3);
        clients.getAllClients().get(4).setLostMoney(7);
        clients.getAllClients().get(5).setLostMoney(1);
        clients.getAllClients().get(6).setLostMoney(11);
        clients.getAllClients().get(7).setLostMoney(8);
        clients.getAllClients().get(8).setLostMoney(18);
        clients.getAllClients().get(9).setLostMoney(0);

        List<Client> sortedClients = clients.sortByLostMoneyAsc();
        Client firstClient = sortedClients.get(0);
        for ( Client client : sortedClients ){
            assert(client.getLostMoney() >= firstClient.getLostMoney());
            firstClient = client;
        }
    }

    @Test
    void sortByLostMoneyDsc() {

        clients.getAllClients().get(0).setLostMoney(5);
        clients.getAllClients().get(1).setLostMoney(13);
        clients.getAllClients().get(2).setLostMoney(0);
        clients.getAllClients().get(3).setLostMoney(3);
        clients.getAllClients().get(4).setLostMoney(7);
        clients.getAllClients().get(5).setLostMoney(1);
        clients.getAllClients().get(6).setLostMoney(11);
        clients.getAllClients().get(7).setLostMoney(8);
        clients.getAllClients().get(8).setLostMoney(18);
        clients.getAllClients().get(9).setLostMoney(0);

        List<Client> sortedClients = clients.sortByLostMoneyDsc();
        Client firstClient = sortedClients.get(0);
        for ( Client client : sortedClients ){
            assert(client.getLostMoney() <= firstClient.getLostMoney());
            firstClient = client;
        }
    }

}