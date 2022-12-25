package Repository.InMemory;
import Repository.CrudRepo;
import Repository.Games.AvailableGames;
import model.Dealer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.sql.Types.NULL;

public class DealerRepositoryMemory implements CrudRepo<Integer, Dealer> {
    private final ArrayList<Dealer> allDealers = new ArrayList<>();

    public DealerRepositoryMemory() {
        populate();
    }

    public void populate() {
        Dealer dealer = new Dealer(1,"Robi", "3321", 67);
        Dealer dealer1 = new Dealer(2,"Vasile", "4564", 35);
        Dealer dealer2 = new Dealer(3,"George", "4514", 45);
        Dealer dealer3 = new Dealer(4,"Rares", "48912", 20);
        Dealer dealer4 = new Dealer(5,"Andrei", "1836", 29);
        Dealer dealer5 = new Dealer(6,"Andreea","154", 37);
        Dealer dealer6 = new Dealer(7,"Fabian", "1231", 24);
        Dealer dealer7 = new Dealer(8,"Luciana", "17752", 59);
        Dealer dealer8 = new Dealer(9,"Adrian", "1121", 43);
        Dealer dealer9 = new Dealer(10, "Ovi", "5290", 89);
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

    public ArrayList<Dealer> getAllDealers() {
        return allDealers;
    }

    @Override
    public void add(Dealer entity) throws Exception {
        try {
            if (entity.getAge() > 18)
                this.allDealers.add(entity);
        }
        catch (RuntimeException e){
            throw new Exception("You are too young!");
        }
    }

    @Override
    public void delete(Dealer entity) {
        this.allDealers.remove(entity);
    }

    @Override
    public void update(Integer id, Dealer newEntity) {
        for (Dealer dealer : allDealers)
            if (Objects.equals(dealer.getIdDealer(), id))
                dealer = newEntity;
    }

    @Override
    public Dealer findById(Integer id) throws Exception {
        boolean found = false;
        Dealer d = new Dealer(NULL, "", "", NULL);
        for(Dealer dealer: allDealers)
            if(Objects.equals(dealer.getIdDealer(), id)) {
                found = true;
                d = dealer;
                break;
            }
        try{
            if(found)
                return d;
        }
        catch(RuntimeException e){
            throw new Exception("No ID found");
        }
        return null;
    }


    public void printAllDealers(){
        for (Dealer dealer : allDealers)
            System.out.println(dealer.getIdDealer()+ " "+ dealer.getName() + " " + dealer.getPassword() + " " + dealer.getAge() + " " + dealer.getGamesKnown());
    }

    public int size(){
        int k = 0;
        for(Dealer dealer: allDealers)
            k += 1;
        return k;
    }
}
