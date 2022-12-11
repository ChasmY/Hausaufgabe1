package Repository.Games;
import model.Client;
import model.Dealer;

import java.util.ArrayList;
import java.util.List;

public abstract class Gamble {
    private Dealer dealer;
    private List<Client> clientList = new ArrayList<Client>();
    private int table = 0, playersAllowed = 0;

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
