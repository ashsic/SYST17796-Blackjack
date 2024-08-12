/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.syst17796group6.blackjack_game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashton
 */
public class Hand {
    private List<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getTotalValue() {
        int total = 0;
        for (Card card : hand) {
            if (card.getValue() == 11) {
                if (total >= 11) {
                    total -= 10;
                }
            }
            total += card.getValue();
        }
        return total;
    }

    public boolean isBusted() {
        return getTotalValue() > 21;
    }

    public void clear() {
        hand.clear();
    }

    public List<Card> getHand() {
        return this.hand;
    }

    @Override
    public String toString() {
        String result = "";
        for (Card card : hand) {
            result += card.toString() + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
}
