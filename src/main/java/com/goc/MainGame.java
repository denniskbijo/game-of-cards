package com.goc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.goc.beans.CardDeck;
import com.goc.beans.Player;
import com.goc.util.HandRank;
import com.goc.util.Rank;

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

	public static void main(String[] args) {
		final int NO_OF_PLAYERS = 4;
		final int NO_OF_CARDS = 3;
		List<Player> players = new ArrayList<>();
		CardDeck cardDeck = new CardDeck();

		System.out.println("WELCOME TO THE CARD GAME\n");
		System.out.println("Enter the four players' name below");

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < NO_OF_PLAYERS; i++) {
			players.add(new Player(scan.next()));
		}
		scan.close();

		// Shuffle the cards
		cardDeck.shuffle();

		System.out.println("Shuffling cards. The Players are ready!");
		for (Player player : players) {
			System.out.println(player);
		}

		// Deal the cards
		List<Player> playersWithCards = cardDeck.dealCards(players, NO_OF_CARDS, cardDeck.getCards());

		// Show Player Hands
		for (Player player : playersWithCards) {
			System.out.println(player.showPlayerCards());
		}

		identifyWinner(playersWithCards, cardDeck);


	}

	private static void identifyWinner(List<Player> playersWithCards,CardDeck cardDeck) {
		// Identify Top Hands
		List<Player> topHandPlayers = new ArrayList<>();
		HandRank handRank = identifyTopHand(playersWithCards, topHandPlayers);

		// Check if there's a tie between top hands or the highest rank is HIGHCARD
		if (topHandPlayers.size() > 1 || handRank.equals(HandRank.HIGHCARD)) {
			// Identify Players with Top Card
			List<Player> topCardPlayers = new ArrayList<>();
			identifyTopCard(playersWithCards, topCardPlayers);
			
			if (topCardPlayers.size() > 1) {
				System.out.println("There is a tie between " + topCardPlayers.size());
				//Initiate tie breaker by drawing cards from deck for topCardPlayers
				initiateTieBreaker(topCardPlayers, cardDeck);
			} else {
				System.out.println("The winner is: " + topCardPlayers.get(0));
			}

		} else {
			System.out.println("The winner is: " + topHandPlayers.get(0));
		}
	}

	private static void initiateTieBreaker(List<Player> topCardPlayers, CardDeck cardDeck) {
		// TODO Auto-generated method stub

	}

	private static void identifyTopCard(List<Player> playersWithCards, List<Player> topCardPlayers) {
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
	}

	private static HandRank identifyTopHand(List<Player> playersWithCards, List<Player> topHandPlayers) {
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
