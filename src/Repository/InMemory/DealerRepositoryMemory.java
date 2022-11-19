package Repository.InMemory;
import Repository.CrudRepo;
import Repository.Games.AvailableGames;
import model.Dealer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DealerRepositoryMemory implements CrudRepo<String, Dealer> {
    private final List<Dealer> allDealers = new ArrayList<>();

    public ArrayList<Dealer> getList(){
        return (ArrayList<Dealer>) this.allDealers;
    }
    public void populateDealers(){
        Dealer dealer1 = new Dealer("Vasile", "4564", 35);
        Dealer dealer2 = new Dealer("George", "4514", 45);
        dealer1.addGame(AvailableGames.Roulette);
        dealer2.addGame(AvailableGames.Roulette);
        dealer2.addGame(AvailableGames.Poker);
        this.allDealers.add(dealer1);
        this.allDealers.add(dealer2);
    }

    public void printing(){
        for(Dealer d :allDealers){
            System.out.println(d.getName() + d.getGamesKnown());

        }
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
