import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Create Deck Class.
class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        setDeck();
    }

    // Creates Deck. Assigns each suit, rank and the value related to each rank.
    private void setDeck() {
        String[] suitNames = { "Diamonds", "Clubs", "Spades", "Hearts" };
        String[] rankSymbols = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        int[] rankValues = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };

        // Adds each card to the deck.
        for (String suitName : suitNames) {
            Suit suit = new Suit(suitName);

            for (int i = 0; i < rankSymbols.length; i++) {
                Rank rank = new Rank(rankValues[i], rankSymbols[i]);
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Shuffles deck.
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deals 1 card. Returns Null if deck is empty.
    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

}
