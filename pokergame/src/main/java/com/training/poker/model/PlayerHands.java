package com.training.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PlayerHands {
	
	
    private Player player;
	private Map<String, TreeSet<Card>> suiteCardsMap;
	private Map<Integer, List<Card>> rankCardsMap;

	// Max Cards in a suite
	private int maxCardsInASuite = 0;
	private String suiteWithMaxCards;
	
	// Max of a kind
	private int maxOfAKind = 0;
	private int maxOfAKindRank;

	public PlayerHands(Player player) {
		this.player=player;
		suiteCardsMap = new HashMap<>();
		setPlayerSuiteCardsMap();
		rankCardsMap = new HashMap<>();
		setPlayerRankCardsMap();
	}


	private void setPlayerSuiteCardsMap() {
		Card[] playerCards = this.player.getPlayerCards();
		for (Card card : playerCards) {
			String suite = card.getSuite();
			TreeSet<Card> cardsSet = null;
			if (suiteCardsMap.containsKey(suite)) {
				cardsSet = suiteCardsMap.get(suite);
			}
			else{
				cardsSet = new TreeSet<Card>();			
			}
			cardsSet.add(card);
			suiteCardsMap.put(suite, cardsSet);
			int count = cardsSet.size();
			if (count > maxCardsInASuite) {
				maxCardsInASuite = count;
				suiteWithMaxCards = card.getSuite();
			}
		}
	}

	public void setPlayerRankCardsMap() {
		Card[] playerCards = this.player.getPlayerCards();
		for (Card card : playerCards) {
			int rank = card.getCardRank().getRank();
			List<Card> cardsList = null;
			if (rankCardsMap.containsKey(rank)) {
				cardsList = rankCardsMap.get(rank);
			}
			else{
				cardsList = new ArrayList<Card>();			
			}
			cardsList.add(card);
			rankCardsMap.put(rank, cardsList);
			int count = cardsList.size();
			if (count > maxOfAKind) {
				maxOfAKind = count;
				maxOfAKindRank = card.getCardRank().getRank();
			}
		}
	}

	
	public Map<String, TreeSet<Card>> getSuiteCardsMap() {
		return suiteCardsMap;
	}


	public void setSuiteCardsMap(Map<String, TreeSet<Card>> suiteCardsMap) {
		this.suiteCardsMap = suiteCardsMap;
	}


	public Map<Integer, List<Card>> getRankCardsMap() {
		return rankCardsMap;
	}


	public void setRankCardsMap(Map<Integer, List<Card>> rankCardsMap) {
		this.rankCardsMap = rankCardsMap;
	}


	public int getMaxCardsInASuite() {
		return maxCardsInASuite;
	}


	public void setMaxCardsInASuite(int maxCardsInASuite) {
		this.maxCardsInASuite = maxCardsInASuite;
	}


	public String getSuiteWithMaxCards() {
		return suiteWithMaxCards;
	}


	public void setSuiteWithMaxCards(String suiteWithMaxCards) {
		this.suiteWithMaxCards = suiteWithMaxCards;
	}


	public int getMaxOfAKind() {
		return maxOfAKind;
	}


	public void setMaxOfAKind(int maxOfAKind) {
		this.maxOfAKind = maxOfAKind;
	}


	public int getMaxOfAKindRank() {
		return maxOfAKindRank;
	}


	public void setMaxOfAKindRank(int maxOfAKindRank) {
		this.maxOfAKindRank = maxOfAKindRank;
	}

	
}
