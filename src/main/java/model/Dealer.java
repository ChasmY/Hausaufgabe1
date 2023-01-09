package model;

import Repository.Games.AvailableGames;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Pentru a fi creat tabelul
@Table(name = "Dealers") //Mentionam in ce tabel sunt stocate datele
@DiscriminatorValue("Dealer") //Stabilim tipul user-ului ce va fi salvat in tabela "Useri
public class Dealer extends User {

    @JoinColumn(name = "idDealer") //pentru a lega cheia principala de cea secundara
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
