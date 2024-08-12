/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.syst17796group6.blackjack_game;

/**
 *
 * @author Georgio, Ashton
 */
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
        String[] suits = { "Diamonds", "Clubs", "Spades", "Hearts" };
        String[][] ranks = { 
            {"2", "Two"},
            {"3", "Three"},
            {"4", "Four"},
            {"5", "Five"},
            {"6", "Six"},
            {"7", "Seven"},
            {"8", "Eight"},
            {"9", "Nine"},
            {"10", "Ten"},
            {"J", "Jack"},
            {"Q", "Queen"},
            {"K", "King"},
            {"A", "Ace"}
        };

        int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};

        // Note that Ace is worth 1 if the current score is 11 or greater - implemented
        // in Blackjack_Game.java

        // Adds each card to the deck.
        for (String suitName : suits) {
            Suit newSuit = new Suit(suitName);

            for (int i = 0; i < ranks.length; i++) {
                Rank newRank = new Rank(ranks[i][0], ranks[i][1], values[i]);
                cards.add(new Card(newSuit, newRank));
            }
        }
    }

    // Shuffles deck.
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deals a card
    public Card dealCard() {
        return cards.remove(0);
    }

}
