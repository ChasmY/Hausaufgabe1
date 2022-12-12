package Controller;

import Repository.InMemory.DealerRepositoryMemory;
import model.Dealer;
import org.junit.jupiter.api.Test;
import sun.awt.util.IdentityArrayList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DealerControllerTest {
    DealerController dealers = new DealerController();

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
        dealers.add(dealer);
        dealers.add(dealer1);
        dealers.add(dealer2);
        dealers.add(dealer3);
        dealers.add(dealer4);
        dealers.add(dealer5);
        dealers.add(dealer6);
        dealers.add(dealer7);
        dealers.add(dealer8);
        dealers.add(dealer9);
    }

    @org.junit.jupiter.api.Test
    void add() {
        populate();
        assert(dealers.size() == 10);
    }

    @org.junit.jupiter.api.Test
    void delete() {
        populate();
        dealers.delete(dealers.findById("George"));
        assert(dealers.size() == 9);
    }

    @org.junit.jupiter.api.Test
    void findById() {
        populate();
        assert(dealers.findById("George") == dealers.getList().get(2));
    }

    @Test
    void sortByNameDscD() {
        populate();
        assert(dealers.size() == 10);
//        dealers.SortByNameAsc(dealers);
//        assert(true);
//        Dealer firstDealer = dealers.getList().get(0);
//        for( Dealer dealer : dealers.getList()){
//            System.out.println(dealer.getName());
//            //assert(dealer.getName().compareTo(firstDealer.getName()) < 0);
//            firstDealer = dealer;
//        }

    }

    @Test
    void sortByNameDsc() {
    }

    @Test
    void sortByAgeDsc() {
    }

    @Test
    void sortByAgeAsc() {
    }
}