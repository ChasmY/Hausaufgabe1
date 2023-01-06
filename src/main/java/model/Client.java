package model;

import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
@DiscriminatorValue("Client")
public class Client extends User {

    private int idClient;
    private int currentMoney;
    private int wonMoney;
    private int lostMoney;
    private int wonGames;
    private int lostGames;

    public Client(int idClient, String name, String password, int age, int currentMoney) {
        super(name, password, age);
        this.idClient = idClient;
        this.currentMoney = currentMoney;
        this.wonGames = 0;
        this.lostGames = 0;
        this.wonMoney = 0;
        this.lostMoney = 0;
    }

    public Client(){}

    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getCurrentMoney() {
        return this.currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getWonMoney() {
        return this.wonMoney;
    }

    public void setWonMoney(int wonMoney) {
        this.wonMoney += wonMoney;
    }

    public int getLostMoney() {
        return this.lostMoney;
    }

    public void setLostMoney(int lostMoney) {
        this.lostMoney += lostMoney;
    }

    public int getWonGames() {
        return this.wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames += wonGames;
    }

    public int getLostGames() {
        return this.lostGames;
    }

    public void setLostGames(int lostGames) {
        this.lostGames += lostGames;
    }
}
