import java.util.*;

class Player extends Partitioner
{
	ArrayList<Card> cards = new ArrayList<Card>();
	ArrayList<Integer> ace = new ArrayList<Integer>();
	int money, bet, count;

	public Player(String pName, int money){
		super(pName);
		this.money = money;
	}
	public void handle(Card newOne){
		cards.add(newOne);
	}
	
	public void points(){
		count = 0;
		for(int i = 0; i < cards.size(); i++){
			if(cards.get(i).face == "J" || cards.get(i).face == "Q" || cards.get(i).face == "K"){
				count += 10;
			}
			else if(cards.get(i).face == "A"){
				if(count + 11 > 21){
					count += 1;
					ace.add(1);
				}
				else{
					count += 11;
					ace.add(11);
				}
			}
			else{
				count += Integer.parseInt(cards.get(i).face);
			}
		}
		if(count > 21){
			for(int j = 0; j < ace.size(); j++){
				if(ace.get(j) == 11){
					count -= 10;
				}
				if(count <= 21){
					break;
				}
			}
		}
		ace.clear();
	}
}