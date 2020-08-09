package com.lss.code.card;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
 
public class Welcome {
	
	String[] nums = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	String[] names = {"黑桃","红心","梅花","方块"};
	List<Card> cardStartList;  //  开始创建扑克牌时的序列
	List<Card> cardEndList;   // 洗牌后的序列
	List<Player> playerList;  //  玩家列表
	
	public Welcome(){
		this.cardStartList= new ArrayList<Card>();
		this.cardEndList = new  ArrayList<Card>();
		this.playerList = new ArrayList<Player>();
	}
	
	//  创建扑克牌
	void createCard(){
		System.out.println("-----------创建扑克牌---------------");
		for (String name : names) {
			for (String num : nums) {
				cardStartList.add(new Card(num,name));
			}
		}
		System.out.println("---------扑克牌创建成功--------------");
		System.out.print("[");
		for(int i=0;i<cardStartList.size();i++){
			Card card = cardStartList.get(i);
			if(i%13!=0) System.out.print(",");
			if((i+1)%13==1 && i!=0){
				System.out.println("]");
				System.out.print("[");
			}
			System.out.print(card.getName()+card.getNum());
		}
		System.out.println("]");
	}
	
	//  洗牌
	void shuffleCard(){
		System.out.println("-----------开始洗牌---------------");
		Random random = new Random();
		Integer listSize = cardStartList.size();
		for(int i=0;i<listSize;i++){
			Card cd = new Card();
			do{
				cd = cardStartList.get(random.nextInt(listSize));
			}while(cardEndList.contains(cd));
			cardEndList.add(cd);
		}
		System.out.println("-----------洗牌结束---------------");

		System.out.print("[");
		for(int i=0;i<cardEndList.size();i++){
			Card card = cardEndList.get(i);
			if(i%13!=0) System.out.print(",");
			if((i+1)%13==1 && i!=0){
				System.out.println("]");
				System.out.print("[");
			}
			System.out.print(card.getName()+card.getNum());
		}
		System.out.println("]");

	}
	
	//  输入角色姓名
	@SuppressWarnings("resource")
	private String getName() {
		System.out.print("输入姓名:");
		Scanner input = new Scanner(System.in);
		return input.next();
	}
	
	//  输入角色id && 输入整数判断
	@SuppressWarnings("resource")
	private Integer getId() {
		Scanner input = new Scanner(System.in);
		Integer id;
		while(true){
			try {
				System.out.print("输入ID:");
				id = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("请输入整数");
				input = new Scanner(System.in);
			}
		}
		return id;
	}
	
	//   创建角色
	private void createPlayers() {
		Integer playerNum = 3;
		for(int i=0;i<playerNum;i++){
			playerList.add(new Player(getId(), getName()));
		}
		for (Player player : playerList) {
			System.out.println("----欢迎玩家 :" + player.getName());
		}
	}
	
	//   给角色发牌
	private void sendCard() {
		System.out.println("-----------开始发牌---------------");
		int cardSendNum = 2,index = 0;
		for(int i=0;i<cardSendNum;i++){
			for(int j=0;j<playerList.size();j++){
				Player player = playerList.get(j);
				player.cardList.add(cardEndList.get(index++));
				System.out.println("----玩家 :" + player.getName()+" 拿牌");
			}
		}
		System.out.println("-----------发牌结束---------------");
	}
	
	//  游戏开始
	private void playGame() {
		System.out.println("-----------游戏开始---------------");
		Card maxCard = new Card("0","方块");
		Player winner = new Player();
		for(int i=0;i<playerList.size();i++){
			Player player = playerList.get(i);
			List<Card> cardList = player.cardList;
			Collections.sort(cardList);
			Card card = cardList.get(cardList.size()-1);
			if(maxCard.compareTo(card)<0){
				maxCard = card;
				winner = player;
			}
			System.out.println("----玩家:"+ player.getName()
					+ "最大的牌为:" + card.getName()+ card.getNum());
		}
		System.out.println("-----------玩家:"+winner.getName()+"获胜----------");
		System.out.println("玩家各自的手牌为:");
		for(int j=0;j<playerList.size();j++){
			Player player = playerList.get(j);
			System.out.print("玩家 :" + player.getName()+"[");
			for(int i=0;i<player.cardList.size();i++){
				if(i!=0) System.out.print(",");
				System.out.print(player.cardList.get(i).getName()+
						player.cardList.get(i).getNum());
			}
			System.out.print("]\n");
		}
	}
	
	public static void main(String[] args) {
		Welcome we = new Welcome();
		we.createCard();  // 创建扑克牌
		we.shuffleCard(); // 洗牌	
		we.createPlayers();  // 创建角色
		we.sendCard();  // 给角色发牌
		we.playGame();  // 游戏开始
	}
}