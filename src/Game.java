import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        Deck deck = new Deck();
        HashMap < Integer, ArrayList < Card >> output = new HashMap < > ();

        output = deck.Deal(10, 5);
        for (Integer key: output.keySet()) {
            System.out.println(key + " " + output.get(key).toString());
        }
    }
}

class CardComparator implements Comparator < Card > {
    @Override
    public int compare(Card o1, Card o2) {
        return o2.cardNumber - o1.cardNumber;
    }
}

class Card {
    String suitName;
    int cardNumber;
    Card(String suitName, int cardNumber) {
        this.suitName = suitName;
        this.cardNumber = cardNumber;
    }
    @Override
    public String toString() {
        return this.suitName + " " + this.cardNumber;
    }
}

class Deck {
    static ArrayList < Card > myDeck = new ArrayList < Card > ();
    String suitArray[] = {
        "Club",
        "Spade",
        "Diamonds",
        "Heart"
    };

    Deck() {
        for (int i = 0; i < suitArray.length; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(suitArray[i], j);
                myDeck.add(card);
            }
        }
        System.out.println(myDeck.size());
        System.out.println(myDeck);
    }
    //map key : ID of a player and value : list of cards
    public static HashMap < Integer, ArrayList < Card >> Deal(int noofPlayers, int noofCardsPerPlayer) {
        HashMap < Integer, ArrayList < Card >> playerAndCards = new HashMap < > ();
        int upperBound = 52;
        if (noofCardsPerPlayer * noofPlayers > upperBound) {
            System.out.println("Not enough cards for all players!");
            return playerAndCards;
        }

        for (int j = 1; j <= noofPlayers; j++) {
            ArrayList < Card > cardPerPlayer = new ArrayList < > ();
            for (int i = 1; i <= noofCardsPerPlayer; i++) {
                Random rand = new Random();
                int int_random = rand.nextInt(upperBound);
                cardPerPlayer.add(myDeck.get(int_random));
                myDeck.remove(int_random);
                upperBound--;
            }
            playerAndCards.put(j, cardPerPlayer);
        }
        int winner = findwinner(playerAndCards);
        System.out.println("Winner = " + winner);
        return playerAndCards;
    }

    private static int findwinner(HashMap < Integer, ArrayList < Card >> playerAndCards) {

        //Assuming ace to be 13

        for (Integer key: playerAndCards.keySet()) {
            System.out.println(playerAndCards.get(key));
            Collections.sort(playerAndCards.get(key), new CardComparator());
        }
        System.out.println(playerAndCards);
        // Round
        HashSet < Integer > current_players = new HashSet < > ();
        for (int i = 1; i <= playerAndCards.size(); i++) {
            current_players.add(i);
        }
        int round = 0;
        while (round < playerAndCards.get(1).size()) {
            int max = 0;
            HashSet < Integer > current_players_temp = new HashSet < > (current_players);
            for (Integer key: current_players) {
                if (playerAndCards.get(key).get(round).cardNumber >= max) {
                    max = playerAndCards.get(key).get(round).cardNumber;
                }
            }
            for (Integer key: current_players) {
                if (playerAndCards.get(key).get(round).cardNumber < max) {
                    current_players_temp.remove(key);
                }
            }
            if (current_players_temp.size() == 1) {
                return current_players_temp.iterator().next();
            }
            current_players = current_players_temp;
            round++;
        }
        // Draw More than 1 player has same order of cards.
        return -1;
    }
}