package model;

import Repository.Games.AvailableGames;
import Repository.InMemory.DealerRepositoryMemory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealer extends User {

    private List<AvailableGames> gamesKnown;

    public List<AvailableGames> getGamesKnown() {
        return gamesKnown;
    }

    public void setGamesKnown(List<AvailableGames> gamesKnown) {
        this.gamesKnown = gamesKnown;
    }

    public void addGame(AvailableGames game){
        this.gamesKnown.add(game);
    }
    public Dealer(String name, String password, int age) {

        super(name, password, age);
        this.gamesKnown = new ArrayList<AvailableGames>();
    }

}
