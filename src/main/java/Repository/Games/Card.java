package Repository.Games;

public class Card implements Comparable<Card>
{
    // I.V.s are suit and rank
    public int suit;
    public int rank;

    @Override
    public int compareTo(Card o)
    {
        return Integer.compare(this.rank, o.rank);
    }


}

