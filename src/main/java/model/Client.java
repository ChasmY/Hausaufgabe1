package model;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Client extends User {
    //public static final AtomicLong idCounter = new AtomicLong(1);
    private int idClient;
    private int currentMoney;
    private int wonMoney;
    private int lostMoney;
    private int wonGames;
    private int lostGames;

    public Client(int idClient, String name, String password, int age, int currentMoney) {
        super(idClient, name, password, age, "Client");
        this.idClient = idClient;
        this.currentMoney = currentMoney;
        this.wonGames = 0;
        this.lostGames = 0;
        this.wonMoney = 0;
        this.lostMoney = 0;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient){
        this.idClient = idClient;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getWonMoney() {
        return wonMoney;
    }

    public void setWonMoney(int wonMoney) {
        this.wonMoney += wonMoney;
    }

    public int getLostMoney() {
        return lostMoney;
    }

    public void setLostMoney(int lostMoney) {
        this.lostMoney += lostMoney;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames += wonGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    public void setLostGames(int lostGames) {
        this.lostGames += lostGames;
    }
}
