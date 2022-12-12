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



    @org.junit.jupiter.api.Test
    void add() {
        assert(dealers.size() == 10);
    }

    @org.junit.jupiter.api.Test
    void delete() {
        dealers.delete(dealers.findById("George"));
        assert(dealers.size() == 9);
    }

    @org.junit.jupiter.api.Test
    void findById() {
        assert(dealers.findById("George") == dealers.getList().get(2));
    }

    @Test
    void sortByNameDscD() {
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