import java.io.*;
import java.util.*;
import java.util.Scanner;

class Blackjack
{
	public static void main(String[] args) {
		String option, n;
		Scanner s = new Scanner(System.in);
		boolean isPlayed = false;
		boolean exit = false;
		Game game;

		while(true){
			System.out.println("請輸入 1)開始遊戲 -1)離開 : ");
			option = s.next();
			switch(option){
				case "1":
					isPlayed = true;
					break;
				case "-1":
					exit = true;
					break;
				default:
					System.out.println("無此選項!");
					break;
			}
			if(exit){
				System.out.println("結束遊戲!");
				break;
			}
			while(isPlayed){
				try{
					System.out.println("請輸入玩家人數 : ");
					n = s.next();
					if(Integer.parseInt(n) >= 1){
						game = new Game(Integer.parseInt(n));
						while(!game.isError){
							game.firstround();
							if(game.exit == 1){
								System.out.println("回主菜單!");
								isPlayed = false;
								break;
							}
							if(!game.isError){
								game.battle();
							}
							if(game.isOver){
								System.out.println("Game Over!");
								isPlayed = false;
								break;
							}
						}
						if(game.isError){
							isPlayed = false;
							break;
						}
					}
					else{
						System.out.println("人數須大於等於1!");
						isPlayed = false;
						break;
					}									
				}
				catch(Exception e){
					System.out.println("error : " + e);
					isPlayed = false;
					break;
				}
			}
		}
	}
}