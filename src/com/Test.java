package com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test {

  public static void main(String[] args) {
    //Golden, Brown, Blue, Green, Red, White
    ArrayList < Integer > player1Coins = new ArrayList < Integer > (Arrays.asList(1, 2, 4, 4, 1, 4));
    //1,2,4,4,1,4
    //0,0,4,2,0,1
    //1,2,0,2,1,3
    //1,2,4,2,1,3

    //0,0,4,0,0,0 cards I have
    // 1,2,4,4,1,4 coins i have
    // 0,0,4,2,0,1 trying to purchase
    // 1,2,4,2,1,3 leftover

    ArrayList < Card > cardList = new ArrayList < > ();
    ArrayList < Integer > card1Cost = new ArrayList < Integer > (Arrays.asList(0, 0, 4, 2, 0, 1));
    ArrayList < Integer > card2Cost = new ArrayList < Integer > (Arrays.asList(0, 0, 0, 0, 1, 0));

    Player player1 = new Player(player1Coins, 1, cardList);
    Card card1 = new Card(2, 4, card1Cost);
    Card card2 = new Card(2, 3, card2Cost);

    System.out.println(player1.canPurchaseCard(card1));
    player1.puchaseCard(card1);
    System.out.println("Player's coins : " + player1Coins + " Player has the following cards " + player1.allCardsOfAPlayer.toString());
    System.out.println(player1.canPurchaseCard(card2));
    player1.puchaseCard(card2);
    System.out.println("Player's coins : " + player1Coins + " Player has the following cards " + player1.allCardsOfAPlayer.toString());

  }
}

class Card {
  int points;
  int color;
  ArrayList < Integer > cost = new ArrayList < > ();

  Card(int points, int color, ArrayList < Integer > cost) {
    this.color = color;
    this.points = points;
    this.cost = cost;
  }
}

class Player {
  private ArrayList < Integer > coins = new ArrayList < > ();
  private int playerNumber;
  ArrayList < Card > allCardsOfAPlayer = new ArrayList < > ();
  ArrayList < Integer > discounts = new ArrayList < > (Arrays.asList(0, 0, 0, 0, 0, 0));

  Player(ArrayList < Integer > coins, int playerNumber, ArrayList < Card > allCardsOfAPlayer) {
    this.coins = coins;
    this.playerNumber = playerNumber;
    this.allCardsOfAPlayer = allCardsOfAPlayer;
  }
  // Player class : purchase a card -> decrease the coins of the respective player
  // Keep track of all the cards purchased by a player

  public boolean canPurchaseCard(Card card) {
    for (int i = 0; i < card.cost.size(); i++) {
      if (card.cost.get(i) > this.coins.get(i) + discounts.get(i)) {
        return false;
      }
    }
    return true;
  }

  public void puchaseCard(Card cardToPurchase) {
    if (canPurchaseCard(cardToPurchase)) {
      for (int i = 0; i < cardToPurchase.cost.size(); i++) {
        int updatedCoins = (this.coins.get(i) + discounts.get(i)) - (cardToPurchase.cost.get(i));
        coins.set(i, updatedCoins);
      }
      discounts.set(cardToPurchase.color, discounts.get(cardToPurchase.color) + 1);
      this.allCardsOfAPlayer.add(cardToPurchase);
    }
  }

}
