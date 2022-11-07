import Controller.DealerController;
import Controller.UserController;
import Repository.InMemory.DealerRepositoryMemory;
import Repository.InMemory.UserRepositoryMemory;
import model.*;
import Repository.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dealer> dealerList = new ArrayList<Dealer>();
        DealerController dealers = new DealerController(dealerList);
        Dealer dealer1 = new Dealer("Rares", "48912", 20);
        dealers.add(dealer1);
        dealers.update("Mircea", dealer1);
        dealers.printing();

        List<User> clientList = new ArrayList<User>();
        UserController clients = new UserController(clientList);
        User user1 = new User("Paraschiv", "415632", 33);
        clients.add(user1);
        clients.printing();
    }
}