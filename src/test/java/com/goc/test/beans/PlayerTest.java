package com.goc.test.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.goc.beans.Card;
import com.goc.beans.Player;
import com.goc.util.HandRank;
import com.goc.util.Rank;
import com.goc.util.Suit;

/**
 * Tests the methods of {@link Player}
 * 
 * @author denniskbijo
 *
 */
class PlayerTest {
	private static final String NAME = "Dennis";


	@Test
	void testIsTrail() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		cards.add(new Card(Suit.SPADES, Rank.JACK));
		cards.add(new Card(Suit.HEARTS, Rank.JACK));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		assertTrue(player.calculateHandRank(cards).equals(HandRank.TRAIL));
	}

	@Test
	void testIsNotTrail() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		cards.add(new Card(Suit.SPADES, Rank.KING));
		cards.add(new Card(Suit.HEARTS, Rank.JACK));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		assertTrue(!player.calculateHandRank(cards).equals(HandRank.TRAIL));
	}

	@Test
	void testIsSequence() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		cards.add(new Card(Suit.SPADES, Rank.KING));
		cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		assertTrue(player.calculateHandRank(cards).equals(HandRank.SEQUENCE));
	}

	@Test
	void testIsNotSequence() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		cards.add(new Card(Suit.SPADES, Rank.NINE));
		cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		assertTrue(!player.calculateHandRank(cards).equals(HandRank.SEQUENCE));
	}

	@Test
	void testIsPair() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.KING));
		cards.add(new Card(Suit.SPADES, Rank.KING));
		cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		assertTrue(player.calculateHandRank(cards).equals(HandRank.PAIR));
	}

	@Test
	void testIsNotPair() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		cards.add(new Card(Suit.SPADES, Rank.NINE));
		cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		assertTrue(!player.calculateHandRank(cards).equals(HandRank.PAIR));
	}

	@Test
	void testIsHighCard() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
		cards.add(new Card(Suit.SPADES, Rank.KING));
		cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		assertTrue(player.calculateHandRank(cards).equals(HandRank.HIGHCARD));
	}

	@Test
	void testIsNotHighCard() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		cards.add(new Card(Suit.SPADES, Rank.JACK));
		cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		assertTrue(!player.calculateHandRank(cards).equals(HandRank.HIGHCARD));
	}

	@Test
	void testGetTopCard() {
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
		Card topCard = new Card(Suit.SPADES, Rank.KING);
		cards.add(topCard);
		cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
		cards.sort(Card.rankComparator);
		player.setCards(cards);

		Card returnedTopCard = player.getTopCard(cards);
		assertTrue(returnedTopCard.equals(topCard));
	}

}
