import Repository.InMemory.DealerRepositoryMemory;
import Repository.InMemory.UserRepositoryMemory;
import model.*;
import Repository.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dealer> dealerList = new ArrayList<Dealer>();
        DealerRepositoryMemory dealers = new DealerRepositoryMemory(dealerList);
        dealers.printing();

        List<User> clientList = new ArrayList<User>();
        UserRepositoryMemory clients = new UserRepositoryMemory(clientList);
        clients.printing();
    }
}