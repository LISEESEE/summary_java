package com.lss.code.card;
 
public class Card implements Comparable<Card>{
	// 牌面
	private String num;
	// 花色
	private String name;
	
	public Card(){		
	}
	
	public Card(String num,String name){
		this.num = num;
		this.name = name;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}
	
	//  获取牌面大小
	private Integer getNumValue(String num){
		switch(num){
			case "A": return 12;
			case "2": return 13;
			case "3": return 1;
			case "4": return 2;
			case "5": return 3;
			case "6": return 4;
			case "7": return 5;
			case "8": return 6;
			case "9": return 7;
			case "10": return 8;
			case "J": return 9;
			case "Q": return 10;
			case "K": return 11;
		}
		return -1;
	}
	
	//  获取花色大小
	private Integer getNameValue(String name){
		switch(name){
			case "黑桃": return 4;
			case "红心": return 3;
			case "梅花": return 2;
			case "方块": return 1;
		}
		return -1;
	}
	
	@Override
	public int compareTo(Card card) {
		// 如果牌面相同就看花色
		int numCompare = getNumValue(this.num).compareTo(getNumValue(card.num));
		if(numCompare == 0){
			return getNameValue(this.name).compareTo(getNameValue(card.name));
		}
		return numCompare;
	}
}