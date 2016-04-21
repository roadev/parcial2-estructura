import java.util.ArrayList;
import java.util.Collections;
import java.awt.List;

public class Deck {

	private ArrayList<Card> cards;

	public Deck(){
		cards = new ArrayList<Card>();
		inicialize();
	}

	private void createCard (String symbol, int value) {
		Card card = new Card(symbol, value);
      	cards.add(card);
	}

	private void inicialize () {
		String str="";
		int codePoint=0;
		String symbol="";

		for (int c2 = 1, value=1; c2 <= 0xE; c2++, value++) {
			for (int c1 = 0xA; c1 <= 0xD; c1++) {
				if (c2!=0xC) {
					str = String.format("1F0%X%X", c1, c2);
					codePoint = Integer.parseInt(str, 16);
					symbol = String.format("%c", codePoint);
					//System.out.println(symbol);
					cards.add(new Card (symbol, value));
				} else {
					value = 11;
				}
			}
		}

		for (int i=0;i<5;i++)
			cards.get(i).setValue(14);
	}

	public void shuffleCards () {
		Collections.shuffle(cards);
	}

	public int sizeDeck () {
		return cards.size();
	}

	public Card[] deleteSubList() {
		Card[] subList = new Card[5];
		int pos = 0;
		do{
			subList[pos]=cards.get(pos);
			cards.remove(pos);
			pos++;
		} while (pos<5);

		return subList;
	}

	public void insertSubList(Card[] returnSublist) {
		int pos = 0;
		Card[] arrayCards = returnSublist;
		
		do{
			cards.add(arrayCards[pos]);
			pos++;
		} while (pos<5);
	}
}