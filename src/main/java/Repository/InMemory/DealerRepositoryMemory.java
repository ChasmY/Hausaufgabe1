package Repository.InMemory;
import Repository.CrudRepo;
import model.Client;
import model.Dealer;
import model.Manager;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.sql.Types.NULL;


public class DealerRepositoryMemory implements CrudRepo<Integer, Dealer> {

    private ArrayList<Dealer> allDealers = new ArrayList<>();

    EntityManager manager;
    EntityManagerFactory factory;

    public DealerRepositoryMemory() {
        fetch();
        populate();
    }

    private void fetch(){
        factory = Persistence.createEntityManagerFactory("default");
        manager = factory.createEntityManager();
        allDealers = (ArrayList<Dealer>) manager.createQuery("SELECT dealer FROM Dealer dealer").getResultList();

    }

    public void populate() {
        Dealer dealer = new Dealer(1,"Robi", "3321", 67);
        Dealer dealer1 = new Dealer(2,"Vasile", "4564", 35);
        Dealer dealer2 = new Dealer(3,"George", "4514", 45);
        Dealer dealer3 = new Dealer(4,"Rares", "48912", 20);
        Dealer dealer4 = new Dealer(5,"Andrei", "1836", 29);
        Dealer dealer5 = new Dealer(6,"Andreea","154", 37);
        Dealer dealer6 = new Dealer(7,"Fabian", "1231", 24);
        Dealer dealer7 = new Dealer(8,"Luciana", "17752", 59);
        Dealer dealer8 = new Dealer(9,"Adrian", "1121", 43);
        Dealer dealer9 = new Dealer(10, "Ovi", "5290", 89);
        addList(dealer);
        addList(dealer1);
        addList(dealer2);
        addList(dealer3);
        addList(dealer4);
        addList(dealer5);
        addList(dealer6);
        addList(dealer7);
        addList(dealer8);
        addList(dealer9);
    }

    public ArrayList<Dealer> getAllDealers() {
        return allDealers;
    }

    public void addList(Dealer entity) {
            String jpql = "FROM User WHERE name = :username AND password = :password";
            TypedQuery<User> query = manager.createQuery(jpql, User.class);
            query.setParameter("username", entity.getName());
            query.setParameter("password", entity.getPassword());
            List<User> results = query.getResultList();
            if (results.isEmpty()) {
                manager.getTransaction().begin();
                manager.persist(entity);
                manager.getTransaction().commit();
                allDealers = (ArrayList<Dealer>) manager.createQuery("SELECT dealer FROM Dealer dealer").getResultList();

            }
            else{
                System.out.println("Dealer already exists");
            }
    }

    @Override
    public void delete(Dealer entity) {
        TypedQuery<Dealer> query = manager.createQuery("SELECT d FROM Dealer d WHERE d.idDealer = :idDealer", Dealer.class);
        query.setParameter("idDealer", entity.getIdDealer());
        Dealer dealer = query.getSingleResult();

        if(dealer != null) {
            this.allDealers.remove(dealer);
            manager.getTransaction().begin();
            manager.remove(dealer);
            manager.getTransaction().commit();
        }
    }

    @Override
    public void update(Integer id, Dealer newEntity) {
        TypedQuery<Dealer> query = manager.createQuery("SELECT d FROM Dealer d WHERE d.idDealer = :idDealer", Dealer.class);
        query.setParameter("idDealer", id);
        Dealer dealer = query.getSingleResult();

        dealer.setName(newEntity.getName());
        manager.getTransaction().begin();
        manager.merge(manager);
        manager.getTransaction().commit();
        allDealers =(ArrayList<Dealer>) manager.createQuery("Select dealer from Dealer dealer").getResultList();
    }

    @Override
    public Dealer findById(Integer id) throws Exception {
        boolean found = false;
        Dealer d = new Dealer(NULL, "", "", NULL);
        for(Dealer dealer: allDealers)
            if(Objects.equals(dealer.getIdDealer(), id)) {
                found = true;
                d = dealer;
                break;
            }
        try{
            if(found)
                return d;
        }
        catch(RuntimeException e){
            throw new Exception("No ID found");
        }
        return null;
    }


    public void printAllDealers(){
        for (Dealer dealer : allDealers)
            System.out.println(dealer.getIdDealer()+ " "+ dealer.getName() + " " + dealer.getPassword() + " " + dealer.getAge() + " " + dealer.getGamesKnown());
    }

    public int size(){
        int k = 0;
        for(Dealer dealer: allDealers)
            k += 1;
        return k;
    }


}
