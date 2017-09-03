package com.training.enums;

public enum CardRank {
	
	ACE(1),
	KING(2),
	QUEEN(3),
	JACK(4),
	TEN(5),
	NINE(6),
	EIGHT(7),
	SEVEN(8),
	SIX(9),
	FIVE(10),
	FOUR(11),
	THREE(12),
	TWO(13);
	
	private Integer rank;
	
	CardRank(Integer rank){
		this.rank = rank;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}
