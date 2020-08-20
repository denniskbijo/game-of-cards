package com.goc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the Game of Cards
 * 
 * @author denniskbijo
 *
 */
public class Player {

	private String name;

	private List<Card> cards = new ArrayList<>();

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void addCardToHand(Card card) {
		this.cards.add(card);
	}

	/**
	 * Shows the cards held by the player
	 * 
	 * @return
	 */
	public String showPlayerCards() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name + " has the following cards:\n");

		for (Card card : cards) {
			stringBuilder.append(card + "\n");
		}

		return stringBuilder.toString();
	}

	@Override
	public String toString() {
		return name;
	}
}
