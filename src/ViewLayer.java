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
    DealerController dealerList = new DealerController(new ArrayList<>());
    Client client = new Client("", "", NULL, NULL);
    ClientController clientList=new ClientController(new ArrayList<>());
    User user = new User("", "", NULL);
    UserController userList = new UserController(new ArrayList<>());

    public void start() throws Exception {
//        printingLists();
//        System.exit(0);

        System.out.println("1 - Log in as a client");
        System.out.println("2 - Log in as a dealer");
        Scanner console = new Scanner(System.in);
        while(console.hasNextInt()) {
            int c = console.nextInt();
            if (c == 1) {
                loginClient();
                clientLogged();
            } else if (c == 2) {
                loginDealer();
                dealerLogged();
            }
        }
    }

    public void loginClient(){
        Scanner console = new Scanner(System.in);

        System.out.println("Name ");
        user.setName(console.nextLine());

        System.out.println("Password ");
        user.setPassword(console.nextLine());

        System.out.println("Age ");
        user.setAge(console.nextInt());

        User newUser = new User(user.getName(), user.getPassword(), user.getAge());
        userList.add(newUser);

        client.setName(user.getName());
        client.setPassword(user.getPassword());
        client.setAge(user.getAge());

        System.out.println("Money to deposit ");
        client.setCurrentMoney(console.nextInt());
        client.setWonMoney(0);
        client.setLostMoney(0);
        System.out.println(client.getCurrentMoney());

        clientList.add(client);
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

    public void clientLogged() throws Exception {
        System.out.println("1 - Choose game");
        System.out.println("2 - Deposit money");
        System.out.println("3 - Check current money");
        System.out.println("4 - Check won money and won games");
        System.out.println("5 - Check lost money and lost games");
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
        }
    }
    public void loginDealer(){
        Scanner console = new Scanner(System.in);
        System.out.println("Name ");
        dealer.setName(console.nextLine());

        System.out.println("Password ");
        dealer.setPassword(console.nextLine());

        System.out.println("Age ");
        dealer.setAge(console.nextInt());

        userList.add(dealer);
    }

    private void dealerLogged() {

        System.out.println("1 - Show dealers sorted by name");
        System.out.println("2 - Show dealers sorted by age");
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
            }
        }
    }
//    public void printingLists(){
//        dealerList.sortByNameAsc();
//        clientList.sortByNameAsc();
//    }
}
