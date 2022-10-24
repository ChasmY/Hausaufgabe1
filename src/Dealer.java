import java.util.ArrayList;
import java.util.List;

public class Dealer extends Person{

    public List<AvailableGames> gamesKnown = new ArrayList<AvailableGames>();


    public Dealer(String firstName, String secondName, int age) {
        super(firstName, secondName, age);
    }
}
