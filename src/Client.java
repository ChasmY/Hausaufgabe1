public class Client extends Person implements Gamble{
    public int currentMoney, winnings, losses;

    public Client(String firstName, String secondName, int age, int currentMoney) {
        super(firstName, secondName, age);
        this.currentMoney = currentMoney;
        this.winnings = 0;
        this.losses = 0;
    }
}
