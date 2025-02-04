package com.goc.beans;

import java.util.ArrayList;
import java.util.List;

import com.goc.util.HandRank;
import com.goc.util.Rank;

/**
 * Represents a player in the Game of Cards
 * 
 * @author denniskbijo
 *
 */
public class Player {

	private String name;

	private List<Card> cards = new ArrayList<>();

	private HandRank handRank = null;

	// GETTERS AND SETTERS

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

	public HandRank getHandRank() {
		return handRank;
	}

	public void setHandRank(HandRank handRank) {
		this.handRank = handRank;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ").append(name).append(this.showPlayerHand());
		return builder.toString();
	}
	// CUSTOM FUNCTIONS

	/**
	 * Adds a card to player's hand
	 * 
	 * @param card
	 */
	public void addCardToHand(Card card) {
		this.cards.add(card);
	}

	/**
	 * Removes the cards dealt to the player
	 */
	public void resetHand() {
		this.cards = new ArrayList<>();
		this.handRank = null;
	}

	/**
	 * Gets the top card in a Hand.
	 * 
	 * @param hand
	 * @return
	 */
	public Card getTopCard(List<Card> hand) {
		hand.sort(Card.rankComparator);
		return hand.get(0);
	}

	/**
	 * Shows the cards held by the player
	 * 
	 * @return
	 */
	public String showPlayerHand() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(System.lineSeparator()).append("Hand: ");

		// Sort cards by Rank
		cards.sort(Card.rankComparator);

		for (Card card : cards) {
			stringBuilder.append(card).append(System.lineSeparator());
		}
		// Adds HandRank to player hand
		HandRank playerHand = calculateHandRank(cards);
		stringBuilder.append(playerHand != null ? playerHand : "").append(System.lineSeparator());

		return stringBuilder.toString();
	}

	/**
	 * Calculate the Player Hand Rank
	 * 
	 * @return
	 */
	public HandRank calculateHandRank(List<Card> cards) {
		// HighCard is the lowest rank
		HandRank playerHandRank = null;

		if (cards.size() > 2) {
			if (isTrail(cards)) {
				playerHandRank = HandRank.TRAIL;
			} else if (isSequence(cards)) {
				playerHandRank = HandRank.SEQUENCE;
			} else if (isPair(cards)) {
				playerHandRank = HandRank.PAIR;
			} else {
				playerHandRank = HandRank.HIGHCARD;
			}
		}
		return playerHandRank;
	}

	/**
	 * Check if the hand contains a pair of cards
	 * 
	 * @param cards
	 * @return
	 */
	private boolean isPair(List<Card> cards) {
		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				if (cards.get(i).getRank().equals(cards.get(j).getRank()))
					return true;
			}
		}
		return false;
	}

	/**
	 * Check if all the cards are in sequence.
	 * 
	 * @param hand
	 * @return
	 */
	private boolean isSequence(List<Card> hand) {
		boolean isSequence = true;
		// Check if its a Sequence (Consecutive ranks)

		// Set the prevRank to zero
		int prevRank = 0;

		// Iterate through the hand
		for (int i = 0; i < hand.size(); i++) {
			// Get rank of card
			int currentRank = hand.get(i).getRank().getSequenceValue();
			// Check if the sequence rank of card is exactly one less than the previous one.

			if (prevRank == 0 || currentRank == (prevRank - 1)) {
				// If prevRank is zero , then this is the first card and if the sequence rank of
				// card is just after the rank of the previous card, a sequence is possible.
				prevRank = currentRank;
			} else {
				return false;
			}
		}
		return isSequence;
	}

	/**
	 * Check if all the cards are of same rank i.e A Trail.
	 * 
	 * @param cards
	 * @return
	 */
	private boolean isTrail(List<Card> cards) {
		boolean isTrail = true;
		// Check if its a Trail (same rank)
		Rank rank = cards.get(0).getRank();
		for (Card card : cards) {
			if (!rank.equals(card.getRank())) {
				isTrail = false;
				break;
			}

		}
		return isTrail;
	}
}
