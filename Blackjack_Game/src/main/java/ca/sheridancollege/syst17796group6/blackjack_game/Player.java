/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.syst17796group6.blackjack_game;

/**
 *
 * @author Ashton
 */
class Player extends Person {
    protected Hand hand;
    private int balance;

    public Player(String name, int balance) {
        super(name);
        this.hand = new Hand();
        this.balance = balance;
    }

    public void placeBet(int amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Not enough money.");
        }
    }

    public void hit(Deck deck) {
        this.hand.addCard(deck.dealCard());
    }

    public void stand() {
        // standing does nothing
    }

    public void doubleDown(Deck deck) {
        placeBet(balance / 2);
        this.hand.addCard(deck.dealCard());
    }

    public boolean isBusted() {
        return this.hand.isBusted();
    }

    public Hand getHand() {
        return this.hand;
    }

    public int getBalance() {
        return this.balance;
    }

    public void updateBalance(int amount) {
        this.balance += amount;
    }

    public void push() {
        // No money lost or gained
    }
}