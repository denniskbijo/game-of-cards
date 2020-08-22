package com.goc.test.game;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.goc.beans.CardDeck;
import com.goc.beans.Player;

/**
 * Tests the card game scenarios where multiple HandRanks are checked to find
 * the winner.
 * 
 * @author denniskbijo
 *
 */
class MainGameTest {

	private static List<Player> testPlayers = null;

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
