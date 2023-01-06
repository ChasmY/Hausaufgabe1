package Repository.Games;
import model.Client;
import model.Dealer;

import static java.sql.Types.NULL;

public abstract class Gamble {

    private Dealer dealer;
    private int table, playersAllowed;

    public Gamble() {
        this.dealer = new Dealer(NULL, "", "", NULL);
        this.table = NULL;
        this.playersAllowed = NULL;
    }

    public int getTable() {
        return table;
    }
    public void setTable(int table) {
        this.table = table;
    }
    public int getPlayersAllowed() {
        return playersAllowed;
    }
    public void setPlayersAllowed(int playersAllowed) {
        this.playersAllowed = playersAllowed;
    }
    public Dealer getDealer() {
        return dealer;
    }
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}
