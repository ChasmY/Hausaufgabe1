import Controller.ClientController;
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
        Dealer dealer;
        DealerController dealerList;
        Client client;
        ClientController clientList;
        User user;
        UserController userList;

        ViewLayer viewLayer = new ViewLayer();
//        Dealer dealer1 = new Dealer("Rares", "48912", 20);
//        dealers.add(dealer1);
//        dealers.update("Mircea", dealer1);
//        dealers.printing();
//
//        List<User> clientList = new ArrayList<User>();
//        UserController clients = new UserController(clientList);
//        User user1 = new User("Paraschiv", "415632", 33);
//        clients.add(user1);
//        clients.printing();
        viewLayer.start();
    }
}