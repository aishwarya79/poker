package com.training.model;

import com.training.enums.CardRank;

public class Card implements Comparable<Card> {

	@Override
	public String toString() {
		return "Card [suite=" + suite + ", cardRank=" + cardRank + "]";
	}

	private String suite;
	private CardRank cardRank;

	public Card() {

	}

	public Card(String suite, CardRank cardRank) {
		this.suite = suite;
		this.cardRank = cardRank;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public CardRank getCardRank() {
		return cardRank;
	}

	public void setCardRank(CardRank cardRank) {
		this.cardRank = cardRank;
	}

	private Integer getSuiteRank(String suite) {
		int rank = 0;
		switch (suite) {
		case "HEART":
			rank = 1;
			break;
		case "CLUB":
			rank = 2;
			break;
		case "SPADE":
			rank = 3;
			break;
		case "DIAMOND":
			rank = 4;
			break;
		}

		return rank;
	}

	@Override
	public int compareTo(Card card) {
		if (this.getCardRank().getRank() > card.getCardRank().getRank()) {
			return 1;
		} else if (this.getCardRank().getRank() < card.getCardRank().getRank()) {
			return -1;
		} else {
           return this.getSuiteRank(this.getSuite()).compareTo(card.getSuiteRank(card.getSuite()));
		}
	}

}
