package Controller;

import Repository.InMemory.ManagerRepositoryMemory;
import model.Manager;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ManagerController extends ManagerRepositoryMemory{
    public ManagerRepositoryMemory repo = new ManagerRepositoryMemory();

    public void add(Manager entity)throws Exception{
        super.addList(entity);
    }


    @Override
    public void delete(Manager entity) {
        super.delete(entity);
    }

    @Override
    public void update(Integer id, Manager newEntity) {
        super.update(id, newEntity);
    }

    @Override
    public Manager findById(Integer id) throws Exception {
        return super.findById(id);
    }

    public List<Manager> sortByIdAsc(){
        List<Manager> sortedManagers = repo.getAllManagers();
        sortedManagers.sort(Comparator.comparing(Manager::getIdManager));
        return sortedManagers;
    }

    public List<Manager> sortByIdDsc(){
        List<Manager> sortedManagers = repo.getAllManagers();
        sortedManagers.sort(Comparator.comparing(Manager::getIdManager).reversed());
        return sortedManagers;
    }

    public List<Manager> sortByNameAsc(){
        List<Manager> sortedManagers = repo.getAllManagers();
        sortedManagers.sort(Comparator.comparing(Manager::getName));
        return sortedManagers;
    }

    public List<Manager> sortByNameDsc(){
        List<Manager> sortedManagers = repo.getAllManagers();
        sortedManagers.sort(Comparator.comparing(Manager::getName).reversed());
        return sortedManagers;
    }
    //filter dupa age

    public List<Manager> filterAge(int age){
        Predicate<Manager> byAge = manager -> manager.getAge() > age;
        return repo.getAllManagers().stream().filter(byAge).collect(Collectors.toList());
    }

    public void printAllManagers(){
        super.printAllManagers();
    }

    @Override
    public int size(){
        return super.size();
    }
}
