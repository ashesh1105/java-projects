package com.algorithms.puzzles;

import java.util.ArrayList;
import java.util.List;

public class Card {

	public enum Rank {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	public enum Suite {
		SPADES, HEARTS, DIAMONDS, CLUBS
	}

	private final Rank rank;
	private final Suite suit;
	private final static List<Card> deck = new ArrayList<Card>();

	public Card(Rank rank, Suite suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suite getSuite() {
		return suit;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	
	private static void initializeDeck() {
		for (Suite suit : Suite.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
	}
	
	public static List<Card> newDeck() {
		
		// Right time to initialize the deck!
		initializeDeck();
		
		return new ArrayList<Card>(deck);	// Return copy of deck
	}
}
