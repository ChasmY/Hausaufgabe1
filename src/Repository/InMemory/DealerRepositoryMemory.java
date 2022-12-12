package Repository.InMemory;
import Repository.CrudRepo;
import Repository.Games.AvailableGames;
import model.Dealer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DealerRepositoryMemory implements CrudRepo<String, Dealer> {
    private final ArrayList<Dealer> allDealers = new ArrayList<Dealer>();

    public DealerRepositoryMemory() {
        populate();
    }

    public ArrayList<Dealer> getList(){
        return (ArrayList<Dealer>) this.allDealers;
    }
    private void populate() {
        Dealer dealer = new Dealer("Robi", "3321", 67);
        Dealer dealer1 = new Dealer("Vasile", "4564", 35);
        Dealer dealer2 = new Dealer("George", "4514", 45);
        Dealer dealer3 = new Dealer("Rares", "48912", 20);
        Dealer dealer4 = new Dealer("Andrei", "1836", 29);
        Dealer dealer5 = new Dealer("Andreea","154", 37);
        Dealer dealer6 = new Dealer("Fabian", "1231", 24);
        Dealer dealer7 = new Dealer("Luciana", "17752", 59);
        Dealer dealer8 = new Dealer("Adrian", "1121", 43);
        Dealer dealer9 = new Dealer("Ovi", "5290", 89);
        allDealers.add(dealer);
        allDealers.add(dealer1);
        allDealers.add(dealer2);
        allDealers.add(dealer3);
        allDealers.add(dealer4);
        allDealers.add(dealer5);
        allDealers.add(dealer6);
        allDealers.add(dealer7);
        allDealers.add(dealer8);
        allDealers.add(dealer9);
    }

    public void printing(){
        for(Dealer d :allDealers){
            System.out.println(d.getName() + " " + d.getGamesKnown());

        }
    }

    public ArrayList<Dealer> getAllDealers() {
        return allDealers;
    }

    @Override
    public void add(Dealer entity) {
        this.allDealers.add(entity);
    }

    @Override
    public void delete(Dealer entity) {
        this.allDealers.remove(entity);
    }

    @Override
    public void update(String s, Dealer newEntity) {
        for (Dealer dealer : allDealers)
            if (Objects.equals(dealer.getName(), s))
                dealer = newEntity;
    }

    @Override
    public Dealer findById(String s) {
        for(Dealer dealer: allDealers)
            if(Objects.equals(dealer.getName(), s))
                return dealer;
        return null;
    }

    public int size(){
        int k=0;
        for(Dealer dealer: allDealers)
            k+=1;
        return k;
    }
}
