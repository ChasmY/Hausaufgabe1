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
    public static void main(String[] args) throws Exception {
        Dealer dealer;
        DealerController dealerList;
        Client client;
        ClientController clientList;
        User user;
        UserController userList;

        ViewLayer viewLayer = new ViewLayer();
        viewLayer.start();
    }
}