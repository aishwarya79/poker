package com.training.model;

import com.training.enums.HandRank;

public class Player implements Comparable<Player> {

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", playerHandRank=" + playerHandRank + ", bestCard=" + bestCard
				+ "]";
	}

	private int playerId;
	private String playerName;
	private Card[] playerCards;

	private HandRank playerHandRank;
	private Card bestCard;

	public Player() {

	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Card[] getPlayerCards() {
		return playerCards;
	}

	public void setPlayerCards(Card[] playerCards) {
		this.playerCards = playerCards;
	}

	public HandRank getPlayerHandRank() {
		return playerHandRank;
	}

	public void setPlayerHandRank(HandRank playerHandRank) {
		this.playerHandRank = playerHandRank;
	}

	public Card getBestCard() {
		return bestCard;
	}

	public void setBestCard(Card bestCard) {
		this.bestCard = bestCard;
	}

	@Override
	public int compareTo(Player p) {

		if (this.playerHandRank.getRank() > p.getPlayerHandRank().getRank()) {
			return 1;
		} else if (this.playerHandRank.getRank() < p.getPlayerHandRank().getRank()) {
			return -1;
		} else {
			return this.getBestCard().compareTo(p.getBestCard());
		}

	}
}
