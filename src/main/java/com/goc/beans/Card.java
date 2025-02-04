package com.goc.beans;

import java.util.Comparator;

import com.goc.util.Rank;
import com.goc.util.Suit;

/**
 * Class represents a card in the deck
 * 
 * @author denniskbijo
 *
 */
public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit cardSuit, Rank cardRank) {
		this.suit = cardSuit;
		this.rank = cardRank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	/**
	 * Comparator to compare two cards by Rank
	 */
	public static final Comparator<Card> rankComparator = (Card left, Card right) -> {
		int leftCardRank = left.getRank().getFaceValue();
		int rightCardRank = right.getRank().getFaceValue();
		if (leftCardRank > rightCardRank) {
			return -1;
		} else if (leftCardRank == rightCardRank) {
			return 0;
		} else {
			return 1;
		}
	};

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

}
