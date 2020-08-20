package com.goc.beans;

/**
 * Class represents a card in the deck
 * 
 * @author denniskbijo
 *
 */
public class Card {
	private String suit;
	private String rank;

	public Card(String cardSuit, String cardRank) {
		this.suit = cardSuit;
		this.rank = cardRank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
