package com.training.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.training.enums.CardRank;
import com.training.model.Card;
import com.training.model.Player;
import com.training.model.PlayerHands;
import com.training.utils.PokerGameUtils;

public class PokerGame {

	public static void main(String[] args) {

		// Player 1
		Player p1 = new Player();
		p1.setPlayerName("player 1");
		Card c11 = new Card("HEART", CardRank.QUEEN);
		Card c12 = new Card("HEART", CardRank.KING);
		Card c13 = new Card("HEART", CardRank.JACK);
		Card c14 = new Card("HEART", CardRank.NINE);
		Card c15 = new Card("HEART", CardRank.TEN);
		Card c16 = new Card("SPADE", CardRank.SEVEN);
		Card c17 = new Card("SPADE", CardRank.FIVE);
		Card[] cards1 = { c11, c12, c13, c14, c15, c16, c17 };
		p1.setPlayerCards(cards1);

		// Player 1
		Player p2 = new Player();
		p2.setPlayerName("player 2");
		Card c21 = new Card("SPADE", CardRank.ACE);
		Card c22 = new Card("SPADE", CardRank.QUEEN);
		Card c23 = new Card("SPADE", CardRank.KING);
		Card c24 = new Card("SPADE", CardRank.JACK);
		Card c25 = new Card("SPADE", CardRank.TEN);
		Card c26 = new Card("SPADE", CardRank.SEVEN);
		Card c27 = new Card("SPADE", CardRank.TEN);
		Card[] cards2 = { c21, c22, c23, c24, c25, c26, c27 };
		p2.setPlayerCards(cards2);

		List<Player> players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		List<Player> playerRanked = playGame(players);
		System.out.println(playerRanked);

	}

	public static List<Player> playGame(List<Player> players) {
		//List<Player> resultList = new ArrayList<>();
		// Map<Integer,Card> playerBestCardMap = new HashMap<>();

		for (Player player : players) {
			PlayerHands hand = new PlayerHands(player);
			PokerGameUtils.setPlayerHandRanking(player, hand);
		}

		Collections.sort(players);
		return players;
	}

}
