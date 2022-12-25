package Repository.Games.Poker;

import Repository.Games.Card;
import Repository.Games.Deck;

public class Player
{

    // gets 5 cards from deck
    public Card[] draw(Deck deck)
    {
        return deck.deal();
    }

    // switches card for a new card
    public Card redraw(int counter, Deck deck)
    {
        return deck.redeal();
    }

}
