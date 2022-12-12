package Controller;

import Repository.InMemory.DealerRepositoryMemory;
import com.sun.jmx.mbeanserver.Repository;
import model.Dealer;

import java.util.*;
import java.util.stream.Collectors;

public class DealerController extends DealerRepositoryMemory {
    private DealerRepositoryMemory allDealers;
    DealerRepositoryMemory repo = new DealerRepositoryMemory();

//    public DealerRepositoryMemory getAllDealers() {
//        return allDealers;
//    }

    public void setAllDealers(DealerRepositoryMemory allDealers) {
        this.allDealers = allDealers;
    }

    @Override
    public void add(Dealer entity) {
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
    public Dealer findById(String s) {
        return super.findById(s);
    }

    public List<Dealer> sortByNameAsc(){ //aia buna
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getName));
        printAllDealers();
        return sortedDealers;
    }

    public List<Dealer> SortByNameAsc(List<Dealer> dealers){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getName));
        printAllDealers();
        return sortedDealers;
    }
    public List<Dealer> sortByNameDsc(){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getName).reversed());
        printAllDealers();
        return sortedDealers;
    }

    public List<Dealer> sortByAgeDsc(){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getAge).reversed());
        printAllDealers();
        return sortedDealers;
    }
    public List<Dealer> sortByAgeAsc(){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getAge));
        printAllDealers();
        return sortedDealers;
    }

    public void printAllDealers()
    {
        for (Dealer dealer : repo.getAllDealers())
            System.out.println(dealer.getName() + " " + dealer.getPassword() + " " + dealer.getAge() + " " + dealer.getGamesKnown());

    }
    @Override
    public int size(){
        return super.size();
    }
}
