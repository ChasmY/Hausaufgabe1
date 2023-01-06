package Controller;

import Repository.InMemory.DealerRepositoryMemory;
import model.Dealer;
import java.util.*;

public class DealerController extends DealerRepositoryMemory {
    public DealerRepositoryMemory repo = new DealerRepositoryMemory();

    public void add(Dealer entity) throws Exception{
        super.addList(entity);
    }

    @Override
    public void delete(Dealer entity) {
        super.delete(entity);
    }

    @Override
    public void update(Integer id, Dealer newEntity) {
        super.update(id, newEntity);
    }

    @Override
    public Dealer findById(Integer id) throws Exception {
        return super.findById(id);
    }

    public List<Dealer> sortByIdAsc(){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getIdDealer));
        //repo.printAllDealers();
        return sortedDealers;
    }

    public List<Dealer> sortByIdDsc(){
        List<Dealer> sortedDealers = repo.getAllDealers();
        sortedDealers.sort(Comparator.comparing(Dealer::getIdDealer).reversed());
        //repo.printAllDealers();
        return sortedDealers;
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

    public void printAllDealers()
    {
        super.printAllDealers();
    }
    @Override
    public int size(){
        return super.size();
    }
}
