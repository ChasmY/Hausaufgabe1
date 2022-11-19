package Controller;

import Repository.InMemory.DealerRepositoryMemory;
import model.Dealer;

import java.util.*;

public class DealerController extends DealerRepositoryMemory {
    private ArrayList<Dealer> allDealers;
    private DealerRepositoryMemory sortedAllDealers;
    public DealerController(ArrayList<Dealer> allDealers) {
        this.allDealers = allDealers;
        populateDealers();
    }

    public ArrayList<Dealer> getList(){
        return allDealers;
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
        List<Dealer> sortedAllDealers =allDealers;
        sortedAllDealers.sort(Comparator.comparing(Dealer::getName));
        printAllDealers();
    }

    public void sortByNameDsc(){
        List<Dealer> sortedAllDealers =allDealers;
        sortedAllDealers.sort(Comparator.comparing(Dealer::getName).reversed());
        printAllDealers();
    }

    public void sortByAgeDsc(){
        List<Dealer> sortedAllDealers = allDealers;
        sortedAllDealers.sort(Comparator.comparing(Dealer::getAge).reversed());
        printAllDealers();
    }
    public void sortByAgeAsc(){
        List<Dealer> sortedAllDealers = allDealers;
        sortedAllDealers.sort(Comparator.comparing(Dealer::getAge));
        printAllDealers();
    }

    public void printAllDealers()
    {
        for (Dealer dealer :sortedAllDealers.getList())
            System.out.println(dealer.getName() + " " + dealer.getPassword() + " " + dealer.getAge() + " " + dealer.getGamesKnown());

    }
    @Override
    public int size(){
        return super.size();
    }
}
