package com.goc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.goc.beans.CardDeck;

public class MainGame {

	public static void main(String[] args) {
		final int NO_OF_PLAYERS = 4;
		List<Player> players = new ArrayList<>();
		CardDeck cardDeck = new CardDeck();

		System.out.println("WELCOME TO THE CARD GAME\n");
		System.out.println("Enter the four players' name below");

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < NO_OF_PLAYERS; i++) {
			players.add(new Player(scan.next()));
		}

		System.out.println();
	}

}
