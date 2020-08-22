package com.goc.util;

/**
 * Enum to represent Rank of a card
 * 
 * @author denniskbijo
 *
 */
public enum Rank {

	// Setting Ace with highest faceValue and lowest sequenceValue
	ACE(14, 1), TWO(2, 2), THREE(3, 3), FOUR(4, 4), FIVE(5, 5), SIX(6, 6), SEVEN(7, 7), EIGHT(8, 8), NINE(9, 9),
	TEN(10, 10), JACK(11, 11), QUEEN(12, 12), KING(13, 13);

	/**
	 * Higher value to be considered in a face-off/tie
	 */
	int faceValue;

	/**
	 * Value used to identify sequence
	 */
	int sequenceValue;

	Rank(int faceValue, int sequenceValue) {
		this.faceValue = faceValue;
		this.sequenceValue = sequenceValue;
	}

	public int getFaceValue() {
		return this.faceValue;
	}

	public int getSequenceValue() {
		return this.sequenceValue;
	}

}
