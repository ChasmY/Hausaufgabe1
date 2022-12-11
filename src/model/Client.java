package model;

public class Client extends User {
    private int currentMoney, wonMoney, lostMoney, wonGames, lostGames;
    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getWonMoney() {
        return wonMoney;
    }

    public void setWonMoney(int wonGames) {
        this.wonGames += wonGames;
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

    public Client(String name, String password, int age, int currentMoney) {
        super(name, password, age);
        this.currentMoney = currentMoney;
        this.wonGames = 0;
        this.lostGames = 0;
        this.wonMoney = 0;
        this.lostMoney = 0;
    }
}
