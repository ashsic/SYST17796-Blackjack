// Returns suit.
class Suit {
    private final String name;

    public Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Returns symbol and value.
class Rank {
    private final int value;
    private final String symbol;

    public Rank(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }
}

// Returns a playing card with suit and rank.
class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank.getSymbol(), suit.getName());
    }
}