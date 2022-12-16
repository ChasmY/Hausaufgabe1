import Controller.ClientController;
import Controller.DealerController;
import Controller.UserController;
import Repository.Games.AvailableGames;
import Repository.Games.Poker.Poker;
import Repository.Games.Roulette;
import model.Client;
import model.Dealer;
import model.User;
import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class ViewLayer {
    Dealer dealer = new Dealer("", "", NULL);
    DealerController dealerList = new DealerController();
    Client client = new Client("", "", NULL, NULL);
    ClientController clientList=new ClientController();
    User user = new User("", "", NULL, "");
    UserController userList = new UserController();

    public void signIn() throws Exception {
        System.out.println("Welcome to sign in portal!\nDo you want to create (new) account? (y/n)");
        Scanner signin = new Scanner(System.in);
        String s = signin.next();
        if(Objects.equals(s, "n")){
            System.out.println("Now you will be sent to Log in portal!\n");
            start();
        }
        else{
            System.out.println("How are you signing in? As a dealer or a client? (d/c)");
            Scanner socialStatus = new Scanner(System.in);
            if (Objects.equals(socialStatus.next(), "d"))
                signinDealer();
            else
                signinClient();
            System.out.println("Thank you for creating an account! Now you can log in!");
            start();
        }
    }

    public void signinClient() throws Exception {
        Scanner console = new Scanner(System.in);

        System.out.println("Name ");
        user.setName(console.nextLine());

        System.out.println("Password ");
        user.setPassword(console.nextLine());

        System.out.println("Age ");
        user.setAge(console.nextInt());

        user.setSocialStatus("Client");

        //User newUser = new User(user.getName(), user.getPassword(), user.getAge(), "Client");
        userList.add(user);

        client.setName(user.getName());
        client.setPassword(user.getPassword());
        client.setAge(user.getAge());

        System.out.println("Money to deposit ");
        client.setCurrentMoney(console.nextInt());

        clientList.repo.add(client);
    }

    public void signinDealer() throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Name ");
        user.setName(console.nextLine());

        System.out.println("Password ");
        user.setPassword(console.nextLine());

        System.out.println("Age ");
        user.setAge(console.nextInt());

        user.setSocialStatus("Dealer");

        userList.add(user);

        dealer.setName(user.getName());
        dealer.setPassword(user.getPassword());
        dealer.setAge(user.getAge());

        dealerList.repo.add(dealer);
    }

    public boolean loginClient(){
        Client clientLogging = new Client("","", NULL, NULL);

        Scanner console = new Scanner(System.in);
        System.out.println("Name ");
        clientLogging.setName(console.nextLine());

        System.out.println("Password ");
        clientLogging.setPassword(console.nextLine());

        for(Client c : clientList.repo.getAllClients()){
            if(Objects.equals(c.getName(), clientLogging.getName()) && Objects.equals(c.getPassword(), clientLogging.getPassword())){
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
        Dealer dealerLogging = new Dealer("", "", NULL);

        Scanner console = new Scanner(System.in);
        System.out.println("Name ");
        dealerLogging.setName(console.nextLine());

        System.out.println("Password ");
        dealerLogging.setPassword(console.nextLine());

        for(Dealer d : dealerList.repo.getList()){
            if(Objects.equals(d.getName(), dealerLogging.getName()) && Objects.equals(d.getPassword(), dealerLogging.getPassword()))
                return true;
        }

        return false;
    }

    public void start() throws Exception {
//        printingLists();
//        System.exit(0);

        System.out.println("1 - Log in as a client");
        System.out.println("2 - Log in as a dealer");
        System.out.println("3 - Create another account");
        System.out.println("0 - Exit the program");
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
                System.out.println("You exited the program. See you soon!");
                return;
            } else if (c == 3){
                signIn();
            }

        }
    }

    public void playGames() throws Exception {
        boolean found = false;
        System.out.println("What game would you want to play?");
        //System.out.println("Poker - Play Poker");
        System.out.println("Roulette - Play Roulette");
//        System.out.println("Blackjack - Play Blackjack");
        Scanner gameMode = new Scanner(System.in);
        String game = gameMode.next();
        found = false;
        for (AvailableGames availableGames : AvailableGames.values())
            if (Objects.equals(game, availableGames.name())) {
                found = true;
                break;
            }
        if (!found)
            throw new Exception("Incorrect game name. Choose another one");
        else {
//            if (Objects.equals(game, "Poker")) {
//                System.out.println("Make your bet!");
//                Scanner bet = new Scanner(System.in);
//                int betInt = bet.nextInt();
//
//                int yourHandCode;
//                Poker pokerClient = new Poker();
//                pokerClient.play();
//                yourHandCode = pokerClient.handCode;
//                System.out.println("Keep in mind what you got!\n");
//
//                int dealerHandCode;
//                System.out.println("Now you will play as a dealer. Make him lose!");
//                Poker pokerDealer = new Poker();
//                pokerDealer.play();
//                dealerHandCode = pokerDealer.handCode;
//
//                if(dealerHandCode > yourHandCode){
//                    System.out.println("You lost!");
//                    client.setCurrentMoney(client.getCurrentMoney() - betInt);
//                    client.setLostMoney(betInt);
//                    client.setLostGames(1);
//                }
//                else if (dealerHandCode < yourHandCode){
//                    System.out.println("You won! Congratulations!");
//                    client.setCurrentMoney(client.getCurrentMoney() + bet.nextInt());
//                    client.setWonMoney(betInt);
//                    client.setWonGames(1);
//                }
//                else{
//                    System.out.println("It's a tie!!");
//                }
//            }
            if (Objects.equals(game, "Roulette")) {
                Roulette roulette = new Roulette(client.getCurrentMoney(), client.getWonMoney(), client.getLostMoney(), client.getWonGames(), client.getLostGames());
                roulette.play();
                client.setCurrentMoney(roulette.getCurrentMoney());
                client.setLostGames(roulette.getLostGames());
                client.setWonGames(roulette.getWonGames());
                client.setWonMoney(roulette.getWonMoney());
                client.setLostMoney(roulette.getLostMoney());
            }
        }
    }

    public void clientLogged() throws Exception {
        System.out.println("1 - Choose game");
        System.out.println("2 - Deposit money");
        System.out.println("3 - Check your current money");
        System.out.println("4 - Check your won money and won games");
        System.out.println("5 - Check your lost money and lost games");
        System.out.println("6 - Show all clients sorted by name");
        System.out.println("7 - Show all clients sorted by age");
        System.out.println("8 - Show all clients sorted by won money");
        System.out.println("9 - Show all clients sorted by lost money");
        System.out.println("10 - Log out as a Client");
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
            if (var == 6){
                System.out.println("1 - Show clients sorted by name ascending");
                System.out.println("2 - Show clients sorted by name descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if (c == 1){
                        List<Client> sortedClients = clientList.sortByNameAsc();
                        printClients(sortedClients);
                        clientLogged();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByNameDsc();
                        printClients(sortedClients);
                        clientLogged();
                    }
                    if (c == 0){
                        System.out.println("Back to client portal. Choose another option");
                        clientLogged();
                    }
                }
            }
            if (var == 7){
                System.out.println("1 - Show clients sorted by age ascending");
                System.out.println("2 - Show clients sorted by age descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if(c == 1){
                        List<Client> sortedClients = clientList.sortByAgeAsc();
                        printClients(sortedClients);
                        clientLogged();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByAgeDsc();
                        printClients(sortedClients);
                        clientLogged();
                    }
                    if(c == 0){
                        System.out.println("Back to client portal. Choose another option");
                        clientLogged();
                    }
                }
            }
            if (var == 8){
                System.out.println("1 - Show clients sorted by won money ascending");
                System.out.println("2 - Show clients sorted by won money descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if(c == 1){
                        List<Client> sortedClients = clientList.sortByWonMoneyAsc();
                        printClients(sortedClients);
                        clientLogged();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByWonMoneyDsc();
                        printClients(sortedClients);
                        clientLogged();
                    }
                    if (c == 0){
                        System.out.println("Back to client portal. Choose another option");
                        clientLogged();
                    }
                }
            }
            if (var == 9){
                System.out.println("1 - Show clients sorted by lost money ascending");
                System.out.println("2 - Show clients sorted by lost money descending");
                System.out.println("0 - Go back");
                Scanner choice = new Scanner(System.in);
                while(choice.hasNextInt()){
                    int c = choice.nextInt();
                    if(c == 1){
                        List<Client> sortedClients = clientList.sortByLostMoneyAsc();
                        printClients(sortedClients);
                        clientLogged();
                    }
                    if (c == 2){
                        List<Client> sortedClients = clientList.sortByLostMoneyDsc();
                        printClients(sortedClients);
                        clientLogged();
                    }
                    if (c == 0){
                        System.out.println("Back to client portal. Choose another option");
                        clientLogged();
                    }
                }
            }
            if (var == 10) {
                System.out.println("You go back to the main menu, select another option");
                start();
            }
        }
    }

    private void dealerLogged() throws Exception {

        System.out.println("1 - Show dealers sorted by name");
        System.out.println("2 - Show dealers sorted by age");
        System.out.println("3 - Log out as a dealer");
        Scanner choice = new Scanner(System.in);
        while(choice.hasNextInt()) {
            int c = choice.nextInt();
            if (c == 1) {
                System.out.println("1 - Show dealers sorted by name ascending");
                System.out.println("2 - Show dealers sorted by name descending");
                System.out.println("0 - Go back");
                Scanner secondChoice = new Scanner(System.in);
                while(secondChoice.hasNextInt()) {
                    int sc = secondChoice.nextInt();
                    if (sc == 1) {
                        List<Dealer> sortedDealers = dealerList.sortByNameAsc();
                        printDealers(sortedDealers);
                        dealerLogged();
                    }
                    if(sc == 2){
                        List<Dealer> sortedDealers= dealerList.sortByNameDsc();
                        printDealers(sortedDealers);
                        dealerLogged();
                    }
                    if (sc == 0){
                        System.out.println("Back to dealer portal. Choose another option");
                        dealerLogged();
                    }
                }
            }
            if (c == 2) {
                System.out.println("1 - Show dealers sorted by age ascending");
                System.out.println("2 - Show dealers sorted by age descending");
                System.out.println("0 - Go back");
                Scanner thirdChoice = new Scanner(System.in);
                while(thirdChoice.hasNextInt()) {
                    int tc = thirdChoice.nextInt();
                    if (tc == 1) {
                        List<Dealer> sortedDealers= dealerList.sortByAgeAsc();
                        printDealers(sortedDealers);
                        dealerLogged();
                    }
                    if(tc == 2){
                        List<Dealer> sortedDealers= dealerList.sortByAgeDsc();
                        printDealers(sortedDealers);
                        dealerLogged();
                    }
                    if (tc == 0){
                        System.out.println("Back to dealer portal. Choose another option");
                        dealerLogged();
                    }
                }
            }if (c == 3) {
                System.out.println("You go back to the main menu, select another option");
                start();
            }

        }
    }

    public void printDealers(List<Dealer> dealerList){
        for(Dealer dealer1: dealerList){
            System.out.println(dealer1.getName() + " "+ dealer1.getPassword() +" " + dealer1.getAge() +
                    " " + dealer1.getGamesKnown());
        }
    }
    public void printClients(List<Client> clientList){
        for(Client client1: clientList){
            System.out.println(client1.getName() + " "+client1.getPassword() +  " " + client1.getAge()
             + " " + client1.getCurrentMoney() +  " " + client1.getWonMoney() + " " + client1.getLostMoney() +
                    " " + client1.getWonGames() + " "+ client1.getLostGames());
        }
    }

    public void printBoth(List<Client> clientList, List<Dealer> dealerList){
        for(Client client1: clientList)
            System.out.println(client1.getName() + " "+client1.getPassword() +  " " + client1.getAge()
                    + " " + client1.getCurrentMoney() +  " " + client1.getWonMoney() + " " + client1.getLostMoney() +
                    " " + client1.getWonGames() + " "+ client1.getLostGames());
        for(Dealer dealer1: dealerList){
            System.out.println(dealer1.getName() + " "+ dealer1.getPassword() +" " + dealer1.getAge() +
                    " " + dealer1.getGamesKnown());
        }
    }
}
