package com.goc.test.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.goc.beans.CardDeck;
import com.goc.beans.Player;

class CardDeckTest {

	@Test
	void testDealCards() {
		CardDeck cardDeck = new CardDeck();
		List<Player> players = new ArrayList<>();
		players.add(new Player("Test1"));
		players.add(new Player("Test2"));
		players.add(new Player("Test3"));
		players.add(new Player("Test4"));
		cardDeck.dealCards(players, 3, cardDeck.getCards());
		boolean isAllCardsDealt = true;
		for (Player player : players) {
			if (player.getCards().size() != 3) {
				isAllCardsDealt = false;
			}
		}
		assertTrue(isAllCardsDealt);
	}

}
