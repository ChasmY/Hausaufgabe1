package Repository.InMemory;

import Repository.CrudRepo;
import model.Dealer;
import model.Manager;

import java.util.ArrayList;
import java.util.Objects;

import static java.sql.Types.NULL;

public class ManagerRepositoryMemory implements CrudRepo<Integer, Manager> {
    private final ArrayList<Manager> allManagers = new ArrayList<Manager>();

    public ArrayList<Manager> getAllManagers(){
        return allManagers;
    }

    public ManagerRepositoryMemory(){
        populate();
    }

    public void populate(){
        Manager manager = new Manager(1,"Rares", 20, "rares123", "casino1");
        Manager manager1 = new Manager(2,"Claudiu", 20, "claudiu123", "casino2");
        allManagers.add(manager);
        allManagers.add(manager1);
    }

    @Override
    public void add(Manager entity) throws Exception {
        try{
            if (entity.getAge() > 18)
                this.allManagers.add(entity);
        }
        catch(RuntimeException e){
            throw new Exception("You are too young!");
        }

    }

    @Override
    public void delete(Manager entity) {
        this.allManagers.remove(entity);
    }

    @Override
    public void update(Integer id, Manager newEntity) {
        for(Manager manager: allManagers)
            if(Objects.equals(manager.getIdManager(), id))
                manager = newEntity;
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
