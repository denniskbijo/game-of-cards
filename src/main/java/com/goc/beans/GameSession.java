package com.goc.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a card game session with players
 * 
 * @author denniskbijo
 *
 */
public class GameSession {

	private List<Player> players = new ArrayList<>();

	private Player winner = null;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	// CUSTOM METHODS

	public List<Player> readPlayerNames(int playerCount) {
		List<Player> players = new ArrayList<>();

		System.out.println("WELCOME TO THE CARD GAME\n");
		System.out.println("Enter the four players' name below");

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < playerCount; i++) {
			players.add(new Player(scan.next()));
		}
		scan.close();
		return players;
	}

	public CardDeck dealCardsToPlayers(List<Player> players, int noOfCards) {
		System.out.println("Shuffling cards. The Players are ready!");
		for (Player player : players) {
			System.out.println(player);
		}
		CardDeck cardDeck = new CardDeck();
		// Shuffle the cards
		cardDeck.shuffle();

		// Deal the cards
		cardDeck.dealCards(players, noOfCards, cardDeck.getCards());

		// Show Player Hands
		for (Player player : players) {
			System.out.println(player.showPlayerHand());
		}
		return cardDeck;
	}

}
