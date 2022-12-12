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
        ViewLayer viewLayer = new ViewLayer();
        viewLayer.signIn();
//        viewLayer.signIn();
        return;
    }
}