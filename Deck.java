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
		cards.add(new Card ("\uD83C\uDCA2", 2));
		cards.add(new Card ("\uD83C\uDCB2", 2));
		cards.add(new Card ("\uD83C\uDCC2", 2));
		cards.add(new Card ("\uD83C\uDCD2", 2));
		cards.add(new Card ("\uD83C\uDCA3", 3));
		cards.add(new Card ("\uD83C\uDCB3", 3));
		cards.add(new Card ("\uD83C\uDCC3", 3));
		cards.add(new Card ("\uD83C\uDCD3", 3));
		cards.add(new Card ("\uD83C\uDCA4", 4));
		cards.add(new Card ("\uD83C\uDCB4", 4));
		cards.add(new Card ("\uD83C\uDCC4", 4));
		cards.add(new Card ("\uD83C\uDCD4", 4));
		cards.add(new Card ("\uD83C\uDCA5", 5));
		cards.add(new Card ("\uD83C\uDCB5", 5));
		cards.add(new Card ("\uD83C\uDCC5", 5));
		cards.add(new Card ("\uD83C\uDCD5", 5));
		cards.add(new Card ("\uD83C\uDCA6", 6));
		cards.add(new Card ("\uD83C\uDCB6", 6));
		cards.add(new Card ("\uD83C\uDCC6", 6));
		cards.add(new Card ("\uD83C\uDCD6", 6));
		cards.add(new Card ("\uD83C\uDCA7", 7));
		cards.add(new Card ("\uD83C\uDCB7", 7));
		cards.add(new Card ("\uD83C\uDCC7", 7));
		cards.add(new Card ("\uD83C\uDCD7", 7));
		cards.add(new Card ("\uD83C\uDCA8", 8));
		cards.add(new Card ("\uD83C\uDCB8", 8));
		cards.add(new Card ("\uD83C\uDCC8", 8));
		cards.add(new Card ("\uD83C\uDCD8", 8));
		cards.add(new Card ("\uD83C\uDCA9", 9));
		cards.add(new Card ("\uD83C\uDCB9", 9));
		cards.add(new Card ("\uD83C\uDCC9", 9));
		cards.add(new Card ("\uD83C\uDCD9", 9));
		cards.add(new Card ("\uD83C\uDCAA", 10));
		cards.add(new Card ("\uD83C\uDCBA", 10));
		cards.add(new Card ("\uD83C\uDCCA", 10));
		cards.add(new Card ("\uD83C\uDCDA", 10));
		cards.add(new Card ("\uD83C\uDCAB", 11));
		cards.add(new Card ("\uD83C\uDCBB", 11));
		cards.add(new Card ("\uD83C\uDCCB", 11));
		cards.add(new Card ("\uD83C\uDCDB", 11));
		cards.add(new Card ("\uD83C\uDCAD", 12));
		cards.add(new Card ("\uD83C\uDCBD", 12));
		cards.add(new Card ("\uD83C\uDCCD", 12));
		cards.add(new Card ("\uD83C\uDCDD", 12));
		cards.add(new Card ("\uD83C\uDCAE", 13));
		cards.add(new Card ("\uD83C\uDCBE", 13));
		cards.add(new Card ("\uD83C\uDCCE", 13));
		cards.add(new Card ("\uD83C\uDCDE", 13));
		cards.add(new Card ("\uD83C\uDCA1", 14));
		cards.add(new Card ("\uD83C\uDCB1", 14));
		cards.add(new Card ("\uD83C\uDCC1", 14));
		cards.add(new Card ("\uD83C\uDCD1", 14));
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