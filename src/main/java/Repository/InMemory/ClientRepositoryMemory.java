package Repository.InMemory;
import Repository.CrudRepo;
import model.Client;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import model.Manager;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class ClientRepositoryMemory implements CrudRepo<Integer, Client> {
    private ArrayList<Client> allClients = new ArrayList();

    EntityManagerFactory factory;
    EntityManager em;
    public ClientRepositoryMemory() {
        fetch();
        populate();
    }

    public ArrayList<Client> getAllClients() {
        return this.allClients;
    }

    private void fetch(){
        factory= Persistence.createEntityManagerFactory("default");
        em = factory.createEntityManager();
        allClients = (ArrayList<Client>) em.createQuery("Select client from Client client").getResultList();
    }

    private void populate() {
        Client client = new Client(1, "Ion", "134", 78, 300);
        Client client1 = new Client(2, "Marie", "124", 30, 5000);
        Client client2 = new Client(3, "Georgiana", "3215", 43, 1200);
        Client client3 = new Client(4, "Georgia", "2213", 23, 3200);
        Client client4 = new Client(5, "Hagrid", "71002", 73, 4900);
        Client client5 = new Client(6, "Viorel", "1234", 80, 10000);
        Client client6 = new Client(7, "Traian", "3245", 49, 200);
        Client client7 = new Client(8, "Claudiu", "2991", 21, 1700);
        Client client8 = new Client(9, "Ioana", "49121", 26, 1990);
        Client client9 = new Client(10, "Riana", "12221", 30, 2300);
        addList(client);
        addList(client1);
        addList(client2);
        addList(client3);
        addList(client4);
        addList(client5);
        addList(client6);
        addList(client7);
        addList(client8);
        addList(client9);
    }

    public void addList(Client client){
        String jpql = "FROM User WHERE name = :username AND password = :password";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("username", client.getName());
        query.setParameter("password", client.getPassword());
        List<User> results = query.getResultList();
        if (results.isEmpty()) {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            allClients =(ArrayList<Client>) em.createQuery("Select client from Client client").getResultList();

        }
        else{
            System.out.println("Client already exists");
        }
    }

    public void delete(Client entity) {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.idClient = :idClient", Client.class);
        query.setParameter("idClient", entity.getIdClient());
        Client client = query.getSingleResult();
        if(client!= null) {
            this.allClients.remove(client);
            em.getTransaction().begin();
            em.remove(client);
            em.getTransaction().commit();
        }
    }

    public void update(Integer id, Client newEntity) {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.idClient = :idClient", Client.class);
        query.setParameter("idClient", id);
        Client client = query.getSingleResult();

        client.setWonGames(newEntity.getWonGames());
        client.setLostGames(newEntity.getLostGames());
        client.setWonMoney(newEntity.getWonMoney());
        client.setLostMoney(newEntity.getLostMoney());
        client.setCurrentMoney(newEntity.getCurrentMoney());
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
        allClients =(ArrayList<Client>) em.createQuery("Select client from Client client").getResultList();
    }

    public Client findById(Integer id) throws Exception {
        boolean found = false;
        Client c = new Client(0, "", "", 0, 0);
        Iterator var4 = this.allClients.iterator();

        while(var4.hasNext()) {
            Client client = (Client)var4.next();
            if (Objects.equals(client.getIdClient(), id)) {
                found = true;
                c = client;
                break;
            }
        }

        try {
            return found ? c : null;
        } catch (RuntimeException var6) {
            throw new Exception("No ID found");
        }
    }

    public int size() {
        int k = 0;

        for(Iterator var2 = this.allClients.iterator(); var2.hasNext(); ++k) {
            User user = (User)var2.next();
        }

        return k;
    }

    public void printAllClients() {
        Iterator var1 = this.allClients.iterator();
        while(var1.hasNext()) {
            Client client = (Client)var1.next();
            System.out.println(client.getIdClient() + " " + client.getName() + " " + client.getPassword() + " " + client.getAge() + " " + client.getLostMoney() + " " + client.getWonMoney() + " " + client.getCurrentMoney() + " " + client.getLostGames() + " " + client.getWonGames());
        }

    }
}
