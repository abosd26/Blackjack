import java.util.*;
import java.util.Random;

class Deck
{
	ArrayList<Card> cards;
	int n;

	public Deck(int n) {
		this.n = n;
		cards = new ArrayList<Card>();
		String[] face = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suit = {"¶Â®ç", "¬õ¤ß", "¤è¶ô", "±öªá"};
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 4; j++){
				for(int k = 0; k < 13; k++){
					Card temp = new Card(face[k], suit[j]);
					cards.add(temp);
				}
			}
		}
	}
	public void shuffle(){
		Card temp;
		Random ran = new Random();
		int t1, t2;
		for(int i = 0; i < cards.size(); i++){
			t1 = ran.nextInt(cards.size());
			t2 = ran.nextInt(cards.size());
			temp = cards.get(t1);
			cards.set(t1, cards.get(t2));
			cards.set(t2, temp);
		}
	}
	public Card deal(){
		Card temp = cards.get(cards.size() - 1);
		cards.remove(cards.size() - 1);
		return temp;
	}
	public void reset(){
		String[] face = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suit = {"¶Â®ç", "¬õ¤ß", "¤è¶ô", "±öªá"};
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 4; j++){
				for(int k = 0; k < 13; k++){
					Card temp = new Card(face[k], suit[j]);
					cards.add(temp);
				}
			}
		}
		shuffle();
		System.out.println("­«·s¸É¥RµP + ¬~µP!");
	}
}