/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.syst17796group6.blackjack_game;

/**
 *
 * @author Georgio
 */
class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public String getName() {
        return this.rank.getName();
    }

    public int getValue() {
        return this.rank.getValue();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rank.getName(), this.suit.getName());
    }
}