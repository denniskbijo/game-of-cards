package com.goc.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.goc.util.Rank;
import com.goc.util.Suit;

/**
 * Represents a deck of cards
 * 
 * @author denniskbijo
 *
 */
public class CardDeck {

	// Size of Deck calculated from Suits and Ranks available
	public static final int SIZE = Suit.values().length * Rank.values().length;

	private final List<Card> cards = new ArrayList<>();

	/**
	 * Initialise Deck with all cards
	 */
	public CardDeck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	public static int getSize() {
		return SIZE;
	}

	public List<Card> getCards() {
		return cards;
	}

	/**
	 * Shuffles the cards
	 */
	public void shuffle() {
		Random rand = new Random();
		Collections.shuffle(cards, rand);
	}
}
