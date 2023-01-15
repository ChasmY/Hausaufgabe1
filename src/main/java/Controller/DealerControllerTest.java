package Controller;

import model.Dealer;
import org.junit.jupiter.api.Test;
import java.util.List;

import static java.sql.Types.NULL;

class DealerControllerTest {
    DealerController dealers = new DealerController();

    @Test
    void add() throws Exception {
        Dealer dealer = new Dealer(11,"Trevor", "5432", 34);
        Dealer dealer1 = new Dealer(12,"Gheorghe", "3244", 57);
        dealers.add(dealer);
        assert(dealers.size() == 11);
        dealers.add(dealer1);
        assert(dealers.size() == 12);

    }

    @Test
    void delete() throws Exception {
        dealers.delete(dealers.findById(1));
        assert(dealers.size() == 9);
        dealers.delete(dealers.findById(2));
        assert(dealers.size() == 8);
        dealers.delete(dealers.findById(3));
        assert(dealers.size() == 7);
        dealers.delete(dealers.findById(4));
        assert(dealers.size() == 6);
        dealers.delete(dealers.findById(5));
        assert(dealers.size() == 5);
        dealers.delete(dealers.findById(6));
        assert(dealers.size() == 4);
        dealers.delete(dealers.findById(7));
        assert(dealers.size() == 3);
        dealers.delete(dealers.findById(8));
        assert(dealers.size() == 2);
        dealers.delete(dealers.findById(9));
        assert(dealers.size() == 1);
        dealers.delete(dealers.findById(10));
        assert(dealers.size() == 0);



    }

    @Test
    void findById() throws Exception {
        assert(dealers.findById(3) == dealers.getAllDealers().get(2));
        assert(dealers.findById(9) == dealers.getAllDealers().get(8));
        assert(dealers.findById(6) == dealers.getAllDealers().get(5));
        try{
            Dealer d = new Dealer(NULL, "", "", NULL);
            d = dealers.findById(15);
        }
        catch (RuntimeException e){
            assert true;
        }
    }

    @Test
    void sortByNameAsc() {
        List<Dealer> sortedDealers = dealers.sortByNameAsc();
        Dealer firstDealer = sortedDealers.get(0);
        for( Dealer dealer : sortedDealers){
            assert(dealer.getName().compareTo(firstDealer.getName()) >= 0);
            firstDealer = dealer;
        }

    }

    @Test
    void sortByNameDsc() {
        List<Dealer> sortedDealers = dealers.sortByNameDsc();
        Dealer firstDealer = sortedDealers.get(0);
        for( Dealer dealer : sortedDealers){
            assert(dealer.getName().compareTo(firstDealer.getName()) <= 0);
            firstDealer = dealer;
        }
    }

    @Test
    void sortByAgeDsc() {
        List<Dealer> sortedDealers = dealers.sortByAgeDsc();
        Dealer firstDealer = sortedDealers.get(0);
        for( Dealer dealer : sortedDealers){
            assert(dealer.getAge() <= firstDealer.getAge());
            firstDealer = dealer;
        }
    }

    @Test
    void sortByAgeAsc() {
        List<Dealer> sortedDealers = dealers.sortByAgeAsc();
        Dealer firstDealer = sortedDealers.get(0);
        for( Dealer dealer : sortedDealers){
            assert(dealer.getAge() >= firstDealer.getAge());
            firstDealer = dealer;
        }
    }
}