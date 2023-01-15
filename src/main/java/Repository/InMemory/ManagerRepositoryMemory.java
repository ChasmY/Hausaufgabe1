package Repository.InMemory;

import Repository.CrudRepo;
import model.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.sql.Types.NULL;

public class ManagerRepositoryMemory implements CrudRepo<Integer, Manager> {
    private ArrayList<Manager> allManagers = new ArrayList<Manager>();

    EntityManagerFactory factory;
    EntityManager em;
    public ArrayList<Manager> getAllManagers(){
        return allManagers;
    }

    public ManagerRepositoryMemory(){
        fetch();
        populate();
    }


    private void fetch(){
        //Cream conexiunea dintre baza de date si program
        factory= Persistence.createEntityManagerFactory("default");
        em = factory.createEntityManager();
        allManagers = (ArrayList<Manager>) em.createQuery("Select manager from Manager manager").getResultList();
    }
    public void populate(){
        Manager manager = new Manager(1,"Rares", 20, "rares123", "casino1");
        Manager manager1 = new Manager(2,"Claudiu", 20, "claudiu123", "casino2");
        addList(manager);
        addList(manager1);
    }

    public void addList(Manager entity){
        //cautam daca exista combinatia de user parola pentru a putea fi adaugata in cazul in care nu se gaseste
        String jpql = "FROM Manager WHERE newUsername = :username AND newPassword = :password";
        TypedQuery<Manager> query = em.createQuery(jpql, Manager.class);
        query.setParameter("username", entity.getNewUsername());
        query.setParameter("password", entity.getNewPassword());
        List<Manager> results = query.getResultList();
        if (results.isEmpty()) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            allManagers = (ArrayList<Manager>) em.createQuery("Select manager from Manager manager").getResultList();

        }
        else{
            System.out.println("Manager already exists");
        }
    }

    @Override
    public void delete(Manager entity) {
        //cautam clientul dupa id si il stergem in momentul in care il gasim

        TypedQuery<Manager> query = em.createQuery("SELECT m FROM Manager m WHERE m.idManager = :idManager", Manager.class);
        query.setParameter("idManager", entity.getIdManager());
        Manager manager = query.getSingleResult();
        if(manager != null){
            allManagers.remove(entity);
            em.getTransaction().begin();
            em.remove(manager);
            em.getTransaction().commit();
            getTable();
        }


    }

    @Override
    public void update(Integer id, Manager newEntity) {
        //Cautam dupa id si facem update la campurile necesare
        TypedQuery<Manager> query = em.createQuery("SELECT m FROM Manager m WHERE m.idManager = :idManager", Manager.class);
        query.setParameter("idManager", id);
        Manager manager = query.getSingleResult();

        manager.setMainUsername(manager.getNewUsername());
        manager.setMainPassword(manager.getNewPassword());
        manager.setNewUsername(newEntity.getNewUsername());
        manager.setNewPassword(newEntity.getNewPassword());

        em.getTransaction().begin();
        em.merge(manager);
        em.getTransaction().commit();
        allManagers = (ArrayList<Manager>) em.createQuery("Select manager from Manager manager").getResultList();

    }

    @Override
    public Manager findById(Integer id) throws Exception {
        boolean found = false;
        Manager m = new Manager(NULL,"", NULL, "", "");
        for(Manager manager: allManagers)
            if(Objects.equals(manager.getIdManager(), id)) {
                found = true;
                m = manager;
                break;
            }
        try{
            if(found)
                return m;
        }
        catch(RuntimeException e){
            throw new Exception("No ID found");
        }
        return null;
    }


    public List<Manager> getTable(){
        //actualizam lista dupa datele stocate in tabel
        em.getTransaction().begin();
        allManagers = (ArrayList<Manager>) em.createQuery("SELECT manager FROM Manager manager").getResultList();
        em.getTransaction().commit();
        return allManagers;
    }

    public void printAllManagers(){
        for(Manager manager : allManagers)
            System.out.println(manager.getIdManager() + " " + manager.getName() + " " + manager.getAge());
    }

    public int size(){
        int k = 0;
        for(Manager manager: allManagers)
            k += 1;
        return k;
    }
}
