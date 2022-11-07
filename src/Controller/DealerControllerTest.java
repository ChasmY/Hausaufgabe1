package Controller;

import model.Dealer;
import sun.awt.util.IdentityArrayList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealerControllerTest {
    private List<Dealer> dealerList = new ArrayList<Dealer>();
    DealerController dealers = new DealerController(dealerList);


    @org.junit.jupiter.api.Test
    void add() {
        populate();
        assert(dealers.size() == 3);
    }

    private void populate() {
        Dealer dealer1 = new Dealer("Vasile", "4564", 35);
        Dealer dealer2 = new Dealer("George", "4514", 45);
        Dealer dealer3 = new Dealer("Rares", "48912", 20);
        dealers.add(dealer1);
        dealers.add(dealer2);
        dealers.add(dealer3);
    }

    @org.junit.jupiter.api.Test
    void delete() {
        Dealer dealer1 = new Dealer("Vasile", "4564", 35);
        Dealer dealer2 = new Dealer("George", "4514", 45);
        Dealer dealer3 = new Dealer("Rares", "48912", 20);
        dealers.add(dealer1);
        dealers.add(dealer2);
        dealers.add(dealer3);
        dealers.delete(dealer1);
        assert(dealers.size() == 2);
    }


    @org.junit.jupiter.api.Test
    void findById() {
        populate();
        dealers.findById("George");
    }
}