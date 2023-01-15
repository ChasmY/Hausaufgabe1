package Repository.InMemory;
import Repository.CrudRepo;
import Repository.Games.AvailableGames;
import model.Dealer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.sql.Types.NULL;

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
    public void update(String s, Dealer newEntity) {
        for (Dealer dealer : allDealers)
            if (Objects.equals(dealer.getName(), s))
                dealer = newEntity;
    }

    @Override
    public Dealer findById(String s) throws Exception {
        boolean found = false;
        Dealer d = new Dealer("", "", NULL);
        for(Dealer dealer: allDealers)
            if(Objects.equals(dealer.getName(), s)) {
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
            System.out.println(dealer.getName() + " " + dealer.getPassword() + " " + dealer.getAge() + " " + dealer.getGamesKnown());
    }

    public int size(){
        int k=0;
        for(Dealer dealer: allDealers)
            k+=1;
        return k;
    }
}
