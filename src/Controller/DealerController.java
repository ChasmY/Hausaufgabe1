package Controller;

import Repository.InMemory.DealerRepositoryMemory;
import com.sun.jmx.mbeanserver.Repository;
import model.Dealer;

import java.util.*;
import java.util.stream.Collectors;

public class DealerController extends DealerRepositoryMemory {
    DealerRepositoryMemory repo = new DealerRepositoryMemory();

    @Override
    public void add(Dealer entity) throws Exception {
        super.add(entity);
    }

    @Override
    public void delete(Dealer entity) {
        super.delete(entity);
    }

    @Override
    public void update(String s, Dealer newEntity) {
        super.update(s, newEntity);
    }

    @Override
    public Dealer findById(String s) throws Exception {
        return super.findById(s);
    }

    @Override
    public void printAllDealers()
    {
        super.printAllDealers();
    }


    public List<Dealer> sortByNameAsc(){ //aia buna
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getName));
        //repo.printAllDealers();
        return sortedDealers;
    }
    public List<Dealer> sortByNameDsc(){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getName).reversed());
        //repo.printAllDealers();
        return sortedDealers;
    }

    public List<Dealer> sortByAgeDsc(){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getAge).reversed());
        //repo.printAllDealers();
        return sortedDealers;
    }
    public List<Dealer> sortByAgeAsc(){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getAge));
        //repo.printAllDealers();
        return sortedDealers;
    }
    @Override
    public int size(){
        return super.size();
    }
}
