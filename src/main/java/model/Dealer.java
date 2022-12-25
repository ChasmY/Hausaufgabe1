package model;

import Repository.Games.AvailableGames;
import Repository.InMemory.DealerRepositoryMemory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Dealer extends User {
    //private static final AtomicLong idCounter = new AtomicLong(1);
    private int idDealer;

    private List<AvailableGames> gamesKnown;

    public List<AvailableGames> getGamesKnown() {
        return gamesKnown;
    }

    public void setGamesKnown(AvailableGames game) {
        this.gamesKnown.add(game);
    }

    public int getIdDealer() {
        return idDealer;
    }

    public void setIdDealer(int idDealer) {
        this.idDealer = idDealer;
    }

    public void addGame(AvailableGames game){
        this.gamesKnown.add(game);
    }
    public Dealer(int idDealer, String name, String password, int age) {
        super(idDealer, name, password, age, "Dealer");
        this.idDealer = idDealer;
        this.gamesKnown = new ArrayList<AvailableGames>();
    }

}
