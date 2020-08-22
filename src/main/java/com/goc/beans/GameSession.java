package com.goc.beans;

import java.util.ArrayList;
import java.util.List;

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

}
