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
		stringBuilder.append(name + " Hand:\n");

		// Sort cards by Rank
		cards.sort(Card.rankComparator);

		for (Card card : cards) {
			stringBuilder.append(card + "\n");
		}

		return stringBuilder.toString();
	}

	/**
	 * Calculate the Player hand score
	 * 
	 * @return
	 */
	public HandRank calculateHandRank(List<Card> cards) {
		// HighCard is the lowest rank
		HandRank handRank = HandRank.HIGHCARD;

		if (isTrail(cards)) {
			handRank = HandRank.TRAIL;
		} else if (isSequence(cards)) {
			handRank = HandRank.SEQUENCE;
		}

		return handRank;
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

		// Set the prevRank to a negative rank
		int prevRank = -1;

		// Iterate through the hand
		for (int i = 0; i < hand.size(); i++) {
			// Get rank of card
			int currentRank = hand.get(i).getRank().getValue();
			// Check if the rank of card is exactly one more than the previous one.

			if (prevRank < 0 || currentRank == (prevRank + 1)) {
				// If prevRank is negative , then this is the first card and if the rank of card
				// is just before the rank of the previous card, a sequence is possible.
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

	@Override
	public String toString() {
		return name;
	}
}
