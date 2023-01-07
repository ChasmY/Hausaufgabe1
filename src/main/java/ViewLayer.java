import Controller.ClientController;
import Controller.DealerController;
import Controller.ManagerController;
import Repository.Games.AvailableGames;
import Repository.Games.Poker.Poker;
import Repository.Games.Roulette;
import model.Client;
import model.Dealer;
import model.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class ViewLayer {
    Manager manager = new Manager(NULL, "", NULL, "", "");
    ManagerController managerList = new ManagerController();
    Dealer dealer = new Dealer(NULL, "", "", NULL);
    DealerController dealerList = new DealerController();
    Client client = new Client(NULL, "", "", NULL, NULL);
    ClientController clientList=new ClientController();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();


    public void start() throws Exception {
        System.out.println("--- MAP CASINO ---");
        System.out.println("Hello! Welcome to the best casino on the internet!");
        System.out.println("Who are you? Are you the manager or a normal user? Or anything else to close the program (m/u)");
        Scanner role = new Scanner(System.in);
        String r = role.next();
        if(Objects.equals(r,"m")){
            managerPortal();
        }
        else if(Objects.equals(r, "u")){
            System.out.println("Now you will be sent to the User Sign In Portal...\n");
            signInUser();
        }
        else
            System.exit(0);
    }

    public void signInManager() throws Exception {
        System.out.println("Welcome! Now you can create a new account");
        Scanner console = new Scanner(System.in);

        manager.setIdManager(managerList.getAllManagers().get(managerList.size()-1).getIdManager() + 1);

        System.out.println("Name:");
        manager.setName(console.nextLine());

        System.out.println("Age:");
        manager.setAge(console.nextInt());

        System.out.println("Username:");
        manager.setNewUsername(console.nextLine());

        System.out.println("Password:");
        manager.setNewPassword(console.nextLine());

        managerList.add(manager);

        System.out.println("Thanks for creating an account! You will be redirected to Menu Manager");
        managerPortal();
    }

    public boolean loginManager(){
        Manager managerLogging = new Manager(NULL, "", NULL, "", "");

        Scanner console = new Scanner(System.in);
        System.out.println("--- LOG IN ---");
        System.out.println("Username:");
        managerLogging.setNewUsername(console.nextLine());

        System.out.println("Password:");
        managerLogging.setNewPassword(console.nextLine());

        for(Manager manager1 : managerList.getAllManagers()){
            if(Objects.equals(manager1.getNewUsername(), managerLogging.getNewUsername())
                    && Objects.equals(manager1.getNewPassword(), managerLogging.getNewPassword())){
                manager.setName(manager1.getName());
                manager.setNewPassword(manager1.getNewPassword());
                manager.setNewUsername(manager1.getNewUsername());
                manager.setAge(manager1.getAge());
                manager.setIdManager(manager1.getIdManager());
                return true;
            }
        }
        return false;
    }

    public void loggedInManager() throws Exception {
        System.out.println("--- OPTIONS FOR A MANAGER ---");
        System.out.println("1 - Show all managers sorted by ID");
        System.out.println("2 - Show all managers sorted by Name");
        System.out.println("3 - Show all managers older than a given age (filtered)");
        System.out.println("4 - Show all clients sorted by ID");
        System.out.println("5 - Show all clients sorted by name");
        System.out.println("6 - Show all clients sorted by age");
        System.out.println("7 - Show all clients sorted by won money");
        System.out.println("8 - Show all clients sorted by lost money");
        System.out.println("9 - Show all dealers sorted by ID");
        System.out.println("10 - Show all dealers sorted by name");
        System.out.println("11 - Show all dealers sorted by age");
        System.out.println("12 - Remove client");
        System.out.println("13 - Remove dealer");
        System.out.println("14 - Remove manager");
        System.out.println("0 - Go back");
        Scanner console = new Scanner(System.in);
        while (console.hasNextInt()){
            int var = console.nextInt();
            if(var==0)
                managerPortal();
            if (var == 1){
                System.out.println("1 - Show managers sorted by ID ascending");
                System.out.println("2 - Show managers sorted by ID descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();

                    if (c == 1){
                        List<Manager> sortedManagers = managerList.sortByIdAsc();
                        printManagers(sortedManagers);
                        loggedInManager();
                    }
                    if(c == 2){
                        List<Manager> sortedManagers = managerList.sortByIdDsc();
                        printManagers(sortedManagers);
                        loggedInManager();
                    }
                    if(c == 0){
                        loggedInManager();
                    }
                }
            }
            if (var == 2){
                System.out.println("1 - Show managers sorted by name ascending");
                System.out.println("2 - Show managers sorted by name descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while (choice.hasNextInt()){
                    int c = choice.nextInt();
                    if (c == 1){
                        List<Manager> sortedManagers = managerList.sortByNameAsc();
                        printManagers(sortedManagers);
                        loggedInManager();
                    }
                    if(c == 2){
                        List<Manager> sortedManagers = managerList.sortByNameDsc();
                        printManagers(sortedManagers);
                        loggedInManager();
                    }
                    if(c == 0){
                        loggedInManager();
                    }
                }
            }
            if (var == 3){
                System.out.println("Choose a(n) age:");
                Scanner age = new Scanner(System.in);
                List<Manager> filteredManagers = managerList.filterAge(age.nextInt());
                printManagers(filteredManagers);
                loggedInManager();
            }
            if (var == 4){
                System.out.println("1 - Show clients sorted by ID ascending");
                System.out.println("2 - Show clients sorted by ID descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if (c == 1){
                        List<Client> sortedClients = clientList.sortByIdAsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByIdDsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 0){
                        System.out.println("Choose another option");
                        loggedInManager();
                    }
                }
            }
            if (var == 5){
                System.out.println("1 - Show clients sorted by name ascending");
                System.out.println("2 - Show clients sorted by name descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if (c == 1){
                        List<Client> sortedClients = clientList.sortByNameAsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByNameDsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 0){
                        System.out.println("Choose another option");
                        loggedInManager();
                    }
                }
            }
            if (var == 6){
                System.out.println("1 - Show clients sorted by age ascending");
                System.out.println("2 - Show clients sorted by age descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if(c == 1){
                        List<Client> sortedClients = clientList.sortByAgeAsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByAgeDsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if(c == 0){
                        System.out.println("hoose another option");
                        loggedInManager();
                    }
                }
            }
            if (var == 7){
                System.out.println("1 - Show clients sorted by won money ascending");
                System.out.println("2 - Show clients sorted by won money descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if(c == 1){
                        List<Client> sortedClients = clientList.sortByWonMoneyAsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByWonMoneyDsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 0){
                        System.out.println("Choose another option");
                        loggedInManager();
                    }
                }
            }
            if (var == 8){
                System.out.println("1 - Show clients sorted by lost money ascending");
                System.out.println("2 - Show clients sorted by lost money descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if(c == 1){
                        List<Client> sortedClients = clientList.sortByLostMoneyAsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByLostMoneyDsc();
                        printClients(sortedClients);
                        loggedInManager();
                    }
                    if (c == 0){
                        System.out.println("Choose another option");
                        loggedInManager();
                    }
                }
            }
            if (var == 9){
                System.out.println("1 - Show dealers sorted by ID ascending");
                System.out.println("2 - Show dealers sorted by ID descending");
                System.out.println("0 - Go back");
                Scanner secondChoice = new Scanner(System.in);
                while(secondChoice.hasNextInt()) {
                    int sc = secondChoice.nextInt();
                    if (sc == 1) {
                        List<Dealer> sortedDealers = dealerList.sortByIdAsc();
                        printDealers(sortedDealers);
                        loggedInManager();
                    }
                    if(sc == 2){
                        List<Dealer> sortedDealers= dealerList.sortByIdDsc();
                        printDealers(sortedDealers);
                        loggedInManager();
                    }
                    if (sc == 0){
                        System.out.println("Choose another option");
                        loggedInManager();
                    }
                }
            }
            if (var == 10) {
                System.out.println("1 - Show dealers sorted by name ascending");
                System.out.println("2 - Show dealers sorted by name descending");
                System.out.println("0 - Go back");
                Scanner secondChoice = new Scanner(System.in);
                while(secondChoice.hasNextInt()) {
                    int sc = secondChoice.nextInt();
                    if (sc == 1) {
                        List<Dealer> sortedDealers = dealerList.sortByNameAsc();
                        printDealers(sortedDealers);
                        loggedInManager();
                    }
                    if(sc == 2){
                        List<Dealer> sortedDealers= dealerList.sortByNameDsc();
                        printDealers(sortedDealers);
                        loggedInManager();
                    }
                    if (sc == 0){
                        System.out.println("Choose another option");
                        loggedInManager();
                    }
                }
            }
            if (var == 11) {
                System.out.println("1 - Show dealers sorted by age ascending");
                System.out.println("2 - Show dealers sorted by age descending");
                System.out.println("0 - Go back");
                Scanner thirdChoice = new Scanner(System.in);
                while(thirdChoice.hasNextInt()) {
                    int tc = thirdChoice.nextInt();
                    if (tc == 1) {
                        List<Dealer> sortedDealers= dealerList.sortByAgeAsc();
                        printDealers(sortedDealers);
                        loggedInManager();
                    }
                    if(tc == 2){
                        List<Dealer> sortedDealers= dealerList.sortByAgeDsc();
                        printDealers(sortedDealers);
                        loggedInManager();
                    }
                    if (tc == 0){
                        System.out.println("Choose another option");
                        loggedInManager();
                    }
                }
            }
            if(var == 12){
                System.out.println("Enter client ID");
                Scanner choice = new Scanner(System.in);
                while (choice.hasNextInt()) {
                    int id = choice.nextInt();
                    while(clientList.findById(id) == null){
                        System.out.println("Client ID not found");
                        System.out.println("Enter client ID ");
                        Scanner choice2 = new Scanner(System.in);
                        int id2 = choice2.nextInt();
                        if (clientList.findById(id2) != null){
                            clientList.delete(clientList.findById(id2));
                            System.out.println("Client deleted successfully");
                            List<Client> sortedById = clientList.sortByIdAsc();
                            printClients(sortedById);
                            loggedInManager();
                        }
                    }
                    clientList.delete(clientList.findById(id));
                    System.out.println("Client deleted successfully");
                    List<Client> sortedById = clientList.sortByIdAsc();
                    printClients(sortedById);
                    loggedInManager();
                }
            }
            if(var == 13){
                System.out.println("Enter dealer ID");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int id = choice.nextInt();
                    while(dealerList.findById(id) == null){
                        System.out.println("Dealer ID not found");
                        System.out.println("Enter dealer ID");
                        Scanner choice2 = new Scanner(System.in);
                        int id2 = choice2.nextInt();
                        if(dealerList.findById(id2) != null) {
                            dealerList.delete(dealerList.findById(id2));
                            System.out.println("Dealer deleted successfully");
                            List<Dealer> sortedById = dealerList.sortByIdAsc();
                            printDealers(sortedById);
                            loggedInManager();
                        }
                    }
                    dealerList.delete(dealerList.findById(id));
                    System.out.println("Dealer deleted successfully");
                    List<Dealer> sortedById = dealerList.sortByIdAsc();
                    printDealers(sortedById);
                    loggedInManager();
                }

            }
            if(var == 14){
                System.out.println("Enter manager ID");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()) {
                    int id = choice.nextInt();
                    while(manager.getIdManager() == id || managerList.findById(manager.getIdManager()) == null){
                        System.out.println("Manager ID not valid");
                        System.out.println("Try again");
                        System.out.println("Enter manager ID");
                        Scanner choice2 = new Scanner(System.in);
                        int id2 = choice2.nextInt();
                        if(managerList.findById(id2) != null){
                            managerList.delete(managerList.findById(id2));
                            System.out.println("Manager deleted successfully");
                            List<Manager> sortedById = managerList.sortByIdAsc();
                            printManagers(sortedById);
                            loggedInManager();
                        }
                    }
                    if(managerList.findById(id) != null) {
                        managerList.delete(managerList.findById(id));
                        System.out.println("Manager deleted successfully");
                        List<Manager> sortedById = managerList.sortByIdAsc();
                        printManagers(sortedById);
                        loggedInManager();
                    }
                }

            }
        }
    }

    public void managerPortal() throws Exception {
        System.out.println("--- MANAGER PORTAL ---");
        System.out.println("Welcome to the Manager portal! What do you want to do?");
        System.out.println("1 - Log in into my account");
        System.out.println("2 - Sign up into a new account");
        System.out.println("0 - Go back");
        Scanner choice = new Scanner(System.in);
        int c = choice.nextInt();
        if( c == 0 )
            start();
        if( c == 1 ){
            while(!loginManager()){
                System.out.println("Wrong username or password for manager! Try again!\n");
            }
            loggedInManager();
        }
        if( c == 2 ){
            Scanner console = new Scanner(System.in);
            System.out.println("If you want to create a new account, you need to know the main credentials.");
            System.out.println("Please enter the username:");
            while(console.hasNextLine()) {
                if (Objects.equals(console.nextLine(), manager.getMainUsername())) {
                    System.out.println("Please enter the password:");
                    if (Objects.equals(console.nextLine(), manager.getMainPassword())) {
                        signInManager();
                    }
                    else {
                        System.out.println("Wrong password. Try again.");
                    }
                }
                else{
                    System.out.println("Wrong username. Try again.\n");
                    System.out.println("Please enter the username:");
                }
            }
        }
    }

    public void signInUser() throws Exception {
        System.out.println("--- USER SIGN IN PORTAL ---");
        System.out.println("Welcome to User sign in portal!\nDo you want to create (new) account? Or anything else to go back (y/n)");
        Scanner signin = new Scanner(System.in);
        String s = signin.next();
        if(Objects.equals(s, "n")){
            System.out.println("Now you will be sent to Log in portal!\n");
            menuUser();
        }
        else if (Objects.equals(s, "y")){
            System.out.println("How are you signing in? As a dealer or a client? (d/c)");
            Scanner socialStatus = new Scanner(System.in);
            if (Objects.equals(socialStatus.next(), "d"))
                signinDealer();
            else
                signinClient();
            System.out.println("Thank you for creating an account! Now you can log in!");
            menuUser();
        }
        else
            start();
    }

    public void signinClient() throws Exception {
        System.out.println("--- SIGN IN CLIENT ---");
        Scanner console = new Scanner(System.in);

        client.setIdClient(clientList.getAllClients().get(clientList.size() - 1).getIdClient() + 1);

        System.out.println("Name ");
        client.setName(console.nextLine());

        System.out.println("Password ");
        client.setPassword(console.nextLine());

        System.out.println("Age ");
        client.setAge(console.nextInt());

        System.out.println("Money to deposit ");
        client.setCurrentMoney(console.nextInt());


        clientList.add(client);
    }

    public void signinDealer() throws Exception {
        System.out.println("--- SIGN IN DEALER ---");
        Scanner console = new Scanner(System.in);

        dealer.setIdDealer(dealerList.getAllDealers().get(dealerList.size()-1).getIdDealer() + 1);

        System.out.println("Name ");
        dealer.setName(console.nextLine());

        System.out.println("Password ");
        dealer.setPassword(console.nextLine());

        System.out.println("Age ");
        dealer.setAge(console.nextInt());

        dealerList.add(dealer);
    }

    public boolean loginClient(){
        System.out.println("--- LOG IN CLIENT ---");
        Client clientLogging = new Client(NULL,"","", NULL, NULL);

        Scanner console = new Scanner(System.in);
        System.out.println("Name ");
        clientLogging.setName(console.nextLine());

        System.out.println("Password ");
        clientLogging.setPassword(console.nextLine());


        for(Client c : clientList.getAllClients()){
            if(Objects.equals(c.getName(), clientLogging.getName()) && Objects.equals(c.getPassword(), clientLogging.getPassword())){
                client.setIdClient(c.getIdClient());
                client.setCurrentMoney(c.getCurrentMoney());
                client.setLostMoney(c.getLostMoney());
                client.setWonMoney(c.getWonMoney());
                client.setLostGames(c.getLostGames());
                client.setWonGames(c.getWonGames());
                client.setAge(c.getAge());
                return true;
            }
        }
        return false;
    }

    public boolean loginDealer(){
        System.out.println("--- LOG IN DEALER ---");
        Dealer dealerLogging = new Dealer(NULL, "", "", NULL);

        Scanner console = new Scanner(System.in);
        System.out.println("Name ");
        dealerLogging.setName(console.nextLine());

        System.out.println("Password ");
        dealerLogging.setPassword(console.nextLine());

        for(Dealer d : dealerList.getAllDealers()){
            if(Objects.equals(d.getName(), dealerLogging.getName()) && Objects.equals(d.getPassword(), dealerLogging.getPassword())) {
                dealer.setIdDealer(d.getIdDealer());
                dealer.setName(d.getName());
                dealer.setPassword(d.getPassword());
                dealer.setAge(d.getAge());
                for(AvailableGames game: d.getGamesKnown())
                    dealer.setGamesKnown(game);
                return true;
            }
        }

        return false;
    }

    public void menuUser() throws Exception {
        System.out.println("--- MENU USER ---");
        System.out.println("1 - Log in as a client");
        System.out.println("2 - Log in as a dealer");
        System.out.println("3 - Create another account");
        System.out.println("0 - Go back to the start");
        Scanner console = new Scanner(System.in);
        while(console.hasNextInt()) {
            int c = console.nextInt();
            if (c == 1) {
                while(!loginClient())
                    System.out.println("Wrong username or password for client!\nTry again!");
                clientLogged();
            } else if (c == 2) {
                while(!loginDealer())
                    System.out.println("Wrong username or password for dealer!\nTry again");
                dealerLogged();
            } else if (c == 0) {
                start();
            } else if (c == 3){
                signInUser();
            }

        }
    }

    public void playGames() throws Exception {
        System.out.println("PLAYING...\n");
        System.out.println("What game would you want to play?\n");
        System.out.println("You can choose from: Poker, Roulette and Blackjack");
        System.out.println("Poker - Play Poker");
        System.out.println("Roulette - Play Roulette");
        System.out.println("Blackjack - Play Blackjack");
        boolean found = false;
        Scanner gameMode = new Scanner(System.in);
        String game = gameMode.next();
        for (AvailableGames availableGames : AvailableGames.values())
            if (Objects.equals(game, availableGames.name())) {
                found = true;
                break;
            }
        if (!found)
            throw new Exception("Incorrect game name. Choose another one");
        else {
            Scanner console = new Scanner(System.in);
            System.out.println("--- BEFORE PLAYING ---");
            System.out.println("Before you start playing something, you need to choose...:");
            System.out.println("...a table: (pick a number from 1-10)");
            int tableNr = console.nextInt();
            System.out.println("...a dealer: (choose an ID from above)");
            printDealers(dealerList.sortByIdAsc());
            int dealerId = console.nextInt();
            System.out.println("...and how many players do you allow at your table?");
            int allowedPlayers = console.nextInt();
            if (Objects.equals(game, "Poker")) {
                System.out.println("NOW START PLAYING!\n");
                System.out.println("Make your bet!");
                Scanner bet = new Scanner(System.in);
                int betInt = bet.nextInt();

                int yourHandCode;
                Poker pokerClient = new Poker();

                pokerClient.setDealer(dealerList.findById(dealerId));
                pokerClient.setPlayersAllowed(allowedPlayers);
                pokerClient.setTable(tableNr);

                pokerClient.play();
                yourHandCode = pokerClient.getHandCode();
                System.out.println("Keep in mind what you got!\n");

                int dealerHandCode;
                System.out.println("Now you will play as a dealer. Make him lose!");
                Poker pokerDealer = new Poker();
                pokerDealer.play();
                dealerHandCode = pokerDealer.getHandCode();

                if(dealerHandCode > yourHandCode){
                    System.out.println("You lost!");
                    client.setCurrentMoney(client.getCurrentMoney() - betInt);
                    client.setLostMoney(betInt);
                    client.setLostGames(1);
                    clientList.update(client.getIdClient(), client);
                }
                else if (dealerHandCode < yourHandCode){
                    System.out.println("You won! Congratulations!");
                    client.setCurrentMoney(client.getCurrentMoney() + bet.nextInt());
                    client.setWonMoney(betInt);
                    client.setWonGames(1);
                    clientList.update(client.getIdClient(), client);
                }
                else{
                    System.out.println("It's a tie!!");
                }
            }
            if (Objects.equals(game, "Roulette")) {
                System.out.println("NOW START PLAYING!\n");
                Roulette roulette = new Roulette(client.getCurrentMoney(), client.getWonMoney(), client.getLostMoney(), client.getWonGames(), client.getLostGames());
                roulette.play();

                client.setCurrentMoney(roulette.getCurrentMoney());
                client.setLostGames(roulette.getLostGames());
                client.setWonGames(roulette.getWonGames());
                client.setWonMoney(roulette.getWonMoney());
                client.setLostMoney(roulette.getLostMoney());
                clientList.update(client.getIdClient(), client);
            }
        }
    }

    public void clientLogged() throws Exception {
        System.out.println("--- MY OPTIONS AS A CLIENT ---");
        System.out.println("1 - Choose game");
        System.out.println("2 - Deposit money");
        System.out.println("3 - Check your current money");
        System.out.println("4 - Check your won money and won games");
        System.out.println("5 - Check your lost money and lost games");
        System.out.println("0 - Log out as a Client");
        Scanner ok = new Scanner(System.in);
        while(ok.hasNextInt()) {
            int var = ok.nextInt();
            if (var == 1) {
                playGames();
                clientLogged();
            }
            if (var == 2) {
                System.out.println("Enter deposit ");
                Scanner ok1 = new Scanner(System.in);
                client.setCurrentMoney(ok1.nextInt()+ client.getCurrentMoney());
                System.out.println(client.getCurrentMoney());
                clientLogged();
            }
            if (var == 3) {
                System.out.println(client.getCurrentMoney());
                clientLogged();
            }
            if (var == 4) {
                System.out.println("You have won: " + client.getWonMoney() +" money");
                System.out.println("You have won: " + client.getWonGames() +" games");
                clientLogged();
            }
            if (var == 5) {
                System.out.println("You have lost: " + client.getLostMoney() +" money");
                System.out.println("You have lost: " + client.getLostGames() +" games");
                clientLogged();
            }

            if (var == 0) {
                System.out.println("You go back to the main menu, select another option");
                menuUser();
            }
        }
    }

    private void dealerLogged() throws Exception {
        System.out.println("--- MY OPTIONS AS A DEALER ---");
        System.out.println("1 - Learn a new game!");
        System.out.println("2 - Show all the known games");
        System.out.println("0 - Log out as a dealer");
        Scanner choice = new Scanner(System.in);
        while(choice.hasNextInt()) {
            int c = choice.nextInt();
            if (c == 0) {
                System.out.println("You go back to the main menu, select another option");
                menuUser();
            }
            if(c == 1){
                System.out.println("These are the games I already know: " + dealer.getGamesKnown());
                System.out.println("These are all the games in the casino: " + Arrays.toString(AvailableGames.values()));
                System.out.println("Which one would you want to learn?");
                Scanner console = new Scanner(System.in);
                String game = console.nextLine();
                boolean found = false;
                for(AvailableGames game1: dealer.getGamesKnown())
                    if(Objects.equals(game, game1.toString())) {
                        System.out.println("You are a master of this game! You learned it more than once!");
                        found = true;
                    }
                if(!found){
                    System.out.println("New game unlocked!");
                    for(AvailableGames game1: dealer.getGamesKnown())
                        if(Objects.equals(game, game1.toString())) {
                            dealer.setGamesKnown(game1);
                        }
                }
                dealerLogged();
            }
            if(c == 2){
                System.out.println("These are the games I already know: " + dealer.getGamesKnown());
                dealerLogged();
            }
        }
    }

    public void printDealers(List<Dealer> dealerList){
        for(Dealer dealer1: dealerList){
            System.out.println(dealer1.getIdDealer()+ " "+dealer1.getName() + " "+ dealer1.getPassword() +" " + dealer1.getAge() +
                    " " + dealer1.getGamesKnown());
        }
    }
    public void printClients(List<Client> clientList){
        System.out.println("ClientId " + "Name " + "Password " + "Age " + "CurrentMoney " + "WonMoney " + "WonGames " + "LostMoney " + "LostGames");
        for(Client client1: clientList){
            System.out.println(client1.getIdClient() +" " + client1.getName() + " "+client1.getPassword() +  " " + client1.getAge()
             + " " + client1.getCurrentMoney() +  " " + client1.getWonMoney() + " " + client1.getWonGames() +
                    " " + client1.getLostMoney() + " "+ client1.getLostGames());
        }
    }
    public void printManagers(List<Manager> managerList){
        for(Manager manager1: managerList){
            System.out.println(manager1.getIdManager()+ " " +manager1.getName() + " " + manager1.getAge());
        }
    }

}
