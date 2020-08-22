package com.goc.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.goc.beans.Card;
import com.goc.beans.CardDeck;
import com.goc.beans.Player;
import com.goc.game.GameSession;
import com.goc.util.Rank;
import com.goc.util.Suit;

/**
 * Tests the card game scenarios where multiple HandRanks are checked to find
 * the winner.
 * 
 * @author denniskbijo
 *
 */
class GameSessionTest {

	private static List<Player> testPlayers = null;
	private static List<Card> highCard = null;
	private static List<Card> trail = null;
	private static List<Card> sequence = null;
	private static List<Card> pair = null;

	private Player ronaldo = new Player("C Ronaldo");
	private Player messi = new Player("L Messi");
	private Player henry = new Player("T O'Henry");
	private Player zidane = new Player("Z Zidane");
	private static CardDeck cardDeck = null;

	/**
	 * Setup the variables for GameSessionTest
	 */
	@BeforeAll
	static void initAll() {
		//Initialise test players
		testPlayers = new ArrayList<>();
		// Initialise Card Deck
		cardDeck = new CardDeck();
		// Initialise Test Hands
		highCard = new ArrayList<>();
		highCard.add(new Card(Suit.CLUBS, Rank.TEN));
		highCard.add(new Card(Suit.CLUBS, Rank.NINE));
		highCard.add(new Card(Suit.CLUBS, Rank.THREE));
		// Initialise Trail Hand
		trail = new ArrayList<>();
		trail.add(new Card(Suit.DIAMONDS, Rank.SEVEN));
		trail.add(new Card(Suit.CLUBS, Rank.SEVEN));
		trail.add(new Card(Suit.CLUBS, Rank.SEVEN));
		// Initialise Sequence
		sequence = new ArrayList<>();
		sequence.add(new Card(Suit.SPADES, Rank.EIGHT));
		sequence.add(new Card(Suit.CLUBS, Rank.NINE));
		sequence.add(new Card(Suit.CLUBS, Rank.TEN));
		// Initialise Pair
		pair = new ArrayList<>();
		pair.add(new Card(Suit.SPADES, Rank.EIGHT));
		pair.add(new Card(Suit.CLUBS, Rank.TEN));
		pair.add(new Card(Suit.DIAMONDS, Rank.TEN));
	}

	@BeforeEach
	void initEach() {
		testPlayers.clear();
	}

	@Test
	void testIdentifyWinnerWithPair() {
		GameSession game = new GameSession();
		ronaldo.setCards(highCard);
		messi.setCards(highCard);
		henry.setCards(highCard);
		zidane.setCards(pair);
		testPlayers.add(ronaldo);
		testPlayers.add(messi);
		testPlayers.add(henry);
		testPlayers.add(zidane);

		assertEquals(zidane, game.identifyWinner(testPlayers, cardDeck));
	}

	@Test
	void testIdentifyWinnerWithTrail() {
		GameSession game = new GameSession();
		ronaldo.setCards(trail);
		messi.setCards(sequence);
		henry.setCards(highCard);
		zidane.setCards(pair);
		testPlayers.add(ronaldo);
		testPlayers.add(messi);
		testPlayers.add(henry);
		testPlayers.add(zidane);

		assertEquals(ronaldo, game.identifyWinner(testPlayers, cardDeck));
	}

	@Test
	void testIdentifyWinnerWithSequence() {
		GameSession game = new GameSession();
		ronaldo.setCards(pair);
		messi.setCards(sequence);
		henry.setCards(highCard);
		zidane.setCards(pair);
		testPlayers.add(ronaldo);
		testPlayers.add(messi);
		testPlayers.add(henry);
		testPlayers.add(zidane);

		assertEquals(messi, game.identifyWinner(testPlayers, cardDeck));
	}

	@Test
	@Disabled
	void testIdentifyWinnerWithHighCard() {
		GameSession game = new GameSession();
		List<Card> highestHand = new ArrayList<>();
		highestHand.add(new Card(Suit.CLUBS, Rank.KING));
		highestHand.add(new Card(Suit.CLUBS, Rank.QUEEN));
		highestHand.add(new Card(Suit.CLUBS, Rank.TEN));
		ronaldo.setCards(highCard);
		messi.setCards(highCard);
		zidane.setCards(highCard);
		henry.setCards(highestHand);
		testPlayers.add(ronaldo);
		testPlayers.add(messi);
		testPlayers.add(zidane);
		testPlayers.add(henry);

		assertEquals(henry, game.identifyWinner(testPlayers, cardDeck));
	}

	@Test
	void testTieBreaker() {
		GameSession game = new GameSession();
		ronaldo.setCards(pair);
		messi.setCards(pair);
		henry.setCards(pair);
		zidane.setCards(pair);
		testPlayers.add(ronaldo);
		testPlayers.add(messi);
		testPlayers.add(henry);
		testPlayers.add(zidane);
		Player winner = game.identifyWinner(testPlayers, cardDeck);
		assertEquals(1, winner.getCards().size());

	}

	@AfterAll
	static void tearDownAll() {
	}
}
