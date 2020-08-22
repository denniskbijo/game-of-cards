package com.goc.test.game;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.goc.beans.Card;
import com.goc.beans.CardDeck;
import com.goc.beans.Player;
import com.goc.util.Rank;
import com.goc.util.Suit;

/**
 * Tests the card game scenarios where multiple HandRanks are checked to find
 * the winner.
 * 
 * @author denniskbijo
 *
 */
class MainGameTest {

	private static List<Player> testPlayers = null;
	private static List<Card> highCard = null;
	private static List<Card> trail = null;
	private static List<Card> sequence = null;
	private static List<Card> pair = null;

	private static CardDeck cardDeck = null;

	/**
	 * Setup the variables for MainGameTest
	 */
	@BeforeAll
	static void initAll() {
		//Initialise test players
		testPlayers = new ArrayList<>();
		Player ronaldo = new Player("C Ronaldo");
		Player messi = new Player("L Messi");
		Player henry = new Player("T O'Henry");
		Player zidane = new Player("Z Zidane");
		testPlayers.add(ronaldo);
		testPlayers.add(messi);
		testPlayers.add(henry);
		testPlayers.add(zidane);
		// Initialise Card Deck
		cardDeck = new CardDeck();
		// Initialise Test Hands
		highCard = new ArrayList<>();
		highCard.add(new Card(Suit.CLUBS, Rank.EIGHT));
		highCard.add(new Card(Suit.CLUBS, Rank.NINE));
		highCard.add(new Card(Suit.CLUBS, Rank.THREE));
		// Initialise Trail Hand
		trail = new ArrayList<>();
		trail.add(new Card(Suit.DIAMONDS, Rank.EIGHT));
		trail.add(new Card(Suit.CLUBS, Rank.NINE));
		trail.add(new Card(Suit.CLUBS, Rank.THREE));
		// Initialise Sequence
		sequence = new ArrayList<>();
		sequence.add(new Card(Suit.SPADES, Rank.EIGHT));
		sequence.add(new Card(Suit.CLUBS, Rank.NINE));
		sequence.add(new Card(Suit.CLUBS, Rank.TEN));
		// Initialise Pair
		pair = new ArrayList<>();
		pair.add(new Card(Suit.SPADES, Rank.EIGHT));
		pair.add(new Card(Suit.CLUBS, Rank.NINE));
		pair.add(new Card(Suit.CLUBS, Rank.TEN));
	}


	@Test
	void testIdentifyWinner() {
	}

	@Test
	void testCannotIdentifyWinner() {
		fail("a failing test");
	}

	@Test
	@Disabled("Only for Tiebreaker case")
	void testTieBreaker() {

	}

	@AfterAll
	static void tearDownAll() {
	}
}
