/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ca.sheridancollege.syst17796group6.blackjack_game;

import java.util.Scanner;

/**
 *
 * @author Ashton
 */
public class Blackjack_Game {

    public static void main(String[] args) {
        System.out.println("Welcome to our blackjack game!");
        System.out.println("This game was coded by Group 6 for the SYST17796 final deliverable.");
        System.out.println("It is targeted to beginners, and includes some extra instructions,");
        System.out.println("as well as having certain operations omitted (insurance, splitting).");
        System.out.println("Good luck and have fun!");
        System.out.println("\n---------------------------------------------------------\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player's name: ");
        String playerName = scanner.nextLine();

        System.out.println("Enter player's starting balance (int): ");
        int playerBalance = scanner.nextInt();

        Player player = new Player(playerName, playerBalance);

        Dealer dealer = new Dealer();

        Deck deck = new Deck();
        deck.shuffle();

        while (player.getBalance() > 0) {
            System.out.println("Player " + player.getName() + " has balance: $" + player.getBalance());
            
            int bet;

            while (true) {
                System.out.print("Place a bet (int): ");
                bet = scanner.nextInt();
                try {
                    player.placeBet(bet);
                    break;
                } catch (IllegalArgumentException err) {
                    System.out.println("Invalid input:" + err.getMessage());
                }
            }

            // Reset both hands
            dealer.getHand().clear();
            player.getHand().clear();

            // Deal both player and dealer 2 cards
            dealer.dealCard(deck);
            dealer.dealCard(deck);
            player.hit(deck);
            player.hit(deck);

            System.out.println("Dealer's hand: [Hidden Card]," + dealer.getHand().toString().split(",")[1] + " (total: " + dealer.getHand().getHand().get(1).getValue() + ")");
            System.out.println("Your hand: " + player.getHand() + " (total: " + player.getHand().getTotalValue() + ")");

            while (!player.isBusted()) {
                System.out.println("Enter 1 to hit (get another card, repeatable while under 21 total score)");
                System.out.println("Enter 2 to stand (get no more cards)");
                System.out.println("Enter 3 to double down (double your bet, get one final card)");
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    player.hit(deck);
                    System.out.println("Your hand: " + player.getHand() + " (total: " + player.getHand().getTotalValue() + ")");
                    if (player.isBusted()) {
                        System.out.println("You are busted!");
                        break;
                    }
                } else if (choice == 2) {
                    player.stand();
                    break;
                } else if (choice == 3) {
                    player.doubleDown(deck);
                    System.out.println("Your hand: " + player.getHand() + " (total: " + player.getHand().getTotalValue() + ")");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            if (!player.isBusted()) {
                while (dealer.shouldHit()) {
                    dealer.dealCard(deck);
                }

                System.out.println("Dealer's hand: " + dealer.getHand() + " (total: " + dealer.getHand().getTotalValue() + ")");

                if (dealer.getHand().isBusted() || player.getHand().getTotalValue() > dealer.getHand().getTotalValue()) {
                    System.out.println("You won the round!");
                    player.updateBalance(bet);
                } else if (player.getHand().getTotalValue() == dealer.getHand().getTotalValue()) {
                    System.out.println("You tied the dealer (known as a push). Your bet is returned.");
                    player.push(); // Nothing happens
                } else {
                    System.out.println("Dealer wins!");
                    player.updateBalance(-bet);
                }
            } else {
                System.out.println("You busted! (score over 21, automatic loss this round.)");
            }

            // Check if user wants to play again
            System.out.println("Enter 1 to play again. Enter anything else to exit the program");
            if (scanner.nextInt() != 1) {
                break;
            }
        }

        System.out.println("You ended with $" + player.getBalance() + " remaining.");
        if (player.getBalance() == 0) {
            System.out.println(player.getName() + ", you're broke!");
        } else if (player.getBalance() < playerBalance) {
            System.out.println(player.getName() + ", you lost money! Gambling doesn't pay...");
        } else {
            System.out.println(player.getName() + ", you have more money than you started with! Good job.");
        }

        scanner.close();
    }
}
