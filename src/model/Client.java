package model;

public class Client extends User {
    private int currentMoney, winnings, losses;
    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public Client(String name, String password, int age, int currentMoney) {
        super(name, password, age);

        this.currentMoney = currentMoney;
        this.winnings = 0;
        this.losses = 0;
    }
}
