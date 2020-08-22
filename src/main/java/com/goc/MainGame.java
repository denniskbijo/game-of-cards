package com.goc;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.goc.beans.CardDeck;
import com.goc.beans.GameSession;
import com.goc.beans.Player;

/**
 * Basic Rules: - Use a standard deck of cards (no Joker). - Each player is
 * dealt only three cards. - 'A' is considered to have a number value of 1. -
 * 'A' is considered the top card in a face-off. So the order is A > K > Q > J >
 * 10...2
 * 
 * Victory: - A trail (three cards of the same number) is the highest possible
 * combination. - The next highest is a sequence (numbers in order, e.g., 4,5,6.
 * A is considered to have a value of 1). - The next highest is a pair of cards
 * (e.g.: two Kings or two 10s). - If all else fails, the top card (by number
 * value wins). - If the top card has the same value, each of the tied players
 * draws a single card from the deck until a winner is found. - Only the newly
 * drawn cards are compared to decide a tie. The top card wins a tie. - For now
 * the suit (spades/hearts etc...), does not matter.
 * 
 * @author denniskbijo
 *
 */
public class MainGame {
	private static final Logger LOGGER = LogManager.getLogger(MainGame.class);

	private static final int NO_OF_PLAYERS = 4;
	private static final int NO_OF_CARDS = 3;

	public static void main(String[] args) {
		GameSession game = new GameSession();
		List<Player> players = game.readPlayerNames(NO_OF_PLAYERS);


		CardDeck cardDeck = game.dealCardsToPlayers(players, NO_OF_CARDS);

		Player winner = game.identifyWinner(players, cardDeck);

		LOGGER.info("The winner is: %s", winner);


	}


}
