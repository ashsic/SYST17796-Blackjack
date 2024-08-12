/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.syst17796group6.blackjack_game;

/**
 *
 * @author Ashton
 */
class Dealer extends Person {
    private Hand hand;

    public Dealer() {
        super("Dealer");
        hand = new Hand();
    }

    public void dealCard(Deck deck) {
        this.hand.addCard(deck.dealCard());
    }

    public boolean shouldHit() {
        return this.hand.getTotalValue() < 17;
    }

    public Hand getHand() {
        return this.hand;
    }
}