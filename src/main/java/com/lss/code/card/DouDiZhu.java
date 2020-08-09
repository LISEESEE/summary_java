package com.lss.code.card;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
 
 
public class DouDiZhu {
	public static void main(String[] args) {
		//1、组合牌
		//创建Map集合，键：编号     值：牌
		HashMap<Integer,String> pooker = new HashMap<Integer,String>();
		//创建List集合，存储编号
		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
		//定义13个点数的数组
		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
		//定义4个花色组合
		String[] colors = {"♠","♣","♥","♦"};
		
		//定义一个整数变量，作为Map的键
		int index = 2;
		//遍历数组，用花色+点数的组合,存储到Map集合中
		for(String number : numbers) {
			for(String color : colors) {
				pooker.put(index, color + number);
				pookerNumber.add(index);
				index++;
			}
		}
		//System.out.println(pooker);
		//System.out.println(pookerNumber);
		
		//单独存储大王和小王
		pooker.put(0, "大王");
		pookerNumber.add(0);
		pooker.put(1, "小王");
		pookerNumber.add(1);
		
		//洗牌，将牌的编号打乱
		Collections.shuffle(pookerNumber);
		//System.out.println(pookerNumber);
		
		//发牌，将牌编号，发给3个玩家集合+1个底牌集合
		ArrayList<Integer> player1 = new ArrayList<Integer>();
		ArrayList<Integer> player2 = new ArrayList<Integer>();
		ArrayList<Integer> player3 = new ArrayList<Integer>();
		ArrayList<Integer> buttom = new ArrayList<Integer>();
		//发牌，采用的是集合的索引%3
		for(int i = 0; i < pookerNumber.size();i++) {
			//现将底牌做好
			if(i<3) {
				//存到底牌去
				buttom.add(pookerNumber.get(i));			
			//对索引%3判断
			}else if(i % 3 == 0) {
				//索引上的编号，发给玩家1
				player1.add(pookerNumber.get(i));
			}else if(i % 3 == 1) {
				//发给玩家2
				player2.add(pookerNumber.get(i));
			}else if(i % 3 == 2) {
				//发给玩家3
				player3.add(pookerNumber.get(i));
			}			
		}
		//对玩家手中的编号进行排序
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		
		//看牌，就是将玩家手中的编号,到Map集合中查找，根据键找值
		//定义实现方法	
		look("包身工  ",player1,pooker);		
		look("清洁工  ",player2,pooker);
		look("洗碗工  ",player3,pooker);
		look("底牌      ",buttom,pooker);
	}
	
	public static void look(String name,ArrayList<Integer> player,HashMap<Integer,String> pooker) {
		//遍历ArrayList集合，获取元素，作为键，到集合Map中找值
		System.out.print(name+" ");
		for(Integer key : player) {
			String value = pooker.get(key);
			System.out.print(value+" ");
		}
		System.out.println();
	}
}