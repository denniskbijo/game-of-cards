package com.goc.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.goc.beans.CardDeck;
import com.goc.beans.Player;
import com.goc.util.HandRank;
import com.goc.util.Rank;

/**
 * Represents a card game session with players
 * 
 * @author denniskbijo
 *
 */
public class GameSession {

	private static final Logger LOGGER = LogManager.getLogger(GameSession.class);
	// CUSTOM METHODS

	public List<Player> readPlayerNames(int playerCount) {
		List<Player> players = new ArrayList<>();
		LOGGER.info("WELCOME TO THE CARD GAME %n Enter the Player Names: ");

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < playerCount; i++) {
			LOGGER.info("Player %d: ", (i + 1));
			players.add(new Player(scan.next()));
		}
		scan.close();
		return players;
	}

	public CardDeck dealCardsToPlayers(List<Player> players, int noOfCards) {
		LOGGER.info("Shuffling cards. The Players are ready!");
		for (Player player : players) {
			LOGGER.info(player);
		}
		CardDeck cardDeck = new CardDeck();
		// Shuffle the cards
		cardDeck.shuffle();

		// Deal the cards
		cardDeck.dealCards(players, noOfCards, cardDeck.getCards());

		// Show Player Hands
		for (Player player : players) {
			LOGGER.info(player.showPlayerHand());
		}
		return cardDeck;
	}

	/**
	 * Identifies the winner and if there's a tie, conducts tie-breaker rounds.
	 * 
	 * @param playersWithCards
	 * @param cardDeck
	 * @return Winner of the game.
	 */
	public Player identifyWinner(List<Player> playersWithCards, CardDeck cardDeck) {
		Player winner = null;
		// Identify Top Hands
		List<Player> topHandPlayers = new ArrayList<>();
		HandRank handRank = identifyTopHand(playersWithCards, topHandPlayers);

		// Check if there's a tie between top hands or the highest rank is HIGHCARD
		if (topHandPlayers.size() > 1 || handRank.equals(HandRank.HIGHCARD)) {
			// Identify Players with Top Card
			List<Player> topCardPlayers = identifyTopCard(playersWithCards);

			if (topCardPlayers.size() > 1) {
				LOGGER.info("There is a tie between: %d", topCardPlayers.size());
				// Initiate tie breaker by drawing cards from deck for topCardPlayers
				winner = initiateTieBreaker(topCardPlayers, cardDeck);
			} else {
				winner = topCardPlayers.get(0);

			}

		} else {
			winner = topHandPlayers.get(0);
		}
		return winner;
	}

	/**
	 * Conducts a tie breaker with the players who are tied on the top card.
	 * 
	 * @param topCardPlayers
	 * @param cardDeck
	 * @return
	 */
	private Player initiateTieBreaker(List<Player> topCardPlayers, CardDeck cardDeck) {
		StringBuilder stringBuilder = new StringBuilder();
		int round = 1;
		while (topCardPlayers.size() > 1) {
			stringBuilder.append("Tiebreaker Round: ").append(round).append(System.lineSeparator());
			cardDeck.shuffle();
			// Draw card for each player
			cardDeck.dealCards(topCardPlayers, 1, cardDeck.getCards());
			for (Player player : topCardPlayers) {
				stringBuilder.append(player.showPlayerHand()).append(System.lineSeparator());

			}
			topCardPlayers = identifyTopCard(topCardPlayers);
			round++;
		}
		stringBuilder.append("%n The tiebreaker winner is: " + topCardPlayers.get(0));

		LOGGER.info(stringBuilder.toString());
		return topCardPlayers.get(0);

	}

	/**
	 * Identifies the players with the top card. This is used when multiple players
	 * are having the same hand.
	 * 
	 * @param playersWithCards
	 * @return
	 */
	private List<Player> identifyTopCard(List<Player> playersWithCards) {
		List<Player> topCardPlayers = new ArrayList<>();
		Rank topCardRank = null;
		// Check the top card among finalPlayers
		// Identify the winner or candidates for a tie breaker
		for (Player player : playersWithCards) {
			Rank newTopCardRank = player.getTopCard(player.getCards()).getRank();
			// Check if the new TopCard is bigger than previous one
			if (topCardRank == null || newTopCardRank.getValue() < topCardRank.getValue()) {
				topCardRank = newTopCardRank;
				topCardPlayers.clear();
			}
			topCardPlayers.add(player);
		}
		return topCardPlayers;
	}

	/**
	 * Identifies the players with the top hand.
	 * 
	 * @param playersWithCards
	 * @param topHandPlayers
	 * @return
	 */
	private HandRank identifyTopHand(List<Player> playersWithCards, List<Player> topHandPlayers) {
		HandRank handRank = null;
		// Identify the winner or candidates for a tie breaker
		for (Player player : playersWithCards) {
			HandRank newHandRank = player.calculateHandRank(player.getCards());
			player.setHandRank(newHandRank);

			// Check if the new HandRank is bigger than previous one
			if (handRank == null || newHandRank.getValue() < handRank.getValue()) {
				handRank = newHandRank;
				topHandPlayers.clear();
			}
			topHandPlayers.add(player);
		}
		return handRank;
	}

}
