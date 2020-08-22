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

class PlayerTest {
	private static final String NAME = "Dennis";

	@Test
	void testShowPlayerHand() {
		StringBuilder stringBuilder = new StringBuilder();
		Player player = new Player(NAME);
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
		cards.add(new Card(Suit.DIAMONDS, Rank.KING));
		cards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
		player.setCards(cards);
		stringBuilder.append(NAME).append(" Hand: ").append(System.lineSeparator());
		// Sort cards by Rank
		cards.sort(Card.rankComparator);
		for (Card card : cards) {
			stringBuilder.append(card).append(System.lineSeparator());
		}
		HandRank handRank = player.calculateHandRank(cards);
		stringBuilder.append(handRank).append(System.lineSeparator());

		String hand = stringBuilder.toString();
		assertTrue(hand.equals(player.showPlayerHand()));
	}

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
