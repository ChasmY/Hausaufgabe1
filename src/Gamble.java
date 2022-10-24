import java.util.ArrayList;
import java.util.List;

public class Gamble {
    public AvailableGames name;
    public int table = 0, playersAllowed = 0;
    public List<Client> clientsList = new ArrayList<Client>();
    public Dealer dealer;
}
