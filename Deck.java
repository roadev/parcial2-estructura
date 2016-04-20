import java.util.ArrayList;
import java.util.Collections;
import java.awt.List;

public class Deck {

	private ArrayList<Card> cards;

	public Deck(){
		cards = new ArrayList<Card>();
		inicialize();
	}

	private void inicialize () {
		Card card;
		String base = "abc";

		for (int value=2; value<=14;value++) {
			String code="";
			String last="";

			if (value < 10)
				last = Integer.toString(value); // 2 - 9
			else if (value == 10) // 10
				last = "A";
			else if (value == 11) // J
				last = "B";
			else if (value == 12) // Q
				last = "D";
			else if (value == 13) // K
				last = "E";
			else if (value == 14) // AS
				last = Integer.toString(1);

			code = base+"A"+last;
			card = new Card(code, value);
			cards.add(card);

			code = base+"B"+last;
			card = new Card(code, value);
			cards.add(card);

			code = base+"D"+last;
			card = new Card(code, value);
			cards.add(card);

			code = base+"E"+last;
			card = new Card(code, value);
			cards.add(card);
		}		
	}

	public void shuffleCards () {
		Collections.shuffle(cards);
	}

	public Card[] getSubList(int init, int fin) {
		return cards.subList(init, fin);
	}
}