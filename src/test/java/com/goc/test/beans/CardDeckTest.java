package com.goc.test.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.goc.beans.Card;
import com.goc.beans.CardDeck;
import com.goc.beans.Player;

/**
 * Tests the methods for {@link CardDeck}
 * 
 * @author denniskbijo
 *
 */
class CardDeckTest {

	@Test
	void testDealCards() {
		CardDeck cardDeck = new CardDeck();
		List<Player> players = new ArrayList<>();
		players.add(new Player("Test1"));
		players.add(new Player("Test2"));
		players.add(new Player("Test3"));
		players.add(new Player("Test4"));
		int numberOfCards = 1;
		cardDeck.dealCards(players, numberOfCards);
		boolean isCardsDealt = true;
		List<Card> dealtCards = new ArrayList<>();
		for (Player player : players) {
			if (player.getCards().size() != numberOfCards) {
				// Check if cards were dealt equally
				isCardsDealt = false;
				break;
			} else {
				// Check if all players received different cards
				for (Card card : player.getCards()) {
					if (dealtCards.contains(card)) {
						isCardsDealt = false;
						break;
					} else {
						dealtCards.add(card);
					}
				}

			}
		}
		assertTrue(isCardsDealt);
	}

}
