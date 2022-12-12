package Controller;

import Repository.InMemory.DealerRepositoryMemory;
import model.Dealer;
import java.util.Collections;

import java.util.*;

public class DealerController extends DealerRepositoryMemory {
    private DealerRepositoryMemory allDealers;

    public DealerRepositoryMemory getAllDealers() {
        return allDealers;
    }

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

    public void sortByNameAsc(){
//        Comparator<Dealer> compareByName = new Comparator<Dealer>() {
//            @Override
//            public int compare(Dealer o1, Dealer o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };
//        allDealers.getList().sort(compareByName);
    }

    public void sortByNameDsc(){
        List<Dealer> sortedDealers = allDealers.getList();
        sortedDealers.sort(Comparator.comparing(Dealer::getName).reversed());
        printAllDealers();
    }

    public void sortByAgeDsc(){
        allDealers.getList().sort(Comparator.comparing(Dealer::getAge).reversed());
        printAllDealers();
    }
    public void sortByAgeAsc(){
        allDealers.getList().sort(Comparator.comparing(Dealer::getAge));
        printAllDealers();
    }

    public void printAllDealers()
    {
        for (Dealer dealer : allDealers.getList())
            System.out.println(dealer.getName() + " " + dealer.getPassword() + " " + dealer.getAge() + " " + dealer.getGamesKnown());

    }
    @Override
    public int size(){
        return super.size();
    }
}
