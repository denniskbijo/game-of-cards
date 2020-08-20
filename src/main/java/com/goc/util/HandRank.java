package com.goc.util;

/**
 * Represent Hand Rank of a hand of cards with least value being the highest
 * hand.
 * 
 * @author denniskbijo
 *
 */
public enum HandRank {

	// Least value means higher rank
	TRAIL(1), SEQUENCE(2), PAIR(3), HIGHCARD(4);

	int value;

	HandRank(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
