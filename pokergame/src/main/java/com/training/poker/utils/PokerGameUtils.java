package com.training.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.training.enums.HandRank;
import com.training.model.Card;
import com.training.model.Player;
import com.training.model.PlayerHands;

public class PokerGameUtils {
	
	public static void setPlayerHandRanking(Player p, PlayerHands hand){
		Card bestCard = null;
		// Check for Royal Flush
		bestCard = hasRoyalFlush(hand);
		if(bestCard!=null){			
			p.setPlayerHandRank(HandRank.ROYAL_FLUSH);
			p.setBestCard(bestCard);
			return;
		}
		
		// Check for Straight Flush		
		bestCard = hasStraightFlush(hand);
		if(bestCard!=null){			
			p.setPlayerHandRank(HandRank.STRAIGHT_FLUSH);
			p.setBestCard(bestCard);
			return;
		}
		
		// Check For Flush
		bestCard = hasFlush(hand);
		if(bestCard!=null){			
			p.setPlayerHandRank(HandRank.FLUSH);
			p.setBestCard(bestCard);
			return;
		}
		
	}

	public static Card hasRoyalFlush(PlayerHands hand) {
		Card resCard = hasFlush(hand);
		if (resCard != null) {
			String maxCardSuite = hand.getSuiteWithMaxCards();
			Map<String, TreeSet<Card>> playerSuiteCardsMap = hand.getSuiteCardsMap();
			TreeSet<Card> cardsSet = playerSuiteCardsMap.get(maxCardSuite);
			Iterator<Card> iter = cardsSet.iterator();
			int i = 1;
			// Check if cards are ACE KING QUEEN JACK TEN
			while (iter.hasNext() && i <= 5) {
				Card nextCard = iter.next();
				if (nextCard.getCardRank().getRank() != i++) {
					return null;
				}
			}
			return cardsSet.first();
		} else {
			return null;
		}
	}

	public static Card hasStraightFlush(PlayerHands hand) {
		Card resCard = hasFlush(hand);
		if (resCard != null) {
			Map<String, TreeSet<Card>> suiteCardsMap = hand.getSuiteCardsMap();
			TreeSet<Card> cardsSet = suiteCardsMap.get(resCard.getSuite());
			Card highest = isInSequence(cardsSet);
			return highest;
		} else {
			return null;
		}

	}

	public static Card hasFourOfAKind(PlayerHands hand) {
		int maxOfAKind = hand.getMaxOfAKind();
		if (maxOfAKind == 4) {						
			//  return any of the 4 cards
			int maxOfAKindRank = hand.getMaxOfAKindRank();
			Map<Integer, List<Card>> rankCardsMap = hand.getRankCardsMap();
			List<Card> cardsList = rankCardsMap.get(maxOfAKindRank);
			return cardsList.get(0);
		} else {
			return null;
		}
	}
	
	public static Card hasThreeOfAKind(PlayerHands hand) {
		int maxOfAKind = hand.getMaxOfAKind();
		if (maxOfAKind == 3) {						
			//  return any of the 3 cards
			int maxOfAKindRank = hand.getMaxOfAKindRank();
			Map<Integer, List<Card>> rankCardsMap = hand.getRankCardsMap();
			List<Card> cardsList = rankCardsMap.get(maxOfAKindRank);
			return cardsList.get(0);
		} else {
			return null;
		}
	}
	
	public static Card hasOnePair(PlayerHands hand) {
		int maxOfAKind = hand.getMaxOfAKind();
		if (maxOfAKind == 2) {						
			//  return any of the 2 cards
			int maxOfAKindRank = hand.getMaxOfAKindRank();
			Map<Integer, List<Card>> rankCardsMap = hand.getRankCardsMap();
			List<Card> cardsList = rankCardsMap.get(maxOfAKindRank);
			return cardsList.get(0);
		} else {
			return null;
		}
	}
	
	public static Card hasTwoPair(PlayerHands hand){
		Card bestCard = null;
		int maxOfAKind = hand.getMaxOfAKind();
		if (maxOfAKind == 2){
			Map<Integer, List<Card>> rankCardsMap = hand.getRankCardsMap();
			
			int pairsCount = 0;
			Card[] bestCards = new Card[3];
			int index = 0;
			for (int rank : rankCardsMap.keySet()){
				if (rank == 2){
					pairsCount++;
					bestCards[index] = rankCardsMap.get(rank).get(0);
				}
			}
			if (pairsCount >= 2 ){
				if (bestCards.length == 2){
					bestCard = (bestCards[0].getCardRank().getRank() < bestCards[1].getCardRank().getRank()) 
							? bestCards[0] : bestCards[1];
				}else{
					//get min of 3
					return bestCards[0];
				}
				return bestCard;
			}else{
				return null;
			}
			
		}else{
			return null;
		}	
	}
	
	public static Card hasFullHouse(PlayerHands hand) {
		Card bestCard = hasThreeOfAKind(hand);
		if (bestCard != null){
			Map<Integer, List<Card>> rankCardsMap = hand.getRankCardsMap();
			if (rankCardsMap.containsKey(2)){
				return bestCard;
			}else{
				return null;
			}
		}else{
			return null;
		}	
	}

	public static Card hasFlush(PlayerHands hand) {
		int maxCardsInSuite = hand.getMaxCardsInASuite();
		if (maxCardsInSuite >= 5) {
			String suiteWithMaxCards = hand.getSuiteWithMaxCards();
			Card maxSuiteCard = hand.getSuiteCardsMap().get(suiteWithMaxCards).first();
			return maxSuiteCard;
		} else {
			return null;
		}

	}

	private static Card isInSequence(TreeSet<Card> cardsSet) {
		int sum = 0;
		Card highestCard = cardsSet.first();

		Card current = null;
		Card prev = null;

		Iterator<Card> iter = cardsSet.iterator();
		while (iter.hasNext()) {
			current = iter.next();
			if(sum == 4) break;
			int currentRank = current.getCardRank().getRank();
			int prevRank = (prev == null) ? currentRank : prev.getCardRank().getRank();
			int currentDiff = currentRank - prevRank;
			if (currentDiff == 1) {
				sum += currentDiff;				
			} else {
				highestCard = current;
				sum = 0;
			}
			prev = current;
		}

		if (sum >= 4) {
			return highestCard;
		} else {
			return null;
		}
	}

}
