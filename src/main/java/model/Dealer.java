package model;

import Repository.Games.AvailableGames;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Dealers")
@DiscriminatorValue("Dealer")
public class Dealer extends User {

    @JoinColumn(name = "idUser")
    private int idDealer;

    @Transient
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
        super(name, password, age);
        this.idDealer = idDealer;
        this.gamesKnown = new ArrayList<AvailableGames>();
    }

    public Dealer(){
        super();
    }
}
