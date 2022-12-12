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
    UserController userList = new UserController(new ArrayList<>());

    public void signIn() throws Exception {
        System.out.println("Welcome to sign in portal!\nDo you already have an account or do you want to create a new one? (y/n)");
        Scanner signin = new Scanner(System.in);
        String s = signin.next();
        if(Objects.equals(s, "y")){
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

    public void signinClient(){
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

        clientList.add(client);
    }

    public void signinDealer(){
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

        dealerList.add(dealer);
    }

    public boolean loginClient(){
        Client clientLogging = new Client("","", NULL, NULL);

        Scanner console = new Scanner(System.in);
        System.out.println("Name ");
        clientLogging.setName(console.nextLine());

        System.out.println("Password ");
        clientLogging.setPassword(console.nextLine());

        for(Client c : clientList.getList()){
            if(Objects.equals(c.getName(), clientLogging.getName()) && Objects.equals(c.getPassword(), clientLogging.getPassword()))
                return true;
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

        for(Dealer d : dealerList.getList()){
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

    public void clientLogged() throws Exception {
        System.out.println("1 - Choose game");
        System.out.println("2 - Deposit money");
        System.out.println("3 - Check current money");
        System.out.println("4 - Check won money and won games");
        System.out.println("5 - Check lost money and lost games");
        System.out.println("6 - Log out as a Client");
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
                client.setWonMoney(ok1.nextInt());
                System.out.println(client.getWonMoney());
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
            if (var == 6) {
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
                Scanner secondChoice = new Scanner(System.in);
                while(secondChoice.hasNextInt()) {
                    if (secondChoice.nextInt() == 1) {
                        dealerList.sortByNameAsc();
                    } else dealerList.sortByNameDsc();
                }
            } else if (c == 2) {
                System.out.println("1 - Show dealers sorted by age ascending");
                System.out.println("2 - Show dealers sorted by age descending");
                Scanner thirdChoice = new Scanner(System.in);
                while(thirdChoice.hasNextInt()) {
                    if (thirdChoice.nextInt() == 1) {
                        dealerList.sortByAgeAsc();
                    } else dealerList.sortByAgeDsc();
                }
            } else if (c == 3) {
                System.out.println("You go back to the main menu, select another option");
                start();
            }

        }
    }

    public void playGames() throws Exception {
        boolean found = false;
        System.out.println("What game would you want to play?");
        System.out.println("Poker - Play Poker");
        System.out.println("Roulette - Play Roulette");
        System.out.println("Blackjack - Play Blackjack");
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
            if (Objects.equals(game, "Poker")) {
                Poker poker = new Poker();
                poker.play();
            }
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
    public void printingLists(){
        dealerList.sortByNameAsc();
        System.out.println();
        dealerList.sortByNameDsc();
        System.out.println();
        dealerList.sortByAgeAsc();
        System.out.println();
        dealerList.sortByAgeDsc();
    }
}
